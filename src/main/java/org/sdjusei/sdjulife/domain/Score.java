package org.sdjusei.sdjulife.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 成绩实体类
 *
 * @author zcz
 * @date 2020/07/16
 */
@Data
public class Score {
	@SerializedName("cj")
	private Integer socre;         //成绩
	@SerializedName("cjsfzf")
	private boolean isInvalid;     //成绩是否作废
	@SerializedName("jd")
	private Double gradePoint;     //绩点
	@SerializedName("xf")
	private Double credit;         //学分
	@SerializedName("kch")
	private String courseId;       //课程号
	@SerializedName("kcmc")
	private String courseName;     //课程名称
}
