package org.sdjusei.sdjulife.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sdjusei.sdjulife.domain.CardRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 一卡通服务
 *
 * @author zcz
 * @date 2020/08/14
 */
@Service
public class CardService {

	@Value("${cardSys.homePageUrl}")
	private String homePageUrl;

	/**
	 * 一卡通主页获取方法
	 *
	 * @param unifiedSysCookies 统一认证系统Cookie
	 * @return 返回主页
	 * @throws Exception Jsoup的所有异常
	 */
	public Document getHomePage(Map<String, String> unifiedSysCookies) throws Exception {
		return Jsoup.connect(homePageUrl)
				.cookies(unifiedSysCookies)
				.get();
	}

	/**
	 * 余额获取方法
	 *
	 * @param page 主页
	 * @return 余额
	 */
	public String getBalance(Document page) {
		return page.getElementsByTag("dd")
				.get(0)
				.getElementsByTag("p")
				.get(1)
				.html()
				.split("：")[1]
				.replaceAll("元", "");
	}

	/**
	 * 交易记录获取方法
	 *
	 * @param page 主页
	 * @return 交易记录实体类List
	 */
	public List<CardRecord> getTransactionRecord(Document page) {
		List<CardRecord> cardRecords = new ArrayList<>();
		Elements trs = page.getElementsByTag("tbody").get(0).select("tr");
		for (Element e : trs) {
			Elements tds = e.select("td");
			CardRecord cardRecord = new CardRecord();
			cardRecord.setDate(tds.get(0).select("div").get(0).text());
			cardRecord.setType(tds.get(1).select("a").text());
			cardRecord.setPayee(tds.get(2).text());
			cardRecord.setSum(tds.get(3).text());
			cardRecord.setIsSuccessful(tds.get(4).text());
			cardRecords.add(cardRecord);
		}
		return cardRecords;
	}
}
