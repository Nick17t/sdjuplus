package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校历管理控制层
 *
 * @author zcz
 * @date 2020/08/16
 */
@Api(tags = "校历管理接口")
@RestController
@RequestMapping("/calendar-mng")
public class SchCaleMngController {

	@ApiOperation("增加事件")
	@PostMapping("/add")
	public Result<Void> add() {
		return Result.success();
	}

	@ApiOperation("修改事件")
	@PostMapping("/update")
	public Result<Void> update() {
		return Result.success();
	}

	@ApiOperation("删除事件")
	@PostMapping("/delete")
	public Result<Void> delete() {
		return Result.success();
	}
}
