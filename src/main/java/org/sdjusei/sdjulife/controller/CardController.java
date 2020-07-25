package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@ApiOperation("余额查询")
	@PostMapping("/balance")
	public Result<Void> getBalance() {
		return Result.success();
	}

	@ApiOperation("交易信息查询")
	@GetMapping("/transaction-record")
	public Result<Void> getRecord() {
		return Result.success();
	}
}
