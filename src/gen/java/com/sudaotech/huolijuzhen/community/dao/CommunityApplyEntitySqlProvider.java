package com.sudaotech.huolijuzhen.community.dao;

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

import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntityExample.Criteria;
import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class CommunityApplyEntitySqlProvider {

    public String countByExample(CommunityApplyEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("community_apply");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CommunityApplyEntityExample example) {
        BEGIN();
        DELETE_FROM("community_apply");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CommunityApplyEntity record) {
        BEGIN();
        INSERT_INTO("community_apply");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderNo() != null) {
            VALUES("orderNo", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            VALUES("companyId", "#{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            VALUES("companyName", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            VALUES("applyTime", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProprser() != null) {
            VALUES("proprser", "#{proprser,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            VALUES("describle", "#{describle,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            VALUES("communityId", "#{communityId,jdbcType=BIGINT}");
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
        
        if (record.getCreateSide() != null) {
            VALUES("createSide", "#{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            VALUES("createSideId", "#{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityName() != null) {
            VALUES("communityName", "#{communityName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(CommunityApplyEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("orderNo");
        SELECT("companyId");
        SELECT("companyName");
        SELECT("parkId");
        SELECT("applyTime");
        SELECT("proprser");
        SELECT("phone");
        SELECT("num");
        SELECT("describle");
        SELECT("communityId");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("approvalStatus");
        SELECT("approvalBy");
        SELECT("approvalTime");
        SELECT("approvalText");
        SELECT("createSide");
        SELECT("createSideId");
        SELECT("communityName");
        FROM("community_apply");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityApplyEntity record = (CommunityApplyEntity) parameter.get("record");
        CommunityApplyEntityExample example = (CommunityApplyEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("community_apply");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderNo() != null) {
            SET("orderNo = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            SET("applyTime = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProprser() != null) {
            SET("proprser = #{record.proprser,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{record.num,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            SET("describle = #{record.describle,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            SET("communityId = #{record.communityId,jdbcType=BIGINT}");
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
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityName() != null) {
            SET("communityName = #{record.communityName,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("community_apply");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("orderNo = #{record.orderNo,jdbcType=VARCHAR}");
        SET("companyId = #{record.companyId,jdbcType=BIGINT}");
        SET("companyName = #{record.companyName,jdbcType=VARCHAR}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("applyTime = #{record.applyTime,jdbcType=TIMESTAMP}");
        SET("proprser = #{record.proprser,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("num = #{record.num,jdbcType=INTEGER}");
        SET("describle = #{record.describle,jdbcType=VARCHAR}");
        SET("communityId = #{record.communityId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("approvalStatus = #{record.approvalStatus,jdbcType=INTEGER}");
        SET("approvalBy = #{record.approvalBy,jdbcType=BIGINT}");
        SET("approvalTime = #{record.approvalTime,jdbcType=TIMESTAMP}");
        SET("approvalText = #{record.approvalText,jdbcType=VARCHAR}");
        SET("createSide = #{record.createSide,jdbcType=INTEGER}");
        SET("createSideId = #{record.createSideId,jdbcType=BIGINT}");
        SET("communityName = #{record.communityName,jdbcType=VARCHAR}");
        
        CommunityApplyEntityExample example = (CommunityApplyEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CommunityApplyEntity record) {
        BEGIN();
        UPDATE("community_apply");
        
        if (record.getOrderNo() != null) {
            SET("orderNo = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            SET("companyId = #{companyId,jdbcType=BIGINT}");
        }
        
        if (record.getCompanyName() != null) {
            SET("companyName = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getApplyTime() != null) {
            SET("applyTime = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProprser() != null) {
            SET("proprser = #{proprser,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            SET("describle = #{describle,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            SET("communityId = #{communityId,jdbcType=BIGINT}");
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
        
        if (record.getCreateSide() != null) {
            SET("createSide = #{createSide,jdbcType=INTEGER}");
        }
        
        if (record.getCreateSideId() != null) {
            SET("createSideId = #{createSideId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityName() != null) {
            SET("communityName = #{communityName,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CommunityApplyEntityExample example, boolean includeExamplePhrase) {
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