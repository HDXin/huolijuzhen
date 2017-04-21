package com.sudaotech.huolijuzhen.basic.dao;

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

import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntity;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample.Criteria;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample.Criterion;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample;
import java.util.List;
import java.util.Map;

public class SystemConfigEntitySqlProvider {

    public String countByExample(SystemConfigEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("system_config");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SystemConfigEntityExample example) {
        BEGIN();
        DELETE_FROM("system_config");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SystemConfigEntity record) {
        BEGIN();
        INSERT_INTO("system_config");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParkId() != null) {
            VALUES("parkId", "#{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getMaintenanceReportSign() != null) {
            VALUES("maintenanceReportSign", "#{maintenanceReportSign,jdbcType=INTEGER}");
        }
        
        if (record.getMaintenanceReportDays() != null) {
            VALUES("maintenanceReportDays", "#{maintenanceReportDays,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkSign() != null) {
            VALUES("createParkSign", "#{createParkSign,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkDays() != null) {
            VALUES("createParkDays", "#{createParkDays,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainSign() != null) {
            VALUES("equipmentMaintainSign", "#{equipmentMaintainSign,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainDays() != null) {
            VALUES("equipmentMaintainDays", "#{equipmentMaintainDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermSign() != null) {
            VALUES("urgeTermSign", "#{urgeTermSign,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermDays() != null) {
            VALUES("urgeTermDays", "#{urgeTermDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeContentTemplate() != null) {
            VALUES("urgeContentTemplate", "#{urgeContentTemplate,jdbcType=VARCHAR}");
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
        
        if (record.getBillIntroduction() != null) {
            VALUES("billIntroduction", "#{billIntroduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBillPayWay() != null) {
            VALUES("billPayWay", "#{billPayWay,jdbcType=VARCHAR}");
        }
        
        if (record.getBillBankAccount() != null) {
            VALUES("billBankAccount", "#{billBankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBillInscrible() != null) {
            VALUES("billInscrible", "#{billInscrible,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SystemConfigEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("parkId");
        SELECT("maintenanceReportSign");
        SELECT("maintenanceReportDays");
        SELECT("createParkSign");
        SELECT("createParkDays");
        SELECT("equipmentMaintainSign");
        SELECT("equipmentMaintainDays");
        SELECT("urgeTermSign");
        SELECT("urgeTermDays");
        SELECT("urgeContentTemplate");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("billIntroduction");
        SELECT("billPayWay");
        SELECT("billBankAccount");
        SELECT("billInscrible");
        FROM("system_config");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SystemConfigEntity record = (SystemConfigEntity) parameter.get("record");
        SystemConfigEntityExample example = (SystemConfigEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("system_config");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getParkId() != null) {
            SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        }
        
        if (record.getMaintenanceReportSign() != null) {
            SET("maintenanceReportSign = #{record.maintenanceReportSign,jdbcType=INTEGER}");
        }
        
        if (record.getMaintenanceReportDays() != null) {
            SET("maintenanceReportDays = #{record.maintenanceReportDays,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkSign() != null) {
            SET("createParkSign = #{record.createParkSign,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkDays() != null) {
            SET("createParkDays = #{record.createParkDays,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainSign() != null) {
            SET("equipmentMaintainSign = #{record.equipmentMaintainSign,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainDays() != null) {
            SET("equipmentMaintainDays = #{record.equipmentMaintainDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermSign() != null) {
            SET("urgeTermSign = #{record.urgeTermSign,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermDays() != null) {
            SET("urgeTermDays = #{record.urgeTermDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeContentTemplate() != null) {
            SET("urgeContentTemplate = #{record.urgeContentTemplate,jdbcType=VARCHAR}");
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
        
        if (record.getBillIntroduction() != null) {
            SET("billIntroduction = #{record.billIntroduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBillPayWay() != null) {
            SET("billPayWay = #{record.billPayWay,jdbcType=VARCHAR}");
        }
        
        if (record.getBillBankAccount() != null) {
            SET("billBankAccount = #{record.billBankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBillInscrible() != null) {
            SET("billInscrible = #{record.billInscrible,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("system_config");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("parkId = #{record.parkId,jdbcType=BIGINT}");
        SET("maintenanceReportSign = #{record.maintenanceReportSign,jdbcType=INTEGER}");
        SET("maintenanceReportDays = #{record.maintenanceReportDays,jdbcType=INTEGER}");
        SET("createParkSign = #{record.createParkSign,jdbcType=INTEGER}");
        SET("createParkDays = #{record.createParkDays,jdbcType=INTEGER}");
        SET("equipmentMaintainSign = #{record.equipmentMaintainSign,jdbcType=INTEGER}");
        SET("equipmentMaintainDays = #{record.equipmentMaintainDays,jdbcType=INTEGER}");
        SET("urgeTermSign = #{record.urgeTermSign,jdbcType=INTEGER}");
        SET("urgeTermDays = #{record.urgeTermDays,jdbcType=INTEGER}");
        SET("urgeContentTemplate = #{record.urgeContentTemplate,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("billIntroduction = #{record.billIntroduction,jdbcType=VARCHAR}");
        SET("billPayWay = #{record.billPayWay,jdbcType=VARCHAR}");
        SET("billBankAccount = #{record.billBankAccount,jdbcType=VARCHAR}");
        SET("billInscrible = #{record.billInscrible,jdbcType=VARCHAR}");
        
        SystemConfigEntityExample example = (SystemConfigEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SystemConfigEntity record) {
        BEGIN();
        UPDATE("system_config");
        
        if (record.getParkId() != null) {
            SET("parkId = #{parkId,jdbcType=BIGINT}");
        }
        
        if (record.getMaintenanceReportSign() != null) {
            SET("maintenanceReportSign = #{maintenanceReportSign,jdbcType=INTEGER}");
        }
        
        if (record.getMaintenanceReportDays() != null) {
            SET("maintenanceReportDays = #{maintenanceReportDays,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkSign() != null) {
            SET("createParkSign = #{createParkSign,jdbcType=INTEGER}");
        }
        
        if (record.getCreateParkDays() != null) {
            SET("createParkDays = #{createParkDays,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainSign() != null) {
            SET("equipmentMaintainSign = #{equipmentMaintainSign,jdbcType=INTEGER}");
        }
        
        if (record.getEquipmentMaintainDays() != null) {
            SET("equipmentMaintainDays = #{equipmentMaintainDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermSign() != null) {
            SET("urgeTermSign = #{urgeTermSign,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeTermDays() != null) {
            SET("urgeTermDays = #{urgeTermDays,jdbcType=INTEGER}");
        }
        
        if (record.getUrgeContentTemplate() != null) {
            SET("urgeContentTemplate = #{urgeContentTemplate,jdbcType=VARCHAR}");
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
        
        if (record.getBillIntroduction() != null) {
            SET("billIntroduction = #{billIntroduction,jdbcType=VARCHAR}");
        }
        
        if (record.getBillPayWay() != null) {
            SET("billPayWay = #{billPayWay,jdbcType=VARCHAR}");
        }
        
        if (record.getBillBankAccount() != null) {
            SET("billBankAccount = #{billBankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getBillInscrible() != null) {
            SET("billInscrible = #{billInscrible,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(SystemConfigEntityExample example, boolean includeExamplePhrase) {
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