package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTemplateEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderTemplateEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andServiceProIdIsNull() {
            addCriterion("serviceProId is null");
            return (Criteria) this;
        }

        public Criteria andServiceProIdIsNotNull() {
            addCriterion("serviceProId is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProIdEqualTo(Long value) {
            addCriterion("serviceProId =", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdNotEqualTo(Long value) {
            addCriterion("serviceProId <>", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdGreaterThan(Long value) {
            addCriterion("serviceProId >", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("serviceProId >=", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdLessThan(Long value) {
            addCriterion("serviceProId <", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdLessThanOrEqualTo(Long value) {
            addCriterion("serviceProId <=", value, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdIn(List<Long> values) {
            addCriterion("serviceProId in", values, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdNotIn(List<Long> values) {
            addCriterion("serviceProId not in", values, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdBetween(Long value1, Long value2) {
            addCriterion("serviceProId between", value1, value2, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andServiceProIdNotBetween(Long value1, Long value2) {
            addCriterion("serviceProId not between", value1, value2, "serviceProId");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayIsNull() {
            addCriterion("supportAliPay is null");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayIsNotNull() {
            addCriterion("supportAliPay is not null");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayEqualTo(Boolean value) {
            addCriterion("supportAliPay =", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayNotEqualTo(Boolean value) {
            addCriterion("supportAliPay <>", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayGreaterThan(Boolean value) {
            addCriterion("supportAliPay >", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("supportAliPay >=", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayLessThan(Boolean value) {
            addCriterion("supportAliPay <", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayLessThanOrEqualTo(Boolean value) {
            addCriterion("supportAliPay <=", value, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayIn(List<Boolean> values) {
            addCriterion("supportAliPay in", values, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayNotIn(List<Boolean> values) {
            addCriterion("supportAliPay not in", values, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayBetween(Boolean value1, Boolean value2) {
            addCriterion("supportAliPay between", value1, value2, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportAliPayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("supportAliPay not between", value1, value2, "supportAliPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayIsNull() {
            addCriterion("supportWeChatPay is null");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayIsNotNull() {
            addCriterion("supportWeChatPay is not null");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayEqualTo(Boolean value) {
            addCriterion("supportWeChatPay =", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayNotEqualTo(Boolean value) {
            addCriterion("supportWeChatPay <>", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayGreaterThan(Boolean value) {
            addCriterion("supportWeChatPay >", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("supportWeChatPay >=", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayLessThan(Boolean value) {
            addCriterion("supportWeChatPay <", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayLessThanOrEqualTo(Boolean value) {
            addCriterion("supportWeChatPay <=", value, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayIn(List<Boolean> values) {
            addCriterion("supportWeChatPay in", values, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayNotIn(List<Boolean> values) {
            addCriterion("supportWeChatPay not in", values, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayBetween(Boolean value1, Boolean value2) {
            addCriterion("supportWeChatPay between", value1, value2, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andSupportWeChatPayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("supportWeChatPay not between", value1, value2, "supportWeChatPay");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneIsNull() {
            addCriterion("priceTitleOne is null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneIsNotNull() {
            addCriterion("priceTitleOne is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneEqualTo(String value) {
            addCriterion("priceTitleOne =", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneNotEqualTo(String value) {
            addCriterion("priceTitleOne <>", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneGreaterThan(String value) {
            addCriterion("priceTitleOne >", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneGreaterThanOrEqualTo(String value) {
            addCriterion("priceTitleOne >=", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneLessThan(String value) {
            addCriterion("priceTitleOne <", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneLessThanOrEqualTo(String value) {
            addCriterion("priceTitleOne <=", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneLike(String value) {
            addCriterion("priceTitleOne like", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneNotLike(String value) {
            addCriterion("priceTitleOne not like", value, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneIn(List<String> values) {
            addCriterion("priceTitleOne in", values, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneNotIn(List<String> values) {
            addCriterion("priceTitleOne not in", values, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneBetween(String value1, String value2) {
            addCriterion("priceTitleOne between", value1, value2, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleOneNotBetween(String value1, String value2) {
            addCriterion("priceTitleOne not between", value1, value2, "priceTitleOne");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoIsNull() {
            addCriterion("priceTitleTwo is null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoIsNotNull() {
            addCriterion("priceTitleTwo is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoEqualTo(String value) {
            addCriterion("priceTitleTwo =", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoNotEqualTo(String value) {
            addCriterion("priceTitleTwo <>", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoGreaterThan(String value) {
            addCriterion("priceTitleTwo >", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoGreaterThanOrEqualTo(String value) {
            addCriterion("priceTitleTwo >=", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoLessThan(String value) {
            addCriterion("priceTitleTwo <", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoLessThanOrEqualTo(String value) {
            addCriterion("priceTitleTwo <=", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoLike(String value) {
            addCriterion("priceTitleTwo like", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoNotLike(String value) {
            addCriterion("priceTitleTwo not like", value, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoIn(List<String> values) {
            addCriterion("priceTitleTwo in", values, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoNotIn(List<String> values) {
            addCriterion("priceTitleTwo not in", values, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoBetween(String value1, String value2) {
            addCriterion("priceTitleTwo between", value1, value2, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleTwoNotBetween(String value1, String value2) {
            addCriterion("priceTitleTwo not between", value1, value2, "priceTitleTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeIsNull() {
            addCriterion("priceTitleThree is null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeIsNotNull() {
            addCriterion("priceTitleThree is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeEqualTo(String value) {
            addCriterion("priceTitleThree =", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeNotEqualTo(String value) {
            addCriterion("priceTitleThree <>", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeGreaterThan(String value) {
            addCriterion("priceTitleThree >", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeGreaterThanOrEqualTo(String value) {
            addCriterion("priceTitleThree >=", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeLessThan(String value) {
            addCriterion("priceTitleThree <", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeLessThanOrEqualTo(String value) {
            addCriterion("priceTitleThree <=", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeLike(String value) {
            addCriterion("priceTitleThree like", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeNotLike(String value) {
            addCriterion("priceTitleThree not like", value, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeIn(List<String> values) {
            addCriterion("priceTitleThree in", values, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeNotIn(List<String> values) {
            addCriterion("priceTitleThree not in", values, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeBetween(String value1, String value2) {
            addCriterion("priceTitleThree between", value1, value2, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andPriceTitleThreeNotBetween(String value1, String value2) {
            addCriterion("priceTitleThree not between", value1, value2, "priceTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneIsNull() {
            addCriterion("discountTitleOne is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneIsNotNull() {
            addCriterion("discountTitleOne is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneEqualTo(String value) {
            addCriterion("discountTitleOne =", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneNotEqualTo(String value) {
            addCriterion("discountTitleOne <>", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneGreaterThan(String value) {
            addCriterion("discountTitleOne >", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneGreaterThanOrEqualTo(String value) {
            addCriterion("discountTitleOne >=", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneLessThan(String value) {
            addCriterion("discountTitleOne <", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneLessThanOrEqualTo(String value) {
            addCriterion("discountTitleOne <=", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneLike(String value) {
            addCriterion("discountTitleOne like", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneNotLike(String value) {
            addCriterion("discountTitleOne not like", value, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneIn(List<String> values) {
            addCriterion("discountTitleOne in", values, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneNotIn(List<String> values) {
            addCriterion("discountTitleOne not in", values, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneBetween(String value1, String value2) {
            addCriterion("discountTitleOne between", value1, value2, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleOneNotBetween(String value1, String value2) {
            addCriterion("discountTitleOne not between", value1, value2, "discountTitleOne");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoIsNull() {
            addCriterion("discountTitleTwo is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoIsNotNull() {
            addCriterion("discountTitleTwo is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoEqualTo(String value) {
            addCriterion("discountTitleTwo =", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoNotEqualTo(String value) {
            addCriterion("discountTitleTwo <>", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoGreaterThan(String value) {
            addCriterion("discountTitleTwo >", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoGreaterThanOrEqualTo(String value) {
            addCriterion("discountTitleTwo >=", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoLessThan(String value) {
            addCriterion("discountTitleTwo <", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoLessThanOrEqualTo(String value) {
            addCriterion("discountTitleTwo <=", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoLike(String value) {
            addCriterion("discountTitleTwo like", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoNotLike(String value) {
            addCriterion("discountTitleTwo not like", value, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoIn(List<String> values) {
            addCriterion("discountTitleTwo in", values, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoNotIn(List<String> values) {
            addCriterion("discountTitleTwo not in", values, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoBetween(String value1, String value2) {
            addCriterion("discountTitleTwo between", value1, value2, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleTwoNotBetween(String value1, String value2) {
            addCriterion("discountTitleTwo not between", value1, value2, "discountTitleTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeIsNull() {
            addCriterion("discountTitleThree is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeIsNotNull() {
            addCriterion("discountTitleThree is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeEqualTo(String value) {
            addCriterion("discountTitleThree =", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeNotEqualTo(String value) {
            addCriterion("discountTitleThree <>", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeGreaterThan(String value) {
            addCriterion("discountTitleThree >", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeGreaterThanOrEqualTo(String value) {
            addCriterion("discountTitleThree >=", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeLessThan(String value) {
            addCriterion("discountTitleThree <", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeLessThanOrEqualTo(String value) {
            addCriterion("discountTitleThree <=", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeLike(String value) {
            addCriterion("discountTitleThree like", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeNotLike(String value) {
            addCriterion("discountTitleThree not like", value, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeIn(List<String> values) {
            addCriterion("discountTitleThree in", values, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeNotIn(List<String> values) {
            addCriterion("discountTitleThree not in", values, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeBetween(String value1, String value2) {
            addCriterion("discountTitleThree between", value1, value2, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountTitleThreeNotBetween(String value1, String value2) {
            addCriterion("discountTitleThree not between", value1, value2, "discountTitleThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeIsNull() {
            addCriterion("discountThree is null");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeIsNotNull() {
            addCriterion("discountThree is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeEqualTo(Double value) {
            addCriterion("discountThree =", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeNotEqualTo(Double value) {
            addCriterion("discountThree <>", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeGreaterThan(Double value) {
            addCriterion("discountThree >", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeGreaterThanOrEqualTo(Double value) {
            addCriterion("discountThree >=", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeLessThan(Double value) {
            addCriterion("discountThree <", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeLessThanOrEqualTo(Double value) {
            addCriterion("discountThree <=", value, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeIn(List<Double> values) {
            addCriterion("discountThree in", values, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeNotIn(List<Double> values) {
            addCriterion("discountThree not in", values, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeBetween(Double value1, Double value2) {
            addCriterion("discountThree between", value1, value2, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountThreeNotBetween(Double value1, Double value2) {
            addCriterion("discountThree not between", value1, value2, "discountThree");
            return (Criteria) this;
        }

        public Criteria andDiscountOneIsNull() {
            addCriterion("discountOne is null");
            return (Criteria) this;
        }

        public Criteria andDiscountOneIsNotNull() {
            addCriterion("discountOne is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountOneEqualTo(Double value) {
            addCriterion("discountOne =", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneNotEqualTo(Double value) {
            addCriterion("discountOne <>", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneGreaterThan(Double value) {
            addCriterion("discountOne >", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneGreaterThanOrEqualTo(Double value) {
            addCriterion("discountOne >=", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneLessThan(Double value) {
            addCriterion("discountOne <", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneLessThanOrEqualTo(Double value) {
            addCriterion("discountOne <=", value, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneIn(List<Double> values) {
            addCriterion("discountOne in", values, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneNotIn(List<Double> values) {
            addCriterion("discountOne not in", values, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneBetween(Double value1, Double value2) {
            addCriterion("discountOne between", value1, value2, "discountOne");
            return (Criteria) this;
        }

        public Criteria andDiscountOneNotBetween(Double value1, Double value2) {
            addCriterion("discountOne not between", value1, value2, "discountOne");
            return (Criteria) this;
        }

        public Criteria andPriceThreeIsNull() {
            addCriterion("priceThree is null");
            return (Criteria) this;
        }

        public Criteria andPriceThreeIsNotNull() {
            addCriterion("priceThree is not null");
            return (Criteria) this;
        }

        public Criteria andPriceThreeEqualTo(Double value) {
            addCriterion("priceThree =", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeNotEqualTo(Double value) {
            addCriterion("priceThree <>", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeGreaterThan(Double value) {
            addCriterion("priceThree >", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeGreaterThanOrEqualTo(Double value) {
            addCriterion("priceThree >=", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeLessThan(Double value) {
            addCriterion("priceThree <", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeLessThanOrEqualTo(Double value) {
            addCriterion("priceThree <=", value, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeIn(List<Double> values) {
            addCriterion("priceThree in", values, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeNotIn(List<Double> values) {
            addCriterion("priceThree not in", values, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeBetween(Double value1, Double value2) {
            addCriterion("priceThree between", value1, value2, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceThreeNotBetween(Double value1, Double value2) {
            addCriterion("priceThree not between", value1, value2, "priceThree");
            return (Criteria) this;
        }

        public Criteria andPriceOneIsNull() {
            addCriterion("priceOne is null");
            return (Criteria) this;
        }

        public Criteria andPriceOneIsNotNull() {
            addCriterion("priceOne is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOneEqualTo(Double value) {
            addCriterion("priceOne =", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotEqualTo(Double value) {
            addCriterion("priceOne <>", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneGreaterThan(Double value) {
            addCriterion("priceOne >", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneGreaterThanOrEqualTo(Double value) {
            addCriterion("priceOne >=", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneLessThan(Double value) {
            addCriterion("priceOne <", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneLessThanOrEqualTo(Double value) {
            addCriterion("priceOne <=", value, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneIn(List<Double> values) {
            addCriterion("priceOne in", values, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotIn(List<Double> values) {
            addCriterion("priceOne not in", values, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneBetween(Double value1, Double value2) {
            addCriterion("priceOne between", value1, value2, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceOneNotBetween(Double value1, Double value2) {
            addCriterion("priceOne not between", value1, value2, "priceOne");
            return (Criteria) this;
        }

        public Criteria andPriceTwoIsNull() {
            addCriterion("priceTwo is null");
            return (Criteria) this;
        }

        public Criteria andPriceTwoIsNotNull() {
            addCriterion("priceTwo is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTwoEqualTo(Double value) {
            addCriterion("priceTwo =", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoNotEqualTo(Double value) {
            addCriterion("priceTwo <>", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoGreaterThan(Double value) {
            addCriterion("priceTwo >", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("priceTwo >=", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoLessThan(Double value) {
            addCriterion("priceTwo <", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoLessThanOrEqualTo(Double value) {
            addCriterion("priceTwo <=", value, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoIn(List<Double> values) {
            addCriterion("priceTwo in", values, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoNotIn(List<Double> values) {
            addCriterion("priceTwo not in", values, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoBetween(Double value1, Double value2) {
            addCriterion("priceTwo between", value1, value2, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andPriceTwoNotBetween(Double value1, Double value2) {
            addCriterion("priceTwo not between", value1, value2, "priceTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoIsNull() {
            addCriterion("discountTwo is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoIsNotNull() {
            addCriterion("discountTwo is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoEqualTo(Double value) {
            addCriterion("discountTwo =", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoNotEqualTo(Double value) {
            addCriterion("discountTwo <>", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoGreaterThan(Double value) {
            addCriterion("discountTwo >", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("discountTwo >=", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoLessThan(Double value) {
            addCriterion("discountTwo <", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoLessThanOrEqualTo(Double value) {
            addCriterion("discountTwo <=", value, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoIn(List<Double> values) {
            addCriterion("discountTwo in", values, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoNotIn(List<Double> values) {
            addCriterion("discountTwo not in", values, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoBetween(Double value1, Double value2) {
            addCriterion("discountTwo between", value1, value2, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andDiscountTwoNotBetween(Double value1, Double value2) {
            addCriterion("discountTwo not between", value1, value2, "discountTwo");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Status value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Status value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Status value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Status value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Status value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Status value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Status> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Status> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Status value1, Status value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Status value1, Status value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("createBy is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("createBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("createBy =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("createBy <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("createBy >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("createBy >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("createBy <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("createBy <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("createBy in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("createBy not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("createBy between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("createBy not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("updateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("updateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("updateBy =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("updateBy <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("updateBy >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("updateBy >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("updateBy <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("updateBy <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("updateBy in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("updateBy not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("updateBy between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("updateBy not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("lastUpdate is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("lastUpdate is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(Date value) {
            addCriterion("lastUpdate =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(Date value) {
            addCriterion("lastUpdate <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(Date value) {
            addCriterion("lastUpdate >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdate >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(Date value) {
            addCriterion("lastUpdate <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdate <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<Date> values) {
            addCriterion("lastUpdate in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<Date> values) {
            addCriterion("lastUpdate not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(Date value1, Date value2) {
            addCriterion("lastUpdate between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdate not between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}