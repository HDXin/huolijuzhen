package com.sudaotech.huolijuzhen.bill.dao;

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

import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class BillCostDetailEntitySqlProvider {

    public String countByExample(BillCostDetailEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bill_cost_detail");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BillCostDetailEntityExample example) {
        BEGIN();
        DELETE_FROM("bill_cost_detail");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BillCostDetailEntity record) {
        BEGIN();
        INSERT_INTO("bill_cost_detail");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            VALUES("billId", "#{billId,jdbcType=BIGINT}");
        }
        
        if (record.getBccrId() != null) {
            VALUES("bccrId", "#{bccrId,jdbcType=BIGINT}");
        }
        
        if (record.getDosage() != null) {
            VALUES("dosage", "#{dosage,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitPrise() != null) {
            VALUES("unitPrise", "#{unitPrise,jdbcType=DECIMAL}");
        }
        
        if (record.getCostProName() != null) {
            VALUES("costProName", "#{costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getCost() != null) {
            VALUES("cost", "#{cost,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxRate() != null) {
            VALUES("taxRate", "#{taxRate,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxMoney() != null) {
            VALUES("taxMoney", "#{taxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            VALUES("totalMoney", "#{totalMoney,jdbcType=DECIMAL}");
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
        
        if (record.getVerifyMoney() != null) {
            VALUES("verifyMoney", "#{verifyMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getIsTask() != null) {
            VALUES("isTask", "#{isTask,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(BillCostDetailEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("billId");
        SELECT("bccrId");
        SELECT("dosage");
        SELECT("unitPrise");
        SELECT("costProName");
        SELECT("cost");
        SELECT("taxRate");
        SELECT("taxMoney");
        SELECT("totalMoney");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("verifyMoney");
        SELECT("isTask");
        FROM("bill_cost_detail");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BillCostDetailEntity record = (BillCostDetailEntity) parameter.get("record");
        BillCostDetailEntityExample example = (BillCostDetailEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bill_cost_detail");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            SET("billId = #{record.billId,jdbcType=BIGINT}");
        }
        
        if (record.getBccrId() != null) {
            SET("bccrId = #{record.bccrId,jdbcType=BIGINT}");
        }
        
        if (record.getDosage() != null) {
            SET("dosage = #{record.dosage,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitPrise() != null) {
            SET("unitPrise = #{record.unitPrise,jdbcType=DECIMAL}");
        }
        
        if (record.getCostProName() != null) {
            SET("costProName = #{record.costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getCost() != null) {
            SET("cost = #{record.cost,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxRate() != null) {
            SET("taxRate = #{record.taxRate,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxMoney() != null) {
            SET("taxMoney = #{record.taxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
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
        
        if (record.getVerifyMoney() != null) {
            SET("verifyMoney = #{record.verifyMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getIsTask() != null) {
            SET("isTask = #{record.isTask,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bill_cost_detail");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("billId = #{record.billId,jdbcType=BIGINT}");
        SET("bccrId = #{record.bccrId,jdbcType=BIGINT}");
        SET("dosage = #{record.dosage,jdbcType=DECIMAL}");
        SET("unitPrise = #{record.unitPrise,jdbcType=DECIMAL}");
        SET("costProName = #{record.costProName,jdbcType=VARCHAR}");
        SET("cost = #{record.cost,jdbcType=DECIMAL}");
        SET("taxRate = #{record.taxRate,jdbcType=DECIMAL}");
        SET("taxMoney = #{record.taxMoney,jdbcType=DECIMAL}");
        SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("verifyMoney = #{record.verifyMoney,jdbcType=DECIMAL}");
        SET("isTask = #{record.isTask,jdbcType=INTEGER}");
        
        BillCostDetailEntityExample example = (BillCostDetailEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BillCostDetailEntity record) {
        BEGIN();
        UPDATE("bill_cost_detail");
        
        if (record.getBillId() != null) {
            SET("billId = #{billId,jdbcType=BIGINT}");
        }
        
        if (record.getBccrId() != null) {
            SET("bccrId = #{bccrId,jdbcType=BIGINT}");
        }
        
        if (record.getDosage() != null) {
            SET("dosage = #{dosage,jdbcType=DECIMAL}");
        }
        
        if (record.getUnitPrise() != null) {
            SET("unitPrise = #{unitPrise,jdbcType=DECIMAL}");
        }
        
        if (record.getCostProName() != null) {
            SET("costProName = #{costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getCost() != null) {
            SET("cost = #{cost,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxRate() != null) {
            SET("taxRate = #{taxRate,jdbcType=DECIMAL}");
        }
        
        if (record.getTaxMoney() != null) {
            SET("taxMoney = #{taxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{totalMoney,jdbcType=DECIMAL}");
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
        
        if (record.getVerifyMoney() != null) {
            SET("verifyMoney = #{verifyMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getIsTask() != null) {
            SET("isTask = #{isTask,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(BillCostDetailEntityExample example, boolean includeExamplePhrase) {
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