package org.sdjusei.sdjulife.exceptionhandler;

import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.util.SchoolSysAccessUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;

/**
 * 服务异常处理类
 *
 * @author zcz
 * @date 2020/07/25
 */
@RestControllerAdvice(basePackageClasses = SchoolSysAccessUtil.class)
public class SchoolSysAccessExceptionHandler {

	/**
	 * Jsoup发送HTTPS请求时会抛出的异常
	 *
	 * @param generalSecurityException 通用安全错误
	 * @return 返回错误码和错误信息
	 */
	@ExceptionHandler(value = {GeneralSecurityException.class})
	public Result<Void> trustError(GeneralSecurityException generalSecurityException) {
		return Result.fail(ResultEnum.SERVER_ERROR);
	}

	@ExceptionHandler(value = SocketTimeoutException.class)
	public Result<Void> timeoutError(SocketTimeoutException socketTimeoutException) {
		return Result.fail(ResultEnum.SCHOOL_SYS_LOGIN_TIMEOUT);
	}
}
