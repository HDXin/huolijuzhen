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

public interface TemplateLabelEntityMapper {
    @SelectProvider(type=TemplateLabelEntitySqlProvider.class, method="countByExample")
    int countByExample(TemplateLabelEntityExample example);

    @DeleteProvider(type=TemplateLabelEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TemplateLabelEntityExample example);

    @Delete({
        "delete from template_label",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into template_label (id, name, ",
        "labelHint, labelType, ",
        "labelNo, applyTemplateId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, isRequire)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{labelHint,jdbcType=VARCHAR}, #{labelType,jdbcType=INTEGER}, ",
        "#{labelNo,jdbcType=BIGINT}, #{applyTemplateId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{isRequire,jdbcType=INTEGER})"
    })
    int insert(TemplateLabelEntity record);

    @InsertProvider(type=TemplateLabelEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TemplateLabelEntity record);

    @SelectProvider(type=TemplateLabelEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTemplateId", property="applyTemplateId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    List<TemplateLabelEntity> selectByExampleWithRowbounds(TemplateLabelEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TemplateLabelEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTemplateId", property="applyTemplateId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    List<TemplateLabelEntity> selectByExample(TemplateLabelEntityExample example);

    @Select({
        "select",
        "id, name, labelHint, labelType, labelNo, applyTemplateId, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, isRequire",
        "from template_label",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTemplateId", property="applyTemplateId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    TemplateLabelEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=TemplateLabelEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TemplateLabelEntity record, @Param("example") TemplateLabelEntityExample example);

    @UpdateProvider(type=TemplateLabelEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TemplateLabelEntity record, @Param("example") TemplateLabelEntityExample example);

    @UpdateProvider(type=TemplateLabelEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TemplateLabelEntity record);

    @Update({
        "update template_label",
        "set name = #{name,jdbcType=VARCHAR},",
          "labelHint = #{labelHint,jdbcType=VARCHAR},",
          "labelType = #{labelType,jdbcType=INTEGER},",
          "labelNo = #{labelNo,jdbcType=BIGINT},",
          "applyTemplateId = #{applyTemplateId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "isRequire = #{isRequire,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TemplateLabelEntity record);
}