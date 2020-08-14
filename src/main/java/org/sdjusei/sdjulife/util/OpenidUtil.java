package org.sdjusei.sdjulife.util;

import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.sdjusei.sdjulife.domain.Code2SessionResult;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

	private static String WX_OPENID_URL;
	private static String WX_APP_ID;
	private static String WX_SECRET;
	private static String QQ_OPENID_URL;
	private static String QQ_APP_ID;
	private static String QQ_SECRET;

	/**
	 * 用腾讯提供的API换取openid和session_key
	 *
	 * @param code     小程序提供的一次性登录用的code
	 * @param platform 小程序平台
	 * @return 以字符串形式返回API返回的JSON对象
	 * @throws SocketTimeoutException       请求超时
	 * @throws UnsupportedMimeTypeException 不知道是啥异常
	 * @throws HttpStatusException          HTTP状态码异常（不是200）
	 * @throws CommonException              自定义异常
	 */
	public Code2SessionResult jsCode2Session(String code, String platform) throws IOException {
		String openIdUrl, appId, secret;

		//判断请求的平台
		if ("wx".equalsIgnoreCase(platform)) {
			openIdUrl = WX_OPENID_URL;
			appId = WX_APP_ID;
			secret = WX_SECRET;
		} else if ("qq".equalsIgnoreCase(platform)) {
			openIdUrl = QQ_OPENID_URL;
			appId = QQ_APP_ID;
			secret = QQ_SECRET;
		} else {
			throw new CommonException(ResultEnum.PLATFORM_PARAMETER_ILLEGAL);
		}

		//使用Jsoup获取openid和session_key
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("appid", appId);
		parameterMap.put("secret", secret);
		parameterMap.put("js_code", code);
		parameterMap.put("grant_type", "authorization_code");
		Connection.Response response = Jsoup.connect(openIdUrl)
				.data(parameterMap)
				.method(Connection.Method.GET)
				.execute();
		Code2SessionResult code2SessionResult = new Gson().fromJson(response.body(), Code2SessionResult.class);

		//根据返回的errCode，抛出异常，进行统一处理
		if ("-1".equals(code2SessionResult.getErrCode())) {
			throw new CommonException(ResultEnum.OPENID_SERVER_BUSY);
		} else if ("45011".equals(code2SessionResult.getErrCode())) {
			throw new CommonException(ResultEnum.OPENID_GET_TOO_FREQUENTLY);
		} else if ("40029".equals(code2SessionResult.getErrCode())) {
			throw new CommonException(ResultEnum.CODE_INVALID);
		} else if ("0".equals(code2SessionResult.getErrCode())) {
			return code2SessionResult;
		} else {
			throw new CommonException(ResultEnum.OPENID_GET_ERROR);
		}
	}

	@Value("${wx.openid.url}")
	public static void setWxOpenidUrl(String wxOpenidUrl) {
		WX_OPENID_URL = wxOpenidUrl;
	}

	@Value("${wx.app.id}")
	public static void setWxAppId(String wxAppId) {
		WX_APP_ID = wxAppId;
	}

	@Value("${wx.app.secret}")
	public static void setWxSecret(String wxSecret) {
		WX_SECRET = wxSecret;
	}

	@Value("${qq.openid.url}")
	public static void setQqOpenidUrl(String qqOpenidUrl) {
		QQ_OPENID_URL = qqOpenidUrl;
	}

	@Value("${qq.app.id}")
	public static void setQqAppId(String qqAppId) {
		QQ_APP_ID = qqAppId;
	}

	@Value("${qq.app.secret}")
	public static void setQqSecret(String qqSecret) {
		QQ_SECRET = qqSecret;
	}
}
