package com.sudaotech.huolijuzhen.resources.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityMapper;

public interface LocationResourceInfoEntityMapper extends ResourceInfoEntityMapper{
	
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resOfAreaAll")
	public List<Map<String, Object>> resOfAreaAll(Map<String, Object> params);
	
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resOfAreaUse")
	public List<Map<String, Object>> resOfAreaUse(Map<String, Object> params);
	
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resOfNumAll")
	public List<Map<String, Object>> resOfNumAll(Map<String, Object> params);
	
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resOfNumUse")
	public List<Map<String, Object>> resOfNumUse(Map<String, Object> params);
	
	/**
	 * 该园区资源平均基价
	 * @param params
	 * @return
	 */
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resAvgBasicPrice")
	public List<Map<String, Object>> resAvgBasicPrice(Map<String, Object> params);

	/**
	 * 该园区已出租资源的均价
	 * @param params
	 * @return
	 */
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resAvgRentPrice")
	public List<Map<String, Object>> resAvgRentPrice(Map<String, Object> params);

	/**
	 * 该园区未出租的资源的面积和、基价和
	 * @param params
	 * @return
	 */
	@SelectProvider(type=LocationResourceInfoEntitySqlProvider.class,method="resNoRentInfo")
	public List<Map<String, Object>> resNoRentInfo(Map<String, Object> params);
}