package org.sdjusei.sdjulife.model.response;

import lombok.Data;

/**
 * 图书借阅记录实体类
 *
 * @author zcz
 * @date 2020/08/16
 */
@Data
public class BookBorrowRecord {
	private String title;
	private String author;
	private String borrowDate;
	private String dueDate;
	private String barcode;
}
