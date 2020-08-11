package org.sdjusei.sdjulife.service;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.util.JsoupUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.Map;

/**
 * 学校系统登录服务，用于获取用户登录后的Cookie，以便多次使用。
 * 目前考虑使用统一认证的方式进行登录，
 * 统一认证的实现方式推测为Cookie中的iPlanetDirectoryPro字段。
 * 需要注意的是，统一认证、办事大厅、教务系统的session互不相通，
 * 进行连续请求时应保留前一步操作后的cookies
 *
 * @author zcz
 * @date 2020/08/10
 */
@Service
public class SchoolSysLoginService {

	@Value("${unifiedSys.loginUrl}")
	private String unifiedSysLoginUrl;
	@Value("${unifiedSys.captchaNeededCheckUrl}")
	private String captchaNeededCheckUrl;
	@Value("${unifiedSys.captchaGetUrl}")
	private String captchaGetUrl;
	@Resource
	private JsoupUtil jsoupUtil;

	/**
	 * 统一认证系统登录方法
	 *
	 * @param map 第一次只带学号请求，第二次带有学号和加密后的密码（可能还有验证码）以及其他暂存的参数
	 * @return 第一次返回验证码、暂存参数和加密用的盐，第二次返回登录后的Cookie
	 * @throws Exception Jsoup连接中的各种异常
	 */
	public Map<String, String> unifiedLogin(Map<String, String> map) throws Exception {
		//无法获得学号则抛出异常
		if (map.get("stuId") == null)
			throw new CommonException(ResultEnum.STU_ID_MISSING);
		//如果需要验证码却没有输入，抛出异常
		if (map.get("captchaImage") != null && map.get("captchaResponse") == null)
			throw new CommonException(ResultEnum.CAPTCHA_CODE_MISSING);
		//如果map中只有学号，则视为首次请求，调用预请求方法
		if (map.get("password") == null)
			return preUnifiedLogin(map);
		else
			//如果学号密码都不为空，则视为正式进行登录
			return postUnifiedLogin(map);
	}


	/**
	 * 统一认证系统预登录方法，获取加密所需的盐和其他参数
	 *
	 * @param dataMap 至少包含学号
	 * @return 返回盐和其他暂存参数（或者还有验证码）
	 * @throws Exception 所有Jsoup连接过程中的异常
	 */
	public Map<String, String> preUnifiedLogin(Map<String, String> dataMap) throws Exception {
		//连接页面
		Connection.Response response = Jsoup.connect(unifiedSysLoginUrl).execute();
		Document loginPage = response.parse();
		//获取盐
		String aseKey = loginPage.select("script").get(1).html().split(";")[1].split("=")[1].replaceAll("\"", "").replaceAll(" ", "");
		//获取lt
		String lt = loginPage.select("input").get(4).attributes().get("value");
		//获取execution
		String execution = loginPage.select("input").get(6).attributes().get("value");

		dataMap.put("aseKey", aseKey);
		dataMap.put("lt", lt);
		dataMap.put("execution", execution);
		dataMap.put("unifiedSys_jsessionid", response.cookies().get("JSESSIONID"));
		dataMap.put("route", response.cookies().get("route"));

		//检查是否需要验证码
		String verifyMark = Jsoup.connect(captchaNeededCheckUrl)
				.data("username", dataMap.get("stuId"))
				.cookie("JSESSIONID", response.cookies().get("JSESSIONID"))
				.cookie("route", response.cookies().get("route"))
				.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", "zh_CN")
				.method(Connection.Method.GET)
				.execute()
				.body();

		//需要则附上验证码获取链接
		//TODO 此法实现的验证码获取，在前端无法使用点击验证码换图片的功能，考虑以后将验证码功能从登录方法分离
		if ("true".equalsIgnoreCase(verifyMark)) {
			byte[] bytes = Jsoup.connect(captchaGetUrl)
					.cookie("JSESSIONID", response.cookies().get("JSESSIONID"))
					.cookie("route", response.cookies().get("route"))
					.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", "zh_CN")
					.execute()
					.bodyAsBytes();
			Base64.Encoder encoder = Base64.getEncoder();
			dataMap.put("captchaImage", "data:image/jpeg;base64," + encoder.encodeToString(bytes));
		}
		return dataMap;
	}

	/**
	 * 统一认证系统正式登录方法
	 *
	 * @param dataMap 预登录的所有信息以及验证码（如果需要）
	 * @return 返回Cookies
	 * @throws Exception 所有Jsoup连接过程中的异常
	 */
	public Map<String, String> postUnifiedLogin(Map<String, String> dataMap) throws Exception {
		//固有登录参数，无需改动，默认开启一周免登录
		dataMap.put("rememberMe", "on");
		dataMap.put("dllt", "userNamePasswordLogin");
		dataMap.put("_eventId", "submit");
		dataMap.put("rmShown", "1");

		Connection.Response response = Jsoup.connect(unifiedSysLoginUrl)
				.data(dataMap)
				.cookie("JSESSIONID", dataMap.get("unifiedSys_jsessionid"))
				.cookie("route", dataMap.get("route"))
				.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", "zh_CN")
				.method(Connection.Method.POST)
				.execute();
		if (response.cookies().get("iPlanetDirectoryPro") == null)
			throw new CommonException(ResultEnum.SCHOOL_SYS_LOGIN_INFO_ERROR);
		return response.cookies();
	}
}
