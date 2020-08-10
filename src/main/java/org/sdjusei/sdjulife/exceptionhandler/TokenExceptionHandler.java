package org.sdjusei.sdjulife.exceptionhandler;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.util.TokenUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Token异常处理类
 *
 * @author zcz
 * @date 2020/07/24
 */
@RestControllerAdvice(basePackageClasses = TokenUtil.class)
public class TokenExceptionHandler {

	/**
	 * token创建错误处理方法
	 *
	 * @param jwtCreationException token创建异常
	 * @return 返回token创建错误的错误码和错误信息
	 */
	@ExceptionHandler(value = JWTCreationException.class)
	public Result<Void> tokenCreateError(JWTCreationException jwtCreationException) {
		return Result.fail(ResultEnum.TOKEN_CREATE_ERROR);
	}

	/**
	 * token验证错误处理方法（默认为用户端错误）
	 *
	 * @param jwtVerificationException token验证异常
	 * @return 返回验证异常的错误码和错误信息
	 */
	@ExceptionHandler(value = JWTVerificationException.class)
	public Result<Void> tokenVerificationError(JWTVerificationException jwtVerificationException) {
		return Result.fail(ResultEnum.TOKEN_INVALID);
	}
}
