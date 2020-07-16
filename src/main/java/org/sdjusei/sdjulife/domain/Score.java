package org.sdjusei.sdjulife.domain;

import lombok.Data;

@Data
public class Score {
	private Integer cj;     //成绩
	private boolean cjsfzf; //成绩是否作废
	private Double jd;      //绩点
	private Double xf;      //学分
	private String kch;     //课程号
	private String kcmc;    //课程名称
	private String xh;      //学号
	private String xnmc;     //学年名
	private String xq;      //学期
}
