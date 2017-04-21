package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample;
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

public interface EnterpriseCorrBusinessEntityMapper {
    @SelectProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseCorrBusinessEntityExample example);

    @DeleteProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseCorrBusinessEntityExample example);

    @Delete({
        "delete from enterprise_corr_business",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_corr_business (id, enterpriseCottId, ",
        "cottTime, cottUser, ",
        "cottStatus, number, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{enterpriseCottId,jdbcType=BIGINT}, ",
        "#{cottTime,jdbcType=TIMESTAMP}, #{cottUser,jdbcType=BIGINT}, ",
        "#{cottStatus,jdbcType=INTEGER}, #{number,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterpriseCorrBusinessEntity record);

    @InsertProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseCorrBusinessEntity record);

    @SelectProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottTime", property="cottTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cottUser", property="cottUser", jdbcType=JdbcType.BIGINT),
        @Result(column="cottStatus", property="cottStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCorrBusinessEntity> selectByExampleWithRowbounds(EnterpriseCorrBusinessEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottTime", property="cottTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cottUser", property="cottUser", jdbcType=JdbcType.BIGINT),
        @Result(column="cottStatus", property="cottStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCorrBusinessEntity> selectByExample(EnterpriseCorrBusinessEntityExample example);

    @Select({
        "select",
        "id, enterpriseCottId, cottTime, cottUser, cottStatus, number, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from enterprise_corr_business",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterpriseCottId", property="enterpriseCottId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottTime", property="cottTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cottUser", property="cottUser", jdbcType=JdbcType.BIGINT),
        @Result(column="cottStatus", property="cottStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterpriseCorrBusinessEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseCorrBusinessEntity record, @Param("example") EnterpriseCorrBusinessEntityExample example);

    @UpdateProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseCorrBusinessEntity record, @Param("example") EnterpriseCorrBusinessEntityExample example);

    @UpdateProvider(type=EnterpriseCorrBusinessEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseCorrBusinessEntity record);

    @Update({
        "update enterprise_corr_business",
        "set enterpriseCottId = #{enterpriseCottId,jdbcType=BIGINT},",
          "cottTime = #{cottTime,jdbcType=TIMESTAMP},",
          "cottUser = #{cottUser,jdbcType=BIGINT},",
          "cottStatus = #{cottStatus,jdbcType=INTEGER},",
          "number = #{number,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseCorrBusinessEntity record);
}