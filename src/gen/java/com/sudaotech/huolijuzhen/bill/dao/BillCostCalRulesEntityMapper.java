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

public interface BillCostCalRulesEntityMapper {
    @SelectProvider(type=BillCostCalRulesEntitySqlProvider.class, method="countByExample")
    int countByExample(BillCostCalRulesEntityExample example);

    @DeleteProvider(type=BillCostCalRulesEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillCostCalRulesEntityExample example);

    @Delete({
        "delete from bill_cost_cal_rules",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_cost_cal_rules (id, contractId, ",
        "costProId, costProName, ",
        "computeMode, freeMonth, ",
        "advanceMonth, fixedAmount, ",
        "startAdjAmount, startAdjMonth, ",
        "endAdjAmount, endAdjMonth, ",
        "leaseAreaCal, contAmountCal, ",
        "daysCal, isRollingCal, ",
        "rollingStartMonth, rollingPeriod, ",
        "rollingRange, formula, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, startDate, ",
        "endDate)",
        "values (#{id,jdbcType=BIGINT}, #{contractId,jdbcType=BIGINT}, ",
        "#{costProId,jdbcType=BIGINT}, #{costProName,jdbcType=VARCHAR}, ",
        "#{computeMode,jdbcType=INTEGER}, #{freeMonth,jdbcType=INTEGER}, ",
        "#{advanceMonth,jdbcType=INTEGER}, #{fixedAmount,jdbcType=DECIMAL}, ",
        "#{startAdjAmount,jdbcType=DECIMAL}, #{startAdjMonth,jdbcType=VARCHAR}, ",
        "#{endAdjAmount,jdbcType=DECIMAL}, #{endAdjMonth,jdbcType=VARCHAR}, ",
        "#{leaseAreaCal,jdbcType=INTEGER}, #{contAmountCal,jdbcType=INTEGER}, ",
        "#{daysCal,jdbcType=INTEGER}, #{isRollingCal,jdbcType=INTEGER}, ",
        "#{rollingStartMonth,jdbcType=INTEGER}, #{rollingPeriod,jdbcType=INTEGER}, ",
        "#{rollingRange,jdbcType=DECIMAL}, #{formula,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{startDate,jdbcType=DATE}, ",
        "#{endDate,jdbcType=DATE})"
    })
    int insert(BillCostCalRulesEntity record);

    @InsertProvider(type=BillCostCalRulesEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillCostCalRulesEntity record);

    @SelectProvider(type=BillCostCalRulesEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="computeMode", property="computeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="freeMonth", property="freeMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="advanceMonth", property="advanceMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="fixedAmount", property="fixedAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjAmount", property="startAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjMonth", property="startAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="endAdjAmount", property="endAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="endAdjMonth", property="endAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="leaseAreaCal", property="leaseAreaCal", jdbcType=JdbcType.INTEGER),
        @Result(column="contAmountCal", property="contAmountCal", jdbcType=JdbcType.INTEGER),
        @Result(column="daysCal", property="daysCal", jdbcType=JdbcType.INTEGER),
        @Result(column="isRollingCal", property="isRollingCal", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingStartMonth", property="rollingStartMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingPeriod", property="rollingPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingRange", property="rollingRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="formula", property="formula", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE)
    })
    List<BillCostCalRulesEntity> selectByExampleWithRowbounds(BillCostCalRulesEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillCostCalRulesEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="computeMode", property="computeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="freeMonth", property="freeMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="advanceMonth", property="advanceMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="fixedAmount", property="fixedAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjAmount", property="startAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjMonth", property="startAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="endAdjAmount", property="endAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="endAdjMonth", property="endAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="leaseAreaCal", property="leaseAreaCal", jdbcType=JdbcType.INTEGER),
        @Result(column="contAmountCal", property="contAmountCal", jdbcType=JdbcType.INTEGER),
        @Result(column="daysCal", property="daysCal", jdbcType=JdbcType.INTEGER),
        @Result(column="isRollingCal", property="isRollingCal", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingStartMonth", property="rollingStartMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingPeriod", property="rollingPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingRange", property="rollingRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="formula", property="formula", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE)
    })
    List<BillCostCalRulesEntity> selectByExample(BillCostCalRulesEntityExample example);

    @Select({
        "select",
        "id, contractId, costProId, costProName, computeMode, freeMonth, advanceMonth, ",
        "fixedAmount, startAdjAmount, startAdjMonth, endAdjAmount, endAdjMonth, leaseAreaCal, ",
        "contAmountCal, daysCal, isRollingCal, rollingStartMonth, rollingPeriod, rollingRange, ",
        "formula, version, status, createBy, createTime, updateBy, updateTime, lastUpdate, ",
        "startDate, endDate",
        "from bill_cost_cal_rules",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="computeMode", property="computeMode", jdbcType=JdbcType.INTEGER),
        @Result(column="freeMonth", property="freeMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="advanceMonth", property="advanceMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="fixedAmount", property="fixedAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjAmount", property="startAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="startAdjMonth", property="startAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="endAdjAmount", property="endAdjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="endAdjMonth", property="endAdjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="leaseAreaCal", property="leaseAreaCal", jdbcType=JdbcType.INTEGER),
        @Result(column="contAmountCal", property="contAmountCal", jdbcType=JdbcType.INTEGER),
        @Result(column="daysCal", property="daysCal", jdbcType=JdbcType.INTEGER),
        @Result(column="isRollingCal", property="isRollingCal", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingStartMonth", property="rollingStartMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingPeriod", property="rollingPeriod", jdbcType=JdbcType.INTEGER),
        @Result(column="rollingRange", property="rollingRange", jdbcType=JdbcType.DECIMAL),
        @Result(column="formula", property="formula", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.DATE)
    })
    BillCostCalRulesEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillCostCalRulesEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillCostCalRulesEntity record, @Param("example") BillCostCalRulesEntityExample example);

    @UpdateProvider(type=BillCostCalRulesEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillCostCalRulesEntity record, @Param("example") BillCostCalRulesEntityExample example);

    @UpdateProvider(type=BillCostCalRulesEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillCostCalRulesEntity record);

    @Update({
        "update bill_cost_cal_rules",
        "set contractId = #{contractId,jdbcType=BIGINT},",
          "costProId = #{costProId,jdbcType=BIGINT},",
          "costProName = #{costProName,jdbcType=VARCHAR},",
          "computeMode = #{computeMode,jdbcType=INTEGER},",
          "freeMonth = #{freeMonth,jdbcType=INTEGER},",
          "advanceMonth = #{advanceMonth,jdbcType=INTEGER},",
          "fixedAmount = #{fixedAmount,jdbcType=DECIMAL},",
          "startAdjAmount = #{startAdjAmount,jdbcType=DECIMAL},",
          "startAdjMonth = #{startAdjMonth,jdbcType=VARCHAR},",
          "endAdjAmount = #{endAdjAmount,jdbcType=DECIMAL},",
          "endAdjMonth = #{endAdjMonth,jdbcType=VARCHAR},",
          "leaseAreaCal = #{leaseAreaCal,jdbcType=INTEGER},",
          "contAmountCal = #{contAmountCal,jdbcType=INTEGER},",
          "daysCal = #{daysCal,jdbcType=INTEGER},",
          "isRollingCal = #{isRollingCal,jdbcType=INTEGER},",
          "rollingStartMonth = #{rollingStartMonth,jdbcType=INTEGER},",
          "rollingPeriod = #{rollingPeriod,jdbcType=INTEGER},",
          "rollingRange = #{rollingRange,jdbcType=DECIMAL},",
          "formula = #{formula,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "startDate = #{startDate,jdbcType=DATE},",
          "endDate = #{endDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillCostCalRulesEntity record);
}