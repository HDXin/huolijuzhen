package com.sudaotech.huolijuzhen.basic.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.basic.dao.LocationEntityMapper;

public interface ServiceLocationEntityMapper extends LocationEntityMapper {
	
	@Select("select distinct(proId) from location_info where status = #{status} and enableStatus = #{enableStatus}")
	@Results(@Result(property="proId",column="proId"))
	List<Long> selectAllProvince(Map<String, Object> param);

	@Select("select distinct(cityId) from location_info where proId = #{proId} and status = #{status} and enableStatus = #{enableStatus}")
	@Results(@Result(property="cityId",column="cityId"))
	List<Long> selectCityByProId(Map<String, Object> param);

	@Select("select distinct(counId) from location_info where cityId = #{cityId} and status = #{status} and enableStatus = #{enableStatus}")
	@Results(@Result(property="counId",column="counId"))
	List<Long> selectCountoryByCityId(Map<String, Object> param);

	@Select("select id,business from location_info where counId = #{counId} and status = #{status} and enableStatus = #{enableStatus}")
	@Results({
			@Result(id=true,property="id",column="id"),
			@Result(property="business",column="business")
	})
	List<Map<String, Object>> selectByCounId(Map<String, Object> param);

	@SelectProvider(type=ServiceLocationEntitySqlProvider.class,method="isExist")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
    })
	public List<Long> isExist(Map<String, Object> params);
}
