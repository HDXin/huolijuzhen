package com.sudaotech.huolijuzhen.util;

import java.util.Random;

public class RandomUtils {
	
	
	/**
	 * 产生 min 到 max 之间的 count 为随机数字
	 * @param max 最大
	 * @param min 最小
	 * @param count 位数
	 * @return
	 */
	public static String randomNumsStr(int max,int min,int count){
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i< count;i++){
			sbf.append(randomNumStr(max, min));
		}
		
		return sbf.toString();
	}
	
	/**
	 * 产生 0 到 9 之间的 count 为随机数字
	 * @param count 位数
	 * @return
	 */
	public static String randomNumsStr(int count){
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i<count;i++){
			sbf.append(randomNumStr(9, 0));
		}
		return sbf.toString();
	}
	
	/**
	 * 产生 min 到 max 之间的一个随机数
	 * @param max 最大
	 * @param min 最小
	 * @return
	 */
	public static int randomNum(int max,int min){
		return new Random().nextInt(max)%(max-min+1) + min;
	}

	/**
	 * 产生 min 到 max 之间的一个随机数字符串
	 * @param max 最大
	 * @param min 最小
	 * @return
	 */
	public static String randomNumStr(int max,int min){
		return ((Integer)randomNum(max, min)).toString();
	}

	
}
