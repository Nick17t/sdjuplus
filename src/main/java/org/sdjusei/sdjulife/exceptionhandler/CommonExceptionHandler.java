package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.exception.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用异常处理类
 *
 * @author zcz
 * @date 2020/07/24
 */
@ControllerAdvice
public class CommonExceptionHandler {

	@ResponseBody
	@ExceptionHandler
	public Result<Void> commonError(CommonException e) {
		return Result.fail(e.getCode(), e.getMessage());
	}
}
