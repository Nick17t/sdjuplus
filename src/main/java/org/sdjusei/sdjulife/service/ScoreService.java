package org.sdjusei.sdjulife.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.sdjusei.sdjulife.domain.Course;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.domain.Score;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 成绩查询服务
 *
 * @author zcz
 * @date 2020/08/13
 */
@Service
public class ScoreService {

	@Value("${ems.url}")
	private String emsUrl;
	@Value("${ems.loginUrl}")
	private String emsLoginUrl;
	@Value("${ems.scoreRequestUrl}")
	private String scoreRequestUrl;

	/**
	 * 成绩获取方法
	 *
	 * @param cookies 包含统一认证系统登录信息的Cookie
	 * @param year    学年
	 * @param term    学期
	 * @return 返回成绩实体类List
	 * @throws Exception Jsoup所有可能抛出的异常和JSON转换异常
	 */
	public List<Score> getScoreList(Map<String, String> cookies, String year, String term) throws Exception {
		//通过统一认证系统来登录教务系统
		Connection.Response response = Jsoup.connect(emsUrl + emsLoginUrl)
				.cookies(cookies)
				.execute();

		//登录后查询成绩
		String rawScoreString = Jsoup.connect(emsUrl + scoreRequestUrl)
				.ignoreContentType(true)
				.data("xnm", year)
				.data("xqm", term)
				.cookies(response.cookies())
				.followRedirects(true)
				.method(Connection.Method.POST)
				.execute()
				.body();

		//将字符串转为实体类，无法正常转换则抛出异常
		List<Score> scores;
		try {
			scores = scoreString2List(rawScoreString);
		} catch (JsonSyntaxException e) {
			throw new CommonException(ResultEnum.EMS_SCORE_GET_FAIL);
		}
		return scores;
	}

	/**
	 * 成绩字符串转成绩实体类
	 *
	 * @return 成绩实体类
	 */
	private List<Score> scoreString2List(String scoreString) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(scoreString, JsonObject.class).get("items");
		return gson.fromJson(jsonElement, new TypeToken<List<Score>>() {
		}.getType());
	}
}
