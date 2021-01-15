package com.jxs.common.vo;

import java.util.HashMap;

/**
 * 返回数据
 */
public class Res extends HashMap<String, Object> {
	private static final String MSG_FIELD = "message";
	private static final String CODE_FIELD = "code";
	private static final String DATA_FIELD = "data";
	private static final long serialVersionUID = -569500316447364006L;

	public Res() {
		put(CODE_FIELD, ResultCode.OK);
		put(MSG_FIELD, "success");
	}

	public static Res error() {
		return error(ResultCode.BAD_REQUEST, "系统异常！");
	}

	public static Res error(String msg) {
		return error(ResultCode.BAD_REQUEST, msg);
	}

	public static Res error(int code, String msg) {
		Res res = new Res();
		res.put(CODE_FIELD, code);
		res.put(MSG_FIELD, msg);
		return res;
	}

	public static Res success(Object data) {
		Res res = new Res();
		res.put(DATA_FIELD, data);
		return res;
	}

	public static Res success() {
		return new Res();
	}

	@Override
	public Res put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
