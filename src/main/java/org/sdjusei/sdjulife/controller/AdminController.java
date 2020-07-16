package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理系统用户接口")
@RestController
@RequestMapping("/manager")
public class AdminController {

	@ApiOperation("添加用户")
	@PostMapping("/add")
	public String add(){
		return "";
	}

	@ApiOperation("用户登录")
	@PostMapping("/login")
	public String login(){
		return "";
	}

	@ApiOperation("退出登录")
	@PostMapping("/logout")
	public String logout() {
		return "";
	}

	@ApiOperation("查询用户")
	@GetMapping("/query")
	public String query(){
		return "";
	}

	@ApiOperation("修改信息")
	@PostMapping("/update")
	public String update() {
		return "";
	}
}
