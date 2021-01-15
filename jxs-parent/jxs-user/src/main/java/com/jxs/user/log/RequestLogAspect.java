
package com.jxs.user.log;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.jxs.common.vo.ControllerThreadLocal;

import lombok.extern.slf4j.Slf4j;

/**
 * controller 中只要带有 @RequestMapping 注解的都将打印日志
 */

@Slf4j
@Aspect
@Component
public class RequestLogAspect {

	/**
	 * 日志切入点
	 */

	@Pointcut("execution(public * com.jxs.user.controller..*.*(..))*")
	public void logPointCut() {
	}

	@Around(value = "logPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		long start = System.currentTimeMillis();

		// 获取当前请求对象
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

		// 获取方法签名
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

		// 请求的方法
		String methodname = methodSignature.getMethod().getName();

		// 请求的类名
		String ClassName = pjp.getSignature().getDeclaringTypeName();

		// 请求的参数
		Object param = null;
		try {
			if (pjp.getArgs() == null) {
				param = null;
			} else if (pjp.getArgs() instanceof Object) {
				param = JSONObject.toJSONString(pjp.getArgs());
			} else {
				param = pjp.getArgs();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// 请求URL
		String URL = request.getRequestURL().toString();

		// 请求方式
		String WebMethod = request.getMethod();

		Object logResult = null;
		Object result = null;
		
		//将信息放到threadLocal
		HashMap<String,Object> methodInfo = new HashMap<>();
		methodInfo.put("className", ClassName);
		methodInfo.put("methodname", methodname);
		methodInfo.put("webMethod", WebMethod);
		methodInfo.put("param", param);
		ControllerThreadLocal.controllerThread.set(methodInfo);
		
		// 代理方法执行
		result = pjp.proceed();

		//
		try {
			if (result instanceof Object) {
				logResult = JSONObject.toJSONString(result);
			} else {
				logResult = null;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		StringBuffer logBuffer = new StringBuffer();
		logBuffer.append("\n调用开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		logBuffer.append("\n类名： " + ClassName);
		logBuffer.append("\n方法名： " + methodname);
		logBuffer.append("\n请求地址： " + URL);
		logBuffer.append("\n请求方式： " + WebMethod);
		logBuffer.append("\n请求参数： " + param);
		logBuffer.append("\n输出参数： " + logResult);
		logBuffer.append("\n调用时间： " + (System.currentTimeMillis() - start) + "毫秒");
		logBuffer.append("\n调用结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		log.info(logBuffer.toString());
		return result;

	}

}
