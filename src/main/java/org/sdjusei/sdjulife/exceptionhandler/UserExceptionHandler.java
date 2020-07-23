package org.sdjusei.sdjulife.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户异常处理类
 *
 * @author zcz
 * @date 2020/07/19
 */
@ControllerAdvice
public class UserExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = {})
	public String loginExceptionHandler() {
		return "";
	}
}
