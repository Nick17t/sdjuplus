package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 考试信息实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exam {
	@JsonAlias("xf")
	private Double credit;      //学分
	@JsonAlias("kch")
	private String courseId;    //课程号
	@JsonAlias("kcmc")
	private String courseName;  //课程名称
	@JsonAlias("xh")
	private String stuId;       //学号
	@JsonAlias("xnm")
	private String year;        //学年名
	@JsonAlias("xq")
	private String semester;    //学期
	@JsonAlias("cdmc")
	private String examPosition;//考试地点
	@JsonAlias("kssj")
	private String examTime;    //考试时间
}
