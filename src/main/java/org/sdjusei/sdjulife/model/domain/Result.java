package org.sdjusei.sdjulife.model.domain;

/**
 * 通用返回JSON模板
 *
 * @author zcz
 * @date 2020/07/18
 */
public class Result<T> {
	private String code;
	private String message;
	private T data;

	public Result() {
	}

	private Result(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private Result(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	private Result(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}

	private Result(ResultEnum resultEnum, T data) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
		this.data = data;
	}

	public static Result<Void> success() {
		return new Result<>(ResultEnum.SUCCESS);
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(ResultEnum.SUCCESS, data);
	}

	public static Result<Void> success(String code, String message) {
		return new Result<>(code, message);
	}

	public static <T> Result<T> success(String code, String message, T data) {
		return new Result<>(code, message, data);
	}

	public static Result<Void> fail(ResultEnum resultEnum) {
		return new Result<>(resultEnum);
	}

	public static <T> Result<T> fail(ResultEnum resultEnum, T data) {
		return new Result<>(resultEnum, data);
	}

	public static Result<Void> fail(String code, String message) {
		return new Result<>(code, message);
	}

	public static <T> Result<T> fail(String code, String message, T data) {
		return new Result<>(code, message, data);
	}
}
