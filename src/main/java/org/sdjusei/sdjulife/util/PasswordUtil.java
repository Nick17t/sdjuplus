package org.sdjusei.sdjulife.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 密码处理方法（仅加密为AES-128-CBC），
 *
 * @author zcz
 * @date 2020/08/06
 * @deprecated 建议仅测试使用，加密应在前端完成
 */
public class PasswordUtil {
	private static final String $aes_chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";

	public static String encryptAES(String data, String aesKey) throws Exception {
		if (aesKey == null) {
			return data;
		}
		return getAesString(randomString(64) + data, aesKey, randomString(16));
	}

	private static String getAesString(String data, String key, String iv) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = cipher.doFinal(data.getBytes());
		String s = Base64.getEncoder().encodeToString(encrypted);
		return s;
	}

	private static String randomString(int len) {
		StringBuilder retStr = new StringBuilder();
		for (int i = 0; i < len; i++) {
			retStr.append($aes_chars.charAt((int) Math.floor(Math.random() * $aes_chars.length())));
		}
		return retStr.toString();
	}

}
