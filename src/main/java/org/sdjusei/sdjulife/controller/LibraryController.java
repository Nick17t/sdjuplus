package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Book;
import org.sdjusei.sdjulife.domain.BookBorrowRecord;
import org.sdjusei.sdjulife.domain.BookLocation;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.service.BookBorrowRecordService;
import org.sdjusei.sdjulife.service.LibrarySearchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图书馆控制层
 * 接收书籍和借阅情况的查询请求
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "图书馆接口")
@RestController
@RequestMapping("/library")
public class LibraryController {

	@Resource
	private LibrarySearchService librarySearchService;
	@Resource
	private BookBorrowRecordService bookBorrowRecordService;

	/**
	 * 图书查询方法
	 *
	 * @param keyword 关键词
	 * @param page    页码
	 * @return 返回图书实体类
	 * @throws Exception 所有Jsoup异常
	 */
	@ApiOperation("图书查询")
	@GetMapping("/search")
	public Result<List<Book>> search(@RequestParam String keyword,
	                                 @RequestParam String page) throws Exception {
		List<Book> books = librarySearchService.bookSearch(keyword, page);
		return Result.success(books);
	}

	/**
	 * 图书在馆信息查询方法
	 *
	 * @param bookrecno 图书编号
	 * @return 图书在馆信息实体类
	 * @throws Exception 所有Jsoup异常和Gson转换异常
	 */
	@ApiOperation("图书在馆信息查询")
	@GetMapping("/book-location")
	public Result<List<BookLocation>> locationSearch(@RequestParam String bookrecno) throws Exception {
		List<BookLocation> bookLocations = librarySearchService.getBookLocation(bookrecno);
		return Result.success(bookLocations);
	}

	/**
	 * 借阅记录查询方法
	 *
	 * @param iPlanetDirectoryPro 统一认证Cookie，放在请求头的Cookie中传入
	 * @param CASTGC              统一认证Cookie，放在请求头的Cookie中传入
	 * @return 借阅记录实体类List
	 * @throws Exception 所有Jsoup异常
	 */
	@ApiOperation("借阅查询")
	@GetMapping("/borrowed")
	public Result<List<BookBorrowRecord>> borrowed(@CookieValue("iPlanetDirectoryPro") String iPlanetDirectoryPro,
	                                               @CookieValue("CASTGC") String CASTGC) throws Exception {
		Map<String, String> cookies = new HashMap<>();
		cookies.put("iPlanetDirectoryPro", iPlanetDirectoryPro);
		cookies.put("CASTGC", CASTGC);
		List<BookBorrowRecord> records = bookBorrowRecordService.getBorrowRecord(cookies);
		return Result.success(records);
	}
}
