package com.sudaotech.company.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sudaotech.company.dao.CompanyEntity;
import com.sudaotech.company.dao.CompanyEntityExample.Criteria;
import com.sudaotech.company.dao.CompanyEntityExample.Criterion;
import com.sudaotech.company.dao.CompanyEntityExample;
import java.util.List;
import java.util.Map;

public class CompanyEntitySqlProvider {

    public String countByExample(CompanyEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("company");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CompanyEntityExample example) {
        BEGIN();
        DELETE_FROM("company");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CompanyEntity record) {
        BEGIN();
        INSERT_INTO("company");
        
        if (record.getCompanyId() != null) {
            VALUES("companyId", "#{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parentId", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            VALUES("brief", "#{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo() != null) {
            VALUES("logo", "#{logo,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisteredCapital() != null) {
            VALUES("registeredCapital", "#{registeredCapital,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessLicence() != null) {
            VALUES("businessLicence", "#{businessLicence,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            VALUES("representative", "#{representative,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentativeIdcard() != null) {
            VALUES("representativeIdcard", "#{representativeIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCellphone() != null) {
            VALUES("cellphone", "#{cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            VALUES("qq", "#{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            VALUES("provinceId", "#{provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            VALUES("cityId", "#{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            VALUES("areaId", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactCellphone() != null) {
            VALUES("contactCellphone", "#{contactCellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            VALUES("contactPhone", "#{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            VALUES("bankName", "#{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCardNo() != null) {
            VALUES("bankCardNo", "#{bankCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranchName() != null) {
            VALUES("bankBranchName", "#{bankBranchName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            VALUES("bankProvince", "#{bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            VALUES("bankCity", "#{bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            VALUES("lng", "#{lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            VALUES("lat", "#{lat,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            VALUES("auditStatus", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            VALUES("displayOrder", "#{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            VALUES("createBy", "#{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            VALUES("updateBy", "#{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            VALUES("lastUpdate", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(CompanyEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("companyId");
        } else {
            SELECT("companyId");
        }
        SELECT("parentId");
        SELECT("type");
        SELECT("code");
        SELECT("name");
        SELECT("brief");
        SELECT("logo");
        SELECT("registeredCapital");
        SELECT("businessLicence");
        SELECT("representative");
        SELECT("representativeIdcard");
        SELECT("tel");
        SELECT("cellphone");
        SELECT("email");
        SELECT("qq");
        SELECT("provinceId");
        SELECT("cityId");
        SELECT("areaId");
        SELECT("address");
        SELECT("contact");
        SELECT("contactCellphone");
        SELECT("contactPhone");
        SELECT("bankName");
        SELECT("bankCardNo");
        SELECT("bankBranchName");
        SELECT("bankProvince");
        SELECT("bankCity");
        SELECT("lng");
        SELECT("lat");
        SELECT("auditStatus");
        SELECT("displayOrder");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("description");
        FROM("company");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(CompanyEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("companyId");
        } else {
            SELECT("companyId");
        }
        SELECT("parentId");
        SELECT("type");
        SELECT("code");
        SELECT("name");
        SELECT("brief");
        SELECT("logo");
        SELECT("registeredCapital");
        SELECT("businessLicence");
        SELECT("representative");
        SELECT("representativeIdcard");
        SELECT("tel");
        SELECT("cellphone");
        SELECT("email");
        SELECT("qq");
        SELECT("provinceId");
        SELECT("cityId");
        SELECT("areaId");
        SELECT("address");
        SELECT("contact");
        SELECT("contactCellphone");
        SELECT("contactPhone");
        SELECT("bankName");
        SELECT("bankCardNo");
        SELECT("bankBranchName");
        SELECT("bankProvince");
        SELECT("bankCity");
        SELECT("lng");
        SELECT("lat");
        SELECT("auditStatus");
        SELECT("displayOrder");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("company");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CompanyEntity record = (CompanyEntity) parameter.get("record");
        CompanyEntityExample example = (CompanyEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("company");
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            SET("parentId = #{record.parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            SET("brief = #{record.brief,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo() != null) {
            SET("logo = #{record.logo,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisteredCapital() != null) {
            SET("registeredCapital = #{record.registeredCapital,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessLicence() != null) {
            SET("businessLicence = #{record.businessLicence,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            SET("representative = #{record.representative,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentativeIdcard() != null) {
            SET("representativeIdcard = #{record.representativeIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCellphone() != null) {
            SET("cellphone = #{record.cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{record.qq,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            SET("provinceId = #{record.provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{record.cityId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            SET("areaId = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactCellphone() != null) {
            SET("contactCellphone = #{record.contactCellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            SET("contactPhone = #{record.contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            SET("bankName = #{record.bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCardNo() != null) {
            SET("bankCardNo = #{record.bankCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranchName() != null) {
            SET("bankBranchName = #{record.bankBranchName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            SET("bankProvince = #{record.bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            SET("bankCity = #{record.bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            SET("lng = #{record.lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            SET("lat = #{record.lat,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            SET("auditStatus = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("displayOrder = #{record.displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("company");
        
        SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        SET("parentId = #{record.parentId,jdbcType=BIGINT}");
        SET("type = #{record.type,jdbcType=INTEGER}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("brief = #{record.brief,jdbcType=VARCHAR}");
        SET("logo = #{record.logo,jdbcType=VARCHAR}");
        SET("registeredCapital = #{record.registeredCapital,jdbcType=INTEGER}");
        SET("businessLicence = #{record.businessLicence,jdbcType=VARCHAR}");
        SET("representative = #{record.representative,jdbcType=VARCHAR}");
        SET("representativeIdcard = #{record.representativeIdcard,jdbcType=VARCHAR}");
        SET("tel = #{record.tel,jdbcType=VARCHAR}");
        SET("cellphone = #{record.cellphone,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("qq = #{record.qq,jdbcType=VARCHAR}");
        SET("provinceId = #{record.provinceId,jdbcType=INTEGER}");
        SET("cityId = #{record.cityId,jdbcType=INTEGER}");
        SET("areaId = #{record.areaId,jdbcType=INTEGER}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("contact = #{record.contact,jdbcType=VARCHAR}");
        SET("contactCellphone = #{record.contactCellphone,jdbcType=VARCHAR}");
        SET("contactPhone = #{record.contactPhone,jdbcType=VARCHAR}");
        SET("bankName = #{record.bankName,jdbcType=VARCHAR}");
        SET("bankCardNo = #{record.bankCardNo,jdbcType=VARCHAR}");
        SET("bankBranchName = #{record.bankBranchName,jdbcType=VARCHAR}");
        SET("bankProvince = #{record.bankProvince,jdbcType=VARCHAR}");
        SET("bankCity = #{record.bankCity,jdbcType=VARCHAR}");
        SET("lng = #{record.lng,jdbcType=VARCHAR}");
        SET("lat = #{record.lat,jdbcType=VARCHAR}");
        SET("auditStatus = #{record.auditStatus,jdbcType=INTEGER}");
        SET("displayOrder = #{record.displayOrder,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        
        CompanyEntityExample example = (CompanyEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("company");
        
        SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        SET("parentId = #{record.parentId,jdbcType=BIGINT}");
        SET("type = #{record.type,jdbcType=INTEGER}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("brief = #{record.brief,jdbcType=VARCHAR}");
        SET("logo = #{record.logo,jdbcType=VARCHAR}");
        SET("registeredCapital = #{record.registeredCapital,jdbcType=INTEGER}");
        SET("businessLicence = #{record.businessLicence,jdbcType=VARCHAR}");
        SET("representative = #{record.representative,jdbcType=VARCHAR}");
        SET("representativeIdcard = #{record.representativeIdcard,jdbcType=VARCHAR}");
        SET("tel = #{record.tel,jdbcType=VARCHAR}");
        SET("cellphone = #{record.cellphone,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("qq = #{record.qq,jdbcType=VARCHAR}");
        SET("provinceId = #{record.provinceId,jdbcType=INTEGER}");
        SET("cityId = #{record.cityId,jdbcType=INTEGER}");
        SET("areaId = #{record.areaId,jdbcType=INTEGER}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("contact = #{record.contact,jdbcType=VARCHAR}");
        SET("contactCellphone = #{record.contactCellphone,jdbcType=VARCHAR}");
        SET("contactPhone = #{record.contactPhone,jdbcType=VARCHAR}");
        SET("bankName = #{record.bankName,jdbcType=VARCHAR}");
        SET("bankCardNo = #{record.bankCardNo,jdbcType=VARCHAR}");
        SET("bankBranchName = #{record.bankBranchName,jdbcType=VARCHAR}");
        SET("bankProvince = #{record.bankProvince,jdbcType=VARCHAR}");
        SET("bankCity = #{record.bankCity,jdbcType=VARCHAR}");
        SET("lng = #{record.lng,jdbcType=VARCHAR}");
        SET("lat = #{record.lat,jdbcType=VARCHAR}");
        SET("auditStatus = #{record.auditStatus,jdbcType=INTEGER}");
        SET("displayOrder = #{record.displayOrder,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        CompanyEntityExample example = (CompanyEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CompanyEntity record) {
        BEGIN();
        UPDATE("company");
        
        if (record.getParentId() != null) {
            SET("parentId = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            SET("brief = #{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo() != null) {
            SET("logo = #{logo,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisteredCapital() != null) {
            SET("registeredCapital = #{registeredCapital,jdbcType=INTEGER}");
        }
        
        if (record.getBusinessLicence() != null) {
            SET("businessLicence = #{businessLicence,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentative() != null) {
            SET("representative = #{representative,jdbcType=VARCHAR}");
        }
        
        if (record.getRepresentativeIdcard() != null) {
            SET("representativeIdcard = #{representativeIdcard,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getCellphone() != null) {
            SET("cellphone = #{cellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getQq() != null) {
            SET("qq = #{qq,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceId() != null) {
            SET("provinceId = #{provinceId,jdbcType=INTEGER}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{cityId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            SET("areaId = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getContact() != null) {
            SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getContactCellphone() != null) {
            SET("contactCellphone = #{contactCellphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            SET("contactPhone = #{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            SET("bankName = #{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCardNo() != null) {
            SET("bankCardNo = #{bankCardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBankBranchName() != null) {
            SET("bankBranchName = #{bankBranchName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankProvince() != null) {
            SET("bankProvince = #{bankProvince,jdbcType=VARCHAR}");
        }
        
        if (record.getBankCity() != null) {
            SET("bankCity = #{bankCity,jdbcType=VARCHAR}");
        }
        
        if (record.getLng() != null) {
            SET("lng = #{lng,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            SET("lat = #{lat,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            SET("auditStatus = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDisplayOrder() != null) {
            SET("displayOrder = #{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateBy() != null) {
            SET("createBy = #{createBy,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("updateBy = #{updateBy,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            SET("lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("companyId = #{companyId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CompanyEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}