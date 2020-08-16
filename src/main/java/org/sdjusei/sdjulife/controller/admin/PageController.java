package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 页面控制层
 * 用于设置主页的按钮和背景图等
 *
 * @author zcz
 * @date 2020/07/16
 */
@Api(tags = "页面设置接口")
@RestController
@RequestMapping("/main-page")
public class PageController {

	@ApiOperation("设置首页按钮")
	@PostMapping("/set-btn")
	public Result<Void> setButton() {
		return Result.success();
	}

	@ApiOperation("设置首页背景图")
	@PostMapping("/set-pic")
	public Result<Void> setBackPicture() {
		return Result.success();
	}
}
