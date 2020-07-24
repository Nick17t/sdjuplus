package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.domain.ResultEnum;
import org.sdjusei.sdjulife.domain.User;
import org.sdjusei.sdjulife.domain.UserLoginMsg;
import org.sdjusei.sdjulife.service.UserLoginService;
import org.sdjusei.sdjulife.service.UserMngService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
	@Resource
	private HttpServletRequest request;

	/**
	 * 登录Controller方法
	 *
	 * @param userLoginMsg 登录信息，包含小程序给的code和平台标记
	 * @return 返回成功信息和token
	 * @throws IOException 包含token创建失败、获取openid失败等，统一由异常处理器处理
	 */
	@ApiOperation("登录")
	@PostMapping("/login")
	public Result login(@RequestBody UserLoginMsg userLoginMsg) throws IOException {
		String token = userLoginService.login(userLoginMsg);
		return new Result(ResultEnum.SUCCESS, token);
	}

	/**
	 * 修改信息Controller方法
	 *
	 * @return 成功返回成功信息，失败则抛出异常
	 */
	@ApiOperation("修改信息")
	@PostMapping("/update")
	public Result updateInfo(@RequestBody User user) {
		String token = request.getHeader("token");
		userMngService.updateInfo(token, user);
		return new Result(ResultEnum.SUCCESS);
	}

	/**
	 * 注销Controller方法
	 *
	 * @return 成功返回成功信息，失败则抛出异常
	 */
	@ApiOperation("注销")
	@PostMapping("/logoff")
	public Result logoff() {
		String token = request.getHeader("token");
		userMngService.delete(token);
		return new Result(ResultEnum.SUCCESS);
	}

	@ApiOperation("查询所有用户")
	@GetMapping("/query")
	public Result query() {
		//TODO 查询待完成（包括分页等功能）
		return new Result(ResultEnum.SUCCESS);
	}

	@ApiOperation("查询单个用户")
	@GetMapping
	public Result searchByStuId() {
		//TODO 待完成
		return new Result(ResultEnum.SUCCESS);
	}
}
