package org.sdjusei.sdjulife.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
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
	/**
	 * SECRET字段
	 */
	private static final String SECRET = "SDJUPLUS IS HARD TO DEVELOP.";
	/**
	 * 签发者
	 */
	private static final String ISSUER = "SDJUSEI";
	private static long EXPIRE_TIME;

	@Value("${token.expireTime}")
	public static void setExpireTime(long expireTime) {
		EXPIRE_TIME = expireTime;
	}

	/**
	 * 创建Token
	 *
	 * @param userId 用户ID
	 * @return 返回生成的Token
	 * @throws JWTCreationException token创建异常
	 */
	public static String createJwtToken(String userId) {
		return JWT.create()
				.withIssuer(ISSUER)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
				.withClaim("user_id", userId)
				.sign(Algorithm.HMAC256(SECRET));
	}

	/**
	 * 验证Token有效性
	 *
	 * @param token 包含token的字符串
	 * @throws JWTVerificationException       总的验证异常，下面都是其子异常
	 * @throws AlgorithmMismatchException     算法不匹配
	 * @throws SignatureVerificationException 签名无效
	 * @throws TokenExpiredException          Token过期
	 * @throws InvalidClaimException          claim中的信息无效
	 */
	public static void verifyJwtToken(String token) {
		JWT.require(Algorithm.HMAC256(SECRET))
				.withIssuer(ISSUER)
				.build()
				.verify(token);
	}

	/**
	 * Token解码，底层先验证，再获取payload中的身份信息
	 *
	 * @param token 包含Token的字符串
	 * @return 返回Token中的信息
	 * @throws JWTDecodeException 解码异常，是验证异常的子类
	 */
	public static Integer decodeJwtToken(String token) {
		return JWT.decode(token)
				.getClaim("user_id")
				.asInt();
	}
}
