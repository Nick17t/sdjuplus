package org.sdjusei.sdjulife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@ResponseBody
	@GetMapping("/")
	public String login() {
		return "Hello World";
	}
}
