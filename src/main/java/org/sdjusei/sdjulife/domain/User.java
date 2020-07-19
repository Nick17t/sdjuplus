package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author zcz
 * @date 2020/07/14
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private Integer userId;
	private String stuId;
	private String wxOpenid;
	private String qqOpenid;
}
