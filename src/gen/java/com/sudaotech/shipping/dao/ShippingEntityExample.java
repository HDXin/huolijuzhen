package com.sudaotech.shipping.dao;

import com.sudaotech.core.enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShippingEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShippingEntityExample() {
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

        public Criteria andShippingIdIsNull() {
            addCriterion("shippingId is null");
            return (Criteria) this;
        }

        public Criteria andShippingIdIsNotNull() {
            addCriterion("shippingId is not null");
            return (Criteria) this;
        }

        public Criteria andShippingIdEqualTo(Long value) {
            addCriterion("shippingId =", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotEqualTo(Long value) {
            addCriterion("shippingId <>", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdGreaterThan(Long value) {
            addCriterion("shippingId >", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shippingId >=", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdLessThan(Long value) {
            addCriterion("shippingId <", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdLessThanOrEqualTo(Long value) {
            addCriterion("shippingId <=", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdIn(List<Long> values) {
            addCriterion("shippingId in", values, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotIn(List<Long> values) {
            addCriterion("shippingId not in", values, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdBetween(Long value1, Long value2) {
            addCriterion("shippingId between", value1, value2, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotBetween(Long value1, Long value2) {
            addCriterion("shippingId not between", value1, value2, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingNoIsNull() {
            addCriterion("shippingNo is null");
            return (Criteria) this;
        }

        public Criteria andShippingNoIsNotNull() {
            addCriterion("shippingNo is not null");
            return (Criteria) this;
        }

        public Criteria andShippingNoEqualTo(String value) {
            addCriterion("shippingNo =", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoNotEqualTo(String value) {
            addCriterion("shippingNo <>", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoGreaterThan(String value) {
            addCriterion("shippingNo >", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoGreaterThanOrEqualTo(String value) {
            addCriterion("shippingNo >=", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoLessThan(String value) {
            addCriterion("shippingNo <", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoLessThanOrEqualTo(String value) {
            addCriterion("shippingNo <=", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoLike(String value) {
            addCriterion("shippingNo like", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoNotLike(String value) {
            addCriterion("shippingNo not like", value, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoIn(List<String> values) {
            addCriterion("shippingNo in", values, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoNotIn(List<String> values) {
            addCriterion("shippingNo not in", values, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoBetween(String value1, String value2) {
            addCriterion("shippingNo between", value1, value2, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingNoNotBetween(String value1, String value2) {
            addCriterion("shippingNo not between", value1, value2, "shippingNo");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIsNull() {
            addCriterion("shippingCompany is null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIsNotNull() {
            addCriterion("shippingCompany is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyEqualTo(String value) {
            addCriterion("shippingCompany =", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotEqualTo(String value) {
            addCriterion("shippingCompany <>", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyGreaterThan(String value) {
            addCriterion("shippingCompany >", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("shippingCompany >=", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLessThan(String value) {
            addCriterion("shippingCompany <", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLessThanOrEqualTo(String value) {
            addCriterion("shippingCompany <=", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyLike(String value) {
            addCriterion("shippingCompany like", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotLike(String value) {
            addCriterion("shippingCompany not like", value, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIn(List<String> values) {
            addCriterion("shippingCompany in", values, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotIn(List<String> values) {
            addCriterion("shippingCompany not in", values, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyBetween(String value1, String value2) {
            addCriterion("shippingCompany between", value1, value2, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyNotBetween(String value1, String value2) {
            addCriterion("shippingCompany not between", value1, value2, "shippingCompany");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdIsNull() {
            addCriterion("shippingCompanyId is null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdIsNotNull() {
            addCriterion("shippingCompanyId is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdEqualTo(String value) {
            addCriterion("shippingCompanyId =", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdNotEqualTo(String value) {
            addCriterion("shippingCompanyId <>", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdGreaterThan(String value) {
            addCriterion("shippingCompanyId >", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("shippingCompanyId >=", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdLessThan(String value) {
            addCriterion("shippingCompanyId <", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("shippingCompanyId <=", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdLike(String value) {
            addCriterion("shippingCompanyId like", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdNotLike(String value) {
            addCriterion("shippingCompanyId not like", value, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdIn(List<String> values) {
            addCriterion("shippingCompanyId in", values, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdNotIn(List<String> values) {
            addCriterion("shippingCompanyId not in", values, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdBetween(String value1, String value2) {
            addCriterion("shippingCompanyId between", value1, value2, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingCompanyIdNotBetween(String value1, String value2) {
            addCriterion("shippingCompanyId not between", value1, value2, "shippingCompanyId");
            return (Criteria) this;
        }

        public Criteria andShippingFromIsNull() {
            addCriterion("shippingFrom is null");
            return (Criteria) this;
        }

        public Criteria andShippingFromIsNotNull() {
            addCriterion("shippingFrom is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFromEqualTo(String value) {
            addCriterion("shippingFrom =", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromNotEqualTo(String value) {
            addCriterion("shippingFrom <>", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromGreaterThan(String value) {
            addCriterion("shippingFrom >", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromGreaterThanOrEqualTo(String value) {
            addCriterion("shippingFrom >=", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromLessThan(String value) {
            addCriterion("shippingFrom <", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromLessThanOrEqualTo(String value) {
            addCriterion("shippingFrom <=", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromLike(String value) {
            addCriterion("shippingFrom like", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromNotLike(String value) {
            addCriterion("shippingFrom not like", value, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromIn(List<String> values) {
            addCriterion("shippingFrom in", values, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromNotIn(List<String> values) {
            addCriterion("shippingFrom not in", values, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromBetween(String value1, String value2) {
            addCriterion("shippingFrom between", value1, value2, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingFromNotBetween(String value1, String value2) {
            addCriterion("shippingFrom not between", value1, value2, "shippingFrom");
            return (Criteria) this;
        }

        public Criteria andShippingToIsNull() {
            addCriterion("shippingTo is null");
            return (Criteria) this;
        }

        public Criteria andShippingToIsNotNull() {
            addCriterion("shippingTo is not null");
            return (Criteria) this;
        }

        public Criteria andShippingToEqualTo(String value) {
            addCriterion("shippingTo =", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToNotEqualTo(String value) {
            addCriterion("shippingTo <>", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToGreaterThan(String value) {
            addCriterion("shippingTo >", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToGreaterThanOrEqualTo(String value) {
            addCriterion("shippingTo >=", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToLessThan(String value) {
            addCriterion("shippingTo <", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToLessThanOrEqualTo(String value) {
            addCriterion("shippingTo <=", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToLike(String value) {
            addCriterion("shippingTo like", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToNotLike(String value) {
            addCriterion("shippingTo not like", value, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToIn(List<String> values) {
            addCriterion("shippingTo in", values, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToNotIn(List<String> values) {
            addCriterion("shippingTo not in", values, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToBetween(String value1, String value2) {
            addCriterion("shippingTo between", value1, value2, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andShippingToNotBetween(String value1, String value2) {
            addCriterion("shippingTo not between", value1, value2, "shippingTo");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIsNull() {
            addCriterion("saleOrderId is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIsNotNull() {
            addCriterion("saleOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdEqualTo(Long value) {
            addCriterion("saleOrderId =", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotEqualTo(Long value) {
            addCriterion("saleOrderId <>", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThan(Long value) {
            addCriterion("saleOrderId >", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("saleOrderId >=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThan(Long value) {
            addCriterion("saleOrderId <", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("saleOrderId <=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIn(List<Long> values) {
            addCriterion("saleOrderId in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotIn(List<Long> values) {
            addCriterion("saleOrderId not in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdBetween(Long value1, Long value2) {
            addCriterion("saleOrderId between", value1, value2, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("saleOrderId not between", value1, value2, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNull() {
            addCriterion("displayOrder is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("displayOrder is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Integer value) {
            addCriterion("displayOrder =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Integer value) {
            addCriterion("displayOrder <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Integer value) {
            addCriterion("displayOrder >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("displayOrder >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Integer value) {
            addCriterion("displayOrder <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Integer value) {
            addCriterion("displayOrder <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Integer> values) {
            addCriterion("displayOrder in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Integer> values) {
            addCriterion("displayOrder not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Integer value1, Integer value2) {
            addCriterion("displayOrder between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("displayOrder not between", value1, value2, "displayOrder");
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