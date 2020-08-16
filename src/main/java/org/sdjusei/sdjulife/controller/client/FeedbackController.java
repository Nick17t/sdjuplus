package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息反馈控制层
 *
 * @author zcz
 * @date 2020/07/14
 */
@Api(tags = "信息反馈接口")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@ApiOperation("提交反馈")
	@PostMapping("/submit")
	public Result<Void> submit() {
		return Result.success();
	}

	@ApiOperation("查看反馈")
	@PostMapping("/list")
	public Result<Void> list() {
		return Result.success();
	}

	@ApiOperation("删除反馈")
	@GetMapping("/delete")
	public Result<Void> delete() {
		return Result.success();
	}
}
