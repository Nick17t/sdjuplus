package org.sdjusei.sdjulife.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.sdjusei.sdjulife.domain.UserLoginMsg;
import org.sdjusei.sdjulife.service.UserLoginService;
import org.sdjusei.sdjulife.service.UserMngService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 小程序用户控制层，
 * 控制用户的登录、退出登录、注销和修改信息
 *
 * @author zcz
 * @date 2020/07/07
 */
@Api(tags = "小程序用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserLoginService userLoginService;
	@Resource
	private UserMngService userMngService;

	@ApiOperation("登录")
	@ApiOperationSupport(includeParameters = {"loginMsg.code", "loginMsg.platform"})
	@PostMapping("/login")
	public String login(@RequestBody UserLoginMsg userLoginMsg) {
		try {
			userLoginService.login(userLoginMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@ApiOperation("退出登录")
	@PostMapping("/logout")
	public String logout() {
		return "";
	}

	@ApiOperation("修改信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "studentId", value = "学号", dataType = "String", paramType = "path")
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
