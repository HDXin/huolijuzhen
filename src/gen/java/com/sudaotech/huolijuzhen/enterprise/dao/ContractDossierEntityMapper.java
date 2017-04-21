package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntityExample;
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

public interface ContractDossierEntityMapper {
    @SelectProvider(type=ContractDossierEntitySqlProvider.class, method="countByExample")
    int countByExample(ContractDossierEntityExample example);

    @DeleteProvider(type=ContractDossierEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContractDossierEntityExample example);

    @Delete({
        "delete from contract_dossier",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into contract_dossier (id, contractId, ",
        "fileType, fileName, ",
        "fileUrl, imgLink, ",
        "fileDesc, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{contractId,jdbcType=BIGINT}, ",
        "#{fileType,jdbcType=INTEGER}, #{fileName,jdbcType=VARCHAR}, ",
        "#{fileUrl,jdbcType=VARCHAR}, #{imgLink,jdbcType=VARCHAR}, ",
        "#{fileDesc,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ContractDossierEntity record);

    @InsertProvider(type=ContractDossierEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ContractDossierEntity record);

    @SelectProvider(type=ContractDossierEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContractDossierEntity> selectByExampleWithRowbounds(ContractDossierEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContractDossierEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContractDossierEntity> selectByExample(ContractDossierEntityExample example);

    @Select({
        "select",
        "id, contractId, fileType, fileName, fileUrl, imgLink, fileDesc, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from contract_dossier",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contractId", property="contractId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ContractDossierEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ContractDossierEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContractDossierEntity record, @Param("example") ContractDossierEntityExample example);

    @UpdateProvider(type=ContractDossierEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContractDossierEntity record, @Param("example") ContractDossierEntityExample example);

    @UpdateProvider(type=ContractDossierEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractDossierEntity record);

    @Update({
        "update contract_dossier",
        "set contractId = #{contractId,jdbcType=BIGINT},",
          "fileType = #{fileType,jdbcType=INTEGER},",
          "fileName = #{fileName,jdbcType=VARCHAR},",
          "fileUrl = #{fileUrl,jdbcType=VARCHAR},",
          "imgLink = #{imgLink,jdbcType=VARCHAR},",
          "fileDesc = #{fileDesc,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContractDossierEntity record);
}