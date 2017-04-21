package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.core.enums.Status;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillCollectionRecordEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillCollectionRecordEntityExample() {
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

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collectionTime is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collectionTime is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Date value) {
            addCriterion("collectionTime =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Date value) {
            addCriterion("collectionTime <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Date value) {
            addCriterion("collectionTime >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collectionTime >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Date value) {
            addCriterion("collectionTime <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("collectionTime <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Date> values) {
            addCriterion("collectionTime in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Date> values) {
            addCriterion("collectionTime not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Date value1, Date value2) {
            addCriterion("collectionTime between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("collectionTime not between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionBankIsNull() {
            addCriterion("collectionBank is null");
            return (Criteria) this;
        }

        public Criteria andCollectionBankIsNotNull() {
            addCriterion("collectionBank is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionBankEqualTo(String value) {
            addCriterion("collectionBank =", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankNotEqualTo(String value) {
            addCriterion("collectionBank <>", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankGreaterThan(String value) {
            addCriterion("collectionBank >", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankGreaterThanOrEqualTo(String value) {
            addCriterion("collectionBank >=", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankLessThan(String value) {
            addCriterion("collectionBank <", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankLessThanOrEqualTo(String value) {
            addCriterion("collectionBank <=", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankLike(String value) {
            addCriterion("collectionBank like", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankNotLike(String value) {
            addCriterion("collectionBank not like", value, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankIn(List<String> values) {
            addCriterion("collectionBank in", values, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankNotIn(List<String> values) {
            addCriterion("collectionBank not in", values, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankBetween(String value1, String value2) {
            addCriterion("collectionBank between", value1, value2, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionBankNotBetween(String value1, String value2) {
            addCriterion("collectionBank not between", value1, value2, "collectionBank");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIsNull() {
            addCriterion("collectionAccount is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIsNotNull() {
            addCriterion("collectionAccount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountEqualTo(String value) {
            addCriterion("collectionAccount =", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountNotEqualTo(String value) {
            addCriterion("collectionAccount <>", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountGreaterThan(String value) {
            addCriterion("collectionAccount >", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountGreaterThanOrEqualTo(String value) {
            addCriterion("collectionAccount >=", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountLessThan(String value) {
            addCriterion("collectionAccount <", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountLessThanOrEqualTo(String value) {
            addCriterion("collectionAccount <=", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountLike(String value) {
            addCriterion("collectionAccount like", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountNotLike(String value) {
            addCriterion("collectionAccount not like", value, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIn(List<String> values) {
            addCriterion("collectionAccount in", values, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountNotIn(List<String> values) {
            addCriterion("collectionAccount not in", values, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountBetween(String value1, String value2) {
            addCriterion("collectionAccount between", value1, value2, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountNotBetween(String value1, String value2) {
            addCriterion("collectionAccount not between", value1, value2, "collectionAccount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIsNull() {
            addCriterion("collectionAmount is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIsNotNull() {
            addCriterion("collectionAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountEqualTo(BigDecimal value) {
            addCriterion("collectionAmount =", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotEqualTo(BigDecimal value) {
            addCriterion("collectionAmount <>", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountGreaterThan(BigDecimal value) {
            addCriterion("collectionAmount >", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collectionAmount >=", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountLessThan(BigDecimal value) {
            addCriterion("collectionAmount <", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collectionAmount <=", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIn(List<BigDecimal> values) {
            addCriterion("collectionAmount in", values, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotIn(List<BigDecimal> values) {
            addCriterion("collectionAmount not in", values, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collectionAmount between", value1, value2, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collectionAmount not between", value1, value2, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andPayChannelsIsNull() {
            addCriterion("payChannels is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelsIsNotNull() {
            addCriterion("payChannels is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelsEqualTo(String value) {
            addCriterion("payChannels =", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsNotEqualTo(String value) {
            addCriterion("payChannels <>", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsGreaterThan(String value) {
            addCriterion("payChannels >", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsGreaterThanOrEqualTo(String value) {
            addCriterion("payChannels >=", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsLessThan(String value) {
            addCriterion("payChannels <", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsLessThanOrEqualTo(String value) {
            addCriterion("payChannels <=", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsLike(String value) {
            addCriterion("payChannels like", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsNotLike(String value) {
            addCriterion("payChannels not like", value, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsIn(List<String> values) {
            addCriterion("payChannels in", values, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsNotIn(List<String> values) {
            addCriterion("payChannels not in", values, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsBetween(String value1, String value2) {
            addCriterion("payChannels between", value1, value2, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPayChannelsNotBetween(String value1, String value2) {
            addCriterion("payChannels not between", value1, value2, "payChannels");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumIsNull() {
            addCriterion("paySerialNum is null");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumIsNotNull() {
            addCriterion("paySerialNum is not null");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumEqualTo(String value) {
            addCriterion("paySerialNum =", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumNotEqualTo(String value) {
            addCriterion("paySerialNum <>", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumGreaterThan(String value) {
            addCriterion("paySerialNum >", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumGreaterThanOrEqualTo(String value) {
            addCriterion("paySerialNum >=", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumLessThan(String value) {
            addCriterion("paySerialNum <", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumLessThanOrEqualTo(String value) {
            addCriterion("paySerialNum <=", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumLike(String value) {
            addCriterion("paySerialNum like", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumNotLike(String value) {
            addCriterion("paySerialNum not like", value, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumIn(List<String> values) {
            addCriterion("paySerialNum in", values, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumNotIn(List<String> values) {
            addCriterion("paySerialNum not in", values, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumBetween(String value1, String value2) {
            addCriterion("paySerialNum between", value1, value2, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andPaySerialNumNotBetween(String value1, String value2) {
            addCriterion("paySerialNum not between", value1, value2, "paySerialNum");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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