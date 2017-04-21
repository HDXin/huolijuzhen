package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntityExample;
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

public interface ApprovalTypeEntityMapper {
    @SelectProvider(type=ApprovalTypeEntitySqlProvider.class, method="countByExample")
    int countByExample(ApprovalTypeEntityExample example);

    @DeleteProvider(type=ApprovalTypeEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApprovalTypeEntityExample example);

    @Delete({
        "delete from approval_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into approval_type (id, parkId, ",
        "approvalType, latestVersion, ",
        "enableStatus, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{parkId,jdbcType=BIGINT}, ",
        "#{approvalType,jdbcType=INTEGER}, #{latestVersion,jdbcType=INTEGER}, ",
        "#{enableStatus,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ApprovalTypeEntity record);

    @InsertProvider(type=ApprovalTypeEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApprovalTypeEntity record);

    @SelectProvider(type=ApprovalTypeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="latestVersion", property="latestVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalTypeEntity> selectByExampleWithRowbounds(ApprovalTypeEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApprovalTypeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="latestVersion", property="latestVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalTypeEntity> selectByExample(ApprovalTypeEntityExample example);

    @Select({
        "select",
        "id, parkId, approvalType, latestVersion, enableStatus, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from approval_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="latestVersion", property="latestVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ApprovalTypeEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApprovalTypeEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApprovalTypeEntity record, @Param("example") ApprovalTypeEntityExample example);

    @UpdateProvider(type=ApprovalTypeEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApprovalTypeEntity record, @Param("example") ApprovalTypeEntityExample example);

    @UpdateProvider(type=ApprovalTypeEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApprovalTypeEntity record);

    @Update({
        "update approval_type",
        "set parkId = #{parkId,jdbcType=BIGINT},",
          "approvalType = #{approvalType,jdbcType=INTEGER},",
          "latestVersion = #{latestVersion,jdbcType=INTEGER},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ApprovalTypeEntity record);
}