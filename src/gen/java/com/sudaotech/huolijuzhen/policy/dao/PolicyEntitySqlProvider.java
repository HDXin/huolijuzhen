package com.sudaotech.huolijuzhen.policy.dao;

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

import com.sudaotech.huolijuzhen.policy.dao.PolicyEntityExample.Criteria;
import com.sudaotech.huolijuzhen.policy.dao.PolicyEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class PolicyEntitySqlProvider {

    public String countByExample(PolicyEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("policy_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(PolicyEntityExample example) {
        BEGIN();
        DELETE_FROM("policy_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PolicyEntity record) {
        BEGIN();
        INSERT_INTO("policy_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPolUri() != null) {
            VALUES("polUri", "#{polUri,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicGrade() != null) {
            VALUES("publicGrade", "#{publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            VALUES("proId", "#{proId,jdbcType=BIGINT}");
        }
        
        if (record.getCityId() != null) {
            VALUES("cityId", "#{cityId,jdbcType=BIGINT}");
        }
        
        if (record.getCounId() != null) {
            VALUES("counId", "#{counId,jdbcType=BIGINT}");
        }
        
        if (record.getLocationId() != null) {
            VALUES("locationId", "#{locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            VALUES("approvalStatus", "#{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            VALUES("approvalBy", "#{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            VALUES("approvalTime", "#{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            VALUES("approvalText", "#{approvalText,jdbcType=VARCHAR}");
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
        
        if (record.getCreateSide() != null) {
            VALUES("createSide", "#{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            VALUES("createSideId", "#{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getReadNum() != null) {
            VALUES("readNum", "#{readNum,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(PolicyEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("title");
        SELECT("polUri");
        SELECT("publicGrade");
        SELECT("parkId");
        SELECT("proId");
        SELECT("cityId");
        SELECT("counId");
        SELECT("locationId");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalText");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("createSide");
        SELECT("createSideId");
        SELECT("readNum");
        FROM("policy_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PolicyEntity record = (PolicyEntity) parameter.get("record");
        PolicyEntityExample example = (PolicyEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("policy_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPolUri() != null) {
            SET("polUri = #{record.polUri,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicGrade() != null) {
            SET("publicGrade = #{record.publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            SET("proId = #{record.proId,jdbcType=BIGINT}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{record.cityId,jdbcType=BIGINT}");
        }
        
        if (record.getCounId() != null) {
            SET("counId = #{record.counId,jdbcType=BIGINT}");
        }
        
        if (record.getLocationId() != null) {
            SET("locationId = #{record.locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
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
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getReadNum() != null) {
            SET("readNum = #{record.readNum,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("policy_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("polUri = #{record.polUri,jdbcType=VARCHAR}");
        SET("publicGrade = #{record.publicGrade,jdbcType=INTEGER}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("proId = #{record.proId,jdbcType=BIGINT}");
        SET("cityId = #{record.cityId,jdbcType=BIGINT}");
        SET("counId = #{record.counId,jdbcType=BIGINT}");
        SET("locationId = #{record.locationId,jdbcType=BIGINT}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        SET("readNum = #{record.readNum,jdbcType=INTEGER}");
        
        PolicyEntityExample example = (PolicyEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PolicyEntity record) {
        BEGIN();
        UPDATE("policy_info");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPolUri() != null) {
            SET("polUri = #{polUri,jdbcType=VARCHAR}");
        }
        
        if (record.getPublicGrade() != null) {
            SET("publicGrade = #{publicGrade,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getProId() != null) {
            SET("proId = #{proId,jdbcType=BIGINT}");
        }
        
        if (record.getCityId() != null) {
            SET("cityId = #{cityId,jdbcType=BIGINT}");
        }
        
        if (record.getCounId() != null) {
            SET("counId = #{counId,jdbcType=BIGINT}");
        }
        
        if (record.getLocationId() != null) {
            SET("locationId = #{locationId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalStatus() != null) {
            SET("approvalStatus = #{approvalStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApprovalBy() != null) {
            SET("approvalBy = #{approvalBy,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalTime() != null) {
            SET("approvalTime = #{approvalTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApprovalText() != null) {
            SET("approvalText = #{approvalText,jdbcType=VARCHAR}");
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
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getReadNum() != null) {
            SET("readNum = #{readNum,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(PolicyEntityExample example, boolean includeExamplePhrase) {
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