package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.service.SchoolSysLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 学校系统登录控制层
 *
 * @author zcz
 * @date 2020/08/10
 */
@Api(tags = "学校系统登录接口")
@RestController
@RequestMapping("/school-sys-login")
public class SchoolSysLoginController {

	@Resource
	private SchoolSysLoginService schoolSysLoginService;

	/**
	 * 统一认证系统登录接口，前端应将返回的Cookie保存，后续请求时放在header中
	 *
	 * @param map 第一次只带学号请求，第二次带有学号和加密后的密码（可能还有验证码）以及其他暂存的参数
	 * @return 第一次返回验证码标记、暂存参数和加密用的盐，第二次返回登录后的Cookie
	 */
	@ApiOperation("统一认证系统登录方法")
	@PostMapping("/unified-sys")
	public Result<Map<String, String>> unifiedLogin(@RequestBody Map<String, String> map) throws Exception {
		Map<String, String> data = schoolSysLoginService.unifiedLogin(map);
		return Result.success(data);
	}
}
