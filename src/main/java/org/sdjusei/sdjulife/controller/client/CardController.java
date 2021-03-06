package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.nodes.Document;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.service.CardService;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 校园卡控制层
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "校园卡接口")
@RestController
@RequestMapping("/card")
public class CardController {

	@Resource
	private CardService cardService;

	/**
	 * 一卡通查询接口，包括余额查询和最近交易信息查询
	 *
	 * @param iPlanetDirectoryPro 统一认证Cookie，放在请求头的Cookie中传入
	 * @param CASTGC              统一认证Cookie，放在请求头的Cookie中传入
	 * @return 返回余额和最近交易记录
	 * @throws Exception Jsoup的所有异常
	 */
	@ApiOperation("一卡通信息查询")
	@PostMapping("/card-info")
	public Result<Map<String, Object>> getInfo(@CookieValue("iPlanetDirectoryPro") String iPlanetDirectoryPro,
	                                           @CookieValue("CASTGC") String CASTGC) throws Exception {
		Map<String, String> cookies = new HashMap<>();
		cookies.put("iPlanetDirectoryPro", iPlanetDirectoryPro);
		cookies.put("CASTGC", CASTGC);
		Map<String, Object> info = new HashMap<>();
		Document page = cardService.getHomePage(cookies);
		info.put("balance", cardService.getBalance(page));
		info.put("transactionRecord", cardService.getTransactionRecord(page));
		return Result.success(info);
	}
}
