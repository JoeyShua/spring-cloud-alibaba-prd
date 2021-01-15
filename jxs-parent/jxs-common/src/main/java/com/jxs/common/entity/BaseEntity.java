package com.jxs.common.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BaseEntity extends IdEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
	
	/**
	 * 是否删除（0，正常；1，已删除）
	 */
	@TableLogic(delval = "1", value = "0")
	@TableField(fill = FieldFill.INSERT)
	private Integer isDelete;

}
