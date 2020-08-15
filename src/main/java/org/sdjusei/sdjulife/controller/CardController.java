package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.nodes.Document;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.service.CardService;
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

	@ApiOperation("一卡通信息查询")
	@PostMapping("/card-info")
	public Result<Map<String, Object>> getInfo(Map<String, String> cookies) throws Exception {
		Map<String, Object> info = new HashMap<>();
		Document page = cardService.getHomePage(cookies);
		info.put("balance",cardService.getBalance(page));
		info.put("transactionRecord",cardService.getTransactionRecord(page));
		return Result.success(info);
	}
}
