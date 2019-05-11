package com.byc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是jsp整合springboot
 * 
 * @author sufangning
 *
 */
@Controller
public class jspController {
	@RequestMapping("/jspIndex")
	public String jspIndex() {
		
		return "jspIndex";
	}
}
