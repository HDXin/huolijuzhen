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

public interface ServiceCommentEntityMapper {
    @SelectProvider(type=ServiceCommentEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceCommentEntityExample example);

    @DeleteProvider(type=ServiceCommentEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceCommentEntityExample example);

    @Delete({
        "delete from service_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_comment (id, serviceProId, ",
        "gradeNum, commentText, ",
        "price, applyOrderId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{serviceProId,jdbcType=BIGINT}, ",
        "#{gradeNum,jdbcType=INTEGER}, #{commentText,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{applyOrderId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ServiceCommentEntity record);

    @InsertProvider(type=ServiceCommentEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceCommentEntity record);

    @SelectProvider(type=ServiceCommentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="gradeNum", property="gradeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentText", property="commentText", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ServiceCommentEntity> selectByExampleWithRowbounds(ServiceCommentEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceCommentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="gradeNum", property="gradeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentText", property="commentText", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ServiceCommentEntity> selectByExample(ServiceCommentEntityExample example);

    @Select({
        "select",
        "id, serviceProId, gradeNum, commentText, price, applyOrderId, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from service_comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="gradeNum", property="gradeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentText", property="commentText", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="applyOrderId", property="applyOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ServiceCommentEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceCommentEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceCommentEntity record, @Param("example") ServiceCommentEntityExample example);

    @UpdateProvider(type=ServiceCommentEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceCommentEntity record, @Param("example") ServiceCommentEntityExample example);

    @UpdateProvider(type=ServiceCommentEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceCommentEntity record);

    @Update({
        "update service_comment",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "gradeNum = #{gradeNum,jdbcType=INTEGER},",
          "commentText = #{commentText,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "applyOrderId = #{applyOrderId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceCommentEntity record);
}