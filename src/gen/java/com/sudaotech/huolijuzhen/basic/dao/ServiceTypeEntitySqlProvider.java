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

import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntityExample.Criteria;
import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class ServiceTypeEntitySqlProvider {

    public String countByExample(ServiceTypeEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("service_type");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ServiceTypeEntityExample example) {
        BEGIN();
        DELETE_FROM("service_type");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ServiceTypeEntity record) {
        BEGIN();
        INSERT_INTO("service_type");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIsReco() != null) {
            VALUES("isReco", "#{isReco,jdbcType=BIT}");
        }
        
        if (record.getServerGrade() != null) {
            VALUES("serverGrade", "#{serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            VALUES("describle", "#{describle,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            VALUES("enableStatus", "#{enableStatus,jdbcType=INTEGER}");
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
        
        if (record.getRecoBy() != null) {
            VALUES("recoBy", "#{recoBy,jdbcType=BIGINT}");
        }
        
        if (record.getRecoTime() != null) {
            VALUES("recoTime", "#{recoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUnRecoBy() != null) {
            VALUES("unRecoBy", "#{unRecoBy,jdbcType=BIGINT}");
        }
        
        if (record.getUnRecoTime() != null) {
            VALUES("unRecoTime", "#{unRecoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTypeLogo() != null) {
            VALUES("typeLogo", "#{typeLogo,jdbcType=VARCHAR}");
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
        
        if (record.getRecoLogo() != null) {
            VALUES("recoLogo", "#{recoLogo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ServiceTypeEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("name");
        SELECT("isReco");
        SELECT("serverGrade");
        SELECT("describle");
        SELECT("enableStatus");
        SELECT("enableBy");
        SELECT("enableTime");
        SELECT("disableBy");
        SELECT("disableTime");
        SELECT("recoBy");
        SELECT("recoTime");
        SELECT("unRecoBy");
        SELECT("unRecoTime");
        SELECT("typeLogo");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        SELECT("recoLogo");
        FROM("service_type");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ServiceTypeEntity record = (ServiceTypeEntity) parameter.get("record");
        ServiceTypeEntityExample example = (ServiceTypeEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("service_type");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getIsReco() != null) {
            SET("isReco = #{record.isReco,jdbcType=BIT}");
        }
        
        if (record.getServerGrade() != null) {
            SET("serverGrade = #{record.serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            SET("describle = #{record.describle,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
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
        
        if (record.getRecoBy() != null) {
            SET("recoBy = #{record.recoBy,jdbcType=BIGINT}");
        }
        
        if (record.getRecoTime() != null) {
            SET("recoTime = #{record.recoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUnRecoBy() != null) {
            SET("unRecoBy = #{record.unRecoBy,jdbcType=BIGINT}");
        }
        
        if (record.getUnRecoTime() != null) {
            SET("unRecoTime = #{record.unRecoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTypeLogo() != null) {
            SET("typeLogo = #{record.typeLogo,jdbcType=VARCHAR}");
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
        
        if (record.getRecoLogo() != null) {
            SET("recoLogo = #{record.recoLogo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("service_type");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("isReco = #{record.isReco,jdbcType=BIT}");
        SET("serverGrade = #{record.serverGrade,jdbcType=INTEGER}");
        SET("describle = #{record.describle,jdbcType=VARCHAR}");
        SET("enableStatus = #{record.enableStatus,jdbcType=INTEGER}");
        SET("enableBy = #{record.enableBy,jdbcType=BIGINT}");
        SET("enableTime = #{record.enableTime,jdbcType=TIMESTAMP}");
        SET("disableBy = #{record.disableBy,jdbcType=BIGINT}");
        SET("disableTime = #{record.disableTime,jdbcType=TIMESTAMP}");
        SET("recoBy = #{record.recoBy,jdbcType=BIGINT}");
        SET("recoTime = #{record.recoTime,jdbcType=TIMESTAMP}");
        SET("unRecoBy = #{record.unRecoBy,jdbcType=BIGINT}");
        SET("unRecoTime = #{record.unRecoTime,jdbcType=TIMESTAMP}");
        SET("typeLogo = #{record.typeLogo,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        SET("recoLogo = #{record.recoLogo,jdbcType=VARCHAR}");
        
        ServiceTypeEntityExample example = (ServiceTypeEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ServiceTypeEntity record) {
        BEGIN();
        UPDATE("service_type");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIsReco() != null) {
            SET("isReco = #{isReco,jdbcType=BIT}");
        }
        
        if (record.getServerGrade() != null) {
            SET("serverGrade = #{serverGrade,jdbcType=INTEGER}");
        }
        
        if (record.getDescrible() != null) {
            SET("describle = #{describle,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enableStatus = #{enableStatus,jdbcType=INTEGER}");
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
        
        if (record.getRecoBy() != null) {
            SET("recoBy = #{recoBy,jdbcType=BIGINT}");
        }
        
        if (record.getRecoTime() != null) {
            SET("recoTime = #{recoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUnRecoBy() != null) {
            SET("unRecoBy = #{unRecoBy,jdbcType=BIGINT}");
        }
        
        if (record.getUnRecoTime() != null) {
            SET("unRecoTime = #{unRecoTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTypeLogo() != null) {
            SET("typeLogo = #{typeLogo,jdbcType=VARCHAR}");
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
        
        if (record.getRecoLogo() != null) {
            SET("recoLogo = #{recoLogo,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ServiceTypeEntityExample example, boolean includeExamplePhrase) {
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