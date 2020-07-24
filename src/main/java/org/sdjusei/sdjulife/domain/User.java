package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author zcz
 * @date 2020/07/14
 */
@Data
@ApiModel(description = "学生用户")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(value = "学号")
	private String stuId;
	@ApiModelProperty(hidden = true)
	private String wxOpenid;
	@ApiModelProperty(hidden = true)
	private String qqOpenid;
}
