package com.sudaotech.huolijuzhen.bill.dao;

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

public interface CostProEntityMapper {
    @SelectProvider(type=CostProEntitySqlProvider.class, method="countByExample")
    int countByExample(CostProEntityExample example);

    @DeleteProvider(type=CostProEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CostProEntityExample example);

    @Delete({
        "delete from cost_pro",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cost_pro (id, name, ",
        "code, chargeMode, ",
        "chargePrice, costRate, ",
        "createSource, parkId, ",
        "isDefault, enableStatus, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, recommendStatus)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{chargeMode,jdbcType=INTEGER}, ",
        "#{chargePrice,jdbcType=DECIMAL}, #{costRate,jdbcType=DECIMAL}, ",
        "#{createSource,jdbcType=INTEGER}, #{parkId,jdbcType=BIGINT}, ",
        "#{isDefault,jdbcType=INTEGER}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{recommendStatus,jdbcType=INTEGER})"
    })
    int insert(CostProEntity record);

    @InsertProvider(type=CostProEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CostProEntity record);

    @SelectProvider(type=CostProEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="chargeMode", property="chargeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="chargePrice", property="chargePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="costRate", property="costRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="isDefault", property="isDefault", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
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
        @Result(column="recommendStatus", property="recommendStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CostProEntity> selectByExampleWithRowbounds(CostProEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CostProEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="chargeMode", property="chargeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="chargePrice", property="chargePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="costRate", property="costRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="isDefault", property="isDefault", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
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
        @Result(column="recommendStatus", property="recommendStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CostProEntity> selectByExample(CostProEntityExample example);

    @Select({
        "select",
        "id, name, code, chargeMode, chargePrice, costRate, createSource, parkId, isDefault, ",
        "enableStatus, enableBy, enableTime, disableBy, disableTime, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate, recommendStatus",
        "from cost_pro",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="chargeMode", property="chargeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="chargePrice", property="chargePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="costRate", property="costRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="createSource", property="createSource", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="isDefault", property="isDefault", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
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
        @Result(column="recommendStatus", property="recommendStatus", jdbcType=JdbcType.INTEGER)
    })
    CostProEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=CostProEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CostProEntity record, @Param("example") CostProEntityExample example);

    @UpdateProvider(type=CostProEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CostProEntity record, @Param("example") CostProEntityExample example);

    @UpdateProvider(type=CostProEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CostProEntity record);

    @Update({
        "update cost_pro",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "chargeMode = #{chargeMode,jdbcType=INTEGER},",
          "chargePrice = #{chargePrice,jdbcType=DECIMAL},",
          "costRate = #{costRate,jdbcType=DECIMAL},",
          "createSource = #{createSource,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "isDefault = #{isDefault,jdbcType=INTEGER},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "recommendStatus = #{recommendStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CostProEntity record);
}