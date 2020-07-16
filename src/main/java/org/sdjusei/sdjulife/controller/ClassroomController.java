package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="教室查询接口")
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@ApiOperation("空闲教室查询")
	@GetMapping("/empty-classroom")
	public String getEmptyClassroom(){
		return "";
	}
}
