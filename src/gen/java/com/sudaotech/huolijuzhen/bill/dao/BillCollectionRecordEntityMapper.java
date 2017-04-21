package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample;
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

public interface BillCollectionRecordEntityMapper {
    @SelectProvider(type=BillCollectionRecordEntitySqlProvider.class, method="countByExample")
    int countByExample(BillCollectionRecordEntityExample example);

    @DeleteProvider(type=BillCollectionRecordEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillCollectionRecordEntityExample example);

    @Delete({
        "delete from bill_collection_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_collection_record (id, billId, ",
        "collectionTime, collectionBank, ",
        "collectionAccount, collectionAmount, ",
        "payChannels, paySerialNum, ",
        "remark, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{billId,jdbcType=BIGINT}, ",
        "#{collectionTime,jdbcType=TIMESTAMP}, #{collectionBank,jdbcType=VARCHAR}, ",
        "#{collectionAccount,jdbcType=VARCHAR}, #{collectionAmount,jdbcType=DECIMAL}, ",
        "#{payChannels,jdbcType=VARCHAR}, #{paySerialNum,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(BillCollectionRecordEntity record);

    @InsertProvider(type=BillCollectionRecordEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillCollectionRecordEntity record);

    @SelectProvider(type=BillCollectionRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectionTime", property="collectionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collectionBank", property="collectionBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAccount", property="collectionAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAmount", property="collectionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="payChannels", property="payChannels", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNum", property="paySerialNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillCollectionRecordEntity> selectByExampleWithRowbounds(BillCollectionRecordEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillCollectionRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectionTime", property="collectionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collectionBank", property="collectionBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAccount", property="collectionAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAmount", property="collectionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="payChannels", property="payChannels", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNum", property="paySerialNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillCollectionRecordEntity> selectByExample(BillCollectionRecordEntityExample example);

    @Select({
        "select",
        "id, billId, collectionTime, collectionBank, collectionAccount, collectionAmount, ",
        "payChannels, paySerialNum, remark, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate",
        "from bill_collection_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectionTime", property="collectionTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="collectionBank", property="collectionBank", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAccount", property="collectionAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="collectionAmount", property="collectionAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="payChannels", property="payChannels", jdbcType=JdbcType.VARCHAR),
        @Result(column="paySerialNum", property="paySerialNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    BillCollectionRecordEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillCollectionRecordEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillCollectionRecordEntity record, @Param("example") BillCollectionRecordEntityExample example);

    @UpdateProvider(type=BillCollectionRecordEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillCollectionRecordEntity record, @Param("example") BillCollectionRecordEntityExample example);

    @UpdateProvider(type=BillCollectionRecordEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillCollectionRecordEntity record);

    @Update({
        "update bill_collection_record",
        "set billId = #{billId,jdbcType=BIGINT},",
          "collectionTime = #{collectionTime,jdbcType=TIMESTAMP},",
          "collectionBank = #{collectionBank,jdbcType=VARCHAR},",
          "collectionAccount = #{collectionAccount,jdbcType=VARCHAR},",
          "collectionAmount = #{collectionAmount,jdbcType=DECIMAL},",
          "payChannels = #{payChannels,jdbcType=VARCHAR},",
          "paySerialNum = #{paySerialNum,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillCollectionRecordEntity record);
}