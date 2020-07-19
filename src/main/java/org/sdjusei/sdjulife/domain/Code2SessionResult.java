package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * code换取openid和session_key时返回的JSON对应的实体类
 *
 * @author zcz
 * @date 2020/07/18
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code2SessionResult {
	private String openId;
	private String sessionKey;
	private String errCode;
	private String errMsg;
}
