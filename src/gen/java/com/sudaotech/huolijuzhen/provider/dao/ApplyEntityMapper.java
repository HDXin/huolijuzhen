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

public interface ApplyEntityMapper {
    @SelectProvider(type=ApplyEntitySqlProvider.class, method="countByExample")
    int countByExample(ApplyEntityExample example);

    @DeleteProvider(type=ApplyEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApplyEntityExample example);

    @Delete({
        "delete from apply_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into apply_info (id, serviceProId, ",
        "serviceProTitle, enterpriseId, ",
        "enterpriseName, parkId, ",
        "parkName, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{serviceProId,jdbcType=BIGINT}, ",
        "#{serviceProTitle,jdbcType=VARCHAR}, #{enterpriseId,jdbcType=BIGINT}, ",
        "#{enterpriseName,jdbcType=VARCHAR}, #{parkId,jdbcType=BIGINT}, ",
        "#{parkName,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ApplyEntity record);

    @InsertProvider(type=ApplyEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApplyEntity record);

    @SelectProvider(type=ApplyEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProTitle", property="serviceProTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ApplyEntity> selectByExampleWithBLOBsWithRowbounds(ApplyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApplyEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProTitle", property="serviceProTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ApplyEntity> selectByExampleWithBLOBs(ApplyEntityExample example);

    @SelectProvider(type=ApplyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProTitle", property="serviceProTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApplyEntity> selectByExampleWithRowbounds(ApplyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApplyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProTitle", property="serviceProTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApplyEntity> selectByExample(ApplyEntityExample example);

    @Select({
        "select",
        "id, serviceProId, serviceProTitle, enterpriseId, enterpriseName, parkId, parkName, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, content",
        "from apply_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProTitle", property="serviceProTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkName", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    ApplyEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApplyEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApplyEntity record, @Param("example") ApplyEntityExample example);

    @UpdateProvider(type=ApplyEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ApplyEntity record, @Param("example") ApplyEntityExample example);

    @UpdateProvider(type=ApplyEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApplyEntity record, @Param("example") ApplyEntityExample example);

    @UpdateProvider(type=ApplyEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApplyEntity record);

    @Update({
        "update apply_info",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "serviceProTitle = #{serviceProTitle,jdbcType=VARCHAR},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "parkName = #{parkName,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ApplyEntity record);

    @Update({
        "update apply_info",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "serviceProTitle = #{serviceProTitle,jdbcType=VARCHAR},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "parkName = #{parkName,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ApplyEntity record);
}