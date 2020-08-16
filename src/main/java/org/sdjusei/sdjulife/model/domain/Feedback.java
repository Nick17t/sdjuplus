package org.sdjusei.sdjulife.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * 反馈信息实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
public class Feedback {
	private Integer feedbackNumber;
	private Integer stuId;
	private String title;
	private String describe;
	private Date submitTime;
	private Integer adminId;
}
