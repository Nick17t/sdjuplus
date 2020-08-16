package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.model.response.Score;
import org.sdjusei.sdjulife.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成绩查询控制层
 * 接受成绩和绩点查询的请求
 *
 * @author zcz
 * @date 2020/07/14
 */
@Api(tags = "成绩查询接口")
@RestController
@RequestMapping("/score")
public class ScoreController {

	@Resource
	private ScoreService scoreService;

	/**
	 * 成绩查询方法
	 *
	 * @param iPlanetDirectoryPro 统一认证Cookie，放在请求头的Cookie中传入
	 * @param CASTGC              统一认证Cookie，放在请求头的Cookie中传入
	 * @param year                学年
	 * @param term                学期
	 * @return 返回成绩Json
	 * @throws Exception Jsoup的所有异常
	 */
	@ApiOperation("成绩查询")
	@GetMapping("/score")
	public Result<List<Score>> listScore(@CookieValue("iPlanetDirectoryPro") String iPlanetDirectoryPro,
	                                     @CookieValue("CASTGC") String CASTGC,
	                                     @RequestParam("year") String year,
	                                     @RequestParam("term") String term) throws Exception {
		Map<String, String> cookies = new HashMap<>();
		cookies.put("iPlanetDirectoryPro", iPlanetDirectoryPro);
		cookies.put("CASTGC", CASTGC);
		List<Score> scoreList = scoreService.getScoreList(cookies, year, term);
		return Result.success(scoreList);
	}
}
