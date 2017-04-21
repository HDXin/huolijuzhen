package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntity;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface SystemConfigEntityMapper {
    @SelectProvider(type=SystemConfigEntitySqlProvider.class, method="countByExample")
    int countByExample(SystemConfigEntityExample example);

    @DeleteProvider(type=SystemConfigEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemConfigEntityExample example);

    @Delete({
        "delete from system_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into system_config (id, parkId, ",
        "maintenanceReportSign, maintenanceReportDays, ",
        "createParkSign, createParkDays, ",
        "equipmentMaintainSign, equipmentMaintainDays, ",
        "urgeTermSign, urgeTermDays, ",
        "urgeContentTemplate, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "billIntroduction, billPayWay, ",
        "billBankAccount, billInscrible)",
        "values (#{id,jdbcType=BIGINT}, #{parkId,jdbcType=BIGINT}, ",
        "#{maintenanceReportSign,jdbcType=INTEGER}, #{maintenanceReportDays,jdbcType=INTEGER}, ",
        "#{createParkSign,jdbcType=INTEGER}, #{createParkDays,jdbcType=INTEGER}, ",
        "#{equipmentMaintainSign,jdbcType=INTEGER}, #{equipmentMaintainDays,jdbcType=INTEGER}, ",
        "#{urgeTermSign,jdbcType=INTEGER}, #{urgeTermDays,jdbcType=INTEGER}, ",
        "#{urgeContentTemplate,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{billIntroduction,jdbcType=VARCHAR}, #{billPayWay,jdbcType=VARCHAR}, ",
        "#{billBankAccount,jdbcType=VARCHAR}, #{billInscrible,jdbcType=VARCHAR})"
    })
    int insert(SystemConfigEntity record);

    @InsertProvider(type=SystemConfigEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SystemConfigEntity record);

    @SelectProvider(type=SystemConfigEntitySqlProvider.class, method="selectByExample")
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
    List<SystemConfigEntity> selectByExampleWithRowbounds(SystemConfigEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=SystemConfigEntitySqlProvider.class, method="selectByExample")
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
    List<SystemConfigEntity> selectByExample(SystemConfigEntityExample example);

    @Select({
        "select",
        "id, parkId, maintenanceReportSign, maintenanceReportDays, createParkSign, createParkDays, ",
        "equipmentMaintainSign, equipmentMaintainDays, urgeTermSign, urgeTermDays, urgeContentTemplate, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, billIntroduction, ",
        "billPayWay, billBankAccount, billInscrible",
        "from system_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    SystemConfigEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=SystemConfigEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemConfigEntity record, @Param("example") SystemConfigEntityExample example);

    @UpdateProvider(type=SystemConfigEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemConfigEntity record, @Param("example") SystemConfigEntityExample example);

    @UpdateProvider(type=SystemConfigEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemConfigEntity record);

    @Update({
        "update system_config",
        "set parkId = #{parkId,jdbcType=BIGINT},",
          "maintenanceReportSign = #{maintenanceReportSign,jdbcType=INTEGER},",
          "maintenanceReportDays = #{maintenanceReportDays,jdbcType=INTEGER},",
          "createParkSign = #{createParkSign,jdbcType=INTEGER},",
          "createParkDays = #{createParkDays,jdbcType=INTEGER},",
          "equipmentMaintainSign = #{equipmentMaintainSign,jdbcType=INTEGER},",
          "equipmentMaintainDays = #{equipmentMaintainDays,jdbcType=INTEGER},",
          "urgeTermSign = #{urgeTermSign,jdbcType=INTEGER},",
          "urgeTermDays = #{urgeTermDays,jdbcType=INTEGER},",
          "urgeContentTemplate = #{urgeContentTemplate,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "billIntroduction = #{billIntroduction,jdbcType=VARCHAR},",
          "billPayWay = #{billPayWay,jdbcType=VARCHAR},",
          "billBankAccount = #{billBankAccount,jdbcType=VARCHAR},",
          "billInscrible = #{billInscrible,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemConfigEntity record);
}