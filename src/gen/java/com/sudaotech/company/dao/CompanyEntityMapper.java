package com.sudaotech.company.dao;

import com.sudaotech.company.dao.CompanyEntity;
import com.sudaotech.company.dao.CompanyEntityExample;
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

public interface CompanyEntityMapper {
    @SelectProvider(type=CompanyEntitySqlProvider.class, method="countByExample")
    int countByExample(CompanyEntityExample example);

    @DeleteProvider(type=CompanyEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CompanyEntityExample example);

    @Delete({
        "delete from company",
        "where companyId = #{companyId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long companyId);

    @Insert({
        "insert into company (companyId, parentId, ",
        "type, code, name, ",
        "brief, logo, registeredCapital, ",
        "businessLicence, representative, ",
        "representativeIdcard, tel, ",
        "cellphone, email, ",
        "qq, provinceId, ",
        "cityId, areaId, ",
        "address, contact, ",
        "contactCellphone, contactPhone, ",
        "bankName, bankCardNo, ",
        "bankBranchName, bankProvince, ",
        "bankCity, lng, lat, ",
        "auditStatus, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, description)",
        "values (#{companyId,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{type,jdbcType=INTEGER}, #{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{brief,jdbcType=VARCHAR}, #{logo,jdbcType=VARCHAR}, #{registeredCapital,jdbcType=INTEGER}, ",
        "#{businessLicence,jdbcType=VARCHAR}, #{representative,jdbcType=VARCHAR}, ",
        "#{representativeIdcard,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, ",
        "#{cellphone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{provinceId,jdbcType=INTEGER}, ",
        "#{cityId,jdbcType=INTEGER}, #{areaId,jdbcType=INTEGER}, ",
        "#{address,jdbcType=VARCHAR}, #{contact,jdbcType=VARCHAR}, ",
        "#{contactCellphone,jdbcType=VARCHAR}, #{contactPhone,jdbcType=VARCHAR}, ",
        "#{bankName,jdbcType=VARCHAR}, #{bankCardNo,jdbcType=VARCHAR}, ",
        "#{bankBranchName,jdbcType=VARCHAR}, #{bankProvince,jdbcType=VARCHAR}, ",
        "#{bankCity,jdbcType=VARCHAR}, #{lng,jdbcType=VARCHAR}, #{lat,jdbcType=VARCHAR}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(CompanyEntity record);

    @InsertProvider(type=CompanyEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CompanyEntity record);

    @SelectProvider(type=CompanyEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="registeredCapital", property="registeredCapital", jdbcType=JdbcType.INTEGER),
        @Result(column="businessLicence", property="businessLicence", jdbcType=JdbcType.VARCHAR),
        @Result(column="representative", property="representative", jdbcType=JdbcType.VARCHAR),
        @Result(column="representativeIdcard", property="representativeIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactCellphone", property="contactCellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactPhone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankName", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCardNo", property="bankCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankBranchName", property="bankBranchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankProvince", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCity", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="auditStatus", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CompanyEntity> selectByExampleWithBLOBsWithRowbounds(CompanyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CompanyEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="registeredCapital", property="registeredCapital", jdbcType=JdbcType.INTEGER),
        @Result(column="businessLicence", property="businessLicence", jdbcType=JdbcType.VARCHAR),
        @Result(column="representative", property="representative", jdbcType=JdbcType.VARCHAR),
        @Result(column="representativeIdcard", property="representativeIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactCellphone", property="contactCellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactPhone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankName", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCardNo", property="bankCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankBranchName", property="bankBranchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankProvince", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCity", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="auditStatus", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CompanyEntity> selectByExampleWithBLOBs(CompanyEntityExample example);

    @SelectProvider(type=CompanyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="registeredCapital", property="registeredCapital", jdbcType=JdbcType.INTEGER),
        @Result(column="businessLicence", property="businessLicence", jdbcType=JdbcType.VARCHAR),
        @Result(column="representative", property="representative", jdbcType=JdbcType.VARCHAR),
        @Result(column="representativeIdcard", property="representativeIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactCellphone", property="contactCellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactPhone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankName", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCardNo", property="bankCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankBranchName", property="bankBranchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankProvince", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCity", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="auditStatus", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CompanyEntity> selectByExampleWithRowbounds(CompanyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CompanyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="registeredCapital", property="registeredCapital", jdbcType=JdbcType.INTEGER),
        @Result(column="businessLicence", property="businessLicence", jdbcType=JdbcType.VARCHAR),
        @Result(column="representative", property="representative", jdbcType=JdbcType.VARCHAR),
        @Result(column="representativeIdcard", property="representativeIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactCellphone", property="contactCellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactPhone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankName", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCardNo", property="bankCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankBranchName", property="bankBranchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankProvince", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCity", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="auditStatus", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CompanyEntity> selectByExample(CompanyEntityExample example);

    @Select({
        "select",
        "companyId, parentId, type, code, name, brief, logo, registeredCapital, businessLicence, ",
        "representative, representativeIdcard, tel, cellphone, email, qq, provinceId, ",
        "cityId, areaId, address, contact, contactCellphone, contactPhone, bankName, ",
        "bankCardNo, bankBranchName, bankProvince, bankCity, lng, lat, auditStatus, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, description",
        "from company",
        "where companyId = #{companyId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="companyId", property="companyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="registeredCapital", property="registeredCapital", jdbcType=JdbcType.INTEGER),
        @Result(column="businessLicence", property="businessLicence", jdbcType=JdbcType.VARCHAR),
        @Result(column="representative", property="representative", jdbcType=JdbcType.VARCHAR),
        @Result(column="representativeIdcard", property="representativeIdcard", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cellphone", property="cellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="provinceId", property="provinceId", jdbcType=JdbcType.INTEGER),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactCellphone", property="contactCellphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contactPhone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankName", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCardNo", property="bankCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankBranchName", property="bankBranchName", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankProvince", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="bankCity", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="auditStatus", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    CompanyEntity selectByPrimaryKey(Long companyId);

    @UpdateProvider(type=CompanyEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CompanyEntity record, @Param("example") CompanyEntityExample example);

    @UpdateProvider(type=CompanyEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CompanyEntity record, @Param("example") CompanyEntityExample example);

    @UpdateProvider(type=CompanyEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CompanyEntity record, @Param("example") CompanyEntityExample example);

    @UpdateProvider(type=CompanyEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CompanyEntity record);

    @Update({
        "update company",
        "set parentId = #{parentId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "registeredCapital = #{registeredCapital,jdbcType=INTEGER},",
          "businessLicence = #{businessLicence,jdbcType=VARCHAR},",
          "representative = #{representative,jdbcType=VARCHAR},",
          "representativeIdcard = #{representativeIdcard,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "cellphone = #{cellphone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "provinceId = #{provinceId,jdbcType=INTEGER},",
          "cityId = #{cityId,jdbcType=INTEGER},",
          "areaId = #{areaId,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "contactCellphone = #{contactCellphone,jdbcType=VARCHAR},",
          "contactPhone = #{contactPhone,jdbcType=VARCHAR},",
          "bankName = #{bankName,jdbcType=VARCHAR},",
          "bankCardNo = #{bankCardNo,jdbcType=VARCHAR},",
          "bankBranchName = #{bankBranchName,jdbcType=VARCHAR},",
          "bankProvince = #{bankProvince,jdbcType=VARCHAR},",
          "bankCity = #{bankCity,jdbcType=VARCHAR},",
          "lng = #{lng,jdbcType=VARCHAR},",
          "lat = #{lat,jdbcType=VARCHAR},",
          "auditStatus = #{auditStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where companyId = #{companyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CompanyEntity record);

    @Update({
        "update company",
        "set parentId = #{parentId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "registeredCapital = #{registeredCapital,jdbcType=INTEGER},",
          "businessLicence = #{businessLicence,jdbcType=VARCHAR},",
          "representative = #{representative,jdbcType=VARCHAR},",
          "representativeIdcard = #{representativeIdcard,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "cellphone = #{cellphone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "provinceId = #{provinceId,jdbcType=INTEGER},",
          "cityId = #{cityId,jdbcType=INTEGER},",
          "areaId = #{areaId,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "contactCellphone = #{contactCellphone,jdbcType=VARCHAR},",
          "contactPhone = #{contactPhone,jdbcType=VARCHAR},",
          "bankName = #{bankName,jdbcType=VARCHAR},",
          "bankCardNo = #{bankCardNo,jdbcType=VARCHAR},",
          "bankBranchName = #{bankBranchName,jdbcType=VARCHAR},",
          "bankProvince = #{bankProvince,jdbcType=VARCHAR},",
          "bankCity = #{bankCity,jdbcType=VARCHAR},",
          "lng = #{lng,jdbcType=VARCHAR},",
          "lat = #{lat,jdbcType=VARCHAR},",
          "auditStatus = #{auditStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where companyId = #{companyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CompanyEntity record);
}