package org.sdjusei.sdjulife.exceptionhandler;

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
@ControllerAdvice
public class OpenidExceptionHandler {

	/**
	 * openid获取超时异常处理方法
	 *
	 * @param socketTimeoutException 捕获到的异常对象
	 * @return 返回openid获取超时错误的错误码和错误信息
	 */
	@ResponseBody
	@ExceptionHandler(value = SocketTimeoutException.class)
	public Result<Void> timeoutError(SocketTimeoutException socketTimeoutException) {
		return Result.fail(ResultEnum.OPENID_GET_TIMEOUT);
	}
}
