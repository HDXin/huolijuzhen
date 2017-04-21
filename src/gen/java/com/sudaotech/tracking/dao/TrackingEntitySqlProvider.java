package com.sudaotech.tracking.dao;

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

import com.sudaotech.tracking.dao.TrackingEntity;
import com.sudaotech.tracking.dao.TrackingEntityExample.Criteria;
import com.sudaotech.tracking.dao.TrackingEntityExample.Criterion;
import com.sudaotech.tracking.dao.TrackingEntityExample;
import java.util.List;
import java.util.Map;

public class TrackingEntitySqlProvider {

    public String countByExample(TrackingEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("tracking");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TrackingEntityExample example) {
        BEGIN();
        DELETE_FROM("tracking");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TrackingEntity record) {
        BEGIN();
        INSERT_INTO("tracking");
        
        if (record.getTrackingId() != null) {
            VALUES("trackingId", "#{trackingId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceId() != null) {
            VALUES("resourceId", "#{resourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            VALUES("action", "#{action,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getData() != null) {
            VALUES("data", "#{data,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(TrackingEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trackingId");
        } else {
            SELECT("trackingId");
        }
        SELECT("type");
        SELECT("resourceId");
        SELECT("action");
        SELECT("time");
        SELECT("data");
        FROM("tracking");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(TrackingEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("trackingId");
        } else {
            SELECT("trackingId");
        }
        SELECT("type");
        SELECT("resourceId");
        SELECT("action");
        SELECT("time");
        FROM("tracking");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TrackingEntity record = (TrackingEntity) parameter.get("record");
        TrackingEntityExample example = (TrackingEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tracking");
        
        if (record.getTrackingId() != null) {
            SET("trackingId = #{record.trackingId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceId() != null) {
            SET("resourceId = #{record.resourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            SET("action = #{record.action,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getData() != null) {
            SET("data = #{record.data,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tracking");
        
        SET("trackingId = #{record.trackingId,jdbcType=BIGINT}");
        SET("type = #{record.type,jdbcType=VARCHAR}");
        SET("resourceId = #{record.resourceId,jdbcType=VARCHAR}");
        SET("action = #{record.action,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("data = #{record.data,jdbcType=LONGVARCHAR}");
        
        TrackingEntityExample example = (TrackingEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tracking");
        
        SET("trackingId = #{record.trackingId,jdbcType=BIGINT}");
        SET("type = #{record.type,jdbcType=VARCHAR}");
        SET("resourceId = #{record.resourceId,jdbcType=VARCHAR}");
        SET("action = #{record.action,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        
        TrackingEntityExample example = (TrackingEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TrackingEntity record) {
        BEGIN();
        UPDATE("tracking");
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getResourceId() != null) {
            SET("resourceId = #{resourceId,jdbcType=VARCHAR}");
        }
        
        if (record.getAction() != null) {
            SET("action = #{action,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getData() != null) {
            SET("data = #{data,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("trackingId = #{trackingId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(TrackingEntityExample example, boolean includeExamplePhrase) {
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