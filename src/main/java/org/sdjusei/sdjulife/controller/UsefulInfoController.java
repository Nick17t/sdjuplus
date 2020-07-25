package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常用信息控制层，
 * 接收校车、电话黄页和学生手册的查询和更新请求
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "常用信息接口")
@RestController
@RequestMapping("/useful-info")
public class UsefulInfoController {

	@ApiOperation("校车查询")
	@GetMapping("/bus")
	public Result<Void> getBus() {
		return Result.success();
	}

	@ApiOperation("电话黄页查询")
	@GetMapping("/yellow-page")
	public Result<Void> getYellowPage() {
		return Result.success();
	}

	@ApiOperation("学生手册查询")
	@GetMapping("/handbook")
	public Result<Void> getHandbook() {
		return Result.success();
	}

	@ApiOperation("校车更新")
	@GetMapping("/update-bus")
	public Result<Void> updateBus() {
		return Result.success();
	}

	@ApiOperation("电话黄页更新")
	@GetMapping("/update-yellow-page")
	public Result<Void> updateYellowPage() {
		return Result.success();
	}

	@ApiOperation("学生手册更新")
	@GetMapping("/update-handbook")
	public Result<Void> updateHandbook() {
		return Result.success();
	}
}
