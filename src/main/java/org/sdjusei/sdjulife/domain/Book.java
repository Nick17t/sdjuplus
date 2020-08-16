package org.sdjusei.sdjulife.domain;

import lombok.Data;

/**
 * 图书馆系统图书实体类
 *
 * @author zcz
 * @date 2020/08/15
 */
@Data
public class Book {
	private String isbn;
	private String bookrecno;
	private String title;
	private String author;
	private String publisher;
}
