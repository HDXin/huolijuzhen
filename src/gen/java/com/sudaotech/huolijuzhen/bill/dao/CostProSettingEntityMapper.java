package com.sudaotech.huolijuzhen.bill.dao;

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

public interface CostProSettingEntityMapper {
    @SelectProvider(type=CostProSettingEntitySqlProvider.class, method="countByExample")
    int countByExample(CostProSettingEntityExample example);

    @DeleteProvider(type=CostProSettingEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CostProSettingEntityExample example);

    @Delete({
        "delete from cost_pro_setting",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cost_pro_setting (id, contractId, ",
        "contractNo, costProType, ",
        "billMonth, enterpriseId, ",
        "enterpriseName, parkId, ",
        "dosage, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "enableStatus)",
        "values (#{id,jdbcType=BIGINT}, #{contractId,jdbcType=BIGINT}, ",
        "#{contractNo,jdbcType=VARCHAR}, #{costProType,jdbcType=BIGINT}, ",
        "#{billMonth,jdbcType=VARCHAR}, #{enterpriseId,jdbcType=BIGINT}, ",
        "#{enterpriseName,jdbcType=VARCHAR}, #{parkId,jdbcType=BIGINT}, ",
        "#{dosage,jdbcType=DECIMAL}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{enableStatus,jdbcType=INTEGER})"
    })
    int insert(CostProSettingEntity record);

    @InsertProvider(type=CostProSettingEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CostProSettingEntity record);

    @SelectProvider(type=CostProSettingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="costProType", property="costProType", jdbcType=JdbcType.BIGINT),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CostProSettingEntity> selectByExampleWithRowbounds(CostProSettingEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CostProSettingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="costProType", property="costProType", jdbcType=JdbcType.BIGINT),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER)
    })
    List<CostProSettingEntity> selectByExample(CostProSettingEntityExample example);

    @Select({
        "select",
        "id, contractId, contractNo, costProType, billMonth, enterpriseId, enterpriseName, ",
        "parkId, dosage, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate, enableStatus",
        "from cost_pro_setting",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="contractNo", property="contractNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="costProType", property="costProType", jdbcType=JdbcType.BIGINT),
        @Result(column="billMonth", property="billMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseName", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="dosage", property="dosage", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER)
    })
    CostProSettingEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=CostProSettingEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CostProSettingEntity record, @Param("example") CostProSettingEntityExample example);

    @UpdateProvider(type=CostProSettingEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CostProSettingEntity record, @Param("example") CostProSettingEntityExample example);

    @UpdateProvider(type=CostProSettingEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CostProSettingEntity record);

    @Update({
        "update cost_pro_setting",
        "set contractId = #{contractId,jdbcType=BIGINT},",
          "contractNo = #{contractNo,jdbcType=VARCHAR},",
          "costProType = #{costProType,jdbcType=BIGINT},",
          "billMonth = #{billMonth,jdbcType=VARCHAR},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "enterpriseName = #{enterpriseName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "dosage = #{dosage,jdbcType=DECIMAL},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CostProSettingEntity record);
}