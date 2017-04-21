package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LocationServiceParkEntityMapper extends ServiceParkEntityMapper{

	/**
	 * 获取指定 ID 园区有权限查看的所有服务项目
	 * @param params
	 * @return
	 */
	@Select("select serviceId "
			+ "from service_park "
			+ "where 1 = 1 "
			+ " and parkId = #{parkId}"
			+ " and status = #{status}")
	@Results({
		@Result(column="serviceId",property="serviceId")
	})
	public List<Long> findAllBySql(Map<String, Object> params);
	
	/**
	 * 根据 服务项目 ID、园区 ID 获取指定关系（用于维护关联关系）
	 * @param params
	 * @return
	 */
	@Select("select id id,"
			+ "serviceId serviceId,"
			+ "parkId parkId,"
			+ "chooseStatus chooseStatus "
			+ " from service_park "
			+ " where 1=1 "
			+ " and serviceId = #{serviceId} "
			+ " and parkId = #{parkId}"
			+ " and status = #{status}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="serviceId",property="serviceId"),
		@Result(column="parkId",property="parkId"),
		@Result(column="chooseStatus",property="chooseStatus")
	})
	public List<Map<String,Object>> findBySql(Map<String, Object> params);
	
	/**
	 * 查找所有有效的服务项目，用于 app 端显示
	 * @param params
	 * @return
	 */
	@Select("select serviceId serviceId"
			+ " from service_park "
			+ " where 1=1 "
			+ " and parkId = #{parkId}"
			+ " and status = #{status}"
			+ " and chooseStatus = #{chooseStatus}")
	public List<Long> findAllValidServiceProIds(Map<String, Object> params);
	
	@Select("select parkId"
			+ " from service_park"
			+ " where 1=1 "
			+ " and serviceId = #{serviceProId}"
			+ " and status = #{status}"
			+ " and serviceProRelease = #{serviceProRelease}")
	public List<Long> findAllParkIdsByServiceProId(Map<String, Object> params);
	
	@Update("update service_park set "
			+ " status = #{status}"
			+ " where serviceId = #{serviceProId}"
			+ " and serviceProRelease = #{serviceProRelease}")
	public void updateByServiceProIdAndRelease(Map<String, Object> params);
	
}