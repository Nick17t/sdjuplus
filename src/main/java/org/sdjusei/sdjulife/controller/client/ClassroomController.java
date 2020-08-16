package org.sdjusei.sdjulife.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.model.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教室查询控制层
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "教室查询接口")
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@ApiOperation("空闲教室查询")
	@GetMapping("/empty-classroom")
	public Result<Void> list() {
		return Result.success();
	}
}
