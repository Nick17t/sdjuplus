package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.model.response.Course;
import org.sdjusei.sdjulife.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 课表查询方法
	 *
	 * @param iPlanetDirectoryPro 统一认证Cookie，放在请求头的Cookie中传入
	 * @param CASTGC              统一认证Cookie，放在请求头的Cookie中传入
	 * @param year                学年
	 * @param term                学期
	 * @return 返回课表Json
	 * @throws Exception Jsoup的所有异常
	 */
	@ApiOperation("课表查询")
	@GetMapping("/timetable")
	public Result<List<Course>> list(@CookieValue("iPlanetDirectoryPro") String iPlanetDirectoryPro,
	                                 @CookieValue("CASTGC") String CASTGC,
	                                 @RequestParam("year") String year,
	                                 @RequestParam("term") String term) throws Exception {
		Map<String, String> cookies = new HashMap<>();
		cookies.put("iPlanetDirectoryPro", iPlanetDirectoryPro);
		cookies.put("CASTGC", CASTGC);
		List<Course> courses = courseService.getSchedule(cookies, year, term);
		return Result.success(courses);
	}
}
