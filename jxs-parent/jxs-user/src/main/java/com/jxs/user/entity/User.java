package com.jxs.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxs.common.entity.BaseEntity;

import lombok.Data;
@Data
@TableName("user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	
	private String userName;

	private String password;

	private String phone;
	

}
