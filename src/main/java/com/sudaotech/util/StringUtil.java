package com.sudaotech.util;

import java.util.regex.Pattern;

public class StringUtil {

	public static final String NUMBER_REGEX = "[0-9]{1,}";
	
	/**
	 * 判断字符串是否为空
	 * */
	public static boolean isEmpty(String data){
		if(data==null || "".equals(data)) return true;
		return false;
	}
	
	/**
	 * 判断字符串是否为纯数字
	 * */
	public static boolean isNumberFormat(String data){
		if(isEmpty(data)) return false;
		return Pattern.compile(NUMBER_REGEX)
			   .matcher(data)
			   .matches();
	}
	
	/**
	 * 判断字符串位数是否符合标准
	 * */
	public static boolean isRightDigit(int standard, String data){
		if(standard<0 || isEmpty(data)) return false;
		return data.length()==standard;
	}
	
	public static void main(String[] args) {
//		System.out.println(isNumberFormat(""));
		System.out.println(isRightDigit(3,"qeq"));
	}
	
}
