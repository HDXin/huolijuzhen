package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillCostDetailEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCostDetailEntityExample() {
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

        public Criteria andBillIdIsNull() {
            addCriterion("billId is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("billId is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Long value) {
            addCriterion("billId =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Long value) {
            addCriterion("billId <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Long value) {
            addCriterion("billId >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Long value) {
            addCriterion("billId >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Long value) {
            addCriterion("billId <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Long value) {
            addCriterion("billId <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Long> values) {
            addCriterion("billId in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Long> values) {
            addCriterion("billId not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Long value1, Long value2) {
            addCriterion("billId between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Long value1, Long value2) {
            addCriterion("billId not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBccrIdIsNull() {
            addCriterion("bccrId is null");
            return (Criteria) this;
        }

        public Criteria andBccrIdIsNotNull() {
            addCriterion("bccrId is not null");
            return (Criteria) this;
        }

        public Criteria andBccrIdEqualTo(Long value) {
            addCriterion("bccrId =", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotEqualTo(Long value) {
            addCriterion("bccrId <>", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdGreaterThan(Long value) {
            addCriterion("bccrId >", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bccrId >=", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdLessThan(Long value) {
            addCriterion("bccrId <", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdLessThanOrEqualTo(Long value) {
            addCriterion("bccrId <=", value, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdIn(List<Long> values) {
            addCriterion("bccrId in", values, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotIn(List<Long> values) {
            addCriterion("bccrId not in", values, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdBetween(Long value1, Long value2) {
            addCriterion("bccrId between", value1, value2, "bccrId");
            return (Criteria) this;
        }

        public Criteria andBccrIdNotBetween(Long value1, Long value2) {
            addCriterion("bccrId not between", value1, value2, "bccrId");
            return (Criteria) this;
        }

        public Criteria andDosageIsNull() {
            addCriterion("dosage is null");
            return (Criteria) this;
        }

        public Criteria andDosageIsNotNull() {
            addCriterion("dosage is not null");
            return (Criteria) this;
        }

        public Criteria andDosageEqualTo(BigDecimal value) {
            addCriterion("dosage =", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotEqualTo(BigDecimal value) {
            addCriterion("dosage <>", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThan(BigDecimal value) {
            addCriterion("dosage >", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dosage >=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThan(BigDecimal value) {
            addCriterion("dosage <", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dosage <=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageIn(List<BigDecimal> values) {
            addCriterion("dosage in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotIn(List<BigDecimal> values) {
            addCriterion("dosage not in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dosage between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dosage not between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andUnitPriseIsNull() {
            addCriterion("unitPrise is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriseIsNotNull() {
            addCriterion("unitPrise is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriseEqualTo(BigDecimal value) {
            addCriterion("unitPrise =", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseNotEqualTo(BigDecimal value) {
            addCriterion("unitPrise <>", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseGreaterThan(BigDecimal value) {
            addCriterion("unitPrise >", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unitPrise >=", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseLessThan(BigDecimal value) {
            addCriterion("unitPrise <", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unitPrise <=", value, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseIn(List<BigDecimal> values) {
            addCriterion("unitPrise in", values, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseNotIn(List<BigDecimal> values) {
            addCriterion("unitPrise not in", values, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitPrise between", value1, value2, "unitPrise");
            return (Criteria) this;
        }

        public Criteria andUnitPriseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitPrise not between", value1, value2, "unitPrise");
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

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("taxRate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("taxRate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("taxRate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("taxRate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("taxRate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxRate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("taxRate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxRate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("taxRate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("taxRate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxRate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxRate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIsNull() {
            addCriterion("taxMoney is null");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIsNotNull() {
            addCriterion("taxMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("taxMoney =", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("taxMoney <>", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("taxMoney >", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxMoney >=", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyLessThan(BigDecimal value) {
            addCriterion("taxMoney <", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxMoney <=", value, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("taxMoney in", values, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("taxMoney not in", values, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxMoney between", value1, value2, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxMoney not between", value1, value2, "taxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("totalMoney =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("totalMoney <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("totalMoney >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMoney >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("totalMoney <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMoney <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("totalMoney in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("totalMoney not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMoney between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMoney not between", value1, value2, "totalMoney");
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

        public Criteria andVerifyMoneyIsNull() {
            addCriterion("verifyMoney is null");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyIsNotNull() {
            addCriterion("verifyMoney is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyEqualTo(BigDecimal value) {
            addCriterion("verifyMoney =", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("verifyMoney <>", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyGreaterThan(BigDecimal value) {
            addCriterion("verifyMoney >", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("verifyMoney >=", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyLessThan(BigDecimal value) {
            addCriterion("verifyMoney <", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("verifyMoney <=", value, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyIn(List<BigDecimal> values) {
            addCriterion("verifyMoney in", values, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("verifyMoney not in", values, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("verifyMoney between", value1, value2, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andVerifyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("verifyMoney not between", value1, value2, "verifyMoney");
            return (Criteria) this;
        }

        public Criteria andIsTaskIsNull() {
            addCriterion("isTask is null");
            return (Criteria) this;
        }

        public Criteria andIsTaskIsNotNull() {
            addCriterion("isTask is not null");
            return (Criteria) this;
        }

        public Criteria andIsTaskEqualTo(Integer value) {
            addCriterion("isTask =", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskNotEqualTo(Integer value) {
            addCriterion("isTask <>", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskGreaterThan(Integer value) {
            addCriterion("isTask >", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskGreaterThanOrEqualTo(Integer value) {
            addCriterion("isTask >=", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskLessThan(Integer value) {
            addCriterion("isTask <", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskLessThanOrEqualTo(Integer value) {
            addCriterion("isTask <=", value, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskIn(List<Integer> values) {
            addCriterion("isTask in", values, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskNotIn(List<Integer> values) {
            addCriterion("isTask not in", values, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskBetween(Integer value1, Integer value2) {
            addCriterion("isTask between", value1, value2, "isTask");
            return (Criteria) this;
        }

        public Criteria andIsTaskNotBetween(Integer value1, Integer value2) {
            addCriterion("isTask not between", value1, value2, "isTask");
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