package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 课程实体类
 *
 * @author zcz
 * @date 2020/07/15
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
	@JsonAlias("cdmc")
	private String position;    //场地名称
	@JsonAlias("jcs")
	private String numInDay;    //节次数
	@JsonAlias("kcmc")
	private String courseName;  //课程名称
	@JsonAlias("xm")
	private String teacherName; //（教师）姓名
	@JsonAlias("xqjmc")
	private String dayInWeek;   //星期几名称
	@JsonAlias("zcd")
	private String beginAndEndWeeks;//从第几周到第几周（实在是读不出来了,周次第？）
	private String mark;        //单双周标记，0为不分，1为单周，2为双周
}
