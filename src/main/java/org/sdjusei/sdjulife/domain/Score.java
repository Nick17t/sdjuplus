package org.sdjusei.sdjulife.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 成绩实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {
	@JsonAlias("cj")
	private Integer socre;         //成绩
	@JsonAlias("cjsfzf")
	private boolean isInvalid;     //成绩是否作废
	@JsonAlias("jd")
	private Double gradePoint;     //绩点
	@JsonAlias("xf")
	private Double credit;         //学分
	@JsonAlias("kch")
	private String courseId;       //课程号
	@JsonAlias("kcmc")
	private String courseName;     //课程名称
	@JsonAlias("xh")
	private String stuId;          //学号
	@JsonAlias("xnmc")
	private String year;           //学年名
	@JsonAlias("xq")
	private String semester;       //学期
}
