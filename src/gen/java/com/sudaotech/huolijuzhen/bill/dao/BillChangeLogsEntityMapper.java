package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntityExample;
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

public interface BillChangeLogsEntityMapper {
    @SelectProvider(type=BillChangeLogsEntitySqlProvider.class, method="countByExample")
    int countByExample(BillChangeLogsEntityExample example);

    @DeleteProvider(type=BillChangeLogsEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillChangeLogsEntityExample example);

    @Delete({
        "delete from bill_change_logs",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_change_logs (id, billId, ",
        "operType, operExplain, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{billId,jdbcType=BIGINT}, ",
        "#{operType,jdbcType=INTEGER}, #{operExplain,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(BillChangeLogsEntity record);

    @InsertProvider(type=BillChangeLogsEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillChangeLogsEntity record);

    @SelectProvider(type=BillChangeLogsEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="operType", property="operType", jdbcType=JdbcType.INTEGER),
        @Result(column="operExplain", property="operExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillChangeLogsEntity> selectByExampleWithRowbounds(BillChangeLogsEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillChangeLogsEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="operType", property="operType", jdbcType=JdbcType.INTEGER),
        @Result(column="operExplain", property="operExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillChangeLogsEntity> selectByExample(BillChangeLogsEntityExample example);

    @Select({
        "select",
        "id, billId, operType, operExplain, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate",
        "from bill_change_logs",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="operType", property="operType", jdbcType=JdbcType.INTEGER),
        @Result(column="operExplain", property="operExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    BillChangeLogsEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillChangeLogsEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillChangeLogsEntity record, @Param("example") BillChangeLogsEntityExample example);

    @UpdateProvider(type=BillChangeLogsEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillChangeLogsEntity record, @Param("example") BillChangeLogsEntityExample example);

    @UpdateProvider(type=BillChangeLogsEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillChangeLogsEntity record);

    @Update({
        "update bill_change_logs",
        "set billId = #{billId,jdbcType=BIGINT},",
          "operType = #{operType,jdbcType=INTEGER},",
          "operExplain = #{operExplain,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillChangeLogsEntity record);
}