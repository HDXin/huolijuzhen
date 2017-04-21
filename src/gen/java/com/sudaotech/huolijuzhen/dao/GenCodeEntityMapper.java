package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.GenCodeEntity;
import com.sudaotech.huolijuzhen.dao.GenCodeEntityExample;
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

public interface GenCodeEntityMapper {
    @SelectProvider(type=GenCodeEntitySqlProvider.class, method="countByExample")
    int countByExample(GenCodeEntityExample example);

    @DeleteProvider(type=GenCodeEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(GenCodeEntityExample example);

    @Delete({
        "delete from gen_code",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into gen_code (id, codeType, ",
        "code, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{codeType,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=BIGINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(GenCodeEntity record);

    @InsertProvider(type=GenCodeEntitySqlProvider.class, method="insertSelective")
    int insertSelective(GenCodeEntity record);

    @SelectProvider(type=GenCodeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="codeType", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GenCodeEntity> selectByExampleWithRowbounds(GenCodeEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=GenCodeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="codeType", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GenCodeEntity> selectByExample(GenCodeEntityExample example);

    @Select({
        "select",
        "id, codeType, code, lastUpdate",
        "from gen_code",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="codeType", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.BIGINT),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    GenCodeEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=GenCodeEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GenCodeEntity record, @Param("example") GenCodeEntityExample example);

    @UpdateProvider(type=GenCodeEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GenCodeEntity record, @Param("example") GenCodeEntityExample example);

    @UpdateProvider(type=GenCodeEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GenCodeEntity record);

    @Update({
        "update gen_code",
        "set codeType = #{codeType,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=BIGINT},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GenCodeEntity record);
}