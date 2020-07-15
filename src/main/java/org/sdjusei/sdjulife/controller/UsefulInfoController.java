package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="常用信息接口")
@RestController
@RequestMapping("/useful-info")
public class UsefulInfoController {

	@ApiOperation("校车查询")
	@GetMapping("/bus")
	public String bus(){
		return "";
	}

	@ApiOperation("电话黄页查询")
	@GetMapping("/yellow-page")
	public String yellowPage(){
		return "";
	}

	@ApiOperation("学生手册查询")
	@GetMapping("/handbook")
	public String handbook(){
		return "";
	}
}
