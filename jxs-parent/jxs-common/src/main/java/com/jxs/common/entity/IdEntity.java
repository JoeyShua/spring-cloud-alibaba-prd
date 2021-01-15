package com.jxs.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class IdEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

}
