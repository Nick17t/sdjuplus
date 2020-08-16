package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校历控制层
 * 接收校历的CRUD请求
 *
 * @author zcz
 * @date 2020/07/16
 */
@Api(tags = "校历接口")
@RestController
@RequestMapping("/calendar")
public class SchoolCalendarController {

	@ApiOperation("事件查询")
	@GetMapping("/list")
	public Result<Void> list() {
		return Result.success();
	}
}
