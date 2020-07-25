package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sdjusei.sdjulife.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书馆控制层
 * 接收书籍和借阅情况的查询请求
 *
 * @author zcz
 * @date 2020/07/13
 */
@Api(tags = "图书馆接口")
@RestController
@RequestMapping("/library")
public class LibraryController {

	@ApiOperation("书籍查询")
	@GetMapping("/search")
	public Result<Void> search() {
		return Result.success();
	}

	@ApiOperation("借阅查询")
	@GetMapping("/borrowed")
	public Result<Void> borrowed() {
		return Result.success();
	}
}
