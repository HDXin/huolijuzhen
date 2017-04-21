package com.sudaotech.huolijuzhen.park.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.sudaotech.huolijuzhen.dao.ParkInfoEntityMapper;

public interface LocationParkInfoEntityMapper extends ParkInfoEntityMapper {
    
	@SelectProvider(type=LocationParkInfoEntitySqlProvider.class,method="findAllParkIdsByLocation")
	@Results({
		@Result(id=true,column="id",property="id")
	})
	public List<Long> findAllParkIdsByLocation(Map<String, Object> params);
	
	@SelectProvider(type=LocationParkInfoEntitySqlProvider.class,method="statisticsPark")
	public Integer statisticsPark(Map<String, Object> params);
}