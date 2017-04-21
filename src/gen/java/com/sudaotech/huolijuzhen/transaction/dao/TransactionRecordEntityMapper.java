package com.sudaotech.huolijuzhen.transaction.dao;

import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntity;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample;
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

public interface TransactionRecordEntityMapper {
    @SelectProvider(type=TransactionRecordEntitySqlProvider.class, method="countByExample")
    int countByExample(TransactionRecordEntityExample example);

    @DeleteProvider(type=TransactionRecordEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TransactionRecordEntityExample example);

    @Delete({
        "delete from transaction_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into transaction_record (id, userId, ",
        "transactionAmount, transactionTime, ",
        "transactionDirection, transactionType, ",
        "transactionStatus, payChannel, ",
        "transferFromType, transferFromId, ",
        "transferToType, transferToId, ",
        "bizType, bizId, ",
        "orderNo, explanation, ",
        "tradeNo, buyerEmail, ",
        "buyerId, version, ",
        "status, createBy, ",
        "createTime, createName, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{transactionAmount,jdbcType=DECIMAL}, #{transactionTime,jdbcType=TIMESTAMP}, ",
        "#{transactionDirection,jdbcType=INTEGER}, #{transactionType,jdbcType=INTEGER}, ",
        "#{transactionStatus,jdbcType=INTEGER}, #{payChannel,jdbcType=INTEGER}, ",
        "#{transferFromType,jdbcType=INTEGER}, #{transferFromId,jdbcType=BIGINT}, ",
        "#{transferToType,jdbcType=INTEGER}, #{transferToId,jdbcType=BIGINT}, ",
        "#{bizType,jdbcType=INTEGER}, #{bizId,jdbcType=VARCHAR}, ",
        "#{orderNo,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR}, ",
        "#{tradeNo,jdbcType=VARCHAR}, #{buyerEmail,jdbcType=VARCHAR}, ",
        "#{buyerId,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createName,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TransactionRecordEntity record);

    @InsertProvider(type=TransactionRecordEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TransactionRecordEntity record);

    @SelectProvider(type=TransactionRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="transactionAmount", property="transactionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="transactionTime", property="transactionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="transactionDirection", property="transactionDirection", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionType", property="transactionType", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionStatus", property="transactionStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="payChannel", property="payChannel", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromType", property="transferFromType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromId", property="transferFromId", jdbcType=JdbcType.BIGINT),
        @Result(column="transferToType", property="transferToType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferToId", property="transferToId", jdbcType=JdbcType.BIGINT),
        @Result(column="bizType", property="bizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="explanation", property="explanation", jdbcType=JdbcType.VARCHAR),
        @Result(column="tradeNo", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerEmail", property="buyerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerId", property="buyerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TransactionRecordEntity> selectByExampleWithRowbounds(TransactionRecordEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TransactionRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="transactionAmount", property="transactionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="transactionTime", property="transactionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="transactionDirection", property="transactionDirection", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionType", property="transactionType", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionStatus", property="transactionStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="payChannel", property="payChannel", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromType", property="transferFromType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromId", property="transferFromId", jdbcType=JdbcType.BIGINT),
        @Result(column="transferToType", property="transferToType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferToId", property="transferToId", jdbcType=JdbcType.BIGINT),
        @Result(column="bizType", property="bizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="explanation", property="explanation", jdbcType=JdbcType.VARCHAR),
        @Result(column="tradeNo", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerEmail", property="buyerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerId", property="buyerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TransactionRecordEntity> selectByExample(TransactionRecordEntityExample example);

    @Select({
        "select",
        "id, userId, transactionAmount, transactionTime, transactionDirection, transactionType, ",
        "transactionStatus, payChannel, transferFromType, transferFromId, transferToType, ",
        "transferToId, bizType, bizId, orderNo, explanation, tradeNo, buyerEmail, buyerId, ",
        "version, status, createBy, createTime, createName, updateBy, updateTime, lastUpdate",
        "from transaction_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="transactionAmount", property="transactionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="transactionTime", property="transactionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="transactionDirection", property="transactionDirection", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionType", property="transactionType", jdbcType=JdbcType.INTEGER),
        @Result(column="transactionStatus", property="transactionStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="payChannel", property="payChannel", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromType", property="transferFromType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferFromId", property="transferFromId", jdbcType=JdbcType.BIGINT),
        @Result(column="transferToType", property="transferToType", jdbcType=JdbcType.INTEGER),
        @Result(column="transferToId", property="transferToId", jdbcType=JdbcType.BIGINT),
        @Result(column="bizType", property="bizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="explanation", property="explanation", jdbcType=JdbcType.VARCHAR),
        @Result(column="tradeNo", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerEmail", property="buyerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="buyerId", property="buyerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    TransactionRecordEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=TransactionRecordEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TransactionRecordEntity record, @Param("example") TransactionRecordEntityExample example);

    @UpdateProvider(type=TransactionRecordEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TransactionRecordEntity record, @Param("example") TransactionRecordEntityExample example);

    @UpdateProvider(type=TransactionRecordEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TransactionRecordEntity record);

    @Update({
        "update transaction_record",
        "set userId = #{userId,jdbcType=BIGINT},",
          "transactionAmount = #{transactionAmount,jdbcType=DECIMAL},",
          "transactionTime = #{transactionTime,jdbcType=TIMESTAMP},",
          "transactionDirection = #{transactionDirection,jdbcType=INTEGER},",
          "transactionType = #{transactionType,jdbcType=INTEGER},",
          "transactionStatus = #{transactionStatus,jdbcType=INTEGER},",
          "payChannel = #{payChannel,jdbcType=INTEGER},",
          "transferFromType = #{transferFromType,jdbcType=INTEGER},",
          "transferFromId = #{transferFromId,jdbcType=BIGINT},",
          "transferToType = #{transferToType,jdbcType=INTEGER},",
          "transferToId = #{transferToId,jdbcType=BIGINT},",
          "bizType = #{bizType,jdbcType=INTEGER},",
          "bizId = #{bizId,jdbcType=VARCHAR},",
          "orderNo = #{orderNo,jdbcType=VARCHAR},",
          "explanation = #{explanation,jdbcType=VARCHAR},",
          "tradeNo = #{tradeNo,jdbcType=VARCHAR},",
          "buyerEmail = #{buyerEmail,jdbcType=VARCHAR},",
          "buyerId = #{buyerId,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TransactionRecordEntity record);
}