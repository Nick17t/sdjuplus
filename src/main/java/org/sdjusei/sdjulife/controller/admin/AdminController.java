package org.sdjusei.sdjulife.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理用户控制层
 *
 * @author zcz
 * @date 2020/07/16
 */
@Api(tags = "管理系统用户接口")
@RestController
@RequestMapping("/manager")
public class AdminController {

	@ApiOperation("添加用户")
	@PostMapping("/add")
	public Result<Void> add() {
		return Result.success();
	}

	@ApiOperation("用户登录")
	@PostMapping("/login")
	public Result<Void> login() {
		return Result.success();
	}

	@ApiOperation("退出登录")
	@PostMapping("/logout")
	public Result<Void> logout() {
		return Result.success();
	}

	@ApiOperation("查询用户")
	@GetMapping("/list")
	public Result<Void> list() {
		return Result.success();
	}

	@ApiOperation("修改信息")
	@PostMapping("/update")
	public Result<Void> update() {
		return Result.success();
	}
}
