package com.sudaotech.huolijuzhen.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface LocationCommunityApplyEntityMapper extends CommunityApplyEntityMapper{

	/**
	 * 统计
	 * @param communityIds
	 * @return
	 */
	@SelectProvider(type=LocationCommunityApplyEntitySqlProvider.class,method="statistics")
	List<Map<String, Object>> statistics(Map<String,Object> parmas);

	
	
}