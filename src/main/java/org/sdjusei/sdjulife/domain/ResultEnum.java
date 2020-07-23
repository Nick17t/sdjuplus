package org.sdjusei.sdjulife.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码和状态信息的枚举类，保存了所有的状态码及对应的状态信息
 * 错误产生来源分为A/B/C，（参照阿里开发手册）
 * A表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题；
 * B表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；
 * C表示错误来源于第三方服务，比如CDN服务出错，消息投递超时等问题；
 * 四位数字编号从0001到9999，大类之间的步长间距预留100
 *
 * @author zcz
 * @date 2020/07/19
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
	UNKNOWN_ERROR("-1", "未知错误"),
	SUCCESS("00000", "请求成功"),
	USER_ERROR("A00001", "用户端错误"),

	SERVER_ERROR("B00001", "服务端错误"),

	THIRD_PARTY_ERROR("C00001", "第三方服务错误"),
	OPENID_ERROR("C00100","openid获取错误"),
	OPENID_GET_TIMEOUT_ERROR("C00101","openid获取超时"),
	PLATFORM_PARAMETER_ERROR("C00102","不合法的登录平台参数"),
	OPENID_SERVER_BUSY_ERROR("C00103","openid服务器繁忙"),
	OPENID_GET_TOO_FREQUENTLY_ERROR("C00104","openid获取太频繁"),
	CODE_INVALID_ERROR("C00105","登录code无效");
	private final String code;
	private final String message;
}
