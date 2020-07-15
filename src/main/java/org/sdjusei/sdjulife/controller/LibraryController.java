package org.sdjusei.sdjulife.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags="图书馆接口")
@RestController
@RequestMapping("/library")
public class LibraryController {

	@ApiOperation("查询书籍")
	@GetMapping("/search")
	public String search(){
		return "";
	}

	@ApiOperation("借阅查询")
	@GetMapping("/borrowed")
	public String borrowed(){
		return "";
	}
}
