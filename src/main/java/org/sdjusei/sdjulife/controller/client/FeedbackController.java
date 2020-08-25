package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Feedback;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.service.FeedbackSubmitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 信息反馈控制层
 *
 * @author zcz
 * @date 2020/07/14
 */
@Api(tags = "信息反馈接口")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Resource
	private FeedbackSubmitService feedbackSubmitService;

	 /**
	 * 反馈信息提交方法
	 *
	 * @param token token，用于读取用户ID
	 * @param feedback 反馈信息主体
	 */
	@ApiOperation("提交反馈")
	@PostMapping("/submit")
	public Result<Void> submit(@CookieValue String token,
	                           @RequestBody Feedback feedback) {
		feedbackSubmitService.submit(token, feedback);
		return Result.success();
	}
}
