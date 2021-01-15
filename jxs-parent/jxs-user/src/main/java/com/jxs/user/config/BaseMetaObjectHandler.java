package com.jxs.user.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jxs.common.constant.CommonConstant;

/**
 * 填充器
 *
 * @author XUZHENHAI
 *
 */
public class BaseMetaObjectHandler implements MetaObjectHandler {


	@Override
	public void insertFill(MetaObject metaObject) {
		Date now = new Date();
		this.setFieldValByName(CommonConstant.baseEntity.IS_DELETE, 0, metaObject);
		this.setFieldValByName(CommonConstant.baseEntity.CREATE_TIME, now, metaObject);
		this.setFieldValByName(CommonConstant.baseEntity.UPDATE_TIME, now, metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		Date now = new Date();
		this.setFieldValByName(CommonConstant.baseEntity.UPDATE_TIME, now, metaObject);
	}
}