package org.sdjusei.sdjulife.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 考试信息实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
public class Exam {
	@SerializedName("xf")
	private Double credit;      //学分
	@SerializedName("kch")
	private String courseId;    //课程号
	@SerializedName("kcmc")
	private String courseName;  //课程名称
	@SerializedName("xh")
	private String stuId;       //学号
	@SerializedName("xnm")
	private String year;        //学年名
	@SerializedName("xq")
	private String semester;    //学期
	@SerializedName("cdmc")
	private String examPosition;//考试地点
	@SerializedName("kssj")
	private String examTime;    //考试时间
}
