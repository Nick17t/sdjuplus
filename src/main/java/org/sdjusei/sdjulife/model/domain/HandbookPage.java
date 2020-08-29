package org.sdjusei.sdjulife.model.domain;

import lombok.Data;

/**
 * 学生手册单页实体类
 *
 * @author zcz
 * @date 2020/08/28
 */
@Data
public class HandbookPage {
	private int id;
	private int pageNumber;
	private String title;
	private String url;
}
