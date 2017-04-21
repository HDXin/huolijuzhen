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

public interface BillCostDetailEntityMapper {
    @SelectProvider(type=BillCostDetailEntitySqlProvider.class, method="countByExample")
    int countByExample(BillCostDetailEntityExample example);

    @DeleteProvider(type=BillCostDetailEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillCostDetailEntityExample example);

    @Delete({
        "delete from bill_cost_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_cost_detail (id, billId, ",
        "bccrId, dosage, unitPrise, ",
        "costProName, cost, ",
        "taxRate, taxMoney, ",
        "totalMoney, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "verifyMoney, isTask)",
        "values (#{id,jdbcType=BIGINT}, #{billId,jdbcType=BIGINT}, ",
        "#{bccrId,jdbcType=BIGINT}, #{dosage,jdbcType=DECIMAL}, #{unitPrise,jdbcType=DECIMAL}, ",
        "#{costProName,jdbcType=VARCHAR}, #{cost,jdbcType=DECIMAL}, ",
        "#{taxRate,jdbcType=DECIMAL}, #{taxMoney,jdbcType=DECIMAL}, ",
        "#{totalMoney,jdbcType=DECIMAL}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{verifyMoney,jdbcType=DECIMAL}, #{isTask,jdbcType=INTEGER})"
    })
    int insert(BillCostDetailEntity record);

    @InsertProvider(type=BillCostDetailEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillCostDetailEntity record);

    @SelectProvider(type=BillCostDetailEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="unitPrise", property="unitPrise", jdbcType=JdbcType.DECIMAL),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxRate", property="taxRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxMoney", property="taxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verifyMoney", property="verifyMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="isTask", property="isTask", jdbcType=JdbcType.INTEGER)
    })
    List<BillCostDetailEntity> selectByExampleWithRowbounds(BillCostDetailEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillCostDetailEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="unitPrise", property="unitPrise", jdbcType=JdbcType.DECIMAL),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxRate", property="taxRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxMoney", property="taxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verifyMoney", property="verifyMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="isTask", property="isTask", jdbcType=JdbcType.INTEGER)
    })
    List<BillCostDetailEntity> selectByExample(BillCostDetailEntityExample example);

    @Select({
        "select",
        "id, billId, bccrId, dosage, unitPrise, costProName, cost, taxRate, taxMoney, ",
        "totalMoney, version, status, createBy, createTime, updateBy, updateTime, lastUpdate, ",
        "verifyMoney, isTask",
        "from bill_cost_detail",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="unitPrise", property="unitPrise", jdbcType=JdbcType.DECIMAL),
        @Result(column="costProName", property="costProName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxRate", property="taxRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="taxMoney", property="taxMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalMoney", property="totalMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verifyMoney", property="verifyMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="isTask", property="isTask", jdbcType=JdbcType.INTEGER)
    })
    BillCostDetailEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillCostDetailEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillCostDetailEntity record, @Param("example") BillCostDetailEntityExample example);

    @UpdateProvider(type=BillCostDetailEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillCostDetailEntity record, @Param("example") BillCostDetailEntityExample example);

    @UpdateProvider(type=BillCostDetailEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillCostDetailEntity record);

    @Update({
        "update bill_cost_detail",
        "set billId = #{billId,jdbcType=BIGINT},",
          "bccrId = #{bccrId,jdbcType=BIGINT},",
          "dosage = #{dosage,jdbcType=DECIMAL},",
          "unitPrise = #{unitPrise,jdbcType=DECIMAL},",
          "costProName = #{costProName,jdbcType=VARCHAR},",
          "cost = #{cost,jdbcType=DECIMAL},",
          "taxRate = #{taxRate,jdbcType=DECIMAL},",
          "taxMoney = #{taxMoney,jdbcType=DECIMAL},",
          "totalMoney = #{totalMoney,jdbcType=DECIMAL},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "verifyMoney = #{verifyMoney,jdbcType=DECIMAL},",
          "isTask = #{isTask,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillCostDetailEntity record);
}