package com.byc.error;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.soap.Addressing;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局捕获异常案例 1.捕获返回json格式 2.捕获返回页面
 * 
 * @author sfn
 *
 */

@ControllerAdvice(basePackages = "com.byc.controller")
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, Object> errorResult() {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("errorCode", 500);
		errorMap.put("errorMsg", "系统错误");
		return errorMap;
	}
}
