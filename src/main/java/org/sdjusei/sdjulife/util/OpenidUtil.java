package org.sdjusei.sdjulife.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.sdjusei.sdjulife.domain.Code2SessionResult;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.OpenidGetException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
	@Resource
	private ObjectMapper objectMapper;

	/**
	 * 用腾讯提供的API换取openid和session_key
	 *
	 * @param code     小程序提供的一次性登录用的code
	 * @param platform 小程序平台
	 * @return 以字符串形式返回API返回的JSON对象
	 * @throws SocketTimeoutException 请求超时
	 * @throws UnsupportedMimeTypeException 不知道是啥异常
	 * @throws HttpStatusException 不知道是啥异常
	 * @throws OpenidGetException 自定义的openid获取异常，处理腾讯服务器返回的错误码
	 */
	public Code2SessionResult jscode2Session(String code, String platform) throws Exception {
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
//		}
		else
			throw new OpenidGetException(ResultEnum.PLATFORM_PARAMETER_ERROR);
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("appid", appId);
		parameterMap.put("secret", secret);
		parameterMap.put("js_code", code);
		parameterMap.put("grant_type", "authorization_code");
		Connection.Response response = Jsoup.connect(openIdUrl)
				.data(parameterMap)
				.method(Connection.Method.GET)
				.execute();
		Code2SessionResult code2SessionResult = objectMapper.readValue(response.body(), Code2SessionResult.class);
		if("-1".equals(code2SessionResult.getErrCode()))
			throw new OpenidGetException(ResultEnum.OPENID_SERVER_BUSY_ERROR);
		else if("45011".equals(code2SessionResult.getErrCode()))
			throw new OpenidGetException(ResultEnum.OPENID_GET_TOO_FREQUENTLY_ERROR);
		else if("40029".equals(code2SessionResult.getErrCode()))
			throw new OpenidGetException(ResultEnum.CODE_INVALID_ERROR);
		else if("0".equals(code2SessionResult.getErrCode()))
			return code2SessionResult;
		else
			throw new OpenidGetException(ResultEnum.OPENID_ERROR);
	}
}
