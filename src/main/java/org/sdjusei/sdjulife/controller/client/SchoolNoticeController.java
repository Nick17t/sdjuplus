package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.sdjusei.sdjulife.model.response.SchoolNotice;
import org.sdjusei.sdjulife.service.SchoolNoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
	 * @return 返回前20条校务通知
	 */
	@ApiOperation("获取校务通知")
	@GetMapping("/xw")
	public Result<List<SchoolNotice>> listXwNotice() throws Exception {
		List<SchoolNotice> xw = schoolNoticeService.getNoticeList("xw");
		return Result.success(xw);
	}

	/**
	 * 教学通知获取方法
	 *
	 * @return 返回前20条教学通知
	 */
	@ApiOperation("获取教学通知")
	@GetMapping("/jx")
	public Result<List<SchoolNotice>> listJxNotice() throws Exception {
		List<SchoolNotice> jx = schoolNoticeService.getNoticeList("jx");
		return Result.success(jx);
	}
}
