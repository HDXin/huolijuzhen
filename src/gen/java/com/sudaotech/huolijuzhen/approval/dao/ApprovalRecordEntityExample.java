package com.sudaotech.huolijuzhen.approval.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApprovalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprovalRecordEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApprovalRecordEntityExample() {
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

        public Criteria andApprovalTypeIsNull() {
            addCriterion("approvalType is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeIsNotNull() {
            addCriterion("approvalType is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeEqualTo(ApprovalType value) {
            addCriterion("approvalType =", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeNotEqualTo(ApprovalType value) {
            addCriterion("approvalType <>", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeGreaterThan(ApprovalType value) {
            addCriterion("approvalType >", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeGreaterThanOrEqualTo(ApprovalType value) {
            addCriterion("approvalType >=", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeLessThan(ApprovalType value) {
            addCriterion("approvalType <", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeLessThanOrEqualTo(ApprovalType value) {
            addCriterion("approvalType <=", value, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeIn(List<ApprovalType> values) {
            addCriterion("approvalType in", values, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeNotIn(List<ApprovalType> values) {
            addCriterion("approvalType not in", values, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeBetween(ApprovalType value1, ApprovalType value2) {
            addCriterion("approvalType between", value1, value2, "approvalType");
            return (Criteria) this;
        }

        public Criteria andApprovalTypeNotBetween(ApprovalType value1, ApprovalType value2) {
            addCriterion("approvalType not between", value1, value2, "approvalType");
            return (Criteria) this;
        }

        public Criteria andMainIdIsNull() {
            addCriterion("mainId is null");
            return (Criteria) this;
        }

        public Criteria andMainIdIsNotNull() {
            addCriterion("mainId is not null");
            return (Criteria) this;
        }

        public Criteria andMainIdEqualTo(Long value) {
            addCriterion("mainId =", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotEqualTo(Long value) {
            addCriterion("mainId <>", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThan(Long value) {
            addCriterion("mainId >", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mainId >=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThan(Long value) {
            addCriterion("mainId <", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThanOrEqualTo(Long value) {
            addCriterion("mainId <=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdIn(List<Long> values) {
            addCriterion("mainId in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotIn(List<Long> values) {
            addCriterion("mainId not in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdBetween(Long value1, Long value2) {
            addCriterion("mainId between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotBetween(Long value1, Long value2) {
            addCriterion("mainId not between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIsNull() {
            addCriterion("approvalItemId is null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIsNotNull() {
            addCriterion("approvalItemId is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdEqualTo(Long value) {
            addCriterion("approvalItemId =", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotEqualTo(Long value) {
            addCriterion("approvalItemId <>", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdGreaterThan(Long value) {
            addCriterion("approvalItemId >", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalItemId >=", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdLessThan(Long value) {
            addCriterion("approvalItemId <", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdLessThanOrEqualTo(Long value) {
            addCriterion("approvalItemId <=", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIn(List<Long> values) {
            addCriterion("approvalItemId in", values, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotIn(List<Long> values) {
            addCriterion("approvalItemId not in", values, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdBetween(Long value1, Long value2) {
            addCriterion("approvalItemId between", value1, value2, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotBetween(Long value1, Long value2) {
            addCriterion("approvalItemId not between", value1, value2, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameIsNull() {
            addCriterion("approvalItemName is null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameIsNotNull() {
            addCriterion("approvalItemName is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameEqualTo(String value) {
            addCriterion("approvalItemName =", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameNotEqualTo(String value) {
            addCriterion("approvalItemName <>", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameGreaterThan(String value) {
            addCriterion("approvalItemName >", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("approvalItemName >=", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameLessThan(String value) {
            addCriterion("approvalItemName <", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameLessThanOrEqualTo(String value) {
            addCriterion("approvalItemName <=", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameLike(String value) {
            addCriterion("approvalItemName like", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameNotLike(String value) {
            addCriterion("approvalItemName not like", value, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameIn(List<String> values) {
            addCriterion("approvalItemName in", values, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameNotIn(List<String> values) {
            addCriterion("approvalItemName not in", values, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameBetween(String value1, String value2) {
            addCriterion("approvalItemName between", value1, value2, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNameNotBetween(String value1, String value2) {
            addCriterion("approvalItemName not between", value1, value2, "approvalItemName");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoIsNull() {
            addCriterion("approvalItemNo is null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoIsNotNull() {
            addCriterion("approvalItemNo is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoEqualTo(Integer value) {
            addCriterion("approvalItemNo =", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoNotEqualTo(Integer value) {
            addCriterion("approvalItemNo <>", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoGreaterThan(Integer value) {
            addCriterion("approvalItemNo >", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("approvalItemNo >=", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoLessThan(Integer value) {
            addCriterion("approvalItemNo <", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoLessThanOrEqualTo(Integer value) {
            addCriterion("approvalItemNo <=", value, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoIn(List<Integer> values) {
            addCriterion("approvalItemNo in", values, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoNotIn(List<Integer> values) {
            addCriterion("approvalItemNo not in", values, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoBetween(Integer value1, Integer value2) {
            addCriterion("approvalItemNo between", value1, value2, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemNoNotBetween(Integer value1, Integer value2) {
            addCriterion("approvalItemNo not between", value1, value2, "approvalItemNo");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionIsNull() {
            addCriterion("approvalItemVersion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionIsNotNull() {
            addCriterion("approvalItemVersion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionEqualTo(Integer value) {
            addCriterion("approvalItemVersion =", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionNotEqualTo(Integer value) {
            addCriterion("approvalItemVersion <>", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionGreaterThan(Integer value) {
            addCriterion("approvalItemVersion >", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("approvalItemVersion >=", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionLessThan(Integer value) {
            addCriterion("approvalItemVersion <", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionLessThanOrEqualTo(Integer value) {
            addCriterion("approvalItemVersion <=", value, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionIn(List<Integer> values) {
            addCriterion("approvalItemVersion in", values, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionNotIn(List<Integer> values) {
            addCriterion("approvalItemVersion not in", values, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionBetween(Integer value1, Integer value2) {
            addCriterion("approvalItemVersion between", value1, value2, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalItemVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("approvalItemVersion not between", value1, value2, "approvalItemVersion");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIsNull() {
            addCriterion("approvalId is null");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIsNotNull() {
            addCriterion("approvalId is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalIdEqualTo(Long value) {
            addCriterion("approvalId =", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotEqualTo(Long value) {
            addCriterion("approvalId <>", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdGreaterThan(Long value) {
            addCriterion("approvalId >", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalId >=", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdLessThan(Long value) {
            addCriterion("approvalId <", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdLessThanOrEqualTo(Long value) {
            addCriterion("approvalId <=", value, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdIn(List<Long> values) {
            addCriterion("approvalId in", values, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotIn(List<Long> values) {
            addCriterion("approvalId not in", values, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdBetween(Long value1, Long value2) {
            addCriterion("approvalId between", value1, value2, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalIdNotBetween(Long value1, Long value2) {
            addCriterion("approvalId not between", value1, value2, "approvalId");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIsNull() {
            addCriterion("approvalName is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIsNotNull() {
            addCriterion("approvalName is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameEqualTo(String value) {
            addCriterion("approvalName =", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotEqualTo(String value) {
            addCriterion("approvalName <>", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThan(String value) {
            addCriterion("approvalName >", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThanOrEqualTo(String value) {
            addCriterion("approvalName >=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThan(String value) {
            addCriterion("approvalName <", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThanOrEqualTo(String value) {
            addCriterion("approvalName <=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLike(String value) {
            addCriterion("approvalName like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotLike(String value) {
            addCriterion("approvalName not like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIn(List<String> values) {
            addCriterion("approvalName in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotIn(List<String> values) {
            addCriterion("approvalName not in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameBetween(String value1, String value2) {
            addCriterion("approvalName between", value1, value2, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotBetween(String value1, String value2) {
            addCriterion("approvalName not between", value1, value2, "approvalName");
            return (Criteria) this;
        }

        public Criteria andPassStatusIsNull() {
            addCriterion("passStatus is null");
            return (Criteria) this;
        }

        public Criteria andPassStatusIsNotNull() {
            addCriterion("passStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPassStatusEqualTo(Boolean value) {
            addCriterion("passStatus =", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusNotEqualTo(Boolean value) {
            addCriterion("passStatus <>", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusGreaterThan(Boolean value) {
            addCriterion("passStatus >", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("passStatus >=", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusLessThan(Boolean value) {
            addCriterion("passStatus <", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("passStatus <=", value, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusIn(List<Boolean> values) {
            addCriterion("passStatus in", values, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusNotIn(List<Boolean> values) {
            addCriterion("passStatus not in", values, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("passStatus between", value1, value2, "passStatus");
            return (Criteria) this;
        }

        public Criteria andPassStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("passStatus not between", value1, value2, "passStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoIsNull() {
            addCriterion("approvalMemo is null");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoIsNotNull() {
            addCriterion("approvalMemo is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoEqualTo(String value) {
            addCriterion("approvalMemo =", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoNotEqualTo(String value) {
            addCriterion("approvalMemo <>", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoGreaterThan(String value) {
            addCriterion("approvalMemo >", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoGreaterThanOrEqualTo(String value) {
            addCriterion("approvalMemo >=", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoLessThan(String value) {
            addCriterion("approvalMemo <", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoLessThanOrEqualTo(String value) {
            addCriterion("approvalMemo <=", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoLike(String value) {
            addCriterion("approvalMemo like", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoNotLike(String value) {
            addCriterion("approvalMemo not like", value, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoIn(List<String> values) {
            addCriterion("approvalMemo in", values, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoNotIn(List<String> values) {
            addCriterion("approvalMemo not in", values, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoBetween(String value1, String value2) {
            addCriterion("approvalMemo between", value1, value2, "approvalMemo");
            return (Criteria) this;
        }

        public Criteria andApprovalMemoNotBetween(String value1, String value2) {
            addCriterion("approvalMemo not between", value1, value2, "approvalMemo");
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