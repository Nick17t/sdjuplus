package org.sdjusei.sdjulife.domain;

import lombok.Data;

import java.util.Date;

/**
 * 活动、事件实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
public class Event {
	private Integer eventNumber;
	private Date beginDate;
	private Date endDate;
	private String eventDescribe;
}
