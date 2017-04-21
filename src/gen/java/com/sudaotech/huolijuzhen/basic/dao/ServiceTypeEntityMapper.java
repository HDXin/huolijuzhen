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

public interface ServiceTypeEntityMapper {
    @SelectProvider(type=ServiceTypeEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceTypeEntityExample example);

    @DeleteProvider(type=ServiceTypeEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceTypeEntityExample example);

    @Delete({
        "delete from service_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_type (id, name, ",
        "isReco, serverGrade, ",
        "describle, enableStatus, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime, ",
        "recoBy, recoTime, ",
        "unRecoBy, unRecoTime, ",
        "typeLogo, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "recoLogo)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{isReco,jdbcType=BIT}, #{serverGrade,jdbcType=INTEGER}, ",
        "#{describle,jdbcType=VARCHAR}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP}, ",
        "#{recoBy,jdbcType=BIGINT}, #{recoTime,jdbcType=TIMESTAMP}, ",
        "#{unRecoBy,jdbcType=BIGINT}, #{unRecoTime,jdbcType=TIMESTAMP}, ",
        "#{typeLogo,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{recoLogo,jdbcType=VARCHAR})"
    })
    int insert(ServiceTypeEntity record);

    @InsertProvider(type=ServiceTypeEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceTypeEntity record);

    @SelectProvider(type=ServiceTypeEntitySqlProvider.class, method="selectByExample")
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
    List<ServiceTypeEntity> selectByExampleWithRowbounds(ServiceTypeEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceTypeEntitySqlProvider.class, method="selectByExample")
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
    List<ServiceTypeEntity> selectByExample(ServiceTypeEntityExample example);

    @Select({
        "select",
        "id, name, isReco, serverGrade, describle, enableStatus, enableBy, enableTime, ",
        "disableBy, disableTime, recoBy, recoTime, unRecoBy, unRecoTime, typeLogo, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate, recoLogo",
        "from service_type",
        "where id = #{id,jdbcType=BIGINT}"
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
    ServiceTypeEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceTypeEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceTypeEntity record, @Param("example") ServiceTypeEntityExample example);

    @UpdateProvider(type=ServiceTypeEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceTypeEntity record, @Param("example") ServiceTypeEntityExample example);

    @UpdateProvider(type=ServiceTypeEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceTypeEntity record);

    @Update({
        "update service_type",
        "set name = #{name,jdbcType=VARCHAR},",
          "isReco = #{isReco,jdbcType=BIT},",
          "serverGrade = #{serverGrade,jdbcType=INTEGER},",
          "describle = #{describle,jdbcType=VARCHAR},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP},",
          "recoBy = #{recoBy,jdbcType=BIGINT},",
          "recoTime = #{recoTime,jdbcType=TIMESTAMP},",
          "unRecoBy = #{unRecoBy,jdbcType=BIGINT},",
          "unRecoTime = #{unRecoTime,jdbcType=TIMESTAMP},",
          "typeLogo = #{typeLogo,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "recoLogo = #{recoLogo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceTypeEntity record);
}