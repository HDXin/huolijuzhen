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

import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample.Criterion;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample;
import java.util.List;
import java.util.Map;

public class ContractInfoEntitySqlProvider {

    public String countByExample(ContractInfoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("contract_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ContractInfoEntityExample example) {
        BEGIN();
        DELETE_FROM("contract_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ContractInfoEntity record) {
        BEGIN();
        INSERT_INTO("contract_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBusinessNum() != null) {
            VALUES("businessNum", "#{businessNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterpriseName() != null) {
            VALUES("enterpriseName", "#{enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getContNo() != null) {
            VALUES("contNo", "#{contNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            VALUES("startDate", "#{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            VALUES("endDate", "#{endDate,jdbcType=DATE}");
        }
        
        if (record.getProAddr() != null) {
            VALUES("proAddr", "#{proAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("area", "#{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            VALUES("totalMoney", "#{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDeposit() != null) {
            VALUES("deposit", "#{deposit,jdbcType=DECIMAL}");
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
        
        if (record.getContractStatus() != null) {
            VALUES("contractStatus", "#{contractStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateBy() != null) {
            VALUES("lastUpdateBy", "#{lastUpdateBy,jdbcType=BIGINT}");
        }
        
        if (record.getLastUpdateTime() != null) {
            VALUES("lastUpdateTime", "#{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutorId() != null) {
            VALUES("executorId", "#{executorId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalProcessId() != null) {
            VALUES("approvalProcessId", "#{approvalProcessId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(ContractInfoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("businessNum");
        SELECT("enterpriseName");
        SELECT("contNo");
        SELECT("startDate");
        SELECT("endDate");
        SELECT("proAddr");
        SELECT("area");
        SELECT("totalMoney");
        SELECT("deposit");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("contractStatus");
        SELECT("lastUpdateBy");
        SELECT("lastUpdateTime");
        SELECT("executorId");
        SELECT("approvalProcessId");
        FROM("contract_info");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ContractInfoEntity record = (ContractInfoEntity) parameter.get("record");
        ContractInfoEntityExample example = (ContractInfoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("contract_info");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBusinessNum() != null) {
            SET("businessNum = #{record.businessNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterpriseName() != null) {
            SET("enterpriseName = #{record.enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getContNo() != null) {
            SET("contNo = #{record.contNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            SET("startDate = #{record.startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("endDate = #{record.endDate,jdbcType=DATE}");
        }
        
        if (record.getProAddr() != null) {
            SET("proAddr = #{record.proAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{record.area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDeposit() != null) {
            SET("deposit = #{record.deposit,jdbcType=DECIMAL}");
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
        
        if (record.getContractStatus() != null) {
            SET("contractStatus = #{record.contractStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateBy() != null) {
            SET("lastUpdateBy = #{record.lastUpdateBy,jdbcType=BIGINT}");
        }
        
        if (record.getLastUpdateTime() != null) {
            SET("lastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutorId() != null) {
            SET("executorId = #{record.executorId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalProcessId() != null) {
            SET("approvalProcessId = #{record.approvalProcessId,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("contract_info");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("businessNum = #{record.businessNum,jdbcType=VARCHAR}");
        SET("enterpriseName = #{record.enterpriseName,jdbcType=VARCHAR}");
        SET("contNo = #{record.contNo,jdbcType=VARCHAR}");
        SET("startDate = #{record.startDate,jdbcType=DATE}");
        SET("endDate = #{record.endDate,jdbcType=DATE}");
        SET("proAddr = #{record.proAddr,jdbcType=VARCHAR}");
        SET("area = #{record.area,jdbcType=DECIMAL}");
        SET("totalMoney = #{record.totalMoney,jdbcType=DECIMAL}");
        SET("deposit = #{record.deposit,jdbcType=DECIMAL}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("contractStatus = #{record.contractStatus,jdbcType=INTEGER}");
        SET("lastUpdateBy = #{record.lastUpdateBy,jdbcType=BIGINT}");
        SET("lastUpdateTime = #{record.lastUpdateTime,jdbcType=TIMESTAMP}");
        SET("executorId = #{record.executorId,jdbcType=BIGINT}");
        SET("approvalProcessId = #{record.approvalProcessId,jdbcType=BIGINT}");
        
        ContractInfoEntityExample example = (ContractInfoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ContractInfoEntity record) {
        BEGIN();
        UPDATE("contract_info");
        
        if (record.getBusinessNum() != null) {
            SET("businessNum = #{businessNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterpriseName() != null) {
            SET("enterpriseName = #{enterpriseName,jdbcType=VARCHAR}");
        }
        
        if (record.getContNo() != null) {
            SET("contNo = #{contNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            SET("startDate = #{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("endDate = #{endDate,jdbcType=DATE}");
        }
        
        if (record.getProAddr() != null) {
            SET("proAddr = #{proAddr,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{area,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            SET("totalMoney = #{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDeposit() != null) {
            SET("deposit = #{deposit,jdbcType=DECIMAL}");
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
        
        if (record.getContractStatus() != null) {
            SET("contractStatus = #{contractStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLastUpdateBy() != null) {
            SET("lastUpdateBy = #{lastUpdateBy,jdbcType=BIGINT}");
        }
        
        if (record.getLastUpdateTime() != null) {
            SET("lastUpdateTime = #{lastUpdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutorId() != null) {
            SET("executorId = #{executorId,jdbcType=BIGINT}");
        }
        
        if (record.getApprovalProcessId() != null) {
            SET("approvalProcessId = #{approvalProcessId,jdbcType=BIGINT}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ContractInfoEntityExample example, boolean includeExamplePhrase) {
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