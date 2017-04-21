package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.TemplateLabel;

public interface LocationTemplateLabelEntityMapper extends TemplateLabelEntityMapper {
   
	@Select("select id id,"
			+ "name name,"
			+ "labelHint labelHint,"
			+ "labelType labelType,"
			+ "labelNo labelNo,"
			+ "applyTemplateId applyTemplateId,"
			+ "isRequire isRequire"
			+ " from template_label"
			+ " where status = #{status}"
			+ " and applyTemplateId = #{applyTemplateId}"
			+ " order by labelNo")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="labelHint",property="labelHint"),
		@Result(column="labelType",property="labelType"),
		@Result(column="labelNo",property="labelNo"),
		@Result(column="isRequire",property="isRequire"),
		@Result(column="applyTemplateId",property="applyTemplateId")
	})
	public List<Map<String, Object>> findByApplyTemplateId(Map<String, Object> params);

	@Select({"select",
	        "id, name, labelHint, labelType, labelNo, isRequire, applyTemplateId, version, status, createBy, ",
	        "createTime, updateBy, updateTime, lastUpdate",
	        " from template_label",
	        " where 1=1 ",
	        " and status = #{status}",
	        " and labelNo < #{labelNo}",
	        " and applyTemplateId = #{applyTemplateId}",
	        " order by labelNo DESC"
	})
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTemplateId", property="applyTemplateId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
	public List<TemplateLabel> findUpItem(Map<String, Object> params);

	@Select({"select",
        "id, name, labelHint, labelType, labelNo, isRequire, applyTemplateId, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        " from template_label",
        " where 1=1 ",
        " and status = #{status}",
        " and labelNo > #{labelNo}",
        " and applyTemplateId = #{applyTemplateId}",
        " order by labelNo"
})
@Results({
    @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
    @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
    @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
    @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
    @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
    @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER),
    @Result(column="applyTemplateId", property="applyTemplateId", jdbcType=JdbcType.BIGINT),
    @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
    @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
    @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
    @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
    @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
    @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
})
	public List<TemplateLabel> findDownItem(Map<String, Object> params);
	
}