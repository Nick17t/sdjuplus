package org.sdjusei.sdjulife.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.model.domain.ResultEnum;
import org.sdjusei.sdjulife.model.response.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

		//判断课程单双周
		courses.forEach(this::checkMark);

		return courses;
	}

	/**
	 * 课表字符串转课程实体类
	 *
	 * @return 课表实体类
	 */
	private List<Course> courseString2List(String courseString) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(courseString, JsonObject.class).get("kbList");
		return gson.fromJson(jsonElement, new TypeToken<List<Course>>() {
		}.getType());
	}

	/**
	 * 单双周判断方法
	 *
	 * @param course 课程实体
	 */
	private void checkMark(Course course) {
		String zcd = course.getBeginAndEndWeeks();
		char mark = zcd.charAt(zcd.length() - 2);
		if (mark == '单') {
			course.setMark(1);
		} else if (mark == '双') {
			course.setMark(2);
		}
		course.setMark(3);
	}
}
