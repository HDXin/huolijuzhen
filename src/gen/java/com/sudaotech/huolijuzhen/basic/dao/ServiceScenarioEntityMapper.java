package com.sudaotech.huolijuzhen.basic.dao;

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

public interface ServiceScenarioEntityMapper {
    @SelectProvider(type=ServiceScenarioEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceScenarioEntityExample example);

    @DeleteProvider(type=ServiceScenarioEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceScenarioEntityExample example);

    @Delete({
        "delete from service_scenario",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_scenario (id, name, ",
        "serverGrade, describle, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, enableStatus, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime, ",
        "scaneLogo, recoLogo)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{serverGrade,jdbcType=INTEGER}, #{describle,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP}, ",
        "#{scaneLogo,jdbcType=VARCHAR}, #{recoLogo,jdbcType=VARCHAR})"
    })
    int insert(ServiceScenarioEntity record);

    @InsertProvider(type=ServiceScenarioEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceScenarioEntity record);

    @SelectProvider(type=ServiceScenarioEntitySqlProvider.class, method="selectByExample")
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
    List<ServiceScenarioEntity> selectByExampleWithRowbounds(ServiceScenarioEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceScenarioEntitySqlProvider.class, method="selectByExample")
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
    List<ServiceScenarioEntity> selectByExample(ServiceScenarioEntityExample example);

    @Select({
        "select",
        "id, name, serverGrade, describle, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate, enableStatus, enableBy, enableTime, disableBy, disableTime, ",
        "scaneLogo, recoLogo",
        "from service_scenario",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    ServiceScenarioEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceScenarioEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceScenarioEntity record, @Param("example") ServiceScenarioEntityExample example);

    @UpdateProvider(type=ServiceScenarioEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceScenarioEntity record, @Param("example") ServiceScenarioEntityExample example);

    @UpdateProvider(type=ServiceScenarioEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceScenarioEntity record);

    @Update({
        "update service_scenario",
        "set name = #{name,jdbcType=VARCHAR},",
          "serverGrade = #{serverGrade,jdbcType=INTEGER},",
          "describle = #{describle,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP},",
          "scaneLogo = #{scaneLogo,jdbcType=VARCHAR},",
          "recoLogo = #{recoLogo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceScenarioEntity record);
}