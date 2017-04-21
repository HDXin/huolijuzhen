package com.sudaotech.sms.dao;

import com.sudaotech.sms.dao.SmsHistoryEntity;
import com.sudaotech.sms.dao.SmsHistoryEntityExample;
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

public interface SmsHistoryEntityMapper {
    @SelectProvider(type=SmsHistoryEntitySqlProvider.class, method="countByExample")
    int countByExample(SmsHistoryEntityExample example);

    @DeleteProvider(type=SmsHistoryEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(SmsHistoryEntityExample example);

    @Delete({
        "delete from sms_history",
        "where smsId = #{smsId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long smsId);

    @Insert({
        "insert into sms_history (smsId, phoneNum, ",
        "content, smsStatus, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{smsId,jdbcType=BIGINT}, #{phoneNum,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{smsStatus,jdbcType=INTEGER}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(SmsHistoryEntity record);

    @InsertProvider(type=SmsHistoryEntitySqlProvider.class, method="insertSelective")
    int insertSelective(SmsHistoryEntity record);

    @SelectProvider(type=SmsHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="smsId", property="smsId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phoneNum", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="smsStatus", property="smsStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SmsHistoryEntity> selectByExampleWithRowbounds(SmsHistoryEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=SmsHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="smsId", property="smsId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phoneNum", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="smsStatus", property="smsStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SmsHistoryEntity> selectByExample(SmsHistoryEntityExample example);

    @Select({
        "select",
        "smsId, phoneNum, content, smsStatus, displayOrder, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from sms_history",
        "where smsId = #{smsId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="smsId", property="smsId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="phoneNum", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="smsStatus", property="smsStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    SmsHistoryEntity selectByPrimaryKey(Long smsId);

    @UpdateProvider(type=SmsHistoryEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SmsHistoryEntity record, @Param("example") SmsHistoryEntityExample example);

    @UpdateProvider(type=SmsHistoryEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SmsHistoryEntity record, @Param("example") SmsHistoryEntityExample example);

    @UpdateProvider(type=SmsHistoryEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SmsHistoryEntity record);

    @Update({
        "update sms_history",
        "set phoneNum = #{phoneNum,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "smsStatus = #{smsStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where smsId = #{smsId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SmsHistoryEntity record);
}