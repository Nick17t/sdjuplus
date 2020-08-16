package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Exam;
import org.sdjusei.sdjulife.domain.Result;
import org.sdjusei.sdjulife.service.ExamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考试信息控制层
 * 负责接收考试信息查询请求
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "考试查询接口")
@RestController
@RequestMapping("/exam")
public class ExamController {

	@Resource
	private ExamService examService;

	/**
	 * 考试信息查询方法
	 *
	 * @param iPlanetDirectoryPro 统一认证Cookie，放在请求头的Cookie中传入
	 * @param CASTGC              统一认证Cookie，放在请求头的Cookie中传入
	 * @param year                学年
	 * @param term                学期
	 * @return 返回考试信息Json
	 * @throws Exception Jsoup的所有异常
	 */
	@ApiOperation("考试信息查询")
	@GetMapping("/exam")
	public Result<List<Exam>> listExam(@CookieValue("iPlanetDirectoryPro") String iPlanetDirectoryPro,
	                                   @CookieValue("CASTGC") String CASTGC,
	                                   @RequestParam("year") String year,
	                                   @RequestParam("term") String term) throws Exception {
		Map<String, String> cookies = new HashMap<>();
		cookies.put("iPlanetDirectoryPro", iPlanetDirectoryPro);
		cookies.put("CASTGC", CASTGC);
		List<Exam> exams = examService.getExamList(cookies, year, term);
		return Result.success(exams);
	}
}
