package com.sudaotech.huolijuzhen.provider.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.enums.PayWay;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyOrderEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyOrderEntityExample() {
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

        public Criteria andApplyOrderNoIsNull() {
            addCriterion("applyOrderNo is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoIsNotNull() {
            addCriterion("applyOrderNo is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoEqualTo(String value) {
            addCriterion("applyOrderNo =", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoNotEqualTo(String value) {
            addCriterion("applyOrderNo <>", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoGreaterThan(String value) {
            addCriterion("applyOrderNo >", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("applyOrderNo >=", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoLessThan(String value) {
            addCriterion("applyOrderNo <", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoLessThanOrEqualTo(String value) {
            addCriterion("applyOrderNo <=", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoLike(String value) {
            addCriterion("applyOrderNo like", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoNotLike(String value) {
            addCriterion("applyOrderNo not like", value, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoIn(List<String> values) {
            addCriterion("applyOrderNo in", values, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoNotIn(List<String> values) {
            addCriterion("applyOrderNo not in", values, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoBetween(String value1, String value2) {
            addCriterion("applyOrderNo between", value1, value2, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderNoNotBetween(String value1, String value2) {
            addCriterion("applyOrderNo not between", value1, value2, "applyOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeIsNull() {
            addCriterion("applyOrderType is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeIsNotNull() {
            addCriterion("applyOrderType is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeEqualTo(ApplyOrderType value) {
            addCriterion("applyOrderType =", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeNotEqualTo(ApplyOrderType value) {
            addCriterion("applyOrderType <>", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeGreaterThan(ApplyOrderType value) {
            addCriterion("applyOrderType >", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeGreaterThanOrEqualTo(ApplyOrderType value) {
            addCriterion("applyOrderType >=", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeLessThan(ApplyOrderType value) {
            addCriterion("applyOrderType <", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeLessThanOrEqualTo(ApplyOrderType value) {
            addCriterion("applyOrderType <=", value, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeIn(List<ApplyOrderType> values) {
            addCriterion("applyOrderType in", values, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeNotIn(List<ApplyOrderType> values) {
            addCriterion("applyOrderType not in", values, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeBetween(ApplyOrderType value1, ApplyOrderType value2) {
            addCriterion("applyOrderType between", value1, value2, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderTypeNotBetween(ApplyOrderType value1, ApplyOrderType value2) {
            addCriterion("applyOrderType not between", value1, value2, "applyOrderType");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusIsNull() {
            addCriterion("applyOrderStatus is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusIsNotNull() {
            addCriterion("applyOrderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusEqualTo(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus =", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusNotEqualTo(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus <>", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusGreaterThan(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus >", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusGreaterThanOrEqualTo(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus >=", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusLessThan(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus <", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusLessThanOrEqualTo(ApplyOrderStatus value) {
            addCriterion("applyOrderStatus <=", value, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusIn(List<ApplyOrderStatus> values) {
            addCriterion("applyOrderStatus in", values, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusNotIn(List<ApplyOrderStatus> values) {
            addCriterion("applyOrderStatus not in", values, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusBetween(ApplyOrderStatus value1, ApplyOrderStatus value2) {
            addCriterion("applyOrderStatus between", value1, value2, "applyOrderStatus");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusNotBetween(ApplyOrderStatus value1, ApplyOrderStatus value2) {
            addCriterion("applyOrderStatus not between", value1, value2, "applyOrderStatus");
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterpriseId is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterpriseId is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Long value) {
            addCriterion("enterpriseId =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Long value) {
            addCriterion("enterpriseId <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Long value) {
            addCriterion("enterpriseId >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("enterpriseId >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Long value) {
            addCriterion("enterpriseId <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Long value) {
            addCriterion("enterpriseId <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Long> values) {
            addCriterion("enterpriseId in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Long> values) {
            addCriterion("enterpriseId not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Long value1, Long value2) {
            addCriterion("enterpriseId between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Long value1, Long value2) {
            addCriterion("enterpriseId not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterpriseName is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterpriseName is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterpriseName =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterpriseName <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterpriseName >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterpriseName >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterpriseName <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterpriseName <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterpriseName like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterpriseName not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterpriseName in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterpriseName not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterpriseName between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterpriseName not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoIsNull() {
            addCriterion("applyOrderStatusMemo is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoIsNotNull() {
            addCriterion("applyOrderStatusMemo is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoEqualTo(String value) {
            addCriterion("applyOrderStatusMemo =", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoNotEqualTo(String value) {
            addCriterion("applyOrderStatusMemo <>", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoGreaterThan(String value) {
            addCriterion("applyOrderStatusMemo >", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoGreaterThanOrEqualTo(String value) {
            addCriterion("applyOrderStatusMemo >=", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoLessThan(String value) {
            addCriterion("applyOrderStatusMemo <", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoLessThanOrEqualTo(String value) {
            addCriterion("applyOrderStatusMemo <=", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoLike(String value) {
            addCriterion("applyOrderStatusMemo like", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoNotLike(String value) {
            addCriterion("applyOrderStatusMemo not like", value, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoIn(List<String> values) {
            addCriterion("applyOrderStatusMemo in", values, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoNotIn(List<String> values) {
            addCriterion("applyOrderStatusMemo not in", values, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoBetween(String value1, String value2) {
            addCriterion("applyOrderStatusMemo between", value1, value2, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andApplyOrderStatusMemoNotBetween(String value1, String value2) {
            addCriterion("applyOrderStatusMemo not between", value1, value2, "applyOrderStatusMemo");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdIsNull() {
            addCriterion("billHistoryId is null");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdIsNotNull() {
            addCriterion("billHistoryId is not null");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdEqualTo(Long value) {
            addCriterion("billHistoryId =", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdNotEqualTo(Long value) {
            addCriterion("billHistoryId <>", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdGreaterThan(Long value) {
            addCriterion("billHistoryId >", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("billHistoryId >=", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdLessThan(Long value) {
            addCriterion("billHistoryId <", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdLessThanOrEqualTo(Long value) {
            addCriterion("billHistoryId <=", value, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdIn(List<Long> values) {
            addCriterion("billHistoryId in", values, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdNotIn(List<Long> values) {
            addCriterion("billHistoryId not in", values, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdBetween(Long value1, Long value2) {
            addCriterion("billHistoryId between", value1, value2, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andBillHistoryIdNotBetween(Long value1, Long value2) {
            addCriterion("billHistoryId not between", value1, value2, "billHistoryId");
            return (Criteria) this;
        }

        public Criteria andOrderMemoIsNull() {
            addCriterion("orderMemo is null");
            return (Criteria) this;
        }

        public Criteria andOrderMemoIsNotNull() {
            addCriterion("orderMemo is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMemoEqualTo(String value) {
            addCriterion("orderMemo =", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoNotEqualTo(String value) {
            addCriterion("orderMemo <>", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoGreaterThan(String value) {
            addCriterion("orderMemo >", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoGreaterThanOrEqualTo(String value) {
            addCriterion("orderMemo >=", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoLessThan(String value) {
            addCriterion("orderMemo <", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoLessThanOrEqualTo(String value) {
            addCriterion("orderMemo <=", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoLike(String value) {
            addCriterion("orderMemo like", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoNotLike(String value) {
            addCriterion("orderMemo not like", value, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoIn(List<String> values) {
            addCriterion("orderMemo in", values, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoNotIn(List<String> values) {
            addCriterion("orderMemo not in", values, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoBetween(String value1, String value2) {
            addCriterion("orderMemo between", value1, value2, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andOrderMemoNotBetween(String value1, String value2) {
            addCriterion("orderMemo not between", value1, value2, "orderMemo");
            return (Criteria) this;
        }

        public Criteria andPriceTitleIsNull() {
            addCriterion("priceTitle is null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleIsNotNull() {
            addCriterion("priceTitle is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTitleEqualTo(String value) {
            addCriterion("priceTitle =", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleNotEqualTo(String value) {
            addCriterion("priceTitle <>", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleGreaterThan(String value) {
            addCriterion("priceTitle >", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("priceTitle >=", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleLessThan(String value) {
            addCriterion("priceTitle <", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleLessThanOrEqualTo(String value) {
            addCriterion("priceTitle <=", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleLike(String value) {
            addCriterion("priceTitle like", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleNotLike(String value) {
            addCriterion("priceTitle not like", value, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleIn(List<String> values) {
            addCriterion("priceTitle in", values, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleNotIn(List<String> values) {
            addCriterion("priceTitle not in", values, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleBetween(String value1, String value2) {
            addCriterion("priceTitle between", value1, value2, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceTitleNotBetween(String value1, String value2) {
            addCriterion("priceTitle not between", value1, value2, "priceTitle");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("commentId is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("commentId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("commentId =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("commentId <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("commentId >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("commentId >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("commentId <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("commentId <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("commentId in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("commentId not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("commentId between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("commentId not between", value1, value2, "commentId");
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

        public Criteria andPayWayIsNull() {
            addCriterion("payWay is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("payWay is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(PayWay value) {
            addCriterion("payWay =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(PayWay value) {
            addCriterion("payWay <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(PayWay value) {
            addCriterion("payWay >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(PayWay value) {
            addCriterion("payWay >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(PayWay value) {
            addCriterion("payWay <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(PayWay value) {
            addCriterion("payWay <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<PayWay> values) {
            addCriterion("payWay in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<PayWay> values) {
            addCriterion("payWay not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(PayWay value1, PayWay value2) {
            addCriterion("payWay between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(PayWay value1, PayWay value2) {
            addCriterion("payWay not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseIsNull() {
            addCriterion("serviceProRelease is null");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseIsNotNull() {
            addCriterion("serviceProRelease is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseEqualTo(Integer value) {
            addCriterion("serviceProRelease =", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseNotEqualTo(Integer value) {
            addCriterion("serviceProRelease <>", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseGreaterThan(Integer value) {
            addCriterion("serviceProRelease >", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("serviceProRelease >=", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseLessThan(Integer value) {
            addCriterion("serviceProRelease <", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseLessThanOrEqualTo(Integer value) {
            addCriterion("serviceProRelease <=", value, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseIn(List<Integer> values) {
            addCriterion("serviceProRelease in", values, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseNotIn(List<Integer> values) {
            addCriterion("serviceProRelease not in", values, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseBetween(Integer value1, Integer value2) {
            addCriterion("serviceProRelease between", value1, value2, "serviceProRelease");
            return (Criteria) this;
        }

        public Criteria andServiceProReleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("serviceProRelease not between", value1, value2, "serviceProRelease");
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