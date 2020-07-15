package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "信息反馈接口")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@ApiOperation("提交反馈")
	@PostMapping("/submit")
	public String submit(){
		return "";
	}

	@ApiOperation("查看反馈")
	@PostMapping("/query")
	public String query(){
		return "";
	}
}
