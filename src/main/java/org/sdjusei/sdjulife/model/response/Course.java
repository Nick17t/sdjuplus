package org.sdjusei.sdjulife.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

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
	private String node;        //节次
	@SerializedName("kcmc")
	private String courseName;  //课程名称
	@SerializedName("xm")
	private String teacherName; //（教师）姓名
	private List<Integer> weeks;
}
