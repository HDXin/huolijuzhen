package com.sudaotech.huolijuzhen.enter.dao;

import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntity;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample;
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

public interface EnterInfoEntityMapper {
    @SelectProvider(type=EnterInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterInfoEntityExample example);

    @DeleteProvider(type=EnterInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterInfoEntityExample example);

    @Delete({
        "delete from enter_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enter_info (id, entryName, ",
        "entryType, treatmentStatus, ",
        "contact, phoneNo, ",
        "address, serviceScope, ",
        "updateDescribe, reserve1, ",
        "reserve2, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{entryName,jdbcType=VARCHAR}, ",
        "#{entryType,jdbcType=INTEGER}, #{treatmentStatus,jdbcType=INTEGER}, ",
        "#{contact,jdbcType=VARCHAR}, #{phoneNo,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{serviceScope,jdbcType=VARCHAR}, ",
        "#{updateDescribe,jdbcType=VARCHAR}, #{reserve1,jdbcType=VARCHAR}, ",
        "#{reserve2,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterInfoEntity record);

    @InsertProvider(type=EnterInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterInfoEntity record);

    @SelectProvider(type=EnterInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="entryName", property="entryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entryType", property="entryType", jdbcType=JdbcType.INTEGER),
        @Result(column="treatmentStatus", property="treatmentStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phoneNo", property="phoneNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceScope", property="serviceScope", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateDescribe", property="updateDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve1", property="reserve1", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve2", property="reserve2", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterInfoEntity> selectByExampleWithRowbounds(EnterInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="entryName", property="entryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entryType", property="entryType", jdbcType=JdbcType.INTEGER),
        @Result(column="treatmentStatus", property="treatmentStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phoneNo", property="phoneNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceScope", property="serviceScope", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateDescribe", property="updateDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve1", property="reserve1", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve2", property="reserve2", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterInfoEntity> selectByExample(EnterInfoEntityExample example);

    @Select({
        "select",
        "id, entryName, entryType, treatmentStatus, contact, phoneNo, address, serviceScope, ",
        "updateDescribe, reserve1, reserve2, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate",
        "from enter_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="entryName", property="entryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entryType", property="entryType", jdbcType=JdbcType.INTEGER),
        @Result(column="treatmentStatus", property="treatmentStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="phoneNo", property="phoneNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceScope", property="serviceScope", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateDescribe", property="updateDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve1", property="reserve1", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserve2", property="reserve2", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterInfoEntity record, @Param("example") EnterInfoEntityExample example);

    @UpdateProvider(type=EnterInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterInfoEntity record, @Param("example") EnterInfoEntityExample example);

    @UpdateProvider(type=EnterInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterInfoEntity record);

    @Update({
        "update enter_info",
        "set entryName = #{entryName,jdbcType=VARCHAR},",
          "entryType = #{entryType,jdbcType=INTEGER},",
          "treatmentStatus = #{treatmentStatus,jdbcType=INTEGER},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "phoneNo = #{phoneNo,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "serviceScope = #{serviceScope,jdbcType=VARCHAR},",
          "updateDescribe = #{updateDescribe,jdbcType=VARCHAR},",
          "reserve1 = #{reserve1,jdbcType=VARCHAR},",
          "reserve2 = #{reserve2,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterInfoEntity record);
}