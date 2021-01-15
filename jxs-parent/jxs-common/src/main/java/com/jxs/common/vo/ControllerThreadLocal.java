package com.jxs.common.vo;

import java.util.HashMap;

public class ControllerThreadLocal {

	public static ThreadLocal<HashMap<String, Object>> controllerThread = new ThreadLocal<HashMap<String,Object>>();


	public void set(HashMap<String,Object> map) {
		controllerThread.remove();
		controllerThread.set(map);
	}
	
	public void get() {
		controllerThread.get();
	}
	
	public void remove() {
		controllerThread.remove();
	}

}
