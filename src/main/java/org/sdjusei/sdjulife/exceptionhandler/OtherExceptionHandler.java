package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用异常处理类
 *
 * @author zcz
 * @date 2020/07/23
 */
@ControllerAdvice
public class OtherExceptionHandler {

	/**
	 * 通用运行时异常处理方法
	 *
	 * @return 返回服务端错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public Result<Void> runtimeException(RuntimeException runtimeException) {
		return Result.fail(ResultEnum.SERVER_ERROR);
	}

	/**
	 * 通用其他异常处理方法
	 *
	 * @return 返回未知错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Result<Void> otherException(Exception e) {
		return Result.fail(ResultEnum.UNKNOWN_ERROR);
	}
}
