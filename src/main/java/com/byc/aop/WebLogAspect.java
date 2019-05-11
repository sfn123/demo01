package com.byc.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class WebLogAspect {
	//private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	@Pointcut("execution(public * com.byc.controller.*.*(..))")
	public void webLog() {

	}

	/**
	 * 前置通知
	 * @param joinPoint
	 * @throws Throwable
	 * 
	 */

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {

		// 接收到请求， 记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录请求内容
		log.info("URL:" + request.getRequestURI().toString());
		log.info("HTTP:" + request.getMethod());
		log.info("IP:" + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			log.info("name:{},value:{}", name, request.getParameter(name));
		}
	}
	/**
	 * 后置通知
	 *
	 * @param 
	 *
	 *
	 */
	@AfterReturning(returning = "ret",pointcut = "webLog()")
	public void doAferReturning(Object ret) throws  Throwable{
		//处理完请求，返回内容
		log.info("RESPONSE:"+ret);
	}
}
