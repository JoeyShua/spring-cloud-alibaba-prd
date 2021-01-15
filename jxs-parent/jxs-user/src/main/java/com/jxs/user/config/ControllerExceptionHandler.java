package com.jxs.user.config;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxs.common.vo.ControllerThreadLocal;
import com.jxs.common.vo.Res;
import com.jxs.common.vo.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 异常处理器
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Res handleException1(Exception e) {
		HashMap<String, Object> methodInfo = ControllerThreadLocal.controllerThread.get();
		StringBuffer logBuffer = new StringBuffer();
		logBuffer.append("\n类名： " + methodInfo.get("className"));
		logBuffer.append("\n方法名： " + methodInfo.get("methodname"));
		logBuffer.append("\n请求方式： " + methodInfo.get("webMethod"));
		logBuffer.append("\n请求参数： " + methodInfo.get("param"));
		logBuffer.append("\n报错信息： " + e.getMessage());
		log.error(logBuffer.toString(), e);
		ControllerThreadLocal.controllerThread.remove();
		return Res.error(ResultCode.BAD_REQUEST, e.getMessage());
	}

}
