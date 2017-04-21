package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntityExample;
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

public interface ApprovalTypeItemEntityMapper {
    @SelectProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="countByExample")
    int countByExample(ApprovalTypeItemEntityExample example);

    @DeleteProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ApprovalTypeItemEntityExample example);

    @Delete({
        "delete from approval_type_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into approval_type_item (id, approvalTypeId, ",
        "currentVersion, name, ",
        "approvalId, approvalNo, ",
        "isHistory, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{approvalTypeId,jdbcType=BIGINT}, ",
        "#{currentVersion,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{approvalId,jdbcType=BIGINT}, #{approvalNo,jdbcType=INTEGER}, ",
        "#{isHistory,jdbcType=BIT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ApprovalTypeItemEntity record);

    @InsertProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ApprovalTypeItemEntity record);

    @SelectProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="currentVersion", property="currentVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalNo", property="approvalNo", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalTypeItemEntity> selectByExampleWithRowbounds(ApprovalTypeItemEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="currentVersion", property="currentVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalNo", property="approvalNo", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ApprovalTypeItemEntity> selectByExample(ApprovalTypeItemEntityExample example);

    @Select({
        "select",
        "id, approvalTypeId, currentVersion, name, approvalId, approvalNo, isHistory, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from approval_type_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="approvalTypeId", property="approvalTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="currentVersion", property="currentVersion", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="approvalId", property="approvalId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalNo", property="approvalNo", jdbcType=JdbcType.INTEGER),
        @Result(column="isHistory", property="isHistory", jdbcType=JdbcType.BIT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ApprovalTypeItemEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ApprovalTypeItemEntity record, @Param("example") ApprovalTypeItemEntityExample example);

    @UpdateProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ApprovalTypeItemEntity record, @Param("example") ApprovalTypeItemEntityExample example);

    @UpdateProvider(type=ApprovalTypeItemEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApprovalTypeItemEntity record);

    @Update({
        "update approval_type_item",
        "set approvalTypeId = #{approvalTypeId,jdbcType=BIGINT},",
          "currentVersion = #{currentVersion,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "approvalId = #{approvalId,jdbcType=BIGINT},",
          "approvalNo = #{approvalNo,jdbcType=INTEGER},",
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
    int updateByPrimaryKey(ApprovalTypeItemEntity record);
}