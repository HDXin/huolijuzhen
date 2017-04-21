package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;

public interface LocationApplyOrderEntityMapper extends ApplyOrderEntityMapper{
	
	@Select("select count(id) from apply_order_info where 1=1 "
			+ " and status = #{status}"
			+ " and serviceProId = ${serviceProId}"
			+ " and applyOrderType = ${applyOrderType}")
	public Integer findApplyOrOrderCount(Map<String, Object> params);
	
	@SelectProvider(type=LocationApplyOrderEntitySqlProvider.class,method="findApplyOrderCount")
	public Integer findApplyOrderCount(Map<String, Object> params);
	
	
	@Update("update apply_order_info "
			+ " set payWay = #{payWay},"
			+ " applyOrderStatus = #{applyOrderStatus}"
			+ " where applyOrderNo = #{applyOrderNo}")
	public int updateStatusByPay(Map<String, Object> params);
	
	@Select({
        "select",
        "id, applyOrderNo, applyOrderType, applyOrderStatus, serviceProId, enterpriseId, ",
        "enterpriseName, applyOrderStatusMemo, billHistoryId, orderMemo, priceTitle, ",
        "price, commentId, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate, payWay, content",
        " from apply_order_info",
        " where applyOrderNo = #{applyOrderNo}",
        " and status = #{status}"
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
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
	public List<ApplyOrder> findByApplyOrderNo(Map<String, Object> params);
	
}