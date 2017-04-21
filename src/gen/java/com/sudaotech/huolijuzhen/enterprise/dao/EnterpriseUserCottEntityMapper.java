package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntityExample;
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

public interface EnterpriseUserCottEntityMapper {
    @SelectProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseUserCottEntityExample example);

    @DeleteProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseUserCottEntityExample example);

    @Delete({
        "delete from enterprise_user_cott",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_user_cott (id, parkId, ",
        "enterpriseUserId, cottId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{parkId,jdbcType=BIGINT}, ",
        "#{enterpriseUserId,jdbcType=BIGINT}, #{cottId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterpriseUserCottEntity record);

    @InsertProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseUserCottEntity record);

    @SelectProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseUserId", property="enterpriseUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottId", property="cottId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseUserCottEntity> selectByExampleWithRowbounds(EnterpriseUserCottEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseUserId", property="enterpriseUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottId", property="cottId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseUserCottEntity> selectByExample(EnterpriseUserCottEntityExample example);

    @Select({
        "select",
        "id, parkId, enterpriseUserId, cottId, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from enterprise_user_cott",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseUserId", property="enterpriseUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="cottId", property="cottId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterpriseUserCottEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseUserCottEntity record, @Param("example") EnterpriseUserCottEntityExample example);

    @UpdateProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseUserCottEntity record, @Param("example") EnterpriseUserCottEntityExample example);

    @UpdateProvider(type=EnterpriseUserCottEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseUserCottEntity record);

    @Update({
        "update enterprise_user_cott",
        "set parkId = #{parkId,jdbcType=BIGINT},",
          "enterpriseUserId = #{enterpriseUserId,jdbcType=BIGINT},",
          "cottId = #{cottId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseUserCottEntity record);
}