package org.sdjusei.sdjulife.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sdjusei.sdjulife.model.response.SchoolNotice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校通知获取服务
 *
 * @author zcz
 * @date 2020/08/16
 */
@Service
public class SchoolNoticeService {

	@Value("${homepage.homePageUrl}")
	private String homePageUrl;
	@Value("${homepage.xwNoticeUrl}")
	private String xwNoticeUrl;
	@Value("${homepage.jxNoticeUrl}")
	private String jxNoticeUrl;

	/**
	 * 通知获取方法
	 *
	 * @param location 具体的通知分类，xw（校务）或者jx（教学）
	 * @return 返回通知实体类List
	 * @throws Exception 所有Jsoup可能抛出的异常
	 */
	public List<SchoolNotice> getNoticeList(String location) throws Exception {
		String url = "";
		if ("xw".equalsIgnoreCase(location))
			url = homePageUrl + xwNoticeUrl;
		else if ("jx".equalsIgnoreCase(location))
			url = homePageUrl + jxNoticeUrl;
		List<SchoolNotice> notices = new ArrayList<>();
		//获取通知列表
		Elements elements = Jsoup.connect(url)
				.get()
				.getElementById("wp_news_w9")
				.getElementsByTag("li");

		//分析页面中的信息装入通知实体类
		for (Element e : elements) {
			SchoolNotice schoolNotice = new SchoolNotice();
			String noticeBodyUrl = "";
			Elements spans = e.getElementsByTag("li")
					.get(0)
					.getElementsByTag("span");
			Attributes attributes = spans
					.get(0)
					.getElementsByTag("a")
					.get(0)
					.attributes();
			noticeBodyUrl = homePageUrl + attributes.get("href");
			schoolNotice.setTitle(attributes.get("title"));
			schoolNotice.setDate(spans.get(1).text());
			schoolNotice.setNoticeBodyUrl(noticeBodyUrl);
			notices.add(schoolNotice);
		}
		return notices;
	}

	/**
	 * 通知内容获取方法
	 *
	 * @param noticeBodyUrl 通知链接
	 * @return 通知内容
	 * @throws Exception 所有Jsoup的异常
	 * @deprecated 无法处理复杂的通知
	 */
	public String getNoticeBody(String noticeBodyUrl) throws Exception {
		Connection.Response response = Jsoup.connect(noticeBodyUrl)
				.followRedirects(false)
				.execute();
		//需要跳转认证则表示该通知内容无法获取
		if (response.statusCode() == 302)
			return null;
		return response
				.parse()
				.getElementsByClass("wp_articlecontent")
				.text();
	}
}
