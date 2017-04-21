package com.sudaotech.huolijuzhen.enterprise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCottInfo;


public interface EnterpriseCottMapper extends EnterpriseCottEntityMapper {
	/**
	 * app--端任务列表
	 */

	 @SelectProvider(type=EnterpriseCottSqlProvider.class, method="selectByObj")
	 @Results({
	        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="corrType", property="corrType", jdbcType=JdbcType.INTEGER),
	        @Result(column="corrStatus", property="corrStatus", jdbcType=JdbcType.INTEGER),
	        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
	        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
	        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
	        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
	        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
	        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
	        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
	        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
	        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
	    })
	 List<EnterpriseCottInfo> selectByObj(EnterpriseCott example,RowBounds rowBounds);
	
    @SelectProvider(type=EnterpriseCottSqlProvider.class, method="countByObj")
    Integer countByObj(EnterpriseCott example);
    
}