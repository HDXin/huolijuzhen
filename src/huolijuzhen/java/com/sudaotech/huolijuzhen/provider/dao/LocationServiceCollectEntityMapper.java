package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LocationServiceCollectEntityMapper extends ServiceCollectEntityMapper{
    
	
	@Select("select count(id) from service_collect"
			+ " where 1=1"
			+ " and serviceProId = #{serviceProId}"
			+ " and status = #{status}")
	public Integer findCollectNum(Map<String, Object> params);
	
	@Select("select id from service_collect"
			+ " where 1=1 "
			+ " and serviceProId = #{serviceProId}"
			+ " and status = #{status}"
			+ " and collectBy = #{collectBy}"
			+ " and parkId = #{parkId}")
	public List<Long> isCollect(Map<String, Object> params);
}