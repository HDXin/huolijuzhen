package com.sudaotech.huolijuzhen.sys.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

public interface LocationOperatorHistoryEntityMapper extends OperatorHistoryEntityMapper{
	
    
	
	@Insert({
        "insert into operator_history (id, businessType, ",
        "operatorType, operatorContent, ",
        "version, status, ",
        "createBy, createTime, ",
        "createName, updateBy, ",
        "updateTime, lastUpdate, ",
        "memo)",
        "values (#{id,jdbcType=BIGINT}, #{businessType,jdbcType=INTEGER}, ",
        "#{operatorType,jdbcType=INTEGER}, #{operatorContent,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createName,jdbcType=VARCHAR}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{memo,jdbcType=LONGVARCHAR})"
    })
    public int batchInsert(List<OperatorHistoryEntity> list);
	
}