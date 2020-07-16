package org.sdjusei.sdjulife.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
	private Integer feedbackNumber;
	private Integer replyNumber;
	private String title;
	private String describe;
	private Date submitTime;
	private Integer posterNumber;
}
