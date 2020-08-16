package org.sdjusei.sdjulife.domain;

import lombok.Data;

/**
 * 图书在馆信息实体类
 *
 * @author zcz
 * @date 2020/08/16
 */
@Data
public class BookLocation {
	private String bookrecno;
	private String callno;
	private String curlocalName;
	private int copycount;
	private int loanableCount;
	private String barcode;
}
