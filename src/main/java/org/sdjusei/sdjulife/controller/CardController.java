package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags="校园卡接口")
@RestController
@RequestMapping("/card")
public class CardController {

	@ApiOperation("获取余额")
	@PostMapping("/balance")
	public String getBalance(){
		return "";
	}

	@ApiOperation("获取交易信息")
	@GetMapping("/transaction-record")
	public String getRecord(){
		return "";
	}
}
