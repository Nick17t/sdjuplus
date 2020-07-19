package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Course;
import org.sdjusei.sdjulife.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程控制层
 *
 * @author zcz
 * @date 2020/07/14
 */
@Api(tags = "课程接口")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Resource
	private CourseService courseService;

	@ApiOperation("课表查询")
	@PostMapping("/timetable")
	public List<Course> list(String password) {
		return courseService.getSchedule(password);
	}
}
