package org.sdjusei.sdjulife.model.response;

import lombok.Data;

/**
 * code换取openid和session_key时返回的JSON对应的实体类
 *
 * @author zcz
 * @date 2020/07/18
 */
@Data
public class Code2SessionResult {
	private String openId;
	private String sessionKey;
	private String errCode;
	private String errMsg;
}
