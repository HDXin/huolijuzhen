package com.sudaotech.huolijuzhen.policy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.policy.service.PolicyService.Policy;

public interface LocationPolicyEntityMapper extends PolicyEntityMapper{
 
	@SelectProvider(type=LocationPolicyEntitySqlProvider.class, method="findAllCountByParkId")
	public Integer findAllCountByParkId(Map<String, Object> params);
	
	
	@SelectProvider(type=LocationPolicyEntitySqlProvider.class, method="findAllByParkId")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="polUri", property="polUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER)
    })
	public List<Policy> findAllByParkId(Map<String, Object> params);
	
}