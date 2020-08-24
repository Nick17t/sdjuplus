package org.sdjusei.sdjulife.service;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.model.domain.ResultEnum;
import org.sdjusei.sdjulife.model.response.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 课程服务，用于获取课表
 *
 * @author zcz
 * @date 2020/07/17
 */
@Service
public class CourseService {

	@Value("${ems.url}")
	private String emsUrl;
	@Value("${ems.loginUrl}")
	private String emsLoginUrl;
	@Value("${ems.courseListRequestUrl}")
	private String courseListRequestUrl;

	/**
	 * 星期枚举类，用于将中文的星期转为数字
	 */
	@AllArgsConstructor
	public enum WeekUtil {
		MONDAY(1, "星期一"),
		TUESDAY(2, "星期二"),
		WEDNESDAY(3, "星期三"),
		THURSDAY(4, "星期四"),
		FRIDAY(5, "星期五"),
		SATURDAY(6, "星期六"),
		SUNDAY(7, "星期日");

		public final int dayNumber;
		public final String dayInWeek;

		public static int parseDayInWeekToDayNumber(String cn){
			for (var value : WeekUtil.values()) {
				if (value.dayInWeek.equals(cn))
					return value.dayNumber;
			}
			return 0;
		}
	}

	/**
	 * 课程表获取方法
	 *
	 * @param cookies 包含统一认证系统登录信息的Cookie
	 * @param year    学年
	 * @param term    学期
	 * @return 返回课程实体类List
	 * @throws Exception Jsoup所有可能抛出的异常和JSON转换异常
	 */
	public List<Course> getSchedule(Map<String, String> cookies, String year, String term) throws Exception {
		//通过统一认证系统来登录教务系统
		Connection.Response response = Jsoup.connect(emsUrl + emsLoginUrl)
				.cookies(cookies)
				.execute();

		//登录成功后再去查询课表
		String rawCourseString = Jsoup.connect(emsUrl + courseListRequestUrl)
				.ignoreContentType(true)
				.data("xnm", year)
				.data("xqm", term)
				.cookies(response.cookies())
				.followRedirects(true)
				.method(Connection.Method.POST)
				.execute()
				.body();

		//将字符串转为实体类，无法正常转换则抛出异常
		List<Course> courses;
		try {
			courses = courseString2List(rawCourseString);
		} catch (JsonSyntaxException e) {
			throw new CommonException(ResultEnum.EMS_COURSE_GET_FAIL);
		}

		return courses;
	}

	/**
	 * 课表字符串转课程实体类
	 *
	 * @return 课表实体类
	 */
	private List<Course> courseString2List(String courseString) {
		List<Course> courses = new ArrayList<>();
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(courseString, JsonObject.class).get("kbList");
		JsonArray elements = jsonElement.getAsJsonArray();

		//遍历课程列表中的元素，转为课程实体类并添加到List中
		for (var e : elements) {
			Course course = new Course();
			JsonObject classInfo = gson.fromJson(e, JsonObject.class);
			course.setPosition(classInfo.get("cdmc").getAsString());
			course.setCourseName(classInfo.get("kcmc").getAsString());
			course.setTeacherName(classInfo.get("xm").getAsString());
			course.setWeeks(getWeeks(classInfo.get("zcd").getAsString()));
			course.setNode(getNode(classInfo.get("xqjmc").getAsString(),
					classInfo.get("jcs").getAsString()));
			courses.add(course);
		}
		return courses;
	}

	/**
	 * 获取上课周次方法
	 *
	 * @param zcd 原始周次信息
	 * @return 返回上课周次List
	 */
	private List<Integer> getWeeks(String zcd) {
		List<Integer> weeks = new ArrayList<>();
		//检查单双周来判断循环步长
		int step = checkMark(zcd);
		//去掉末尾的“周”字
		if (step == 1)
			zcd = zcd.substring(0, zcd.length() - 1);
		else if (step == 2)
			zcd = zcd.substring(0, zcd.length() - 4);
		String[] split = zcd.split("-");

		//如果是只有某一周才有的课，直接返回即可
		if (split.length == 1) {
			weeks.add(Integer.parseInt(zcd));
			return weeks;
		}

		//如果是2周以上的课，则需要根据起始和结尾周次填充weeks
		int begin = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
		for (int i = begin; i <= end; i += step) {
			weeks.add(i);
		}
		return weeks;
	}

	/**
	 * 单双周判断方法
	 *
	 * @param zcd 原始周次信息
	 * @return 两周一次的返回2，一周一次的返回1
	 */
	private int checkMark(String zcd) {
		char mark = zcd.charAt(zcd.length() - 2);
		if (mark == '单' || mark == '双') {
			return 2;
		}
		return 1;
	}

	/**
	 * 课程节次获取方法
	 *
	 * @param dayInWeek 原始星期几字符串
	 * @param rawNode   原始课程节次
	 * @return 返回星期几与节次的组合字符串
	 */
	private String getNode(String dayInWeek, String rawNode) {
		StringBuilder node = new StringBuilder();
		int day = WeekUtil.parseDayInWeekToDayNumber(dayInWeek);
		String[] split = rawNode.split("-");
		int begin = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
		for (int i = begin; i <= end; i++) {
			node.append(day);
			node.append('-');
			node.append(i);
			if (i != end)
				node.append('&');
		}
		return node.toString();
	}
}
