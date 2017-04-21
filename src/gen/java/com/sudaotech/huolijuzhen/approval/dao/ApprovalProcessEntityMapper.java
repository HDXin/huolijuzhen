package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityExample;
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

public interface ApprovalProcessEntityMapper {
    @SelectProvider(type=ApprovalProcessEntitySqlProvider.class, method="countByExample")
    int countByExample(ApprovalProcessEntityExample example);

    @DeleteProvider(type=ApprovalProcessEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApprovalProcessEntityExample example);

    @Delete({
        "delete from approval_process",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into approval_process (id, approvalTypeId, ",
        "approvalTypeVersion, approvalType, ",
        "mainId, approvalItemId, ",
        "approvalItemNo, approvalItemVersion, ",
        "approvalId, approvalProcessStatus, ",
        "isHistory, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{approvalTypeId,jdbcType=BIGINT}, ",
        "#{approvalTypeVersion,jdbcType=INTEGER}, #{approvalType,jdbcType=INTEGER}, ",
        "#{mainId,jdbcType=BIGINT}, #{approvalItemId,jdbcType=BIGINT}, ",
        "#{approvalItemNo,jdbcType=INTEGER}, #{approvalItemVersion,jdbcType=INTEGER}, ",
        "#{approvalId,jdbcType=BIGINT}, #{approvalProcessStatus,jdbcType=INTEGER}, ",
        "#{isHistory,jdbcType=BIT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ApprovalProcessEntity record);

    @InsertProvider(type=ApprovalProcessEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApprovalProcessEntity record);

    @SelectProvider(type=ApprovalProcessEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTypeVersion", property="approvalTypeVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessStatus", property="approvalProcessStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalProcessEntity> selectByExampleWithRowbounds(ApprovalProcessEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApprovalProcessEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTypeVersion", property="approvalTypeVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessStatus", property="approvalProcessStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalProcessEntity> selectByExample(ApprovalProcessEntityExample example);

    @Select({
        "select",
        "id, approvalTypeId, approvalTypeVersion, approvalType, mainId, approvalItemId, ",
        "approvalItemNo, approvalItemVersion, approvalId, approvalProcessStatus, isHistory, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from approval_process",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTypeVersion", property="approvalTypeVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalProcessStatus", property="approvalProcessStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ApprovalProcessEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApprovalProcessEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApprovalProcessEntity record, @Param("example") ApprovalProcessEntityExample example);

    @UpdateProvider(type=ApprovalProcessEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApprovalProcessEntity record, @Param("example") ApprovalProcessEntityExample example);

    @UpdateProvider(type=ApprovalProcessEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApprovalProcessEntity record);

    @Update({
        "update approval_process",
        "set approvalTypeId = #{approvalTypeId,jdbcType=BIGINT},",
          "approvalTypeVersion = #{approvalTypeVersion,jdbcType=INTEGER},",
          "approvalType = #{approvalType,jdbcType=INTEGER},",
          "mainId = #{mainId,jdbcType=BIGINT},",
          "approvalItemId = #{approvalItemId,jdbcType=BIGINT},",
          "approvalItemNo = #{approvalItemNo,jdbcType=INTEGER},",
          "approvalItemVersion = #{approvalItemVersion,jdbcType=INTEGER},",
          "approvalId = #{approvalId,jdbcType=BIGINT},",
          "approvalProcessStatus = #{approvalProcessStatus,jdbcType=INTEGER},",
          "isHistory = #{isHistory,jdbcType=BIT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ApprovalProcessEntity record);
}