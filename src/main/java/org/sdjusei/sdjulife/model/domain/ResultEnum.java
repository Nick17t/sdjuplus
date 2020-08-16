package org.sdjusei.sdjulife.model.domain;

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
	SUCCESS("000000", "请求成功"),

	USER_ERROR("A00001", "用户端错误"),
	MINI_PRO_LOGIN_INFO_ERROR("A00100", "登录信息错误"),
	MINI_PRO_LOGIN_INFO_MISSING("A00101", "登录信息缺失"),
	TOKEN_INVALID("A00200", "token无效"),
	SCHOOL_SYS_NOT_LOGIN("A00210", "未登录统一认证系统"),
	SCHOOL_SYS_LOGIN_FAIL("A00300", "统一认证系统登录失败"),
	STU_ID_MISSING("A00301", "学号为空"),
	CAPTCHA_CODE_MISSING("A00302", "验证码为空"),

	SERVER_ERROR("B00001", "服务端错误"),
	TOKEN_CREATE_ERROR("B00010", "token创建失败"),
	USER_REGISTER_FAIL("B00020", "用户注册失败"),
	USER_LOGOFF_FAIL("B00021", "用户注销失败"),
	USER_UPDATE_FAIL("B00022", "用户信息更新失败"),

	THIRD_PARTY_ERROR("C00001", "第三方服务错误"),
	OPENID_GET_ERROR("C00100", "openid获取错误"),
	OPENID_GET_TIMEOUT("C00101", "openid获取超时"),
	PLATFORM_PARAMETER_ILLEGAL("C00102", "不合法的登录平台参数"),
	OPENID_SERVER_BUSY("C00103", "openid服务器繁忙"),
	OPENID_GET_TOO_FREQUENTLY("C00104", "openid获取太频繁"),
	CODE_INVALID("C00105", "登录code无效"),
	SCHOOL_SYS_REQUEST_ERROR("COO200", "学校系统请求出错"),
	SCHOOL_SYS_ACCESS_FAILED("C00210", "学校系统连接失败"),
	SCHOOL_SYS_LOGIN_TIMEOUT("C00211", "学校系统登录超时"),
	EMS_COURSE_GET_FAIL("C00212", "课表获取失败"),
	EMS_SCORE_GET_FAIL("C00213", "成绩获取失败"),
	EMS_EXAM_GET_FAIL("C00214", "考试信息获取失败"),
	LIB_SYS_LOCATION_GET_FAIL("C00215", "图书在馆信息获取失败");

	private final String code;
	private final String message;
}
