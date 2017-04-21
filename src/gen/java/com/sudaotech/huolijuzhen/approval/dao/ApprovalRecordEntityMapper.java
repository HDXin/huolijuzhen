package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample;
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

public interface ApprovalRecordEntityMapper {
    @SelectProvider(type=ApprovalRecordEntitySqlProvider.class, method="countByExample")
    int countByExample(ApprovalRecordEntityExample example);

    @DeleteProvider(type=ApprovalRecordEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApprovalRecordEntityExample example);

    @Delete({
        "delete from approval_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into approval_record (id, approvalType, ",
        "mainId, approvalItemId, ",
        "approvalItemName, approvalItemNo, ",
        "approvalItemVersion, approvalId, ",
        "approvalName, passStatus, ",
        "approvalMemo, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{approvalType,jdbcType=INTEGER}, ",
        "#{mainId,jdbcType=BIGINT}, #{approvalItemId,jdbcType=BIGINT}, ",
        "#{approvalItemName,jdbcType=VARCHAR}, #{approvalItemNo,jdbcType=INTEGER}, ",
        "#{approvalItemVersion,jdbcType=INTEGER}, #{approvalId,jdbcType=BIGINT}, ",
        "#{approvalName,jdbcType=VARCHAR}, #{passStatus,jdbcType=BIT}, ",
        "#{approvalMemo,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ApprovalRecordEntity record);

    @InsertProvider(type=ApprovalRecordEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApprovalRecordEntity record);

    @SelectProvider(type=ApprovalRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemName", property="approvalItemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalName", property="approvalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="passStatus", property="passStatus", jdbcType=JdbcType.BIT),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalRecordEntity> selectByExampleWithRowbounds(ApprovalRecordEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApprovalRecordEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemName", property="approvalItemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalName", property="approvalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="passStatus", property="passStatus", jdbcType=JdbcType.BIT),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalRecordEntity> selectByExample(ApprovalRecordEntityExample example);

    @Select({
        "select",
        "id, approvalType, mainId, approvalItemId, approvalItemName, approvalItemNo, ",
        "approvalItemVersion, approvalId, approvalName, passStatus, approvalMemo, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from approval_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalType", property="approvalType", jdbcType=JdbcType.INTEGER),
        @Result(column="mainId", property="mainId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemId", property="approvalItemId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalItemName", property="approvalItemName", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalItemNo", property="approvalItemNo", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalItemVersion", property="approvalItemVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalName", property="approvalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="passStatus", property="passStatus", jdbcType=JdbcType.BIT),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ApprovalRecordEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApprovalRecordEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApprovalRecordEntity record, @Param("example") ApprovalRecordEntityExample example);

    @UpdateProvider(type=ApprovalRecordEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApprovalRecordEntity record, @Param("example") ApprovalRecordEntityExample example);

    @UpdateProvider(type=ApprovalRecordEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApprovalRecordEntity record);

    @Update({
        "update approval_record",
        "set approvalType = #{approvalType,jdbcType=INTEGER},",
          "mainId = #{mainId,jdbcType=BIGINT},",
          "approvalItemId = #{approvalItemId,jdbcType=BIGINT},",
          "approvalItemName = #{approvalItemName,jdbcType=VARCHAR},",
          "approvalItemNo = #{approvalItemNo,jdbcType=INTEGER},",
          "approvalItemVersion = #{approvalItemVersion,jdbcType=INTEGER},",
          "approvalId = #{approvalId,jdbcType=BIGINT},",
          "approvalName = #{approvalName,jdbcType=VARCHAR},",
          "passStatus = #{passStatus,jdbcType=BIT},",
          "approvalMemo = #{approvalMemo,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ApprovalRecordEntity record);
}