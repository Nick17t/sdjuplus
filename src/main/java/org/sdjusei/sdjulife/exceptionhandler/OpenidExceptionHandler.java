package org.sdjusei.sdjulife.exceptionhandler;

import org.jsoup.HttpStatusException;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.util.OpenidUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

/**
 * openid获取异常处理类，只处理获取openid时的异常（即OpenidUtil中的）
 *
 * @author zcz
 * @date 2020/07/23
 */
@RestControllerAdvice(basePackageClasses = OpenidUtil.class)
public class OpenidExceptionHandler {

	/**
	 * openid获取超时异常处理方法
	 *
	 * @param socketTimeoutException 捕获到的异常对象
	 * @return 返回openid获取超时错误的错误码和错误信息
	 */
	@ExceptionHandler(value = SocketTimeoutException.class)
	public Result<Void> timeoutError(SocketTimeoutException socketTimeoutException) {
		return Result.fail(ResultEnum.OPENID_GET_TIMEOUT);
	}

	/**
	 * openid获取错误
	 *
	 * @param httpStatusException http请求状态码不是200
	 * @return 返回错误码和错误信息
	 */
	@ExceptionHandler(value = HttpStatusException.class)
	public Result<Void> httpStatusError(HttpStatusException httpStatusException) {
		return Result.fail(ResultEnum.OPENID_GET_ERROR);
	}
}
