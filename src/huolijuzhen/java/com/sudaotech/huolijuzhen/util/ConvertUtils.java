package com.sudaotech.huolijuzhen.util;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public class ConvertUtils {

	/**
	 * 将 Integer 类型的 List 转换成 in 子句
	 * @param nums
	 * @return
	 */
	public static String intListToStr(List<Integer> nums){
		if(CollectionUtils.isEmpty(nums)){
			return null;
		}
		StringBuilder inSql = new StringBuilder();
		inSql.append("(");
		for(int i=0;i<nums.size();i++){
			inSql.append(nums.get(i));
			if(i<nums.size()-1){
				inSql.append(",");
			}
		}
		inSql.append(")");
		return inSql.toString();
	}
	
	/**
	 * 将 Long 类型的 List 转换成 in 子句
	 * @param ids
	 * @return
	 */
	public static String longListToStr(List<Long> ids){
		if(CollectionUtils.isEmpty(ids)){
			return null;
		}
		StringBuilder inSql = new StringBuilder();
		inSql.append("(");
		for(int i=0;i<ids.size();i++){
			inSql.append(ids.get(i));
			if(i<ids.size()-1){
				inSql.append(",");
			}
		}
		inSql.append(")");
		return inSql.toString();		
	}
	
	/**
	 * 将 Long 类型的 List 转换成 in 子句
	 * @param ids
	 * @return
	 */
	public static String toStr(List<Long> ids){
		if(CollectionUtils.isEmpty(ids)){
			return null;
		}
		StringBuilder inSql = new StringBuilder();
		inSql.append("(-999,");
		for(int i=0;i<ids.size();i++){
			inSql.append(ids.get(i));
			if(i<ids.size()-1){
				inSql.append(",");
			}
		}
		inSql.append(")");
		return inSql.toString();		
	}

}
