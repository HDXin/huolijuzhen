package com.sudaotech.huolijuzhen.equipment.dao;

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

import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntityExample.Criteria;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class EquipmentPreserveEntitySqlProvider {

    public String countByExample(EquipmentPreserveEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("equ_pre_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EquipmentPreserveEntityExample example) {
        BEGIN();
        DELETE_FROM("equ_pre_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(EquipmentPreserveEntity record) {
        BEGIN();
        INSERT_INTO("equ_pre_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPreCycle() != null) {
            VALUES("preCycle", "#{preCycle,jdbcType=INTEGER}");
        }
        
        if (record.getCycleType() != null) {
            VALUES("cycleType", "#{cycleType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            VALUES("equTypeId", "#{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getEquTypeName() != null) {
            VALUES("equTypeName", "#{equTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPreObj() != null) {
            VALUES("preObj", "#{preObj,jdbcType=VARCHAR}");
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
        
        if (record.getEnableStatus() != null) {
            VALUES("enableStatus", "#{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEnableDate() != null) {
            VALUES("enableDate", "#{enableDate,jdbcType=DATE}");
        }
        
        if (record.getEnableBy() != null) {
            VALUES("enableBy", "#{enableBy,jdbcType=BIGINT}");
        }
        
        if (record.getEnableTime() != null) {
            VALUES("enableTime", "#{enableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisableBy() != null) {
            VALUES("disableBy", "#{disableBy,jdbcType=BIGINT}");
        }
        
        if (record.getDisableTime() != null) {
            VALUES("disableTime", "#{disableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsEnablePlan() != null) {
            VALUES("isEnablePlan", "#{isEnablePlan,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String selectByExample(EquipmentPreserveEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("preCycle");
        SELECT("cycleType");
        SELECT("parkId");
        SELECT("code");
        SELECT("equTypeId");
        SELECT("equTypeName");
        SELECT("preObj");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("enableStatus");
        SELECT("enableDate");
        SELECT("enableBy");
        SELECT("enableTime");
        SELECT("disableBy");
        SELECT("disableTime");
        SELECT("isEnablePlan");
        FROM("equ_pre_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        EquipmentPreserveEntity record = (EquipmentPreserveEntity) parameter.get("record");
        EquipmentPreserveEntityExample example = (EquipmentPreserveEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("equ_pre_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPreCycle() != null) {
            SET("preCycle = #{record.preCycle,jdbcType=INTEGER}");
        }
        
        if (record.getCycleType() != null) {
            SET("cycleType = #{record.cycleType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getEquTypeName() != null) {
            SET("equTypeName = #{record.equTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPreObj() != null) {
            SET("preObj = #{record.preObj,jdbcType=VARCHAR}");
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
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEnableDate() != null) {
            SET("enableDate = #{record.enableDate,jdbcType=DATE}");
        }
        
        if (record.getEnableBy() != null) {
            SET("enableBy = #{record.enableBy,jdbcType=BIGINT}");
        }
        
        if (record.getEnableTime() != null) {
            SET("enableTime = #{record.enableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisableBy() != null) {
            SET("disableBy = #{record.disableBy,jdbcType=BIGINT}");
        }
        
        if (record.getDisableTime() != null) {
            SET("disableTime = #{record.disableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsEnablePlan() != null) {
            SET("isEnablePlan = #{record.isEnablePlan,jdbcType=BIT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("equ_pre_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("preCycle = #{record.preCycle,jdbcType=INTEGER}");
        SET("cycleType = #{record.cycleType,jdbcType=INTEGER}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        SET("equTypeName = #{record.equTypeName,jdbcType=VARCHAR}");
        SET("preObj = #{record.preObj,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        SET("enableDate = #{record.enableDate,jdbcType=DATE}");
        SET("enableBy = #{record.enableBy,jdbcType=BIGINT}");
        SET("enableTime = #{record.enableTime,jdbcType=TIMESTAMP}");
        SET("disableBy = #{record.disableBy,jdbcType=BIGINT}");
        SET("disableTime = #{record.disableTime,jdbcType=TIMESTAMP}");
        SET("isEnablePlan = #{record.isEnablePlan,jdbcType=BIT}");
        
        EquipmentPreserveEntityExample example = (EquipmentPreserveEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(EquipmentPreserveEntity record) {
        BEGIN();
        UPDATE("equ_pre_info");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPreCycle() != null) {
            SET("preCycle = #{preCycle,jdbcType=INTEGER}");
        }
        
        if (record.getCycleType() != null) {
            SET("cycleType = #{cycleType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getEquTypeName() != null) {
            SET("equTypeName = #{equTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPreObj() != null) {
            SET("preObj = #{preObj,jdbcType=VARCHAR}");
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
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getEnableDate() != null) {
            SET("enableDate = #{enableDate,jdbcType=DATE}");
        }
        
        if (record.getEnableBy() != null) {
            SET("enableBy = #{enableBy,jdbcType=BIGINT}");
        }
        
        if (record.getEnableTime() != null) {
            SET("enableTime = #{enableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisableBy() != null) {
            SET("disableBy = #{disableBy,jdbcType=BIGINT}");
        }
        
        if (record.getDisableTime() != null) {
            SET("disableTime = #{disableTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsEnablePlan() != null) {
            SET("isEnablePlan = #{isEnablePlan,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(EquipmentPreserveEntityExample example, boolean includeExamplePhrase) {
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