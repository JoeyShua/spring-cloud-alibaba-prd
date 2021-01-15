package com.jxs.common.vo;

/**
 * 请求返回码
 */
public class ResultCode {

	//调用成功
    public static final int OK = 200;
    
    //请求参数有误。
    public static final int BAD_REQUEST = 400 ;
    
    //没有用户认证
    public static final int UNAUTHORIZED = 401 ;
    
    //禁止
    public static final int FORBIDDEN = 403 ;



}
