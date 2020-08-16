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
import org.sdjusei.sdjulife.model.response.Exam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 考试信息服务
 *
 * @author zcz
 * @date 2020/08/13
 */
@Service
public class ExamService {

	@Value("${ems.url}")
	private String emsUrl;
	@Value("${ems.loginUrl}")
	private String emsLoginUrl;
	@Value("${ems.examRequestUrl}")
	private String examRequestUrl;

	/**
	 * 考试信息获取方法
	 *
	 * @param cookies 包含统一认证系统登录信息的Cookie
	 * @param year    学年
	 * @param term    学期
	 * @return 返回考试信息实体类List
	 * @throws Exception Jsoup所有可能抛出的异常和JSON转换异常
	 */
	public List<Exam> getExamList(Map<String, String> cookies, String year, String term) throws Exception {
		//通过统一认证系统来登录教务系统
		Connection.Response response = Jsoup.connect(emsUrl + emsLoginUrl)
				.cookies(cookies)
				.execute();

		//登录后查询成绩
		String rawExamString = Jsoup.connect(emsUrl + examRequestUrl)
				.ignoreContentType(true)
				.data("xnm", year)
				.data("xqm", term)
				.cookies(response.cookies())
				.followRedirects(true)
				.method(Connection.Method.POST)
				.execute()
				.body();

		//将字符串转为实体类，无法正常转换则抛出异常
		List<Exam> exams;
		try {
			exams = examString2List(rawExamString);
		} catch (JsonSyntaxException e) {
			throw new CommonException(ResultEnum.EMS_EXAM_GET_FAIL);
		}
		return exams;
	}


	/**
	 * 考试信息字符串转考试信息实体类
	 *
	 * @return 考试信息实体类
	 */
	private List<Exam> examString2List(String examString) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(examString, JsonObject.class).get("items");
		return gson.fromJson(jsonElement, new TypeToken<List<Exam>>() {
		}.getType());
	}
}
