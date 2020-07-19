package org.sdjusei.sdjulife.util;

import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * 登录工具类，用于获取用户登录教务系统等的登录状态，以便多次使用
 *
 * @author zcz
 * @date 2020/07/17
 */
@Component
public class LoginUtil {
	public static void trustEveryone() throws Exception {
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new X509TrustManager[]{new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}
		}}, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	}

	public void emsLogin() throws Exception {
		trustEveryone();
	}

	public void ehallLogin() throws Exception {
		trustEveryone();
	}
}
