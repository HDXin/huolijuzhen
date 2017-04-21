package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceInfoEntityExample() {
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

        public Criteria andIsRootIsNull() {
            addCriterion("isRoot is null");
            return (Criteria) this;
        }

        public Criteria andIsRootIsNotNull() {
            addCriterion("isRoot is not null");
            return (Criteria) this;
        }

        public Criteria andIsRootEqualTo(Boolean value) {
            addCriterion("isRoot =", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotEqualTo(Boolean value) {
            addCriterion("isRoot <>", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThan(Boolean value) {
            addCriterion("isRoot >", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isRoot >=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThan(Boolean value) {
            addCriterion("isRoot <", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThanOrEqualTo(Boolean value) {
            addCriterion("isRoot <=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootIn(List<Boolean> values) {
            addCriterion("isRoot in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotIn(List<Boolean> values) {
            addCriterion("isRoot not in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootBetween(Boolean value1, Boolean value2) {
            addCriterion("isRoot between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isRoot not between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNull() {
            addCriterion("resInfoId is null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIsNotNull() {
            addCriterion("resInfoId is not null");
            return (Criteria) this;
        }

        public Criteria andResInfoIdEqualTo(Long value) {
            addCriterion("resInfoId =", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotEqualTo(Long value) {
            addCriterion("resInfoId <>", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThan(Long value) {
            addCriterion("resInfoId >", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resInfoId >=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThan(Long value) {
            addCriterion("resInfoId <", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("resInfoId <=", value, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdIn(List<Long> values) {
            addCriterion("resInfoId in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotIn(List<Long> values) {
            addCriterion("resInfoId not in", values, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdBetween(Long value1, Long value2) {
            addCriterion("resInfoId between", value1, value2, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andResInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("resInfoId not between", value1, value2, "resInfoId");
            return (Criteria) this;
        }

        public Criteria andTierIdIsNull() {
            addCriterion("tierId is null");
            return (Criteria) this;
        }

        public Criteria andTierIdIsNotNull() {
            addCriterion("tierId is not null");
            return (Criteria) this;
        }

        public Criteria andTierIdEqualTo(Long value) {
            addCriterion("tierId =", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdNotEqualTo(Long value) {
            addCriterion("tierId <>", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdGreaterThan(Long value) {
            addCriterion("tierId >", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tierId >=", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdLessThan(Long value) {
            addCriterion("tierId <", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdLessThanOrEqualTo(Long value) {
            addCriterion("tierId <=", value, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdIn(List<Long> values) {
            addCriterion("tierId in", values, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdNotIn(List<Long> values) {
            addCriterion("tierId not in", values, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdBetween(Long value1, Long value2) {
            addCriterion("tierId between", value1, value2, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierIdNotBetween(Long value1, Long value2) {
            addCriterion("tierId not between", value1, value2, "tierId");
            return (Criteria) this;
        }

        public Criteria andTierNameIsNull() {
            addCriterion("tierName is null");
            return (Criteria) this;
        }

        public Criteria andTierNameIsNotNull() {
            addCriterion("tierName is not null");
            return (Criteria) this;
        }

        public Criteria andTierNameEqualTo(String value) {
            addCriterion("tierName =", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotEqualTo(String value) {
            addCriterion("tierName <>", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameGreaterThan(String value) {
            addCriterion("tierName >", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameGreaterThanOrEqualTo(String value) {
            addCriterion("tierName >=", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLessThan(String value) {
            addCriterion("tierName <", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLessThanOrEqualTo(String value) {
            addCriterion("tierName <=", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameLike(String value) {
            addCriterion("tierName like", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotLike(String value) {
            addCriterion("tierName not like", value, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameIn(List<String> values) {
            addCriterion("tierName in", values, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotIn(List<String> values) {
            addCriterion("tierName not in", values, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameBetween(String value1, String value2) {
            addCriterion("tierName between", value1, value2, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNameNotBetween(String value1, String value2) {
            addCriterion("tierName not between", value1, value2, "tierName");
            return (Criteria) this;
        }

        public Criteria andTierNumIsNull() {
            addCriterion("tierNum is null");
            return (Criteria) this;
        }

        public Criteria andTierNumIsNotNull() {
            addCriterion("tierNum is not null");
            return (Criteria) this;
        }

        public Criteria andTierNumEqualTo(Integer value) {
            addCriterion("tierNum =", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotEqualTo(Integer value) {
            addCriterion("tierNum <>", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumGreaterThan(Integer value) {
            addCriterion("tierNum >", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("tierNum >=", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumLessThan(Integer value) {
            addCriterion("tierNum <", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumLessThanOrEqualTo(Integer value) {
            addCriterion("tierNum <=", value, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumIn(List<Integer> values) {
            addCriterion("tierNum in", values, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotIn(List<Integer> values) {
            addCriterion("tierNum not in", values, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumBetween(Integer value1, Integer value2) {
            addCriterion("tierNum between", value1, value2, "tierNum");
            return (Criteria) this;
        }

        public Criteria andTierNumNotBetween(Integer value1, Integer value2) {
            addCriterion("tierNum not between", value1, value2, "tierNum");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andGardenIdIsNull() {
            addCriterion("gardenId is null");
            return (Criteria) this;
        }

        public Criteria andGardenIdIsNotNull() {
            addCriterion("gardenId is not null");
            return (Criteria) this;
        }

        public Criteria andGardenIdEqualTo(Long value) {
            addCriterion("gardenId =", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotEqualTo(Long value) {
            addCriterion("gardenId <>", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdGreaterThan(Long value) {
            addCriterion("gardenId >", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gardenId >=", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdLessThan(Long value) {
            addCriterion("gardenId <", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdLessThanOrEqualTo(Long value) {
            addCriterion("gardenId <=", value, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdIn(List<Long> values) {
            addCriterion("gardenId in", values, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotIn(List<Long> values) {
            addCriterion("gardenId not in", values, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdBetween(Long value1, Long value2) {
            addCriterion("gardenId between", value1, value2, "gardenId");
            return (Criteria) this;
        }

        public Criteria andGardenIdNotBetween(Long value1, Long value2) {
            addCriterion("gardenId not between", value1, value2, "gardenId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parentId =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parentId <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parentId >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parentId >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parentId <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parentId <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parentId in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parentId not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parentId between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parentId not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andIsSeatIsNull() {
            addCriterion("isSeat is null");
            return (Criteria) this;
        }

        public Criteria andIsSeatIsNotNull() {
            addCriterion("isSeat is not null");
            return (Criteria) this;
        }

        public Criteria andIsSeatEqualTo(Boolean value) {
            addCriterion("isSeat =", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatNotEqualTo(Boolean value) {
            addCriterion("isSeat <>", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatGreaterThan(Boolean value) {
            addCriterion("isSeat >", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isSeat >=", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatLessThan(Boolean value) {
            addCriterion("isSeat <", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatLessThanOrEqualTo(Boolean value) {
            addCriterion("isSeat <=", value, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatIn(List<Boolean> values) {
            addCriterion("isSeat in", values, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatNotIn(List<Boolean> values) {
            addCriterion("isSeat not in", values, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatBetween(Boolean value1, Boolean value2) {
            addCriterion("isSeat between", value1, value2, "isSeat");
            return (Criteria) this;
        }

        public Criteria andIsSeatNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isSeat not between", value1, value2, "isSeat");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Double value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Double value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Double value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Double value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Double value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Double> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Double> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Double value1, Double value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Double value1, Double value2) {
            addCriterion("area not between", value1, value2, "area");
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

        public Criteria andContIdIsNull() {
            addCriterion("contId is null");
            return (Criteria) this;
        }

        public Criteria andContIdIsNotNull() {
            addCriterion("contId is not null");
            return (Criteria) this;
        }

        public Criteria andContIdEqualTo(Long value) {
            addCriterion("contId =", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotEqualTo(Long value) {
            addCriterion("contId <>", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdGreaterThan(Long value) {
            addCriterion("contId >", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contId >=", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdLessThan(Long value) {
            addCriterion("contId <", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdLessThanOrEqualTo(Long value) {
            addCriterion("contId <=", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdIn(List<Long> values) {
            addCriterion("contId in", values, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotIn(List<Long> values) {
            addCriterion("contId not in", values, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdBetween(Long value1, Long value2) {
            addCriterion("contId between", value1, value2, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotBetween(Long value1, Long value2) {
            addCriterion("contId not between", value1, value2, "contId");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNull() {
            addCriterion("useStatus is null");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNotNull() {
            addCriterion("useStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUseStatusEqualTo(UseStatus value) {
            addCriterion("useStatus =", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotEqualTo(UseStatus value) {
            addCriterion("useStatus <>", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThan(UseStatus value) {
            addCriterion("useStatus >", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(UseStatus value) {
            addCriterion("useStatus >=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThan(UseStatus value) {
            addCriterion("useStatus <", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(UseStatus value) {
            addCriterion("useStatus <=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIn(List<UseStatus> values) {
            addCriterion("useStatus in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotIn(List<UseStatus> values) {
            addCriterion("useStatus not in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusBetween(UseStatus value1, UseStatus value2) {
            addCriterion("useStatus between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotBetween(UseStatus value1, UseStatus value2) {
            addCriterion("useStatus not between", value1, value2, "useStatus");
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