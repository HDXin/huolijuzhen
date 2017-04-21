package com.sudaotech.huolijuzhen.basic.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.basic.service.ServiceTypeService.ServiceType;

public interface LocationServiceTypeEntityMapper extends ServiceTypeEntityMapper{
	
	@Select({
        "select",
        "id, name, isReco, serverGrade, describle, enableStatus, enableBy, enableTime, ",
        "disableBy, disableTime, recoBy, recoTime, unRecoBy, unRecoTime, typeLogo, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate, recoLogo",
        " from service_type",
        " where 1=1 "
        + " and status = #{status}"
        + " and enableStatus = #{enableStatus}"
        + " order by createTime DESC "
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="isReco", property="isReco", jdbcType=JdbcType.BIT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="recoBy", property="recoBy", jdbcType=JdbcType.BIGINT),
        @Result(column="recoTime", property="recoTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="unRecoBy", property="unRecoBy", jdbcType=JdbcType.BIGINT),
        @Result(column="unRecoTime", property="unRecoTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="typeLogo", property="typeLogo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="recoLogo", property="recoLogo", jdbcType=JdbcType.VARCHAR)
    })
	public List<ServiceType> findAll(Map<String, Object> params);
	
}