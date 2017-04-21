package com.sudaotech.huolijuzhen.sys.common.dao;

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

public interface OperatorHistoryEntityMapper {
    @SelectProvider(type=OperatorHistoryEntitySqlProvider.class, method="countByExample")
    int countByExample(OperatorHistoryEntityExample example);

    @DeleteProvider(type=OperatorHistoryEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(OperatorHistoryEntityExample example);

    @Delete({
        "delete from operator_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into operator_history (id, businessType, ",
        "operatorType, operatorContent, ",
        "version, status, ",
        "createBy, createTime, ",
        "createName, updateBy, ",
        "updateTime, lastUpdate, ",
        "memo)",
        "values (#{id,jdbcType=BIGINT}, #{businessType,jdbcType=INTEGER}, ",
        "#{operatorType,jdbcType=INTEGER}, #{operatorContent,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createName,jdbcType=VARCHAR}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{memo,jdbcType=LONGVARCHAR})"
    })
    int insert(OperatorHistoryEntity record);

    @InsertProvider(type=OperatorHistoryEntitySqlProvider.class, method="insertSelective")
    int insertSelective(OperatorHistoryEntity record);

    @SelectProvider(type=OperatorHistoryEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessType", property="businessType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorType", property="operatorType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorContent", property="operatorContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="memo", property="memo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OperatorHistoryEntity> selectByExampleWithBLOBsWithRowbounds(OperatorHistoryEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=OperatorHistoryEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessType", property="businessType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorType", property="operatorType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorContent", property="operatorContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="memo", property="memo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OperatorHistoryEntity> selectByExampleWithBLOBs(OperatorHistoryEntityExample example);

    @SelectProvider(type=OperatorHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessType", property="businessType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorType", property="operatorType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorContent", property="operatorContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OperatorHistoryEntity> selectByExampleWithRowbounds(OperatorHistoryEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=OperatorHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessType", property="businessType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorType", property="operatorType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorContent", property="operatorContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OperatorHistoryEntity> selectByExample(OperatorHistoryEntityExample example);

    @Select({
        "select",
        "id, businessType, operatorType, operatorContent, version, status, createBy, ",
        "createTime, createName, updateBy, updateTime, lastUpdate, memo",
        "from operator_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="businessType", property="businessType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorType", property="operatorType", jdbcType=JdbcType.INTEGER),
        @Result(column="operatorContent", property="operatorContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="memo", property="memo", jdbcType=JdbcType.LONGVARCHAR)
    })
    OperatorHistoryEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=OperatorHistoryEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OperatorHistoryEntity record, @Param("example") OperatorHistoryEntityExample example);

    @UpdateProvider(type=OperatorHistoryEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OperatorHistoryEntity record, @Param("example") OperatorHistoryEntityExample example);

    @UpdateProvider(type=OperatorHistoryEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OperatorHistoryEntity record, @Param("example") OperatorHistoryEntityExample example);

    @UpdateProvider(type=OperatorHistoryEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OperatorHistoryEntity record);

    @Update({
        "update operator_history",
        "set businessType = #{businessType,jdbcType=INTEGER},",
          "operatorType = #{operatorType,jdbcType=INTEGER},",
          "operatorContent = #{operatorContent,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "memo = #{memo,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OperatorHistoryEntity record);

    @Update({
        "update operator_history",
        "set businessType = #{businessType,jdbcType=INTEGER},",
          "operatorType = #{operatorType,jdbcType=INTEGER},",
          "operatorContent = #{operatorContent,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OperatorHistoryEntity record);
}