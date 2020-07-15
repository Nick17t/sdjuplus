package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "成绩查询接口")
@RestController
@RequestMapping("/score")
public class ScoreController {

	@ApiOperation("成绩查询")
	@GetMapping("/score")
	public String score(){
		return "";
	}

	@ApiOperation("绩点查询")
	@PostMapping("/gpa")
	public String gpa(){
		return "";
	}
}
