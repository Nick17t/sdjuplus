package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@ApiOperation("登录")
	@GetMapping("/login")
	public String login() {
		return "";
	}

	@ApiOperation("退出登录")
	@PostMapping("/logout")
	public String logout() {
		return "";
	}

	@ApiOperation("修改信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名", dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "studentnumber", value = "学号", dataType = "String",paramType = "path")
	})
	@ApiResponses({
			@ApiResponse(code = 200, message = "修改成功"),
			@ApiResponse(code = 404, message = "请求路径无效")
	})
	@PostMapping("/update")
	public String updateInfo() {
		return "";
	}

	@ApiOperation("注销")
	@PostMapping("/logoff")
	public String logoff() {
		return "";
	}


}
