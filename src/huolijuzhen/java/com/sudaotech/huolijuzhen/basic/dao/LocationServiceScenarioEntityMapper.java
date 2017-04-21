package com.sudaotech.huolijuzhen.basic.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;

public interface LocationServiceScenarioEntityMapper extends ServiceScenarioEntityMapper{
    
	@Select("select id,"
			+ "name,"
			+ "serverGrade,"
			+ "describle,"
			+ "version,"
			+ "status,"
			+ "createBy,"
			+ "createTime,"
			+ "updateBy,"
			+ "updateTime,"
			+ "lastUpdate,"
			+ "enableStatus,"
			+ "enableBy,"
			+ "enableTime,"
			+ "disableBy,"
			+ "disableTime,"
			+ "scaneLogo,"
			+ "recoLogo"
			+ " from service_scenario"
			+ " where 1=1 "
			+ " and status = #{status}")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="scaneLogo", property="scaneLogo", jdbcType=JdbcType.VARCHAR),
        @Result(column="recoLogo", property="recoLogo", jdbcType=JdbcType.VARCHAR)
    })
	public List<ServiceScenario> findAll(Map<String, Object> params);
}