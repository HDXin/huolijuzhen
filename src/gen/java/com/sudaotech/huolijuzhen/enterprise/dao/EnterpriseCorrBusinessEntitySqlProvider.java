package com.sudaotech.huolijuzhen.enterprise.dao;

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

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample.Criterion;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample;
import java.util.List;
import java.util.Map;

public class EnterpriseCorrBusinessEntitySqlProvider {

    public String countByExample(EnterpriseCorrBusinessEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("enterprise_corr_business");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EnterpriseCorrBusinessEntityExample example) {
        BEGIN();
        DELETE_FROM("enterprise_corr_business");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(EnterpriseCorrBusinessEntity record) {
        BEGIN();
        INSERT_INTO("enterprise_corr_business");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseCottId() != null) {
            VALUES("enterpriseCottId", "#{enterpriseCottId,jdbcType=BIGINT}");
        }
        
        if (record.getCottTime() != null) {
            VALUES("cottTime", "#{cottTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCottUser() != null) {
            VALUES("cottUser", "#{cottUser,jdbcType=BIGINT}");
        }
        
        if (record.getCottStatus() != null) {
            VALUES("cottStatus", "#{cottStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumber() != null) {
            VALUES("number", "#{number,jdbcType=INTEGER}");
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

    public String selectByExample(EnterpriseCorrBusinessEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("enterpriseCottId");
        SELECT("cottTime");
        SELECT("cottUser");
        SELECT("cottStatus");
        SELECT("number");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("enterprise_corr_business");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        EnterpriseCorrBusinessEntity record = (EnterpriseCorrBusinessEntity) parameter.get("record");
        EnterpriseCorrBusinessEntityExample example = (EnterpriseCorrBusinessEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("enterprise_corr_business");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEnterpriseCottId() != null) {
            SET("enterpriseCottId = #{record.enterpriseCottId,jdbcType=BIGINT}");
        }
        
        if (record.getCottTime() != null) {
            SET("cottTime = #{record.cottTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCottUser() != null) {
            SET("cottUser = #{record.cottUser,jdbcType=BIGINT}");
        }
        
        if (record.getCottStatus() != null) {
            SET("cottStatus = #{record.cottStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumber() != null) {
            SET("number = #{record.number,jdbcType=INTEGER}");
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
        UPDATE("enterprise_corr_business");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("enterpriseCottId = #{record.enterpriseCottId,jdbcType=BIGINT}");
        SET("cottTime = #{record.cottTime,jdbcType=TIMESTAMP}");
        SET("cottUser = #{record.cottUser,jdbcType=BIGINT}");
        SET("cottStatus = #{record.cottStatus,jdbcType=INTEGER}");
        SET("number = #{record.number,jdbcType=INTEGER}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        EnterpriseCorrBusinessEntityExample example = (EnterpriseCorrBusinessEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(EnterpriseCorrBusinessEntity record) {
        BEGIN();
        UPDATE("enterprise_corr_business");
        
        if (record.getEnterpriseCottId() != null) {
            SET("enterpriseCottId = #{enterpriseCottId,jdbcType=BIGINT}");
        }
        
        if (record.getCottTime() != null) {
            SET("cottTime = #{cottTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCottUser() != null) {
            SET("cottUser = #{cottUser,jdbcType=BIGINT}");
        }
        
        if (record.getCottStatus() != null) {
            SET("cottStatus = #{cottStatus,jdbcType=INTEGER}");
        }
        
        if (record.getNumber() != null) {
            SET("number = #{number,jdbcType=INTEGER}");
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

    protected void applyWhere(EnterpriseCorrBusinessEntityExample example, boolean includeExamplePhrase) {
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