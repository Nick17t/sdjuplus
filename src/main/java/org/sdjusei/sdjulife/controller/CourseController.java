package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags="课程接口")
@RestController
@RequestMapping("/course")
public class CourseController {

	@ApiOperation("获取课表")
	@PostMapping("/timetable")
	public String getCourses() {
		return "";
	}
}
