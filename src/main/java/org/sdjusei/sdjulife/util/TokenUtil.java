package org.sdjusei.sdjulife.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Token工具类，用于创建、验证、解析Token
 *
 * @author zcz
 * @date 2020/07/18
 */
@Component
public class TokenUtil {
	private static final String SECRET = "SDJUPLUS IS HARD TO DEVELOP.";
	private static final String ISSUER = "SDJUSEI";
	private static long EXPIRE_TIME;

	@Value("${token.expire.time}")
	public static void setExpireTime(long expireTime) {
		EXPIRE_TIME = expireTime;
	}

	/**
	 * 创建Token
	 *
	 * @param id 任意ID
	 * @return 返回生成的Token
	 */
	public static String createJwtToken(String id) {
		return JWT.create()
				.withIssuer(ISSUER)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
				.withClaim("id", id)
				.sign(Algorithm.HMAC256(SECRET));
	}

	/**
	 * 验证Token有效性
	 *
	 * @param token 包含token的字符串
	 * @throws AlgorithmMismatchException
	 * @throws SignatureVerificationException 签名无效
	 * @throws TokenExpiredException          Token过期
	 * @throws InvalidClaimException          claim中的信息无效
	 */
	public static void verifyJwtToken(String token) throws JWTVerificationException {
		DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
				.withIssuer(ISSUER)
				.build()
				.verify(token);
	}

	/**
	 * Token解码，获取payload中的身份信息
	 *
	 * @param token 包含Token的字符串
	 * @return 返回Token中的信息
	 */
	public static String decodeJwtToken(String token) {
		return JWT.decode(token)
				.getClaim("openid")
				.asString();
	}
}
