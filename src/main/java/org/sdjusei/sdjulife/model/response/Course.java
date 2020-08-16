package org.sdjusei.sdjulife.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 课程实体类
 *
 * @author zcz
 * @date 2020/07/15
 */
@Data
public class Course {
	@SerializedName("cdmc")
	private String position;    //场地名称
	@SerializedName("jcs")
	private String numInDay;    //节次数
	@SerializedName("kcmc")
	private String courseName;  //课程名称
	@SerializedName("xm")
	private String teacherName; //（教师）姓名
	@SerializedName("xqjmc")
	private String dayInWeek;   //星期几名称
	@SerializedName("zcd")
	private String beginAndEndWeeks;//从第几周到第几周（实在是读不出来了,周次第？）
	private Integer mark;        //单双周标记，0为不分，1为单周，2为双周
}
