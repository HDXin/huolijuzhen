package com.sudaotech.huolijuzhen.community.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityEntityExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDiscribleIsNull() {
            addCriterion("discrible is null");
            return (Criteria) this;
        }

        public Criteria andDiscribleIsNotNull() {
            addCriterion("discrible is not null");
            return (Criteria) this;
        }

        public Criteria andDiscribleEqualTo(String value) {
            addCriterion("discrible =", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleNotEqualTo(String value) {
            addCriterion("discrible <>", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleGreaterThan(String value) {
            addCriterion("discrible >", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleGreaterThanOrEqualTo(String value) {
            addCriterion("discrible >=", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleLessThan(String value) {
            addCriterion("discrible <", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleLessThanOrEqualTo(String value) {
            addCriterion("discrible <=", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleLike(String value) {
            addCriterion("discrible like", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleNotLike(String value) {
            addCriterion("discrible not like", value, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleIn(List<String> values) {
            addCriterion("discrible in", values, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleNotIn(List<String> values) {
            addCriterion("discrible not in", values, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleBetween(String value1, String value2) {
            addCriterion("discrible between", value1, value2, "discrible");
            return (Criteria) this;
        }

        public Criteria andDiscribleNotBetween(String value1, String value2) {
            addCriterion("discrible not between", value1, value2, "discrible");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIsNull() {
            addCriterion("publicGrade is null");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIsNotNull() {
            addCriterion("publicGrade is not null");
            return (Criteria) this;
        }

        public Criteria andPublicGradeEqualTo(PublicGrade value) {
            addCriterion("publicGrade =", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotEqualTo(PublicGrade value) {
            addCriterion("publicGrade <>", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeGreaterThan(PublicGrade value) {
            addCriterion("publicGrade >", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeGreaterThanOrEqualTo(PublicGrade value) {
            addCriterion("publicGrade >=", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeLessThan(PublicGrade value) {
            addCriterion("publicGrade <", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeLessThanOrEqualTo(PublicGrade value) {
            addCriterion("publicGrade <=", value, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeIn(List<PublicGrade> values) {
            addCriterion("publicGrade in", values, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotIn(List<PublicGrade> values) {
            addCriterion("publicGrade not in", values, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeBetween(PublicGrade value1, PublicGrade value2) {
            addCriterion("publicGrade between", value1, value2, "publicGrade");
            return (Criteria) this;
        }

        public Criteria andPublicGradeNotBetween(PublicGrade value1, PublicGrade value2) {
            addCriterion("publicGrade not between", value1, value2, "publicGrade");
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

        public Criteria andProIdIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("proId =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("proId <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("proId >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("proId >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("proId <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("proId <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("proId like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("proId not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("proId in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("proId not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("proId between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("proId not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("cityId is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("cityId is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("cityId =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("cityId <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("cityId >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("cityId >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("cityId <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("cityId <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("cityId like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("cityId not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("cityId in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("cityId not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("cityId between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("cityId not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCounIdIsNull() {
            addCriterion("counId is null");
            return (Criteria) this;
        }

        public Criteria andCounIdIsNotNull() {
            addCriterion("counId is not null");
            return (Criteria) this;
        }

        public Criteria andCounIdEqualTo(String value) {
            addCriterion("counId =", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotEqualTo(String value) {
            addCriterion("counId <>", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdGreaterThan(String value) {
            addCriterion("counId >", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdGreaterThanOrEqualTo(String value) {
            addCriterion("counId >=", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdLessThan(String value) {
            addCriterion("counId <", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdLessThanOrEqualTo(String value) {
            addCriterion("counId <=", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdLike(String value) {
            addCriterion("counId like", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotLike(String value) {
            addCriterion("counId not like", value, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdIn(List<String> values) {
            addCriterion("counId in", values, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotIn(List<String> values) {
            addCriterion("counId not in", values, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdBetween(String value1, String value2) {
            addCriterion("counId between", value1, value2, "counId");
            return (Criteria) this;
        }

        public Criteria andCounIdNotBetween(String value1, String value2) {
            addCriterion("counId not between", value1, value2, "counId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("locationId is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("locationId is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Long value) {
            addCriterion("locationId =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Long value) {
            addCriterion("locationId <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Long value) {
            addCriterion("locationId >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("locationId >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Long value) {
            addCriterion("locationId <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Long value) {
            addCriterion("locationId <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Long> values) {
            addCriterion("locationId in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Long> values) {
            addCriterion("locationId not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Long value1, Long value2) {
            addCriterion("locationId between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Long value1, Long value2) {
            addCriterion("locationId not between", value1, value2, "locationId");
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

        public Criteria andApprovalStatusEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(ApprovalStatus value) {
            addCriterion("approvalStatus >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(ApprovalStatus value) {
            addCriterion("approvalStatus <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(ApprovalStatus value) {
            addCriterion("approvalStatus <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<ApprovalStatus> values) {
            addCriterion("approvalStatus in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<ApprovalStatus> values) {
            addCriterion("approvalStatus not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(ApprovalStatus value1, ApprovalStatus value2) {
            addCriterion("approvalStatus between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(ApprovalStatus value1, ApprovalStatus value2) {
            addCriterion("approvalStatus not between", value1, value2, "approvalStatus");
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

        public Criteria andDeleteByIsNull() {
            addCriterion("deleteBy is null");
            return (Criteria) this;
        }

        public Criteria andDeleteByIsNotNull() {
            addCriterion("deleteBy is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteByEqualTo(Long value) {
            addCriterion("deleteBy =", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotEqualTo(Long value) {
            addCriterion("deleteBy <>", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThan(Long value) {
            addCriterion("deleteBy >", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThanOrEqualTo(Long value) {
            addCriterion("deleteBy >=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThan(Long value) {
            addCriterion("deleteBy <", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThanOrEqualTo(Long value) {
            addCriterion("deleteBy <=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByIn(List<Long> values) {
            addCriterion("deleteBy in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotIn(List<Long> values) {
            addCriterion("deleteBy not in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByBetween(Long value1, Long value2) {
            addCriterion("deleteBy between", value1, value2, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotBetween(Long value1, Long value2) {
            addCriterion("deleteBy not between", value1, value2, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("deleteTime is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("deleteTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("deleteTime =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("deleteTime <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("deleteTime >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deleteTime >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("deleteTime <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("deleteTime <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("deleteTime in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("deleteTime not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("deleteTime between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("deleteTime not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andCreateSideIsNull() {
            addCriterion("createSide is null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIsNotNull() {
            addCriterion("createSide is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSideEqualTo(CreateSide value) {
            addCriterion("createSide =", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotEqualTo(CreateSide value) {
            addCriterion("createSide <>", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideGreaterThan(CreateSide value) {
            addCriterion("createSide >", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideGreaterThanOrEqualTo(CreateSide value) {
            addCriterion("createSide >=", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideLessThan(CreateSide value) {
            addCriterion("createSide <", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideLessThanOrEqualTo(CreateSide value) {
            addCriterion("createSide <=", value, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideIn(List<CreateSide> values) {
            addCriterion("createSide in", values, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotIn(List<CreateSide> values) {
            addCriterion("createSide not in", values, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideBetween(CreateSide value1, CreateSide value2) {
            addCriterion("createSide between", value1, value2, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideNotBetween(CreateSide value1, CreateSide value2) {
            addCriterion("createSide not between", value1, value2, "createSide");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIsNull() {
            addCriterion("createSideId is null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIsNotNull() {
            addCriterion("createSideId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdEqualTo(Long value) {
            addCriterion("createSideId =", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotEqualTo(Long value) {
            addCriterion("createSideId <>", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdGreaterThan(Long value) {
            addCriterion("createSideId >", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdGreaterThanOrEqualTo(Long value) {
            addCriterion("createSideId >=", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdLessThan(Long value) {
            addCriterion("createSideId <", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdLessThanOrEqualTo(Long value) {
            addCriterion("createSideId <=", value, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdIn(List<Long> values) {
            addCriterion("createSideId in", values, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotIn(List<Long> values) {
            addCriterion("createSideId not in", values, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdBetween(Long value1, Long value2) {
            addCriterion("createSideId between", value1, value2, "createSideId");
            return (Criteria) this;
        }

        public Criteria andCreateSideIdNotBetween(Long value1, Long value2) {
            addCriterion("createSideId not between", value1, value2, "createSideId");
            return (Criteria) this;
        }

        public Criteria andTerminateByIsNull() {
            addCriterion("terminateBy is null");
            return (Criteria) this;
        }

        public Criteria andTerminateByIsNotNull() {
            addCriterion("terminateBy is not null");
            return (Criteria) this;
        }

        public Criteria andTerminateByEqualTo(Long value) {
            addCriterion("terminateBy =", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByNotEqualTo(Long value) {
            addCriterion("terminateBy <>", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByGreaterThan(Long value) {
            addCriterion("terminateBy >", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByGreaterThanOrEqualTo(Long value) {
            addCriterion("terminateBy >=", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByLessThan(Long value) {
            addCriterion("terminateBy <", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByLessThanOrEqualTo(Long value) {
            addCriterion("terminateBy <=", value, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByIn(List<Long> values) {
            addCriterion("terminateBy in", values, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByNotIn(List<Long> values) {
            addCriterion("terminateBy not in", values, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByBetween(Long value1, Long value2) {
            addCriterion("terminateBy between", value1, value2, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateByNotBetween(Long value1, Long value2) {
            addCriterion("terminateBy not between", value1, value2, "terminateBy");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeIsNull() {
            addCriterion("terminateTime is null");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeIsNotNull() {
            addCriterion("terminateTime is not null");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeEqualTo(Date value) {
            addCriterion("terminateTime =", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeNotEqualTo(Date value) {
            addCriterion("terminateTime <>", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeGreaterThan(Date value) {
            addCriterion("terminateTime >", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("terminateTime >=", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeLessThan(Date value) {
            addCriterion("terminateTime <", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeLessThanOrEqualTo(Date value) {
            addCriterion("terminateTime <=", value, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeIn(List<Date> values) {
            addCriterion("terminateTime in", values, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeNotIn(List<Date> values) {
            addCriterion("terminateTime not in", values, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeBetween(Date value1, Date value2) {
            addCriterion("terminateTime between", value1, value2, "terminateTime");
            return (Criteria) this;
        }

        public Criteria andTerminateTimeNotBetween(Date value1, Date value2) {
            addCriterion("terminateTime not between", value1, value2, "terminateTime");
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