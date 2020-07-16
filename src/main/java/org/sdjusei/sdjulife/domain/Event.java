package org.sdjusei.sdjulife.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Event {
	private Integer eventNumber;
	private Date beginDate;
	private Date endDate;
	private String eventDescribe;
}
