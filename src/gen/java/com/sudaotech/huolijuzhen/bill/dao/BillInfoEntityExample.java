package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;
import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillInfoEntityExample() {
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

        public Criteria andBillNoIsNull() {
            addCriterion("billNo is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("billNo is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("billNo =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("billNo <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("billNo >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("billNo >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("billNo <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("billNo <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("billNo like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("billNo not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("billNo in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("billNo not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("billNo between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("billNo not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("parkId is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("parkId is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Long value) {
            addCriterion("parkId =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Long value) {
            addCriterion("parkId <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Long value) {
            addCriterion("parkId >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parkId >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Long value) {
            addCriterion("parkId <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Long value) {
            addCriterion("parkId <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Long> values) {
            addCriterion("parkId in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Long> values) {
            addCriterion("parkId not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Long value1, Long value2) {
            addCriterion("parkId between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Long value1, Long value2) {
            addCriterion("parkId not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("companyId is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("companyId is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("companyId =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("companyId <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("companyId >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("companyId >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("companyId <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("companyId <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("companyId in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("companyId not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("companyId between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("companyId not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("companyName =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("companyName <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("companyName like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("companyName not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("companyName in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyName");
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

        public Criteria andContractNoIsNull() {
            addCriterion("contractNo is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contractNo is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contractNo =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contractNo <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contractNo >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contractNo >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contractNo <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contractNo <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contractNo like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contractNo not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contractNo in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contractNo not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contractNo between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contractNo not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNull() {
            addCriterion("billMonth is null");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNotNull() {
            addCriterion("billMonth is not null");
            return (Criteria) this;
        }

        public Criteria andBillMonthEqualTo(String value) {
            addCriterion("billMonth =", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotEqualTo(String value) {
            addCriterion("billMonth <>", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThan(String value) {
            addCriterion("billMonth >", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThanOrEqualTo(String value) {
            addCriterion("billMonth >=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThan(String value) {
            addCriterion("billMonth <", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThanOrEqualTo(String value) {
            addCriterion("billMonth <=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLike(String value) {
            addCriterion("billMonth like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotLike(String value) {
            addCriterion("billMonth not like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthIn(List<String> values) {
            addCriterion("billMonth in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotIn(List<String> values) {
            addCriterion("billMonth not in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthBetween(String value1, String value2) {
            addCriterion("billMonth between", value1, value2, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotBetween(String value1, String value2) {
            addCriterion("billMonth not between", value1, value2, "billMonth");
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

        public Criteria andTotalTaxMoneyIsNull() {
            addCriterion("totalTaxMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyIsNotNull() {
            addCriterion("totalTaxMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("totalTaxMoney =", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("totalTaxMoney <>", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("totalTaxMoney >", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalTaxMoney >=", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyLessThan(BigDecimal value) {
            addCriterion("totalTaxMoney <", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalTaxMoney <=", value, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("totalTaxMoney in", values, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("totalTaxMoney not in", values, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalTaxMoney between", value1, value2, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andTotalTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalTaxMoney not between", value1, value2, "totalTaxMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyIsNull() {
            addCriterion("reliefMoney is null");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyIsNotNull() {
            addCriterion("reliefMoney is not null");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyEqualTo(BigDecimal value) {
            addCriterion("reliefMoney =", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyNotEqualTo(BigDecimal value) {
            addCriterion("reliefMoney <>", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyGreaterThan(BigDecimal value) {
            addCriterion("reliefMoney >", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reliefMoney >=", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyLessThan(BigDecimal value) {
            addCriterion("reliefMoney <", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reliefMoney <=", value, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyIn(List<BigDecimal> values) {
            addCriterion("reliefMoney in", values, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyNotIn(List<BigDecimal> values) {
            addCriterion("reliefMoney not in", values, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reliefMoney between", value1, value2, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reliefMoney not between", value1, value2, "reliefMoney");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkIsNull() {
            addCriterion("reliefRemark is null");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkIsNotNull() {
            addCriterion("reliefRemark is not null");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkEqualTo(String value) {
            addCriterion("reliefRemark =", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkNotEqualTo(String value) {
            addCriterion("reliefRemark <>", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkGreaterThan(String value) {
            addCriterion("reliefRemark >", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("reliefRemark >=", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkLessThan(String value) {
            addCriterion("reliefRemark <", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkLessThanOrEqualTo(String value) {
            addCriterion("reliefRemark <=", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkLike(String value) {
            addCriterion("reliefRemark like", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkNotLike(String value) {
            addCriterion("reliefRemark not like", value, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkIn(List<String> values) {
            addCriterion("reliefRemark in", values, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkNotIn(List<String> values) {
            addCriterion("reliefRemark not in", values, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkBetween(String value1, String value2) {
            addCriterion("reliefRemark between", value1, value2, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andReliefRemarkNotBetween(String value1, String value2) {
            addCriterion("reliefRemark not between", value1, value2, "reliefRemark");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("totalAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("totalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("totalAmount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("totalAmount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("totalAmount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalAmount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("totalAmount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalAmount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("totalAmount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("totalAmount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalAmount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalAmount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("billStatus is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("billStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(BillStatus value) {
            addCriterion("billStatus =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(BillStatus value) {
            addCriterion("billStatus <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(BillStatus value) {
            addCriterion("billStatus >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(BillStatus value) {
            addCriterion("billStatus >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(BillStatus value) {
            addCriterion("billStatus <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(BillStatus value) {
            addCriterion("billStatus <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<BillStatus> values) {
            addCriterion("billStatus in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<BillStatus> values) {
            addCriterion("billStatus not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(BillStatus value1, BillStatus value2) {
            addCriterion("billStatus between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(BillStatus value1, BillStatus value2) {
            addCriterion("billStatus not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNull() {
            addCriterion("submitStatus is null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNotNull() {
            addCriterion("submitStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusEqualTo(BillSubmitStatus value) {
            addCriterion("submitStatus =", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotEqualTo(BillSubmitStatus value) {
            addCriterion("submitStatus <>", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThan(BillSubmitStatus value) {
            addCriterion("submitStatus >", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThanOrEqualTo(BillSubmitStatus value) {
            addCriterion("submitStatus >=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThan(BillSubmitStatus value) {
            addCriterion("submitStatus <", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThanOrEqualTo(BillSubmitStatus value) {
            addCriterion("submitStatus <=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIn(List<BillSubmitStatus> values) {
            addCriterion("submitStatus in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotIn(List<BillSubmitStatus> values) {
            addCriterion("submitStatus not in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusBetween(BillSubmitStatus value1, BillSubmitStatus value2) {
            addCriterion("submitStatus between", value1, value2, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotBetween(BillSubmitStatus value1, BillSubmitStatus value2) {
            addCriterion("submitStatus not between", value1, value2, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitByIsNull() {
            addCriterion("submitBy is null");
            return (Criteria) this;
        }

        public Criteria andSubmitByIsNotNull() {
            addCriterion("submitBy is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitByEqualTo(Long value) {
            addCriterion("submitBy =", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByNotEqualTo(Long value) {
            addCriterion("submitBy <>", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByGreaterThan(Long value) {
            addCriterion("submitBy >", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByGreaterThanOrEqualTo(Long value) {
            addCriterion("submitBy >=", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByLessThan(Long value) {
            addCriterion("submitBy <", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByLessThanOrEqualTo(Long value) {
            addCriterion("submitBy <=", value, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByIn(List<Long> values) {
            addCriterion("submitBy in", values, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByNotIn(List<Long> values) {
            addCriterion("submitBy not in", values, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByBetween(Long value1, Long value2) {
            addCriterion("submitBy between", value1, value2, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitByNotBetween(Long value1, Long value2) {
            addCriterion("submitBy not between", value1, value2, "submitBy");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submitTime =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submitTime <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submitTime >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submitTime >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submitTime <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submitTime <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submitTime in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submitTime not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submitTime between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submitTime not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approvalStatus is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approvalStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(BillApprovalStatus value) {
            addCriterion("approvalStatus =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(BillApprovalStatus value) {
            addCriterion("approvalStatus <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(BillApprovalStatus value) {
            addCriterion("approvalStatus >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(BillApprovalStatus value) {
            addCriterion("approvalStatus >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(BillApprovalStatus value) {
            addCriterion("approvalStatus <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(BillApprovalStatus value) {
            addCriterion("approvalStatus <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<BillApprovalStatus> values) {
            addCriterion("approvalStatus in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<BillApprovalStatus> values) {
            addCriterion("approvalStatus not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(BillApprovalStatus value1, BillApprovalStatus value2) {
            addCriterion("approvalStatus between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(BillApprovalStatus value1, BillApprovalStatus value2) {
            addCriterion("approvalStatus not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalByIsNull() {
            addCriterion("approvalBy is null");
            return (Criteria) this;
        }

        public Criteria andApprovalByIsNotNull() {
            addCriterion("approvalBy is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalByEqualTo(Long value) {
            addCriterion("approvalBy =", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotEqualTo(Long value) {
            addCriterion("approvalBy <>", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByGreaterThan(Long value) {
            addCriterion("approvalBy >", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalBy >=", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByLessThan(Long value) {
            addCriterion("approvalBy <", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByLessThanOrEqualTo(Long value) {
            addCriterion("approvalBy <=", value, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByIn(List<Long> values) {
            addCriterion("approvalBy in", values, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotIn(List<Long> values) {
            addCriterion("approvalBy not in", values, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByBetween(Long value1, Long value2) {
            addCriterion("approvalBy between", value1, value2, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalByNotBetween(Long value1, Long value2) {
            addCriterion("approvalBy not between", value1, value2, "approvalBy");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approvalTime is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approvalTime is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approvalTime =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approvalTime <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approvalTime >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approvalTime >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approvalTime <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approvalTime <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approvalTime in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approvalTime not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approvalTime between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approvalTime not between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNull() {
            addCriterion("pushStatus is null");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNotNull() {
            addCriterion("pushStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPushStatusEqualTo(BillPushStatus value) {
            addCriterion("pushStatus =", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotEqualTo(BillPushStatus value) {
            addCriterion("pushStatus <>", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThan(BillPushStatus value) {
            addCriterion("pushStatus >", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThanOrEqualTo(BillPushStatus value) {
            addCriterion("pushStatus >=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThan(BillPushStatus value) {
            addCriterion("pushStatus <", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThanOrEqualTo(BillPushStatus value) {
            addCriterion("pushStatus <=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusIn(List<BillPushStatus> values) {
            addCriterion("pushStatus in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotIn(List<BillPushStatus> values) {
            addCriterion("pushStatus not in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusBetween(BillPushStatus value1, BillPushStatus value2) {
            addCriterion("pushStatus between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotBetween(BillPushStatus value1, BillPushStatus value2) {
            addCriterion("pushStatus not between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushByIsNull() {
            addCriterion("pushBy is null");
            return (Criteria) this;
        }

        public Criteria andPushByIsNotNull() {
            addCriterion("pushBy is not null");
            return (Criteria) this;
        }

        public Criteria andPushByEqualTo(Long value) {
            addCriterion("pushBy =", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByNotEqualTo(Long value) {
            addCriterion("pushBy <>", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByGreaterThan(Long value) {
            addCriterion("pushBy >", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByGreaterThanOrEqualTo(Long value) {
            addCriterion("pushBy >=", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByLessThan(Long value) {
            addCriterion("pushBy <", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByLessThanOrEqualTo(Long value) {
            addCriterion("pushBy <=", value, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByIn(List<Long> values) {
            addCriterion("pushBy in", values, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByNotIn(List<Long> values) {
            addCriterion("pushBy not in", values, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByBetween(Long value1, Long value2) {
            addCriterion("pushBy between", value1, value2, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushByNotBetween(Long value1, Long value2) {
            addCriterion("pushBy not between", value1, value2, "pushBy");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("pushTime is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("pushTime is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("pushTime =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("pushTime <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("pushTime >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pushTime >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("pushTime <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("pushTime <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("pushTime in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("pushTime not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("pushTime between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("pushTime not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNull() {
            addCriterion("confirmStatus is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("confirmStatus is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(BillConfirmStatus value) {
            addCriterion("confirmStatus =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(BillConfirmStatus value) {
            addCriterion("confirmStatus <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(BillConfirmStatus value) {
            addCriterion("confirmStatus >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(BillConfirmStatus value) {
            addCriterion("confirmStatus >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(BillConfirmStatus value) {
            addCriterion("confirmStatus <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(BillConfirmStatus value) {
            addCriterion("confirmStatus <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<BillConfirmStatus> values) {
            addCriterion("confirmStatus in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<BillConfirmStatus> values) {
            addCriterion("confirmStatus not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(BillConfirmStatus value1, BillConfirmStatus value2) {
            addCriterion("confirmStatus between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(BillConfirmStatus value1, BillConfirmStatus value2) {
            addCriterion("confirmStatus not between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmByIsNull() {
            addCriterion("confirmBy is null");
            return (Criteria) this;
        }

        public Criteria andConfirmByIsNotNull() {
            addCriterion("confirmBy is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmByEqualTo(Long value) {
            addCriterion("confirmBy =", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByNotEqualTo(Long value) {
            addCriterion("confirmBy <>", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByGreaterThan(Long value) {
            addCriterion("confirmBy >", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByGreaterThanOrEqualTo(Long value) {
            addCriterion("confirmBy >=", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByLessThan(Long value) {
            addCriterion("confirmBy <", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByLessThanOrEqualTo(Long value) {
            addCriterion("confirmBy <=", value, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByIn(List<Long> values) {
            addCriterion("confirmBy in", values, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByNotIn(List<Long> values) {
            addCriterion("confirmBy not in", values, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByBetween(Long value1, Long value2) {
            addCriterion("confirmBy between", value1, value2, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmByNotBetween(Long value1, Long value2) {
            addCriterion("confirmBy not between", value1, value2, "confirmBy");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirmTime is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirmTime is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(Date value) {
            addCriterion("confirmTime =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(Date value) {
            addCriterion("confirmTime <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(Date value) {
            addCriterion("confirmTime >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("confirmTime >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(Date value) {
            addCriterion("confirmTime <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("confirmTime <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<Date> values) {
            addCriterion("confirmTime in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<Date> values) {
            addCriterion("confirmTime not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("confirmTime between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("confirmTime not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusIsNull() {
            addCriterion("verificationStatus is null");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusIsNotNull() {
            addCriterion("verificationStatus is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusEqualTo(BillVerificationStatus value) {
            addCriterion("verificationStatus =", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusNotEqualTo(BillVerificationStatus value) {
            addCriterion("verificationStatus <>", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusGreaterThan(BillVerificationStatus value) {
            addCriterion("verificationStatus >", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusGreaterThanOrEqualTo(BillVerificationStatus value) {
            addCriterion("verificationStatus >=", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusLessThan(BillVerificationStatus value) {
            addCriterion("verificationStatus <", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusLessThanOrEqualTo(BillVerificationStatus value) {
            addCriterion("verificationStatus <=", value, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusIn(List<BillVerificationStatus> values) {
            addCriterion("verificationStatus in", values, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusNotIn(List<BillVerificationStatus> values) {
            addCriterion("verificationStatus not in", values, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusBetween(BillVerificationStatus value1, BillVerificationStatus value2) {
            addCriterion("verificationStatus between", value1, value2, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationStatusNotBetween(BillVerificationStatus value1, BillVerificationStatus value2) {
            addCriterion("verificationStatus not between", value1, value2, "verificationStatus");
            return (Criteria) this;
        }

        public Criteria andVerificationByIsNull() {
            addCriterion("verificationBy is null");
            return (Criteria) this;
        }

        public Criteria andVerificationByIsNotNull() {
            addCriterion("verificationBy is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationByEqualTo(Long value) {
            addCriterion("verificationBy =", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByNotEqualTo(Long value) {
            addCriterion("verificationBy <>", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByGreaterThan(Long value) {
            addCriterion("verificationBy >", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByGreaterThanOrEqualTo(Long value) {
            addCriterion("verificationBy >=", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByLessThan(Long value) {
            addCriterion("verificationBy <", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByLessThanOrEqualTo(Long value) {
            addCriterion("verificationBy <=", value, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByIn(List<Long> values) {
            addCriterion("verificationBy in", values, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByNotIn(List<Long> values) {
            addCriterion("verificationBy not in", values, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByBetween(Long value1, Long value2) {
            addCriterion("verificationBy between", value1, value2, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationByNotBetween(Long value1, Long value2) {
            addCriterion("verificationBy not between", value1, value2, "verificationBy");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeIsNull() {
            addCriterion("verificationTime is null");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeIsNotNull() {
            addCriterion("verificationTime is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeEqualTo(Date value) {
            addCriterion("verificationTime =", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeNotEqualTo(Date value) {
            addCriterion("verificationTime <>", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeGreaterThan(Date value) {
            addCriterion("verificationTime >", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verificationTime >=", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeLessThan(Date value) {
            addCriterion("verificationTime <", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("verificationTime <=", value, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeIn(List<Date> values) {
            addCriterion("verificationTime in", values, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeNotIn(List<Date> values) {
            addCriterion("verificationTime not in", values, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeBetween(Date value1, Date value2) {
            addCriterion("verificationTime between", value1, value2, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andVerificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("verificationTime not between", value1, value2, "verificationTime");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusIsNull() {
            addCriterion("urgePushStatus is null");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusIsNotNull() {
            addCriterion("urgePushStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusEqualTo(BillUrgePushStatus value) {
            addCriterion("urgePushStatus =", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusNotEqualTo(BillUrgePushStatus value) {
            addCriterion("urgePushStatus <>", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusGreaterThan(BillUrgePushStatus value) {
            addCriterion("urgePushStatus >", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusGreaterThanOrEqualTo(BillUrgePushStatus value) {
            addCriterion("urgePushStatus >=", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusLessThan(BillUrgePushStatus value) {
            addCriterion("urgePushStatus <", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusLessThanOrEqualTo(BillUrgePushStatus value) {
            addCriterion("urgePushStatus <=", value, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusIn(List<BillUrgePushStatus> values) {
            addCriterion("urgePushStatus in", values, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusNotIn(List<BillUrgePushStatus> values) {
            addCriterion("urgePushStatus not in", values, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusBetween(BillUrgePushStatus value1, BillUrgePushStatus value2) {
            addCriterion("urgePushStatus between", value1, value2, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgePushStatusNotBetween(BillUrgePushStatus value1, BillUrgePushStatus value2) {
            addCriterion("urgePushStatus not between", value1, value2, "urgePushStatus");
            return (Criteria) this;
        }

        public Criteria andUrgeByIsNull() {
            addCriterion("urgeBy is null");
            return (Criteria) this;
        }

        public Criteria andUrgeByIsNotNull() {
            addCriterion("urgeBy is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeByEqualTo(Long value) {
            addCriterion("urgeBy =", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByNotEqualTo(Long value) {
            addCriterion("urgeBy <>", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByGreaterThan(Long value) {
            addCriterion("urgeBy >", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByGreaterThanOrEqualTo(Long value) {
            addCriterion("urgeBy >=", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByLessThan(Long value) {
            addCriterion("urgeBy <", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByLessThanOrEqualTo(Long value) {
            addCriterion("urgeBy <=", value, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByIn(List<Long> values) {
            addCriterion("urgeBy in", values, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByNotIn(List<Long> values) {
            addCriterion("urgeBy not in", values, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByBetween(Long value1, Long value2) {
            addCriterion("urgeBy between", value1, value2, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeByNotBetween(Long value1, Long value2) {
            addCriterion("urgeBy not between", value1, value2, "urgeBy");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNull() {
            addCriterion("urgeTime is null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNotNull() {
            addCriterion("urgeTime is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeEqualTo(Date value) {
            addCriterion("urgeTime =", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotEqualTo(Date value) {
            addCriterion("urgeTime <>", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThan(Date value) {
            addCriterion("urgeTime >", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("urgeTime >=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThan(Date value) {
            addCriterion("urgeTime <", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThanOrEqualTo(Date value) {
            addCriterion("urgeTime <=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIn(List<Date> values) {
            addCriterion("urgeTime in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotIn(List<Date> values) {
            addCriterion("urgeTime not in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeBetween(Date value1, Date value2) {
            addCriterion("urgeTime between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotBetween(Date value1, Date value2) {
            addCriterion("urgeTime not between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andPayBankIsNull() {
            addCriterion("payBank is null");
            return (Criteria) this;
        }

        public Criteria andPayBankIsNotNull() {
            addCriterion("payBank is not null");
            return (Criteria) this;
        }

        public Criteria andPayBankEqualTo(String value) {
            addCriterion("payBank =", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankNotEqualTo(String value) {
            addCriterion("payBank <>", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankGreaterThan(String value) {
            addCriterion("payBank >", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankGreaterThanOrEqualTo(String value) {
            addCriterion("payBank >=", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankLessThan(String value) {
            addCriterion("payBank <", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankLessThanOrEqualTo(String value) {
            addCriterion("payBank <=", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankLike(String value) {
            addCriterion("payBank like", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankNotLike(String value) {
            addCriterion("payBank not like", value, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankIn(List<String> values) {
            addCriterion("payBank in", values, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankNotIn(List<String> values) {
            addCriterion("payBank not in", values, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankBetween(String value1, String value2) {
            addCriterion("payBank between", value1, value2, "payBank");
            return (Criteria) this;
        }

        public Criteria andPayBankNotBetween(String value1, String value2) {
            addCriterion("payBank not between", value1, value2, "payBank");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberIsNull() {
            addCriterion("paySerialNumber is null");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberIsNotNull() {
            addCriterion("paySerialNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberEqualTo(String value) {
            addCriterion("paySerialNumber =", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberNotEqualTo(String value) {
            addCriterion("paySerialNumber <>", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberGreaterThan(String value) {
            addCriterion("paySerialNumber >", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("paySerialNumber >=", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberLessThan(String value) {
            addCriterion("paySerialNumber <", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberLessThanOrEqualTo(String value) {
            addCriterion("paySerialNumber <=", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberLike(String value) {
            addCriterion("paySerialNumber like", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberNotLike(String value) {
            addCriterion("paySerialNumber not like", value, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberIn(List<String> values) {
            addCriterion("paySerialNumber in", values, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberNotIn(List<String> values) {
            addCriterion("paySerialNumber not in", values, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberBetween(String value1, String value2) {
            addCriterion("paySerialNumber between", value1, value2, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumberNotBetween(String value1, String value2) {
            addCriterion("paySerialNumber not between", value1, value2, "paySerialNumber");
            return (Criteria) this;
        }

        public Criteria andNextAdjustIsNull() {
            addCriterion("nextAdjust is null");
            return (Criteria) this;
        }

        public Criteria andNextAdjustIsNotNull() {
            addCriterion("nextAdjust is not null");
            return (Criteria) this;
        }

        public Criteria andNextAdjustEqualTo(Integer value) {
            addCriterion("nextAdjust =", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustNotEqualTo(Integer value) {
            addCriterion("nextAdjust <>", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustGreaterThan(Integer value) {
            addCriterion("nextAdjust >", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustGreaterThanOrEqualTo(Integer value) {
            addCriterion("nextAdjust >=", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustLessThan(Integer value) {
            addCriterion("nextAdjust <", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustLessThanOrEqualTo(Integer value) {
            addCriterion("nextAdjust <=", value, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustIn(List<Integer> values) {
            addCriterion("nextAdjust in", values, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustNotIn(List<Integer> values) {
            addCriterion("nextAdjust not in", values, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustBetween(Integer value1, Integer value2) {
            addCriterion("nextAdjust between", value1, value2, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andNextAdjustNotBetween(Integer value1, Integer value2) {
            addCriterion("nextAdjust not between", value1, value2, "nextAdjust");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountIsNull() {
            addCriterion("adjustAmount is null");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountIsNotNull() {
            addCriterion("adjustAmount is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountEqualTo(BigDecimal value) {
            addCriterion("adjustAmount =", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountNotEqualTo(BigDecimal value) {
            addCriterion("adjustAmount <>", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountGreaterThan(BigDecimal value) {
            addCriterion("adjustAmount >", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjustAmount >=", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountLessThan(BigDecimal value) {
            addCriterion("adjustAmount <", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjustAmount <=", value, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountIn(List<BigDecimal> values) {
            addCriterion("adjustAmount in", values, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountNotIn(List<BigDecimal> values) {
            addCriterion("adjustAmount not in", values, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjustAmount between", value1, value2, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjustAmount not between", value1, value2, "adjustAmount");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkIsNull() {
            addCriterion("adjustRemark is null");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkIsNotNull() {
            addCriterion("adjustRemark is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkEqualTo(String value) {
            addCriterion("adjustRemark =", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkNotEqualTo(String value) {
            addCriterion("adjustRemark <>", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkGreaterThan(String value) {
            addCriterion("adjustRemark >", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("adjustRemark >=", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkLessThan(String value) {
            addCriterion("adjustRemark <", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkLessThanOrEqualTo(String value) {
            addCriterion("adjustRemark <=", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkLike(String value) {
            addCriterion("adjustRemark like", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkNotLike(String value) {
            addCriterion("adjustRemark not like", value, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkIn(List<String> values) {
            addCriterion("adjustRemark in", values, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkNotIn(List<String> values) {
            addCriterion("adjustRemark not in", values, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkBetween(String value1, String value2) {
            addCriterion("adjustRemark between", value1, value2, "adjustRemark");
            return (Criteria) this;
        }

        public Criteria andAdjustRemarkNotBetween(String value1, String value2) {
            addCriterion("adjustRemark not between", value1, value2, "adjustRemark");
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

        public Criteria andApprovalProcessIdIsNull() {
            addCriterion("approvalProcessId is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdIsNotNull() {
            addCriterion("approvalProcessId is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdEqualTo(Long value) {
            addCriterion("approvalProcessId =", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotEqualTo(Long value) {
            addCriterion("approvalProcessId <>", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdGreaterThan(Long value) {
            addCriterion("approvalProcessId >", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalProcessId >=", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdLessThan(Long value) {
            addCriterion("approvalProcessId <", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("approvalProcessId <=", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdIn(List<Long> values) {
            addCriterion("approvalProcessId in", values, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotIn(List<Long> values) {
            addCriterion("approvalProcessId not in", values, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdBetween(Long value1, Long value2) {
            addCriterion("approvalProcessId between", value1, value2, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("approvalProcessId not between", value1, value2, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdIsNull() {
            addCriterion("approvalExecutorId is null");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdIsNotNull() {
            addCriterion("approvalExecutorId is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdEqualTo(Long value) {
            addCriterion("approvalExecutorId =", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdNotEqualTo(Long value) {
            addCriterion("approvalExecutorId <>", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdGreaterThan(Long value) {
            addCriterion("approvalExecutorId >", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approvalExecutorId >=", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdLessThan(Long value) {
            addCriterion("approvalExecutorId <", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdLessThanOrEqualTo(Long value) {
            addCriterion("approvalExecutorId <=", value, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdIn(List<Long> values) {
            addCriterion("approvalExecutorId in", values, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdNotIn(List<Long> values) {
            addCriterion("approvalExecutorId not in", values, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdBetween(Long value1, Long value2) {
            addCriterion("approvalExecutorId between", value1, value2, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andApprovalExecutorIdNotBetween(Long value1, Long value2) {
            addCriterion("approvalExecutorId not between", value1, value2, "approvalExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdIsNull() {
            addCriterion("verifyProcessId is null");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdIsNotNull() {
            addCriterion("verifyProcessId is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdEqualTo(Long value) {
            addCriterion("verifyProcessId =", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdNotEqualTo(Long value) {
            addCriterion("verifyProcessId <>", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdGreaterThan(Long value) {
            addCriterion("verifyProcessId >", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("verifyProcessId >=", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdLessThan(Long value) {
            addCriterion("verifyProcessId <", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("verifyProcessId <=", value, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdIn(List<Long> values) {
            addCriterion("verifyProcessId in", values, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdNotIn(List<Long> values) {
            addCriterion("verifyProcessId not in", values, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdBetween(Long value1, Long value2) {
            addCriterion("verifyProcessId between", value1, value2, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("verifyProcessId not between", value1, value2, "verifyProcessId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdIsNull() {
            addCriterion("verifyExecutorId is null");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdIsNotNull() {
            addCriterion("verifyExecutorId is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdEqualTo(Long value) {
            addCriterion("verifyExecutorId =", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdNotEqualTo(Long value) {
            addCriterion("verifyExecutorId <>", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdGreaterThan(Long value) {
            addCriterion("verifyExecutorId >", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("verifyExecutorId >=", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdLessThan(Long value) {
            addCriterion("verifyExecutorId <", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdLessThanOrEqualTo(Long value) {
            addCriterion("verifyExecutorId <=", value, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdIn(List<Long> values) {
            addCriterion("verifyExecutorId in", values, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdNotIn(List<Long> values) {
            addCriterion("verifyExecutorId not in", values, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdBetween(Long value1, Long value2) {
            addCriterion("verifyExecutorId between", value1, value2, "verifyExecutorId");
            return (Criteria) this;
        }

        public Criteria andVerifyExecutorIdNotBetween(Long value1, Long value2) {
            addCriterion("verifyExecutorId not between", value1, value2, "verifyExecutorId");
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