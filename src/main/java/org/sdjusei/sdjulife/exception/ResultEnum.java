package org.sdjusei.sdjulife.exception;

import lombok.Getter;

/**
 * 状态码和状态信息的枚举类，保存了所有的状态码及对应的状态信息
 * 错误产生来源分为A/B/C，
 * A表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题；
 * B表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；
 * C表示错误来源于第三方服务，比如CDN服务出错，消息投递超时等问题；
 * 四位数字编号从0001到9999，大类之间的步长间距预留100
 *
 * @author zcz
 * @date 2020/07/19
 */
@Getter
public enum ResultEnum {
	UNKNOWN_ERROR("-1", "未知错误"),
	LOGIN_SUCCESS("200", "登录成功");


	private String code;
	private String message;

	ResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
