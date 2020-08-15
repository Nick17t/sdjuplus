package org.sdjusei.sdjulife.domain;

import lombok.Data;

/**
 * 一卡通交易记录实体类
 *
 * @author zcz
 * @date 2020/08/15
 */
@Data
public class CardRecord {
	private String date;
	private String type;
	private String payee;
	private String sum;
	private String isSuccessful;
}
