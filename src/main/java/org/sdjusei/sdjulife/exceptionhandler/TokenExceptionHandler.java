package org.sdjusei.sdjulife.exceptionhandler;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Token异常处理类
 *
 * @author zcz
 * @date 2020/07/24
 */
@ControllerAdvice
public class TokenExceptionHandler {

	/**
	 * token创建错误处理方法
	 *
	 * @param jwtCreationException token创建异常
	 * @return 返回token创建错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(value = JWTCreationException.class)
	public Result tokenCreateError(JWTCreationException jwtCreationException) {
		return new Result(ResultEnum.TOKEN_CREATE_ERROR);
	}

	/**
	 * token验证错误处理方法（默认为用户端错误）
	 *
	 * @param jwtVerificationException token验证异常
	 * @return 返回验证异常的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(value = JWTVerificationException.class)
	public Result tokenVerificationError(JWTVerificationException jwtVerificationException) {
		return new Result(ResultEnum.TOKEN_INVALID);
	}
}
