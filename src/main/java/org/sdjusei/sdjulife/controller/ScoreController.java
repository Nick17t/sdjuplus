package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 成绩查询控制层
 * 接受成绩和绩点查询的请求
 *
 * @author zcz
 * @date 2020/07/14
 */
@Api(tags = "成绩查询接口")
@RestController
@RequestMapping("/score")
public class ScoreController {

	@ApiOperation("成绩查询")
	@GetMapping("/score")
	public Result<Void> listScore() {
		return Result.success();
	}

	@ApiOperation("绩点查询")
	@PostMapping("/gpa")
	public Result<Void> getGpa() {
		return Result.success();
	}
}
