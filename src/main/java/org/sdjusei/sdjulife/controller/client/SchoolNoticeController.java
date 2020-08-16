package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.service.SchoolNoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 学校通知控制层
 *
 * @author zcz
 * @date 2020/07/16
 */
@Api(tags = "学校通知接口")
@RestController
@RequestMapping("/school-notice")
public class SchoolNoticeController {

	@Resource
	private SchoolNoticeService schoolNoticeService;

	/**
	 * 校务通知获取方法
	 *
	 * @return 返回前10条校务通知
	 */
	@ApiOperation("获取校务通知")
	@GetMapping("/xw")
	public Result<Void> listXwNotice() {
		return Result.success();
	}

	/**
	 * 教学通知获取方法
	 *
	 * @return 返回前10条教学通知
	 */
	@ApiOperation("获取教学通知")
	@GetMapping("/jx")
	public Result<Void> listJxNotice() {
		return Result.success();
	}
}
