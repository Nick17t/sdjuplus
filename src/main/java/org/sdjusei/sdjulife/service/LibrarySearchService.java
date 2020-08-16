package org.sdjusei.sdjulife.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sdjusei.sdjulife.exception.CommonException;
import org.sdjusei.sdjulife.model.domain.ResultEnum;
import org.sdjusei.sdjulife.model.response.Book;
import org.sdjusei.sdjulife.model.response.BookLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书查询服务
 *
 * @author zcz
 * @date 2020/08/15
 */
@Service
public class LibrarySearchService {

	@Value("${librarySys.searchUrl}")
	private String bookSearchUrl;
	@Value("${librarySys.bookLocationUrl}")
	private String bookLocationUrl;

	/**
	 * 书籍信息查询方法
	 *
	 * @param keyword 搜索关键词
	 * @param page    页码
	 * @return 返回书籍实体类List
	 * @throws Exception 所有Jsoup的异常
	 */
	public List<Book> bookSearch(String keyword, String page) throws Exception {
		List<Book> books = new ArrayList<>();

		//取得搜索结果的tr元素数组
		Elements records = Jsoup.connect(bookSearchUrl)
				.data("q", keyword)
				.data("page", page)
				.get()
				.getElementsByClass("resultTable")
				.get(0)
				.getElementsByTag("tbody")
				.get(0)
				.getElementsByTag("tr");

		//遍历tr数组
		for (Element e : records) {
			Book book = new Book();
			Elements tds = e.getElementsByTag("td");
			//获得isbn和bookrecno
			Attributes attributes = tds.get(2).getElementsByTag("img").get(0).attributes();
			book.setIsbn(attributes.get("isbn"));
			book.setBookrecno(attributes.get("bookrecno"));
			//获得标题
			book.setTitle(tds.get(3).getElementsByClass("title-link").text());
			//获得作者
			book.setAuthor(tds.get(3).getElementsByClass("author-link").text());
			//获得出版社名称
			book.setPublisher(tds.get(3).getElementsByClass("publisher-link").text());
			books.add(book);
		}
		return books;
	}

	/**
	 * 书籍在馆信息查询方法
	 *
	 * @param bookrecno 查询书籍信息时获得的bookrecno
	 * @return 返回书籍在馆信息实体类List
	 */
	public List<BookLocation> getBookLocation(String bookrecno) throws Exception {
		String rawBookLocationString = Jsoup.connect(bookLocationUrl)
				.data("bookrecnos", bookrecno)
				.data("return_fmt", "json")
				.ignoreContentType(true)
				.execute()
				.body();
		List<BookLocation> bookLocation;
		try {
			bookLocation = bookLocationString2List(rawBookLocationString, bookrecno);
		} catch (JsonSyntaxException e) {
			throw new CommonException(ResultEnum.LIB_SYS_LOCATION_GET_FAIL);
		}
		return bookLocation;
	}

	/**
	 * 图书在馆信息字符串转图书在馆信息实体类
	 *
	 * @param bookLocationString 图书在馆信息字符串
	 * @param bookrecno          图书编号
	 * @return 图书在馆信息实体类List
	 */
	private List<BookLocation> bookLocationString2List(String bookLocationString, String bookrecno) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(bookLocationString, JsonObject.class).get("previews");
		jsonElement = gson.fromJson(jsonElement, JsonObject.class).get(bookrecno);
		return gson.fromJson(jsonElement, new TypeToken<List<BookLocation>>() {
		}.getType());
	}
}