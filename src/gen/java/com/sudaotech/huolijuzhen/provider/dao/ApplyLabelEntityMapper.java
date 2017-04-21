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

public interface ApplyLabelEntityMapper {
    @SelectProvider(type=ApplyLabelEntitySqlProvider.class, method="countByExample")
    int countByExample(ApplyLabelEntityExample example);

    @DeleteProvider(type=ApplyLabelEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApplyLabelEntityExample example);

    @Delete({
        "delete from apply_label",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into apply_label (id, name, ",
        "labelHint, labelType, ",
        "labelNo, value, applyOrderId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, isRequire)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{labelHint,jdbcType=VARCHAR}, #{labelType,jdbcType=INTEGER}, ",
        "#{labelNo,jdbcType=BIGINT}, #{value,jdbcType=VARCHAR}, #{applyOrderId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{isRequire,jdbcType=INTEGER})"
    })
    int insert(ApplyLabelEntity record);

    @InsertProvider(type=ApplyLabelEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApplyLabelEntity record);

    @SelectProvider(type=ApplyLabelEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    List<ApplyLabelEntity> selectByExampleWithRowbounds(ApplyLabelEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApplyLabelEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    List<ApplyLabelEntity> selectByExample(ApplyLabelEntityExample example);

    @Select({
        "select",
        "id, name, labelHint, labelType, labelNo, value, applyOrderId, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate, isRequire",
        "from apply_label",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelHint", property="labelHint", jdbcType=JdbcType.VARCHAR),
        @Result(column="labelType", property="labelType", jdbcType=JdbcType.INTEGER),
        @Result(column="labelNo", property="labelNo", jdbcType=JdbcType.BIGINT),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isRequire", property="isRequire", jdbcType=JdbcType.INTEGER)
    })
    ApplyLabelEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApplyLabelEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApplyLabelEntity record, @Param("example") ApplyLabelEntityExample example);

    @UpdateProvider(type=ApplyLabelEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApplyLabelEntity record, @Param("example") ApplyLabelEntityExample example);

    @UpdateProvider(type=ApplyLabelEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApplyLabelEntity record);

    @Update({
        "update apply_label",
        "set name = #{name,jdbcType=VARCHAR},",
          "labelHint = #{labelHint,jdbcType=VARCHAR},",
          "labelType = #{labelType,jdbcType=INTEGER},",
          "labelNo = #{labelNo,jdbcType=BIGINT},",
          "value = #{value,jdbcType=VARCHAR},",
          "applyOrderId = #{applyOrderId,jdbcType=BIGINT},",
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
    int updateByPrimaryKey(ApplyLabelEntity record);
}