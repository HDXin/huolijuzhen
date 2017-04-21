package com.sudaotech.huolijuzhen.enterprise.dao;

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

public interface ContractBillEntityMapper {
    @SelectProvider(type=ContractBillEntitySqlProvider.class, method="countByExample")
    int countByExample(ContractBillEntityExample example);

    @DeleteProvider(type=ContractBillEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContractBillEntityExample example);

    @Delete({
        "delete from contract_bill",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into contract_bill (id, contractId, ",
        "month, billAmount, ",
        "isBillMonth, costProId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{contractId,jdbcType=BIGINT}, ",
        "#{month,jdbcType=VARCHAR}, #{billAmount,jdbcType=DECIMAL}, ",
        "#{isBillMonth,jdbcType=INTEGER}, #{costProId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ContractBillEntity record);

    @InsertProvider(type=ContractBillEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ContractBillEntity record);

    @SelectProvider(type=ContractBillEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="billAmount", property="billAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="isBillMonth", property="isBillMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContractBillEntity> selectByExampleWithRowbounds(ContractBillEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContractBillEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="billAmount", property="billAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="isBillMonth", property="isBillMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContractBillEntity> selectByExample(ContractBillEntityExample example);

    @Select({
        "select",
        "id, contractId, month, billAmount, isBillMonth, costProId, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from contract_bill",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="billAmount", property="billAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="isBillMonth", property="isBillMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="costProId", property="costProId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ContractBillEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContractBillEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContractBillEntity record, @Param("example") ContractBillEntityExample example);

    @UpdateProvider(type=ContractBillEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContractBillEntity record, @Param("example") ContractBillEntityExample example);

    @UpdateProvider(type=ContractBillEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractBillEntity record);

    @Update({
        "update contract_bill",
        "set contractId = #{contractId,jdbcType=BIGINT},",
          "month = #{month,jdbcType=VARCHAR},",
          "billAmount = #{billAmount,jdbcType=DECIMAL},",
          "isBillMonth = #{isBillMonth,jdbcType=INTEGER},",
          "costProId = #{costProId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContractBillEntity record);
}