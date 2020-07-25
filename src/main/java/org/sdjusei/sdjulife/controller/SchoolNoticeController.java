package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学校通知控制层
 *
 * @author zcz
 * @date 2020/07/16
 */
@Api(tags = "学校通知接口")
@RestController
@RequestMapping("/school-notice")
public class SchoolNoticeController {

	@ApiOperation("获取官网通知")
	@GetMapping("/homepage")
	public Result<Void> listHomePageNotice() {
		return Result.success();
	}

	@ApiOperation("获取教务系统通知")
	@GetMapping("/ems")
	public Result<Void> listEduMgtSysNotice() {
		return Result.success();
	}
}
