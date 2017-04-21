package com.sudaotech.huolijuzhen.equipment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.equipment.service.EquipmentTypeService.EquipmentType;

public interface LocationEquipmentTypeEntityMapper extends EquipmentTypeEntityMapper{
    
	@Select("select id,"
			+ "code,"
			+ "name,"
			+ "parkId,"
			+ "version,"
			+ "status,"
			+ "createBy,"
			+ "createTime,"
			+ "updateBy,"
			+ "updateTime,"
			+ "lastUpdate,"
			+ "enableStatus,"
			+ "enableBy,"
			+ "disableBy,"
			+ "disableTime,"
			+ "deleteTime,"
			+ "deleteBy"
			+ " from equipment_type where 1=1 "
			+ " and status = #{status}"
			+ " and enableStatus = #{enableStatus}"
			+ " and parkId = #{parkId}")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT)
    })
	public List<EquipmentType> findAll(Map<String, Object> params);
	
}