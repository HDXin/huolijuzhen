package com.sudaotech.huolijuzhen.community.dao;

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

public interface CommunityApplyEntityMapper {
    @SelectProvider(type=CommunityApplyEntitySqlProvider.class, method="countByExample")
    int countByExample(CommunityApplyEntityExample example);

    @DeleteProvider(type=CommunityApplyEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityApplyEntityExample example);

    @Delete({
        "delete from community_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_apply (id, orderNo, ",
        "companyId, companyName, ",
        "parkId, applyTime, ",
        "proprser, phone, ",
        "num, describle, ",
        "communityId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "approvalStatus, approvalBy, ",
        "approvalTime, approvalText, ",
        "createSide, createSideId, ",
        "communityName)",
        "values (#{id,jdbcType=BIGINT}, #{orderNo,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=BIGINT}, #{companyName,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=BIGINT}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{proprser,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{num,jdbcType=INTEGER}, #{describle,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{approvalStatus,jdbcType=INTEGER}, #{approvalBy,jdbcType=BIGINT}, ",
        "#{approvalTime,jdbcType=TIMESTAMP}, #{approvalText,jdbcType=VARCHAR}, ",
        "#{createSide,jdbcType=INTEGER}, #{createSideId,jdbcType=BIGINT}, ",
        "#{communityName,jdbcType=VARCHAR})"
    })
    int insert(CommunityApplyEntity record);

    @InsertProvider(type=CommunityApplyEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CommunityApplyEntity record);

    @SelectProvider(type=CommunityApplyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTime", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="proprser", property="proprser", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="communityId", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="communityName", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityApplyEntity> selectByExampleWithRowbounds(CommunityApplyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CommunityApplyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTime", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="proprser", property="proprser", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="communityId", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="communityName", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityApplyEntity> selectByExample(CommunityApplyEntityExample example);

    @Select({
        "select",
        "id, orderNo, companyId, companyName, parkId, applyTime, proprser, phone, num, ",
        "describle, communityId, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate, approvalStatus, approvalBy, approvalTime, approvalText, createSide, ",
        "createSideId, communityName",
        "from community_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="orderNo", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT),
        @Result(column="companyName", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyTime", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="proprser", property="proprser", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="communityId", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="communityName", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
    CommunityApplyEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityApplyEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityApplyEntity record, @Param("example") CommunityApplyEntityExample example);

    @UpdateProvider(type=CommunityApplyEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityApplyEntity record, @Param("example") CommunityApplyEntityExample example);

    @UpdateProvider(type=CommunityApplyEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityApplyEntity record);

    @Update({
        "update community_apply",
        "set orderNo = #{orderNo,jdbcType=VARCHAR},",
          "companyId = #{companyId,jdbcType=BIGINT},",
          "companyName = #{companyName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "applyTime = #{applyTime,jdbcType=TIMESTAMP},",
          "proprser = #{proprser,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "describle = #{describle,jdbcType=VARCHAR},",
          "communityId = #{communityId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "communityName = #{communityName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityApplyEntity record);
}