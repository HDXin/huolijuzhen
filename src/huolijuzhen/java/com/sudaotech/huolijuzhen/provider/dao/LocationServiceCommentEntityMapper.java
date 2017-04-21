package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface LocationServiceCommentEntityMapper extends ServiceCommentEntityMapper{
    
	
	@Select("select gradeNum from service_comment where 1=1 "
			+ " and serviceProId = #{serviceProId}"
			+ " and status = #{status}")
	@Results({
		@Result(column="gradeNum",property="gradeNum")
	})
	public List<Integer> findGradeNum(Map<String, Object> params);
	
}