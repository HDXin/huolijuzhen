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

import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class BillCostCalRulesEntitySqlProvider {

    public String countByExample(BillCostCalRulesEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bill_cost_cal_rules");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BillCostCalRulesEntityExample example) {
        BEGIN();
        DELETE_FROM("bill_cost_cal_rules");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BillCostCalRulesEntity record) {
        BEGIN();
        INSERT_INTO("bill_cost_cal_rules");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getContractId() != null) {
            VALUES("contractId", "#{contractId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProId() != null) {
            VALUES("costProId", "#{costProId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProName() != null) {
            VALUES("costProName", "#{costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getComputeMode() != null) {
            VALUES("computeMode", "#{computeMode,jdbcType=INTEGER}");
        }
        
        if (record.getFreeMonth() != null) {
            VALUES("freeMonth", "#{freeMonth,jdbcType=INTEGER}");
        }
        
        if (record.getAdvanceMonth() != null) {
            VALUES("advanceMonth", "#{advanceMonth,jdbcType=INTEGER}");
        }
        
        if (record.getFixedAmount() != null) {
            VALUES("fixedAmount", "#{fixedAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjAmount() != null) {
            VALUES("startAdjAmount", "#{startAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjMonth() != null) {
            VALUES("startAdjMonth", "#{startAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getEndAdjAmount() != null) {
            VALUES("endAdjAmount", "#{endAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEndAdjMonth() != null) {
            VALUES("endAdjMonth", "#{endAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaseAreaCal() != null) {
            VALUES("leaseAreaCal", "#{leaseAreaCal,jdbcType=INTEGER}");
        }
        
        if (record.getContAmountCal() != null) {
            VALUES("contAmountCal", "#{contAmountCal,jdbcType=INTEGER}");
        }
        
        if (record.getDaysCal() != null) {
            VALUES("daysCal", "#{daysCal,jdbcType=INTEGER}");
        }
        
        if (record.getIsRollingCal() != null) {
            VALUES("isRollingCal", "#{isRollingCal,jdbcType=INTEGER}");
        }
        
        if (record.getRollingStartMonth() != null) {
            VALUES("rollingStartMonth", "#{rollingStartMonth,jdbcType=INTEGER}");
        }
        
        if (record.getRollingPeriod() != null) {
            VALUES("rollingPeriod", "#{rollingPeriod,jdbcType=INTEGER}");
        }
        
        if (record.getRollingRange() != null) {
            VALUES("rollingRange", "#{rollingRange,jdbcType=DECIMAL}");
        }
        
        if (record.getFormula() != null) {
            VALUES("formula", "#{formula,jdbcType=VARCHAR}");
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
        
        if (record.getStartDate() != null) {
            VALUES("startDate", "#{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            VALUES("endDate", "#{endDate,jdbcType=DATE}");
        }
        
        return SQL();
    }

    public String selectByExample(BillCostCalRulesEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("contractId");
        SELECT("costProId");
        SELECT("costProName");
        SELECT("computeMode");
        SELECT("freeMonth");
        SELECT("advanceMonth");
        SELECT("fixedAmount");
        SELECT("startAdjAmount");
        SELECT("startAdjMonth");
        SELECT("endAdjAmount");
        SELECT("endAdjMonth");
        SELECT("leaseAreaCal");
        SELECT("contAmountCal");
        SELECT("daysCal");
        SELECT("isRollingCal");
        SELECT("rollingStartMonth");
        SELECT("rollingPeriod");
        SELECT("rollingRange");
        SELECT("formula");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("startDate");
        SELECT("endDate");
        FROM("bill_cost_cal_rules");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BillCostCalRulesEntity record = (BillCostCalRulesEntity) parameter.get("record");
        BillCostCalRulesEntityExample example = (BillCostCalRulesEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bill_cost_cal_rules");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getContractId() != null) {
            SET("contractId = #{record.contractId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProId() != null) {
            SET("costProId = #{record.costProId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProName() != null) {
            SET("costProName = #{record.costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getComputeMode() != null) {
            SET("computeMode = #{record.computeMode,jdbcType=INTEGER}");
        }
        
        if (record.getFreeMonth() != null) {
            SET("freeMonth = #{record.freeMonth,jdbcType=INTEGER}");
        }
        
        if (record.getAdvanceMonth() != null) {
            SET("advanceMonth = #{record.advanceMonth,jdbcType=INTEGER}");
        }
        
        if (record.getFixedAmount() != null) {
            SET("fixedAmount = #{record.fixedAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjAmount() != null) {
            SET("startAdjAmount = #{record.startAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjMonth() != null) {
            SET("startAdjMonth = #{record.startAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getEndAdjAmount() != null) {
            SET("endAdjAmount = #{record.endAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEndAdjMonth() != null) {
            SET("endAdjMonth = #{record.endAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaseAreaCal() != null) {
            SET("leaseAreaCal = #{record.leaseAreaCal,jdbcType=INTEGER}");
        }
        
        if (record.getContAmountCal() != null) {
            SET("contAmountCal = #{record.contAmountCal,jdbcType=INTEGER}");
        }
        
        if (record.getDaysCal() != null) {
            SET("daysCal = #{record.daysCal,jdbcType=INTEGER}");
        }
        
        if (record.getIsRollingCal() != null) {
            SET("isRollingCal = #{record.isRollingCal,jdbcType=INTEGER}");
        }
        
        if (record.getRollingStartMonth() != null) {
            SET("rollingStartMonth = #{record.rollingStartMonth,jdbcType=INTEGER}");
        }
        
        if (record.getRollingPeriod() != null) {
            SET("rollingPeriod = #{record.rollingPeriod,jdbcType=INTEGER}");
        }
        
        if (record.getRollingRange() != null) {
            SET("rollingRange = #{record.rollingRange,jdbcType=DECIMAL}");
        }
        
        if (record.getFormula() != null) {
            SET("formula = #{record.formula,jdbcType=VARCHAR}");
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
        
        if (record.getStartDate() != null) {
            SET("startDate = #{record.startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("endDate = #{record.endDate,jdbcType=DATE}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bill_cost_cal_rules");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("contractId = #{record.contractId,jdbcType=BIGINT}");
        SET("costProId = #{record.costProId,jdbcType=BIGINT}");
        SET("costProName = #{record.costProName,jdbcType=VARCHAR}");
        SET("computeMode = #{record.computeMode,jdbcType=INTEGER}");
        SET("freeMonth = #{record.freeMonth,jdbcType=INTEGER}");
        SET("advanceMonth = #{record.advanceMonth,jdbcType=INTEGER}");
        SET("fixedAmount = #{record.fixedAmount,jdbcType=DECIMAL}");
        SET("startAdjAmount = #{record.startAdjAmount,jdbcType=DECIMAL}");
        SET("startAdjMonth = #{record.startAdjMonth,jdbcType=VARCHAR}");
        SET("endAdjAmount = #{record.endAdjAmount,jdbcType=DECIMAL}");
        SET("endAdjMonth = #{record.endAdjMonth,jdbcType=VARCHAR}");
        SET("leaseAreaCal = #{record.leaseAreaCal,jdbcType=INTEGER}");
        SET("contAmountCal = #{record.contAmountCal,jdbcType=INTEGER}");
        SET("daysCal = #{record.daysCal,jdbcType=INTEGER}");
        SET("isRollingCal = #{record.isRollingCal,jdbcType=INTEGER}");
        SET("rollingStartMonth = #{record.rollingStartMonth,jdbcType=INTEGER}");
        SET("rollingPeriod = #{record.rollingPeriod,jdbcType=INTEGER}");
        SET("rollingRange = #{record.rollingRange,jdbcType=DECIMAL}");
        SET("formula = #{record.formula,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("startDate = #{record.startDate,jdbcType=DATE}");
        SET("endDate = #{record.endDate,jdbcType=DATE}");
        
        BillCostCalRulesEntityExample example = (BillCostCalRulesEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BillCostCalRulesEntity record) {
        BEGIN();
        UPDATE("bill_cost_cal_rules");
        
        if (record.getContractId() != null) {
            SET("contractId = #{contractId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProId() != null) {
            SET("costProId = #{costProId,jdbcType=BIGINT}");
        }
        
        if (record.getCostProName() != null) {
            SET("costProName = #{costProName,jdbcType=VARCHAR}");
        }
        
        if (record.getComputeMode() != null) {
            SET("computeMode = #{computeMode,jdbcType=INTEGER}");
        }
        
        if (record.getFreeMonth() != null) {
            SET("freeMonth = #{freeMonth,jdbcType=INTEGER}");
        }
        
        if (record.getAdvanceMonth() != null) {
            SET("advanceMonth = #{advanceMonth,jdbcType=INTEGER}");
        }
        
        if (record.getFixedAmount() != null) {
            SET("fixedAmount = #{fixedAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjAmount() != null) {
            SET("startAdjAmount = #{startAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getStartAdjMonth() != null) {
            SET("startAdjMonth = #{startAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getEndAdjAmount() != null) {
            SET("endAdjAmount = #{endAdjAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getEndAdjMonth() != null) {
            SET("endAdjMonth = #{endAdjMonth,jdbcType=VARCHAR}");
        }
        
        if (record.getLeaseAreaCal() != null) {
            SET("leaseAreaCal = #{leaseAreaCal,jdbcType=INTEGER}");
        }
        
        if (record.getContAmountCal() != null) {
            SET("contAmountCal = #{contAmountCal,jdbcType=INTEGER}");
        }
        
        if (record.getDaysCal() != null) {
            SET("daysCal = #{daysCal,jdbcType=INTEGER}");
        }
        
        if (record.getIsRollingCal() != null) {
            SET("isRollingCal = #{isRollingCal,jdbcType=INTEGER}");
        }
        
        if (record.getRollingStartMonth() != null) {
            SET("rollingStartMonth = #{rollingStartMonth,jdbcType=INTEGER}");
        }
        
        if (record.getRollingPeriod() != null) {
            SET("rollingPeriod = #{rollingPeriod,jdbcType=INTEGER}");
        }
        
        if (record.getRollingRange() != null) {
            SET("rollingRange = #{rollingRange,jdbcType=DECIMAL}");
        }
        
        if (record.getFormula() != null) {
            SET("formula = #{formula,jdbcType=VARCHAR}");
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
        
        if (record.getStartDate() != null) {
            SET("startDate = #{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("endDate = #{endDate,jdbcType=DATE}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(BillCostCalRulesEntityExample example, boolean includeExamplePhrase) {
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