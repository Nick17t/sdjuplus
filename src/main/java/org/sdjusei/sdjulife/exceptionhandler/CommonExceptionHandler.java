package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用异常处理类（能够自行检查的异常）
 *
 * @author zcz
 * @date 2020/07/24
 */
@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler
	public Result<Void> commonError(CommonException e) {
		return Result.fail(e.getCode(), e.getMessage());
	}
}
