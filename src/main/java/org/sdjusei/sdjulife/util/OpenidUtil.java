package org.sdjusei.sdjulife.util;

import lombok.SneakyThrows;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

/**
 * openid工具类，用于向微信和QQ的服务器请求用户的openid
 *
 * @author zcz
 * @date 2020/07/18
 */
@Component
public class OpenidUtil {
	@Value("${wx.openid.url}")
	private String WX_OPENID_URL;
	@Value("${wx.app.id}")
	private String WX_APP_ID;
	@Value("${wx.app.secret}")
	private String WX_SECRET;
//	@Value("${qq.openid.url}")
//	private String QQ_OPENID_URL;
//	@Value("${qq.app.id}")
//	private String QQ_APP_ID;
//	@Value("${qq.app.secret}")
//	private String QQ_SECRET;

	/**
	 * 用腾讯提供的API换取openid和session_key
	 *
	 * @param code     小程序提供的一次性登录用的code
	 * @param platform 小程序平台
	 * @return 以字符串形式返回API返回的JSON对象
	 * @throws SocketTimeoutException       请求超时
	 * @throws UnsupportedMimeTypeException 不知道是啥异常
	 * @throws HttpStatusException          不知道是啥异常
	 */
	@SneakyThrows({SocketTimeoutException.class, UnsupportedMimeTypeException.class, HttpStatusException.class})
	public String jscode2Session(String code, String platform) throws Exception {
		String openIdUrl = null, appId = null, secret = null;
		if ("wx".equalsIgnoreCase(platform)) {
			openIdUrl = WX_OPENID_URL;
			appId = WX_APP_ID;
			secret = WX_SECRET;
		}
//		else if("qq".equalsIgnoreCase(platform)){
//			openIdUrl=QQ_OPENID_URL;
//			appId=QQ_APP_ID;
//			secret=QQ_SECRET;
//		}else
//			throw someException(000,"非小程序禁止访问");
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("appid", appId);
		parameterMap.put("secret", secret);
		parameterMap.put("js_code", code);
		parameterMap.put("grant_type", "authorization_code");
		Connection.Response response = Jsoup.connect(openIdUrl)
				.data(parameterMap)
				.method(Connection.Method.GET)
				.execute();
		return response.body();
	}
}
