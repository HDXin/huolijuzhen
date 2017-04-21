package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntity;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntityExample;
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

public interface RollPeriodEntityMapper {
    @SelectProvider(type=RollPeriodEntitySqlProvider.class, method="countByExample")
    int countByExample(RollPeriodEntityExample example);

    @DeleteProvider(type=RollPeriodEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(RollPeriodEntityExample example);

    @Delete({
        "delete from roll_period_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into roll_period_info (id, startDate, ",
        "endDate, rollPeriod, ",
        "rollRange, billCostCalRulesId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{startDate,jdbcType=TIMESTAMP}, ",
        "#{endDate,jdbcType=TIMESTAMP}, #{rollPeriod,jdbcType=INTEGER}, ",
        "#{rollRange,jdbcType=DECIMAL}, #{billCostCalRulesId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(RollPeriodEntity record);

    @InsertProvider(type=RollPeriodEntitySqlProvider.class, method="insertSelective")
    int insertSelective(RollPeriodEntity record);

    @SelectProvider(type=RollPeriodEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rollPeriod", property="rollPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollRange", property="rollRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="billCostCalRulesId", property="billCostCalRulesId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RollPeriodEntity> selectByExampleWithRowbounds(RollPeriodEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=RollPeriodEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rollPeriod", property="rollPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollRange", property="rollRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="billCostCalRulesId", property="billCostCalRulesId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RollPeriodEntity> selectByExample(RollPeriodEntityExample example);

    @Select({
        "select",
        "id, startDate, endDate, rollPeriod, rollRange, billCostCalRulesId, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from roll_period_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="rollPeriod", property="rollPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollRange", property="rollRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="billCostCalRulesId", property="billCostCalRulesId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    RollPeriodEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=RollPeriodEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RollPeriodEntity record, @Param("example") RollPeriodEntityExample example);

    @UpdateProvider(type=RollPeriodEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RollPeriodEntity record, @Param("example") RollPeriodEntityExample example);

    @UpdateProvider(type=RollPeriodEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RollPeriodEntity record);

    @Update({
        "update roll_period_info",
        "set startDate = #{startDate,jdbcType=TIMESTAMP},",
          "endDate = #{endDate,jdbcType=TIMESTAMP},",
          "rollPeriod = #{rollPeriod,jdbcType=INTEGER},",
          "rollRange = #{rollRange,jdbcType=DECIMAL},",
          "billCostCalRulesId = #{billCostCalRulesId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RollPeriodEntity record);
}