package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.model.domain.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用异常处理类(兜底处理类，处理其他Handler无法拦截的异常)
 *
 * @author zcz
 * @date 2020/07/23
 */
@RestControllerAdvice
public class OtherExceptionHandler {

	/**
	 * 通用运行时异常处理方法
	 *
	 * @return 返回服务端错误的错误码和错误信息
	 */
	@ExceptionHandler(RuntimeException.class)
	public Result<Void> runtimeException(RuntimeException runtimeException) {
		return Result.fail(ResultEnum.SERVER_ERROR);
	}

	/**
	 * 通用其他异常处理方法
	 *
	 * @return 返回未知错误的错误码和错误信息
	 */
	@ExceptionHandler(Exception.class)
	public Result<Void> otherException(Exception e) {
		return Result.fail(ResultEnum.UNKNOWN_ERROR);
	}
}
