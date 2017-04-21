package com.sudaotech.huolijuzhen.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.basic.service.SystemConfigService.SystemConfig;

public interface SystemConfigEntityExtendsMapper extends SystemConfigEntityMapper {

	@SelectProvider(type=SystemConfigEntityextendsSqlProvider.class, method="selectByParkId")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="maintenanceReportSign", property="maintenanceReportSign", jdbcType=JdbcType.INTEGER),
        @Result(column="maintenanceReportDays", property="maintenanceReportDays", jdbcType=JdbcType.INTEGER),
        @Result(column="createParkSign", property="createParkSign", jdbcType=JdbcType.INTEGER),
        @Result(column="createParkDays", property="createParkDays", jdbcType=JdbcType.INTEGER),
        @Result(column="equipmentMaintainSign", property="equipmentMaintainSign", jdbcType=JdbcType.INTEGER),
        @Result(column="equipmentMaintainDays", property="equipmentMaintainDays", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeTermSign", property="urgeTermSign", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeTermDays", property="urgeTermDays", jdbcType=JdbcType.INTEGER),
        @Result(column="urgeContentTemplate", property="urgeContentTemplate", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="billIntroduction", property="billIntroduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="billPayWay", property="billPayWay", jdbcType=JdbcType.VARCHAR),
        @Result(column="billBankAccount", property="billBankAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="billInscrible", property="billInscrible", jdbcType=JdbcType.VARCHAR)
    })
	public List<SystemConfig> getByParkId(Long parkId);
	
}
