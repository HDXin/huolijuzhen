package com.sudaotech.huolijuzhen.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.EnterpriseDisplay;

public interface EnterpriseDisplayEntityExtendsMapper extends
		EnterpriseDisplayEntityMapper {

	@SelectProvider(type=EnterpriseDisplayEntityExtendsSqlProvider.class, method="selectByEnterpriseIds")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="publishLevel", property="publishLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalDate", property="approvalDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalUser", property="approvalUser", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<Map<String, Object>> selectByEnterpriseIds(Map<String, Object> paramsMap);
	
	@SelectProvider(type=EnterpriseDisplayEntityExtendsSqlProvider.class,method="findCountBySql")
	public Integer findCountBySql(Map<String,Object> paramsMap);
	
	/**
	 * 根据parkId和企业id查询数量
	 * */
	@SelectProvider(type=EnterpriseDisplayEntityExtendsSqlProvider.class,method="findCountByParkidAndEnterpriseId")
	public Integer findCountByParkidAndEnterpriseId(Map<String, Object> paramsMap);
	
	//查询所有id
	@SelectProvider(type=EnterpriseDisplayEntityExtendsSqlProvider.class, method="selectAllIDs")
    @Results({
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT)    
    })
    public List<Map<String, Object>> selectAllIDs();
	
	/**
	 * 根据发布级别查询
	 * */
	@SelectProvider(type=EnterpriseDisplayEntityExtendsSqlProvider.class, method="selectByPublishLevel")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="publishLevel", property="publishLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalDate", property="approvalDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalUser", property="approvalUser", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
	public List<EnterpriseDisplay> findByPublishLevel(Integer publishLevel);
	
}
