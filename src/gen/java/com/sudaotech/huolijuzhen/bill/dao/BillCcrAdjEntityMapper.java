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

public interface BillCcrAdjEntityMapper {
    @SelectProvider(type=BillCcrAdjEntitySqlProvider.class, method="countByExample")
    int countByExample(BillCcrAdjEntityExample example);

    @DeleteProvider(type=BillCcrAdjEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillCcrAdjEntityExample example);

    @Delete({
        "delete from bill_ccr_adj",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_ccr_adj (id, bccrId, ",
        "adjAmount, adjMonth, ",
        "adjRemark, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{bccrId,jdbcType=BIGINT}, ",
        "#{adjAmount,jdbcType=DECIMAL}, #{adjMonth,jdbcType=VARCHAR}, ",
        "#{adjRemark,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(BillCcrAdjEntity record);

    @InsertProvider(type=BillCcrAdjEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillCcrAdjEntity record);

    @SelectProvider(type=BillCcrAdjEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="adjAmount", property="adjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjMonth", property="adjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="adjRemark", property="adjRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillCcrAdjEntity> selectByExampleWithRowbounds(BillCcrAdjEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillCcrAdjEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="adjAmount", property="adjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjMonth", property="adjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="adjRemark", property="adjRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillCcrAdjEntity> selectByExample(BillCcrAdjEntityExample example);

    @Select({
        "select",
        "id, bccrId, adjAmount, adjMonth, adjRemark, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from bill_ccr_adj",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="bccrId", property="bccrId", jdbcType=JdbcType.BIGINT),
        @Result(column="adjAmount", property="adjAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="adjMonth", property="adjMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="adjRemark", property="adjRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    BillCcrAdjEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillCcrAdjEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillCcrAdjEntity record, @Param("example") BillCcrAdjEntityExample example);

    @UpdateProvider(type=BillCcrAdjEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillCcrAdjEntity record, @Param("example") BillCcrAdjEntityExample example);

    @UpdateProvider(type=BillCcrAdjEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillCcrAdjEntity record);

    @Update({
        "update bill_ccr_adj",
        "set bccrId = #{bccrId,jdbcType=BIGINT},",
          "adjAmount = #{adjAmount,jdbcType=DECIMAL},",
          "adjMonth = #{adjMonth,jdbcType=VARCHAR},",
          "adjRemark = #{adjRemark,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillCcrAdjEntity record);
}