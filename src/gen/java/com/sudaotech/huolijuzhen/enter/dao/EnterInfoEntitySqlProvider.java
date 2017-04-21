package com.sudaotech.huolijuzhen.enter.dao;

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

import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntity;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample.Criterion;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntityExample;
import java.util.List;
import java.util.Map;

public class EnterInfoEntitySqlProvider {

    public String countByExample(EnterInfoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("enter_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EnterInfoEntityExample example) {
        BEGIN();
        DELETE_FROM("enter_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(EnterInfoEntity record) {
        BEGIN();
        INSERT_INTO("enter_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getEntryName() != null) {
            VALUES("entryName", "#{entryName,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryType() != null) {
            VALUES("entryType", "#{entryType,jdbcType=INTEGER}");
        }
        
        if (record.getTreatmentStatus() != null) {
            VALUES("treatmentStatus", "#{treatmentStatus,jdbcType=INTEGER}");
        }
        
        if (record.getContact() != null) {
            VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNo() != null) {
            VALUES("phoneNo", "#{phoneNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceScope() != null) {
            VALUES("serviceScope", "#{serviceScope,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDescribe() != null) {
            VALUES("updateDescribe", "#{updateDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve1() != null) {
            VALUES("reserve1", "#{reserve1,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve2() != null) {
            VALUES("reserve2", "#{reserve2,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(EnterInfoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("entryName");
        SELECT("entryType");
        SELECT("treatmentStatus");
        SELECT("contact");
        SELECT("phoneNo");
        SELECT("address");
        SELECT("serviceScope");
        SELECT("updateDescribe");
        SELECT("reserve1");
        SELECT("reserve2");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("enter_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        EnterInfoEntity record = (EnterInfoEntity) parameter.get("record");
        EnterInfoEntityExample example = (EnterInfoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("enter_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEntryName() != null) {
            SET("entryName = #{record.entryName,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryType() != null) {
            SET("entryType = #{record.entryType,jdbcType=INTEGER}");
        }
        
        if (record.getTreatmentStatus() != null) {
            SET("treatmentStatus = #{record.treatmentStatus,jdbcType=INTEGER}");
        }
        
        if (record.getContact() != null) {
            SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNo() != null) {
            SET("phoneNo = #{record.phoneNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceScope() != null) {
            SET("serviceScope = #{record.serviceScope,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDescribe() != null) {
            SET("updateDescribe = #{record.updateDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve1() != null) {
            SET("reserve1 = #{record.reserve1,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve2() != null) {
            SET("reserve2 = #{record.reserve2,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("enter_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("entryName = #{record.entryName,jdbcType=VARCHAR}");
        SET("entryType = #{record.entryType,jdbcType=INTEGER}");
        SET("treatmentStatus = #{record.treatmentStatus,jdbcType=INTEGER}");
        SET("contact = #{record.contact,jdbcType=VARCHAR}");
        SET("phoneNo = #{record.phoneNo,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("serviceScope = #{record.serviceScope,jdbcType=VARCHAR}");
        SET("updateDescribe = #{record.updateDescribe,jdbcType=VARCHAR}");
        SET("reserve1 = #{record.reserve1,jdbcType=VARCHAR}");
        SET("reserve2 = #{record.reserve2,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        EnterInfoEntityExample example = (EnterInfoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(EnterInfoEntity record) {
        BEGIN();
        UPDATE("enter_info");
        
        if (record.getEntryName() != null) {
            SET("entryName = #{entryName,jdbcType=VARCHAR}");
        }
        
        if (record.getEntryType() != null) {
            SET("entryType = #{entryType,jdbcType=INTEGER}");
        }
        
        if (record.getTreatmentStatus() != null) {
            SET("treatmentStatus = #{treatmentStatus,jdbcType=INTEGER}");
        }
        
        if (record.getContact() != null) {
            SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNo() != null) {
            SET("phoneNo = #{phoneNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceScope() != null) {
            SET("serviceScope = #{serviceScope,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDescribe() != null) {
            SET("updateDescribe = #{updateDescribe,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve1() != null) {
            SET("reserve1 = #{reserve1,jdbcType=VARCHAR}");
        }
        
        if (record.getReserve2() != null) {
            SET("reserve2 = #{reserve2,jdbcType=VARCHAR}");
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
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(EnterInfoEntityExample example, boolean includeExamplePhrase) {
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