package org.sdjusei.sdjulife.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 公用Exception处理类，处理所有Exception
 *
 * @author zcz
 * @date 2020/07/19
 */
@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler
	public String loginExceptionHandler() {
		return "";
	}
}
