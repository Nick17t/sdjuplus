package org.sdjusei.sdjulife.model.domain;

import lombok.Data;

/**
 * 班车信息实体类
 *
 * @author zcz
 * @date 2020/08/27
 */
@Data
public class BusInfo {
	private String category;
	private String name;
	private String driver;
	private String driverPhone;
	private String busNumber;
	private String schedule;
	private String remark;
}
