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

import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityExample.Criteria;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class EquipmentPlanEntitySqlProvider {

    public String countByExample(EquipmentPlanEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("equipment_plan");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EquipmentPlanEntityExample example) {
        BEGIN();
        DELETE_FROM("equipment_plan");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(EquipmentPlanEntity record) {
        BEGIN();
        INSERT_INTO("equipment_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getEquId() != null) {
            VALUES("equId", "#{equId,jdbcType=BIGINT}");
        }
        
        if (record.getEquCode() != null) {
            VALUES("equCode", "#{equCode,jdbcType=VARCHAR}");
        }
        
        if (record.getEquName() != null) {
            VALUES("equName", "#{equName,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            VALUES("equTypeId", "#{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpkeepTime() != null) {
            VALUES("upkeepTime", "#{upkeepTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEquTypeName() != null) {
            VALUES("equTypeName", "#{equTypeName,jdbcType=VARCHAR}");
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
        
        if (record.getPlanStatus() != null) {
            VALUES("planStatus", "#{planStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAssignerId() != null) {
            VALUES("assignerId", "#{assignerId,jdbcType=BIGINT}");
        }
        
        if (record.getAssignerTime() != null) {
            VALUES("assignerTime", "#{assignerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlanExecutorDate() != null) {
            VALUES("planExecutorDate", "#{planExecutorDate,jdbcType=DATE}");
        }
        
        if (record.getDeleteBy() != null) {
            VALUES("deleteBy", "#{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            VALUES("deleteTime", "#{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteMemo() != null) {
            VALUES("deleteMemo", "#{deleteMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            VALUES("enableStatus", "#{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(EquipmentPlanEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("equId");
        SELECT("equCode");
        SELECT("equName");
        SELECT("equTypeId");
        SELECT("upkeepTime");
        SELECT("equTypeName");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("planStatus");
        SELECT("assignerId");
        SELECT("assignerTime");
        SELECT("planExecutorDate");
        SELECT("deleteBy");
        SELECT("deleteTime");
        SELECT("deleteMemo");
        SELECT("enableStatus");
        SELECT("description");
        FROM("equipment_plan");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        EquipmentPlanEntity record = (EquipmentPlanEntity) parameter.get("record");
        EquipmentPlanEntityExample example = (EquipmentPlanEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("equipment_plan");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEquId() != null) {
            SET("equId = #{record.equId,jdbcType=BIGINT}");
        }
        
        if (record.getEquCode() != null) {
            SET("equCode = #{record.equCode,jdbcType=VARCHAR}");
        }
        
        if (record.getEquName() != null) {
            SET("equName = #{record.equName,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpkeepTime() != null) {
            SET("upkeepTime = #{record.upkeepTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEquTypeName() != null) {
            SET("equTypeName = #{record.equTypeName,jdbcType=VARCHAR}");
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
        
        if (record.getPlanStatus() != null) {
            SET("planStatus = #{record.planStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAssignerId() != null) {
            SET("assignerId = #{record.assignerId,jdbcType=BIGINT}");
        }
        
        if (record.getAssignerTime() != null) {
            SET("assignerTime = #{record.assignerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlanExecutorDate() != null) {
            SET("planExecutorDate = #{record.planExecutorDate,jdbcType=DATE}");
        }
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteMemo() != null) {
            SET("deleteMemo = #{record.deleteMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("equipment_plan");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("equId = #{record.equId,jdbcType=BIGINT}");
        SET("equCode = #{record.equCode,jdbcType=VARCHAR}");
        SET("equName = #{record.equName,jdbcType=VARCHAR}");
        SET("equTypeId = #{record.equTypeId,jdbcType=BIGINT}");
        SET("upkeepTime = #{record.upkeepTime,jdbcType=TIMESTAMP}");
        SET("equTypeName = #{record.equTypeName,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("planStatus = #{record.planStatus,jdbcType=INTEGER}");
        SET("assignerId = #{record.assignerId,jdbcType=BIGINT}");
        SET("assignerTime = #{record.assignerTime,jdbcType=TIMESTAMP}");
        SET("planExecutorDate = #{record.planExecutorDate,jdbcType=DATE}");
        SET("deleteBy = #{record.deleteBy,jdbcType=BIGINT}");
        SET("deleteTime = #{record.deleteTime,jdbcType=TIMESTAMP}");
        SET("deleteMemo = #{record.deleteMemo,jdbcType=VARCHAR}");
        SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        
        EquipmentPlanEntityExample example = (EquipmentPlanEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(EquipmentPlanEntity record) {
        BEGIN();
        UPDATE("equipment_plan");
        
        if (record.getEquId() != null) {
            SET("equId = #{equId,jdbcType=BIGINT}");
        }
        
        if (record.getEquCode() != null) {
            SET("equCode = #{equCode,jdbcType=VARCHAR}");
        }
        
        if (record.getEquName() != null) {
            SET("equName = #{equName,jdbcType=VARCHAR}");
        }
        
        if (record.getEquTypeId() != null) {
            SET("equTypeId = #{equTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getUpkeepTime() != null) {
            SET("upkeepTime = #{upkeepTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEquTypeName() != null) {
            SET("equTypeName = #{equTypeName,jdbcType=VARCHAR}");
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
        
        if (record.getPlanStatus() != null) {
            SET("planStatus = #{planStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAssignerId() != null) {
            SET("assignerId = #{assignerId,jdbcType=BIGINT}");
        }
        
        if (record.getAssignerTime() != null) {
            SET("assignerTime = #{assignerTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlanExecutorDate() != null) {
            SET("planExecutorDate = #{planExecutorDate,jdbcType=DATE}");
        }
        
        if (record.getDeleteBy() != null) {
            SET("deleteBy = #{deleteBy,jdbcType=BIGINT}");
        }
        
        if (record.getDeleteTime() != null) {
            SET("deleteTime = #{deleteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteMemo() != null) {
            SET("deleteMemo = #{deleteMemo,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{enableStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(EquipmentPlanEntityExample example, boolean includeExamplePhrase) {
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