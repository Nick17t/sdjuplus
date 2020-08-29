package org.sdjusei.sdjulife.model.domain;

import lombok.Data;

/**
 * 学校电话黄页实体类
 *
 * @author zcz
 * @date 2020/08/28
 */
@Data
public class ContactInfo {
	//完整机构名称（一级名称+二级名称+……）
	private String branchName;
	private String position;
	private String phoneNumber;
}
