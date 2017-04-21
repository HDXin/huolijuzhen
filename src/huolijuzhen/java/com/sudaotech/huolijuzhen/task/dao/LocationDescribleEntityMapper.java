package com.sudaotech.huolijuzhen.task.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.task.service.DescribleService.Describle;

public interface LocationDescribleEntityMapper extends DescribleEntityMapper{


	@Select("select id,"
			+ "desciption,"
			+ "enableStatus,"
			+ "parkId,"
			+ "enableBy,"
			+ "enableTime,"
			+ "disableBy,"
			+ "disableTime,"
			+ "version,"
			+ "status,"
			+ "createBy,"
			+ "updateTime,"
			+ "updateBy,"
			+ "lastUpdate,"
			+ "deleteBy,"
			+ "deleteTime"
			+ " from desc_info"
			+ " where 1=1 "
			+ " and status = #{status}"
			+ " and enableStatus = #{enableStatus}"
			+ " and parkId = #{parkId}")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="desciption", property="desciption", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
	public List<Describle> findAll(Map<String, Object> params);


}