package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String list() {
		return "";
	}

	@ApiOperation("增加事件")
	@PostMapping("/add")
	public String add() {
		return "";
	}

	@ApiOperation("修改事件")
	@PostMapping("/update")
	public String update() {
		return "";
	}

	@ApiOperation("删除事件")
	@PostMapping("/delete")
	public String delete() {
		return "";
	}

}
