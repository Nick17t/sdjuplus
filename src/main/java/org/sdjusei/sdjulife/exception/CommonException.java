package org.sdjusei.sdjulife.exception;

import lombok.Getter;
import org.sdjusei.sdjulife.domain.ResultEnum;

/**
 * 通用异常类
 *
 * @author zcz
 * @date 2020/07/24
 */
@Getter
public class CommonException extends RuntimeException {

	private final String code;

	public CommonException(String code, String message) {
		super(message);
		this.code = code;
	}

	public CommonException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}