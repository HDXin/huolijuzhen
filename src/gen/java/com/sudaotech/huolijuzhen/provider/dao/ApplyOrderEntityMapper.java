package com.sudaotech.huolijuzhen.provider.dao;

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

public interface ApplyOrderEntityMapper {
    @SelectProvider(type=ApplyOrderEntitySqlProvider.class, method="countByExample")
    int countByExample(ApplyOrderEntityExample example);

    @DeleteProvider(type=ApplyOrderEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApplyOrderEntityExample example);

    @Delete({
        "delete from apply_order_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into apply_order_info (id, applyOrderNo, ",
        "applyOrderType, applyOrderStatus, ",
        "serviceProId, enterpriseId, ",
        "enterpriseName, applyOrderStatusMemo, ",
        "billHistoryId, orderMemo, ",
        "priceTitle, price, ",
        "commentId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "payWay, serviceProRelease, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{applyOrderNo,jdbcType=VARCHAR}, ",
        "#{applyOrderType,jdbcType=INTEGER}, #{applyOrderStatus,jdbcType=INTEGER}, ",
        "#{serviceProId,jdbcType=BIGINT}, #{enterpriseId,jdbcType=BIGINT}, ",
        "#{enterpriseName,jdbcType=VARCHAR}, #{applyOrderStatusMemo,jdbcType=VARCHAR}, ",
        "#{billHistoryId,jdbcType=BIGINT}, #{orderMemo,jdbcType=VARCHAR}, ",
        "#{priceTitle,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{commentId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{payWay,jdbcType=INTEGER}, #{serviceProRelease,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ApplyOrderEntity record);

    @InsertProvider(type=ApplyOrderEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApplyOrderEntity record);

    @SelectProvider(type=ApplyOrderEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="applyOrderNo", property="applyOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderType", property="applyOrderType", jdbcType=JdbcType.INTEGER),
        @Result(column="applyOrderStatus", property="applyOrderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderStatusMemo", property="applyOrderStatusMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billHistoryId", property="billHistoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="orderMemo", property="orderMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitle", property="priceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ApplyOrderEntity> selectByExampleWithBLOBsWithRowbounds(ApplyOrderEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApplyOrderEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="applyOrderNo", property="applyOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderType", property="applyOrderType", jdbcType=JdbcType.INTEGER),
        @Result(column="applyOrderStatus", property="applyOrderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderStatusMemo", property="applyOrderStatusMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billHistoryId", property="billHistoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="orderMemo", property="orderMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitle", property="priceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ApplyOrderEntity> selectByExampleWithBLOBs(ApplyOrderEntityExample example);

    @SelectProvider(type=ApplyOrderEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="applyOrderNo", property="applyOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderType", property="applyOrderType", jdbcType=JdbcType.INTEGER),
        @Result(column="applyOrderStatus", property="applyOrderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderStatusMemo", property="applyOrderStatusMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billHistoryId", property="billHistoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="orderMemo", property="orderMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitle", property="priceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ApplyOrderEntity> selectByExampleWithRowbounds(ApplyOrderEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApplyOrderEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="applyOrderNo", property="applyOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderType", property="applyOrderType", jdbcType=JdbcType.INTEGER),
        @Result(column="applyOrderStatus", property="applyOrderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderStatusMemo", property="applyOrderStatusMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billHistoryId", property="billHistoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="orderMemo", property="orderMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitle", property="priceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ApplyOrderEntity> selectByExample(ApplyOrderEntityExample example);

    @Select({
        "select",
        "id, applyOrderNo, applyOrderType, applyOrderStatus, serviceProId, enterpriseId, ",
        "enterpriseName, applyOrderStatusMemo, billHistoryId, orderMemo, priceTitle, ",
        "price, commentId, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate, payWay, serviceProRelease, content",
        "from apply_order_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="applyOrderNo", property="applyOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderType", property="applyOrderType", jdbcType=JdbcType.INTEGER),
        @Result(column="applyOrderStatus", property="applyOrderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderStatusMemo", property="applyOrderStatusMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="billHistoryId", property="billHistoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="orderMemo", property="orderMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitle", property="priceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    ApplyOrderEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApplyOrderEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApplyOrderEntity record, @Param("example") ApplyOrderEntityExample example);

    @UpdateProvider(type=ApplyOrderEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ApplyOrderEntity record, @Param("example") ApplyOrderEntityExample example);

    @UpdateProvider(type=ApplyOrderEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApplyOrderEntity record, @Param("example") ApplyOrderEntityExample example);

    @UpdateProvider(type=ApplyOrderEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApplyOrderEntity record);

    @Update({
        "update apply_order_info",
        "set applyOrderNo = #{applyOrderNo,jdbcType=VARCHAR},",
          "applyOrderType = #{applyOrderType,jdbcType=INTEGER},",
          "applyOrderStatus = #{applyOrderStatus,jdbcType=INTEGER},",
          "serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "applyOrderStatusMemo = #{applyOrderStatusMemo,jdbcType=VARCHAR},",
          "billHistoryId = #{billHistoryId,jdbcType=BIGINT},",
          "orderMemo = #{orderMemo,jdbcType=VARCHAR},",
          "priceTitle = #{priceTitle,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "commentId = #{commentId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "payWay = #{payWay,jdbcType=INTEGER},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ApplyOrderEntity record);

    @Update({
        "update apply_order_info",
        "set applyOrderNo = #{applyOrderNo,jdbcType=VARCHAR},",
          "applyOrderType = #{applyOrderType,jdbcType=INTEGER},",
          "applyOrderStatus = #{applyOrderStatus,jdbcType=INTEGER},",
          "serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "applyOrderStatusMemo = #{applyOrderStatusMemo,jdbcType=VARCHAR},",
          "billHistoryId = #{billHistoryId,jdbcType=BIGINT},",
          "orderMemo = #{orderMemo,jdbcType=VARCHAR},",
          "priceTitle = #{priceTitle,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "commentId = #{commentId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "payWay = #{payWay,jdbcType=INTEGER},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ApplyOrderEntity record);
}