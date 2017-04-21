package com.sudaotech.huolijuzhen.util;

public class StringUtils {

	/**
	 * 为空判断
	 * */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str)) return true;
		return false;
	}
	
}
