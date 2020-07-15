package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
	private String cdmc;    //场地名称
	private String jcs;     //节次数
	private String kcmc;    //课程名称
	private String xm;      //（教师）姓名
	private String xqjmc;   //星期几名称
	private String zcd;     //从第几周到第几周（实在是读不出来了,周次第？）
	private String mark;    //单双周标记，0为不分，1为单周，2为双周
}
