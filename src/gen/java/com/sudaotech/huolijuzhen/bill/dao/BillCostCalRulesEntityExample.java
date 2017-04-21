package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ComputeMode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BillCostCalRulesEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCostCalRulesEntityExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andContractIdIsNull() {
            addCriterion("contractId is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contractId is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Long value) {
            addCriterion("contractId =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Long value) {
            addCriterion("contractId <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Long value) {
            addCriterion("contractId >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contractId >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Long value) {
            addCriterion("contractId <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Long value) {
            addCriterion("contractId <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Long> values) {
            addCriterion("contractId in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Long> values) {
            addCriterion("contractId not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Long value1, Long value2) {
            addCriterion("contractId between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Long value1, Long value2) {
            addCriterion("contractId not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andCostProIdIsNull() {
            addCriterion("costProId is null");
            return (Criteria) this;
        }

        public Criteria andCostProIdIsNotNull() {
            addCriterion("costProId is not null");
            return (Criteria) this;
        }

        public Criteria andCostProIdEqualTo(Long value) {
            addCriterion("costProId =", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdNotEqualTo(Long value) {
            addCriterion("costProId <>", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdGreaterThan(Long value) {
            addCriterion("costProId >", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("costProId >=", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdLessThan(Long value) {
            addCriterion("costProId <", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdLessThanOrEqualTo(Long value) {
            addCriterion("costProId <=", value, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdIn(List<Long> values) {
            addCriterion("costProId in", values, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdNotIn(List<Long> values) {
            addCriterion("costProId not in", values, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdBetween(Long value1, Long value2) {
            addCriterion("costProId between", value1, value2, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProIdNotBetween(Long value1, Long value2) {
            addCriterion("costProId not between", value1, value2, "costProId");
            return (Criteria) this;
        }

        public Criteria andCostProNameIsNull() {
            addCriterion("costProName is null");
            return (Criteria) this;
        }

        public Criteria andCostProNameIsNotNull() {
            addCriterion("costProName is not null");
            return (Criteria) this;
        }

        public Criteria andCostProNameEqualTo(String value) {
            addCriterion("costProName =", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameNotEqualTo(String value) {
            addCriterion("costProName <>", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameGreaterThan(String value) {
            addCriterion("costProName >", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameGreaterThanOrEqualTo(String value) {
            addCriterion("costProName >=", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameLessThan(String value) {
            addCriterion("costProName <", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameLessThanOrEqualTo(String value) {
            addCriterion("costProName <=", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameLike(String value) {
            addCriterion("costProName like", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameNotLike(String value) {
            addCriterion("costProName not like", value, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameIn(List<String> values) {
            addCriterion("costProName in", values, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameNotIn(List<String> values) {
            addCriterion("costProName not in", values, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameBetween(String value1, String value2) {
            addCriterion("costProName between", value1, value2, "costProName");
            return (Criteria) this;
        }

        public Criteria andCostProNameNotBetween(String value1, String value2) {
            addCriterion("costProName not between", value1, value2, "costProName");
            return (Criteria) this;
        }

        public Criteria andComputeModeIsNull() {
            addCriterion("computeMode is null");
            return (Criteria) this;
        }

        public Criteria andComputeModeIsNotNull() {
            addCriterion("computeMode is not null");
            return (Criteria) this;
        }

        public Criteria andComputeModeEqualTo(ComputeMode value) {
            addCriterion("computeMode =", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeNotEqualTo(ComputeMode value) {
            addCriterion("computeMode <>", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeGreaterThan(ComputeMode value) {
            addCriterion("computeMode >", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeGreaterThanOrEqualTo(ComputeMode value) {
            addCriterion("computeMode >=", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeLessThan(ComputeMode value) {
            addCriterion("computeMode <", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeLessThanOrEqualTo(ComputeMode value) {
            addCriterion("computeMode <=", value, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeIn(List<ComputeMode> values) {
            addCriterion("computeMode in", values, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeNotIn(List<ComputeMode> values) {
            addCriterion("computeMode not in", values, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeBetween(ComputeMode value1, ComputeMode value2) {
            addCriterion("computeMode between", value1, value2, "computeMode");
            return (Criteria) this;
        }

        public Criteria andComputeModeNotBetween(ComputeMode value1, ComputeMode value2) {
            addCriterion("computeMode not between", value1, value2, "computeMode");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIsNull() {
            addCriterion("freeMonth is null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIsNotNull() {
            addCriterion("freeMonth is not null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthEqualTo(Integer value) {
            addCriterion("freeMonth =", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotEqualTo(Integer value) {
            addCriterion("freeMonth <>", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthGreaterThan(Integer value) {
            addCriterion("freeMonth >", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeMonth >=", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthLessThan(Integer value) {
            addCriterion("freeMonth <", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthLessThanOrEqualTo(Integer value) {
            addCriterion("freeMonth <=", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIn(List<Integer> values) {
            addCriterion("freeMonth in", values, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotIn(List<Integer> values) {
            addCriterion("freeMonth not in", values, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthBetween(Integer value1, Integer value2) {
            addCriterion("freeMonth between", value1, value2, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("freeMonth not between", value1, value2, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthIsNull() {
            addCriterion("advanceMonth is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthIsNotNull() {
            addCriterion("advanceMonth is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthEqualTo(Integer value) {
            addCriterion("advanceMonth =", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthNotEqualTo(Integer value) {
            addCriterion("advanceMonth <>", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthGreaterThan(Integer value) {
            addCriterion("advanceMonth >", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanceMonth >=", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthLessThan(Integer value) {
            addCriterion("advanceMonth <", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthLessThanOrEqualTo(Integer value) {
            addCriterion("advanceMonth <=", value, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthIn(List<Integer> values) {
            addCriterion("advanceMonth in", values, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthNotIn(List<Integer> values) {
            addCriterion("advanceMonth not in", values, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthBetween(Integer value1, Integer value2) {
            addCriterion("advanceMonth between", value1, value2, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andAdvanceMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("advanceMonth not between", value1, value2, "advanceMonth");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIsNull() {
            addCriterion("fixedAmount is null");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIsNotNull() {
            addCriterion("fixedAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFixedAmountEqualTo(BigDecimal value) {
            addCriterion("fixedAmount =", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotEqualTo(BigDecimal value) {
            addCriterion("fixedAmount <>", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountGreaterThan(BigDecimal value) {
            addCriterion("fixedAmount >", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fixedAmount >=", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountLessThan(BigDecimal value) {
            addCriterion("fixedAmount <", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fixedAmount <=", value, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountIn(List<BigDecimal> values) {
            addCriterion("fixedAmount in", values, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotIn(List<BigDecimal> values) {
            addCriterion("fixedAmount not in", values, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixedAmount between", value1, value2, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andFixedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixedAmount not between", value1, value2, "fixedAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountIsNull() {
            addCriterion("startAdjAmount is null");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountIsNotNull() {
            addCriterion("startAdjAmount is not null");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountEqualTo(BigDecimal value) {
            addCriterion("startAdjAmount =", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountNotEqualTo(BigDecimal value) {
            addCriterion("startAdjAmount <>", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountGreaterThan(BigDecimal value) {
            addCriterion("startAdjAmount >", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("startAdjAmount >=", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountLessThan(BigDecimal value) {
            addCriterion("startAdjAmount <", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("startAdjAmount <=", value, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountIn(List<BigDecimal> values) {
            addCriterion("startAdjAmount in", values, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountNotIn(List<BigDecimal> values) {
            addCriterion("startAdjAmount not in", values, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("startAdjAmount between", value1, value2, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("startAdjAmount not between", value1, value2, "startAdjAmount");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthIsNull() {
            addCriterion("startAdjMonth is null");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthIsNotNull() {
            addCriterion("startAdjMonth is not null");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthEqualTo(String value) {
            addCriterion("startAdjMonth =", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthNotEqualTo(String value) {
            addCriterion("startAdjMonth <>", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthGreaterThan(String value) {
            addCriterion("startAdjMonth >", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthGreaterThanOrEqualTo(String value) {
            addCriterion("startAdjMonth >=", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthLessThan(String value) {
            addCriterion("startAdjMonth <", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthLessThanOrEqualTo(String value) {
            addCriterion("startAdjMonth <=", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthLike(String value) {
            addCriterion("startAdjMonth like", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthNotLike(String value) {
            addCriterion("startAdjMonth not like", value, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthIn(List<String> values) {
            addCriterion("startAdjMonth in", values, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthNotIn(List<String> values) {
            addCriterion("startAdjMonth not in", values, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthBetween(String value1, String value2) {
            addCriterion("startAdjMonth between", value1, value2, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andStartAdjMonthNotBetween(String value1, String value2) {
            addCriterion("startAdjMonth not between", value1, value2, "startAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountIsNull() {
            addCriterion("endAdjAmount is null");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountIsNotNull() {
            addCriterion("endAdjAmount is not null");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountEqualTo(BigDecimal value) {
            addCriterion("endAdjAmount =", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountNotEqualTo(BigDecimal value) {
            addCriterion("endAdjAmount <>", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountGreaterThan(BigDecimal value) {
            addCriterion("endAdjAmount >", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("endAdjAmount >=", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountLessThan(BigDecimal value) {
            addCriterion("endAdjAmount <", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("endAdjAmount <=", value, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountIn(List<BigDecimal> values) {
            addCriterion("endAdjAmount in", values, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountNotIn(List<BigDecimal> values) {
            addCriterion("endAdjAmount not in", values, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endAdjAmount between", value1, value2, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("endAdjAmount not between", value1, value2, "endAdjAmount");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthIsNull() {
            addCriterion("endAdjMonth is null");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthIsNotNull() {
            addCriterion("endAdjMonth is not null");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthEqualTo(String value) {
            addCriterion("endAdjMonth =", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthNotEqualTo(String value) {
            addCriterion("endAdjMonth <>", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthGreaterThan(String value) {
            addCriterion("endAdjMonth >", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthGreaterThanOrEqualTo(String value) {
            addCriterion("endAdjMonth >=", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthLessThan(String value) {
            addCriterion("endAdjMonth <", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthLessThanOrEqualTo(String value) {
            addCriterion("endAdjMonth <=", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthLike(String value) {
            addCriterion("endAdjMonth like", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthNotLike(String value) {
            addCriterion("endAdjMonth not like", value, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthIn(List<String> values) {
            addCriterion("endAdjMonth in", values, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthNotIn(List<String> values) {
            addCriterion("endAdjMonth not in", values, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthBetween(String value1, String value2) {
            addCriterion("endAdjMonth between", value1, value2, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andEndAdjMonthNotBetween(String value1, String value2) {
            addCriterion("endAdjMonth not between", value1, value2, "endAdjMonth");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalIsNull() {
            addCriterion("leaseAreaCal is null");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalIsNotNull() {
            addCriterion("leaseAreaCal is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalEqualTo(Integer value) {
            addCriterion("leaseAreaCal =", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalNotEqualTo(Integer value) {
            addCriterion("leaseAreaCal <>", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalGreaterThan(Integer value) {
            addCriterion("leaseAreaCal >", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalGreaterThanOrEqualTo(Integer value) {
            addCriterion("leaseAreaCal >=", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalLessThan(Integer value) {
            addCriterion("leaseAreaCal <", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalLessThanOrEqualTo(Integer value) {
            addCriterion("leaseAreaCal <=", value, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalIn(List<Integer> values) {
            addCriterion("leaseAreaCal in", values, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalNotIn(List<Integer> values) {
            addCriterion("leaseAreaCal not in", values, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalBetween(Integer value1, Integer value2) {
            addCriterion("leaseAreaCal between", value1, value2, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andLeaseAreaCalNotBetween(Integer value1, Integer value2) {
            addCriterion("leaseAreaCal not between", value1, value2, "leaseAreaCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalIsNull() {
            addCriterion("contAmountCal is null");
            return (Criteria) this;
        }

        public Criteria andContAmountCalIsNotNull() {
            addCriterion("contAmountCal is not null");
            return (Criteria) this;
        }

        public Criteria andContAmountCalEqualTo(Integer value) {
            addCriterion("contAmountCal =", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalNotEqualTo(Integer value) {
            addCriterion("contAmountCal <>", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalGreaterThan(Integer value) {
            addCriterion("contAmountCal >", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalGreaterThanOrEqualTo(Integer value) {
            addCriterion("contAmountCal >=", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalLessThan(Integer value) {
            addCriterion("contAmountCal <", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalLessThanOrEqualTo(Integer value) {
            addCriterion("contAmountCal <=", value, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalIn(List<Integer> values) {
            addCriterion("contAmountCal in", values, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalNotIn(List<Integer> values) {
            addCriterion("contAmountCal not in", values, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalBetween(Integer value1, Integer value2) {
            addCriterion("contAmountCal between", value1, value2, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andContAmountCalNotBetween(Integer value1, Integer value2) {
            addCriterion("contAmountCal not between", value1, value2, "contAmountCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalIsNull() {
            addCriterion("daysCal is null");
            return (Criteria) this;
        }

        public Criteria andDaysCalIsNotNull() {
            addCriterion("daysCal is not null");
            return (Criteria) this;
        }

        public Criteria andDaysCalEqualTo(Integer value) {
            addCriterion("daysCal =", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalNotEqualTo(Integer value) {
            addCriterion("daysCal <>", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalGreaterThan(Integer value) {
            addCriterion("daysCal >", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalGreaterThanOrEqualTo(Integer value) {
            addCriterion("daysCal >=", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalLessThan(Integer value) {
            addCriterion("daysCal <", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalLessThanOrEqualTo(Integer value) {
            addCriterion("daysCal <=", value, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalIn(List<Integer> values) {
            addCriterion("daysCal in", values, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalNotIn(List<Integer> values) {
            addCriterion("daysCal not in", values, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalBetween(Integer value1, Integer value2) {
            addCriterion("daysCal between", value1, value2, "daysCal");
            return (Criteria) this;
        }

        public Criteria andDaysCalNotBetween(Integer value1, Integer value2) {
            addCriterion("daysCal not between", value1, value2, "daysCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalIsNull() {
            addCriterion("isRollingCal is null");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalIsNotNull() {
            addCriterion("isRollingCal is not null");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalEqualTo(Integer value) {
            addCriterion("isRollingCal =", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalNotEqualTo(Integer value) {
            addCriterion("isRollingCal <>", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalGreaterThan(Integer value) {
            addCriterion("isRollingCal >", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalGreaterThanOrEqualTo(Integer value) {
            addCriterion("isRollingCal >=", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalLessThan(Integer value) {
            addCriterion("isRollingCal <", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalLessThanOrEqualTo(Integer value) {
            addCriterion("isRollingCal <=", value, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalIn(List<Integer> values) {
            addCriterion("isRollingCal in", values, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalNotIn(List<Integer> values) {
            addCriterion("isRollingCal not in", values, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalBetween(Integer value1, Integer value2) {
            addCriterion("isRollingCal between", value1, value2, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andIsRollingCalNotBetween(Integer value1, Integer value2) {
            addCriterion("isRollingCal not between", value1, value2, "isRollingCal");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthIsNull() {
            addCriterion("rollingStartMonth is null");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthIsNotNull() {
            addCriterion("rollingStartMonth is not null");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthEqualTo(Integer value) {
            addCriterion("rollingStartMonth =", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthNotEqualTo(Integer value) {
            addCriterion("rollingStartMonth <>", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthGreaterThan(Integer value) {
            addCriterion("rollingStartMonth >", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("rollingStartMonth >=", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthLessThan(Integer value) {
            addCriterion("rollingStartMonth <", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthLessThanOrEqualTo(Integer value) {
            addCriterion("rollingStartMonth <=", value, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthIn(List<Integer> values) {
            addCriterion("rollingStartMonth in", values, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthNotIn(List<Integer> values) {
            addCriterion("rollingStartMonth not in", values, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthBetween(Integer value1, Integer value2) {
            addCriterion("rollingStartMonth between", value1, value2, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingStartMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("rollingStartMonth not between", value1, value2, "rollingStartMonth");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodIsNull() {
            addCriterion("rollingPeriod is null");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodIsNotNull() {
            addCriterion("rollingPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodEqualTo(Integer value) {
            addCriterion("rollingPeriod =", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodNotEqualTo(Integer value) {
            addCriterion("rollingPeriod <>", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodGreaterThan(Integer value) {
            addCriterion("rollingPeriod >", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("rollingPeriod >=", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodLessThan(Integer value) {
            addCriterion("rollingPeriod <", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("rollingPeriod <=", value, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodIn(List<Integer> values) {
            addCriterion("rollingPeriod in", values, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodNotIn(List<Integer> values) {
            addCriterion("rollingPeriod not in", values, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodBetween(Integer value1, Integer value2) {
            addCriterion("rollingPeriod between", value1, value2, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("rollingPeriod not between", value1, value2, "rollingPeriod");
            return (Criteria) this;
        }

        public Criteria andRollingRangeIsNull() {
            addCriterion("rollingRange is null");
            return (Criteria) this;
        }

        public Criteria andRollingRangeIsNotNull() {
            addCriterion("rollingRange is not null");
            return (Criteria) this;
        }

        public Criteria andRollingRangeEqualTo(BigDecimal value) {
            addCriterion("rollingRange =", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeNotEqualTo(BigDecimal value) {
            addCriterion("rollingRange <>", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeGreaterThan(BigDecimal value) {
            addCriterion("rollingRange >", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rollingRange >=", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeLessThan(BigDecimal value) {
            addCriterion("rollingRange <", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rollingRange <=", value, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeIn(List<BigDecimal> values) {
            addCriterion("rollingRange in", values, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeNotIn(List<BigDecimal> values) {
            addCriterion("rollingRange not in", values, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rollingRange between", value1, value2, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andRollingRangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rollingRange not between", value1, value2, "rollingRange");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNull() {
            addCriterion("formula is null");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNotNull() {
            addCriterion("formula is not null");
            return (Criteria) this;
        }

        public Criteria andFormulaEqualTo(String value) {
            addCriterion("formula =", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotEqualTo(String value) {
            addCriterion("formula <>", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThan(String value) {
            addCriterion("formula >", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("formula >=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThan(String value) {
            addCriterion("formula <", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThanOrEqualTo(String value) {
            addCriterion("formula <=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLike(String value) {
            addCriterion("formula like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotLike(String value) {
            addCriterion("formula not like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaIn(List<String> values) {
            addCriterion("formula in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotIn(List<String> values) {
            addCriterion("formula not in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaBetween(String value1, String value2) {
            addCriterion("formula between", value1, value2, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotBetween(String value1, String value2) {
            addCriterion("formula not between", value1, value2, "formula");
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

        public Criteria andStartDateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("startDate =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("startDate >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("startDate <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("startDate in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("startDate not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("endDate =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("endDate >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("endDate <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("endDate in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("endDate not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate not between", value1, value2, "endDate");
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