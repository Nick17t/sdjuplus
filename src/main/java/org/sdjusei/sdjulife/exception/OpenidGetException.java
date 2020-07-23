package org.sdjusei.sdjulife.exception;

import lombok.Getter;
import org.sdjusei.sdjulife.domain.ResultEnum;

/**
 *
 */
@Getter
public class OpenidGetException extends RuntimeException {
	private final String code;

	public OpenidGetException(String code, String message) {
		super(message);
		this.code = code;
	}

	public OpenidGetException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
