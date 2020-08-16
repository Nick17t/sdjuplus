package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小程序用户管理接口
 *
 * @author zcz
 * @date 2020/08/16
 */
@RestController
@RequestMapping("/user-mng")
public class UserMngController {

	/**
	 * 修改信息Controller方法
	 *
	 * @return 成功返回成功信息，失败则抛出异常
	 */
	@ApiOperation("修改信息")
	@PostMapping("/update")
	public Result<Void> updateInfo() {
		return Result.success();
	}

	/**
	 * 删除Controller方法
	 *
	 * @return 成功返回成功信息，失败则抛出异常
	 */
	@ApiOperation("删除用户")
	@PostMapping("/delete")
	public Result<Void> logoff() {
		return Result.success();
	}

	@ApiOperation("查询所有用户")
	@GetMapping("/query")
	public Result<Void> query() {
		//TODO 查询待完成（包括分页等功能）
		return Result.success();
	}

	@ApiOperation("查询单个用户")
	@GetMapping
	public Result<Void> searchByStuId() {
		//TODO 待完成
		return Result.success();
	}
}
