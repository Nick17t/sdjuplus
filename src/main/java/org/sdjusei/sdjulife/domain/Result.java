package org.sdjusei.sdjulife.domain;

import lombok.Data;

/**
 * 通用返回JSON模板
 *
 * @author zcz
 * @date 2020/07/18
 */
@Data
public class Result {
	private String code;
	private String message;
	private Object data;

	public Result() {
	}

	public Result(ResultEnum resultEnum){
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}

	public Result(ResultEnum resultEnum, Object data) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
		this.data = data;
	}
}
