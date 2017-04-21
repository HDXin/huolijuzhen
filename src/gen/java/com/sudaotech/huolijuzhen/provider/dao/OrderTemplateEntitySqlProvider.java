package com.sudaotech.huolijuzhen.provider.dao;

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

import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityExample.Criterion;
import java.util.List;
import java.util.Map;

public class OrderTemplateEntitySqlProvider {

    public String countByExample(OrderTemplateEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("order_template");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderTemplateEntityExample example) {
        BEGIN();
        DELETE_FROM("order_template");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderTemplateEntity record) {
        BEGIN();
        INSERT_INTO("order_template");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceProId() != null) {
            VALUES("serviceProId", "#{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportAliPay() != null) {
            VALUES("supportAliPay", "#{supportAliPay,jdbcType=BIT}");
        }
        
        if (record.getSupportWeChatPay() != null) {
            VALUES("supportWeChatPay", "#{supportWeChatPay,jdbcType=BIT}");
        }
        
        if (record.getPriceTitleOne() != null) {
            VALUES("priceTitleOne", "#{priceTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleTwo() != null) {
            VALUES("priceTitleTwo", "#{priceTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleThree() != null) {
            VALUES("priceTitleThree", "#{priceTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleOne() != null) {
            VALUES("discountTitleOne", "#{discountTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleTwo() != null) {
            VALUES("discountTitleTwo", "#{discountTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleThree() != null) {
            VALUES("discountTitleThree", "#{discountTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountThree() != null) {
            VALUES("discountThree", "#{discountThree,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountOne() != null) {
            VALUES("discountOne", "#{discountOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceThree() != null) {
            VALUES("priceThree", "#{priceThree,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceOne() != null) {
            VALUES("priceOne", "#{priceOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceTwo() != null) {
            VALUES("priceTwo", "#{priceTwo,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountTwo() != null) {
            VALUES("discountTwo", "#{discountTwo,jdbcType=DOUBLE}");
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

    public String selectByExample(OrderTemplateEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("serviceProId");
        SELECT("supportAliPay");
        SELECT("supportWeChatPay");
        SELECT("priceTitleOne");
        SELECT("priceTitleTwo");
        SELECT("priceTitleThree");
        SELECT("discountTitleOne");
        SELECT("discountTitleTwo");
        SELECT("discountTitleThree");
        SELECT("discountThree");
        SELECT("discountOne");
        SELECT("priceThree");
        SELECT("priceOne");
        SELECT("priceTwo");
        SELECT("discountTwo");
        SELECT("version");
        SELECT("status");
        SELECT("createBy");
        SELECT("createTime");
        SELECT("updateBy");
        SELECT("updateTime");
        SELECT("lastUpdate");
        FROM("order_template");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderTemplateEntity record = (OrderTemplateEntity) parameter.get("record");
        OrderTemplateEntityExample example = (OrderTemplateEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("order_template");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportAliPay() != null) {
            SET("supportAliPay = #{record.supportAliPay,jdbcType=BIT}");
        }
        
        if (record.getSupportWeChatPay() != null) {
            SET("supportWeChatPay = #{record.supportWeChatPay,jdbcType=BIT}");
        }
        
        if (record.getPriceTitleOne() != null) {
            SET("priceTitleOne = #{record.priceTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleTwo() != null) {
            SET("priceTitleTwo = #{record.priceTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleThree() != null) {
            SET("priceTitleThree = #{record.priceTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleOne() != null) {
            SET("discountTitleOne = #{record.discountTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleTwo() != null) {
            SET("discountTitleTwo = #{record.discountTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleThree() != null) {
            SET("discountTitleThree = #{record.discountTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountThree() != null) {
            SET("discountThree = #{record.discountThree,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountOne() != null) {
            SET("discountOne = #{record.discountOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceThree() != null) {
            SET("priceThree = #{record.priceThree,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceOne() != null) {
            SET("priceOne = #{record.priceOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceTwo() != null) {
            SET("priceTwo = #{record.priceTwo,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountTwo() != null) {
            SET("discountTwo = #{record.discountTwo,jdbcType=DOUBLE}");
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
        UPDATE("order_template");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("serviceProId = #{record.serviceProId,jdbcType=BIGINT}");
        SET("supportAliPay = #{record.supportAliPay,jdbcType=BIT}");
        SET("supportWeChatPay = #{record.supportWeChatPay,jdbcType=BIT}");
        SET("priceTitleOne = #{record.priceTitleOne,jdbcType=VARCHAR}");
        SET("priceTitleTwo = #{record.priceTitleTwo,jdbcType=VARCHAR}");
        SET("priceTitleThree = #{record.priceTitleThree,jdbcType=VARCHAR}");
        SET("discountTitleOne = #{record.discountTitleOne,jdbcType=VARCHAR}");
        SET("discountTitleTwo = #{record.discountTitleTwo,jdbcType=VARCHAR}");
        SET("discountTitleThree = #{record.discountTitleThree,jdbcType=VARCHAR}");
        SET("discountThree = #{record.discountThree,jdbcType=DOUBLE}");
        SET("discountOne = #{record.discountOne,jdbcType=DOUBLE}");
        SET("priceThree = #{record.priceThree,jdbcType=DOUBLE}");
        SET("priceOne = #{record.priceOne,jdbcType=DOUBLE}");
        SET("priceTwo = #{record.priceTwo,jdbcType=DOUBLE}");
        SET("discountTwo = #{record.discountTwo,jdbcType=DOUBLE}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("createBy = #{record.createBy,jdbcType=BIGINT}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("updateBy = #{record.updateBy,jdbcType=BIGINT}");
        SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("lastUpdate = #{record.lastUpdate,jdbcType=TIMESTAMP}");
        
        OrderTemplateEntityExample example = (OrderTemplateEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderTemplateEntity record) {
        BEGIN();
        UPDATE("order_template");
        
        if (record.getServiceProId() != null) {
            SET("serviceProId = #{serviceProId,jdbcType=BIGINT}");
        }
        
        if (record.getSupportAliPay() != null) {
            SET("supportAliPay = #{supportAliPay,jdbcType=BIT}");
        }
        
        if (record.getSupportWeChatPay() != null) {
            SET("supportWeChatPay = #{supportWeChatPay,jdbcType=BIT}");
        }
        
        if (record.getPriceTitleOne() != null) {
            SET("priceTitleOne = #{priceTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleTwo() != null) {
            SET("priceTitleTwo = #{priceTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getPriceTitleThree() != null) {
            SET("priceTitleThree = #{priceTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleOne() != null) {
            SET("discountTitleOne = #{discountTitleOne,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleTwo() != null) {
            SET("discountTitleTwo = #{discountTitleTwo,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountTitleThree() != null) {
            SET("discountTitleThree = #{discountTitleThree,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscountThree() != null) {
            SET("discountThree = #{discountThree,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountOne() != null) {
            SET("discountOne = #{discountOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceThree() != null) {
            SET("priceThree = #{priceThree,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceOne() != null) {
            SET("priceOne = #{priceOne,jdbcType=DOUBLE}");
        }
        
        if (record.getPriceTwo() != null) {
            SET("priceTwo = #{priceTwo,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountTwo() != null) {
            SET("discountTwo = #{discountTwo,jdbcType=DOUBLE}");
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

    protected void applyWhere(OrderTemplateEntityExample example, boolean includeExamplePhrase) {
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