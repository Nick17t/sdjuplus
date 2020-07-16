package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "学校通知接口")
@RestController
@RequestMapping("/notice")
public class NoticeController {

	@ApiOperation("获取官网通知")
	@GetMapping("/homepage")
	public String getHomePageNotice() {
		return "";
	}

	@ApiOperation("获取教务系统通知")
	@GetMapping("/ems")
	public String getEduMgtSysNotice() {
		return "";
	}
}
