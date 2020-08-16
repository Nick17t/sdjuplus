package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常用信息管理控制层
 *
 * @author zcz
 * @date 2020/08/16
 */
@Api(tags = "常用信息管理接口")
@RestController
@RequestMapping("/useful-inf-mng")
public class UsefulInfMngController {

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
