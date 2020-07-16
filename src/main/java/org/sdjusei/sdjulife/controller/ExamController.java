package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags="考试查询接口")
@RestController
@RequestMapping("/exam")
public class ExamController {

	@ApiOperation("考试信息查询")
	@GetMapping("/exam")
	public String getExam(){
		return "";
	}
}
