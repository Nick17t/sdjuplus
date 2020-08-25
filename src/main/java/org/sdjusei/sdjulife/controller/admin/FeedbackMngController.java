package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 反馈信息管理控制层
 *
 * @author zcz
 * @date 2020/08/16
 */
@Api(tags = "反馈信息管理接口")
@RestController
@RequestMapping("/fbk-mng")
public class FeedbackMngController {

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
