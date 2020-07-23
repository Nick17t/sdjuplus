package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.controller.UserController;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.SocketTimeoutException;

/**
 * openid获取异常处理类
 *
 * @author zcz
 * @date 2020/07/23
 */
@ControllerAdvice(basePackageClasses = UserController.class)
public class OpenidExceptionHandler {

	/**
	 * openid获取超时异常处理方法
	 *
	 * @param socketTimeoutException 捕获到的异常对象
	 * @return 返回openid获取超时错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(value = SocketTimeoutException.class)
	public Result timeoutError(SocketTimeoutException socketTimeoutException) {
		return new Result(ResultEnum.OPENID_GET_TIMEOUT_ERROR);
	}

	/**
	 * openid获取其他异常处理方法
	 *
	 * @param exception 捕获到的异常对象
	 * @return 返回openid获取错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result otherError(Exception exception) {
		return new Result(ResultEnum.OPENID_ERROR);
	}
}
