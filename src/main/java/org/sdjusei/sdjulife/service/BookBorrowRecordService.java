package org.sdjusei.sdjulife.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sdjusei.sdjulife.domain.BookBorrowRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 图书借阅记录查询服务
 *
 * @author zcz
 * @date 2020/08/16
 */
@Service
public class BookBorrowRecordService {

	@Value("${librarySys.borrowRecordUrl}")
	private String borrowRecordUrl;

	public List<BookBorrowRecord> getBorrowRecord(Map<String, String> cookies) throws Exception {
		//通过统一认证系统来登录借阅系统
		Elements elements = Jsoup.connect(borrowRecordUrl)
				.cookies(cookies)
				.get()
				.getElementById("contentTable")
				.getElementsByTag("tr");

		//删掉标题行
		elements.remove(0);

		List<BookBorrowRecord> records = new ArrayList<>();
		for (Element e : elements) {
			BookBorrowRecord record = new BookBorrowRecord();
			Elements tds = e.getElementsByTag("td");
			//获得条码编号
			record.setBarcode(tds.get(0).text());
			//获得标题
			record.setTitle(tds.get(1).text());
			//获得作者
			record.setAuthor(tds.get(2).text());
			//获得借书日期
			record.setBorrowDate(tds.get(6).text());
			//获得应还日期
			record.setDueDate(tds.get(7).text());
			records.add(record);
		}

		return records;
	}
}
