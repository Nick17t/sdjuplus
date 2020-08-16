package org.sdjusei.sdjulife.domain;

import lombok.Data;

@Data
public class BookBorrowRecord {
	private String title;
	private String author;
	private String borrowDate;
	private String dueDate;
	private String barcode;
}
