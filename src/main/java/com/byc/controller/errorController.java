package com.byc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class errorController {
	@RequestMapping("/getUser")
	public String getUser(int i) {
		int j = 1 / i;
		return "success" + j;
	}
}
