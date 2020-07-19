package org.sdjusei.sdjulife.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 登录请求实体类
 *
 * @author zcz
 * @date 2020/07/17
 */
@Component
@Data
public class UserLoginMsg {
	@ApiModelProperty(value = "登录校验code", required = true)
	private String code;
	@ApiModelProperty(value = "请求来源", required = true, example = "wx")
	private String platform;

	@Override
	public String toString() {
		return "{\"code\":" + "\"" + code + "\"" + "," +
				"\"platform\":" + "\"" + platform + "\"" +
				"}";
	}
}
