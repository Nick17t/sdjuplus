package org.sdjusei.sdjulife.util;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Map;

/**
 * Jsoup工具类
 *
 * @author zcz
 * @date 2020/07/17
 */
@Component
public class JsoupUtil {
	/**
	 * 处理HttpClient和Jsoup无法访问Https问题
	 *
	 * @throws GeneralSecurityException 以下两个异常类的父类
	 * @throws NoSuchAlgorithmException 抛出，由SchoolSysAccessExceptionHandler处理
	 * @throws KeyManagementException   同上
	 */
	public static void trustEveryone() throws Exception {
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new X509TrustManager[]{new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		}}, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	}

}
