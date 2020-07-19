package org.sdjusei.sdjulife.domain;

import lombok.Data;


/**
 * 管理用户实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
public class Admin {
	private Integer adminId;
	private String password;
	//TODO 表示管理用户权限的属性
}
