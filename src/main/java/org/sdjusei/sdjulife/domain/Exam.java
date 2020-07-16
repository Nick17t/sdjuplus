package org.sdjusei.sdjulife.domain;

import lombok.Data;

@Data
public class Exam {
	private Double xf;      //学分
	private String kch;     //课程号
	private String kcmc;    //课程名称
	private String xh;      //学号
	private String xnm;     //学年名
	private String xq;      //学期
	private String cdmc;    //考试地点
	private String kssj;    //考试时间
}
