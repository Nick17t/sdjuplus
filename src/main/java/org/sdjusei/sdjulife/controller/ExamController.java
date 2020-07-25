package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@ApiOperation("考试信息查询")
	@GetMapping("/exam")
	public Result<Void> listExam() {
		return Result.success();
	}
}
