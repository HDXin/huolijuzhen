package com.sudaotech.huolijuzhen.resources.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.DateSerializer;
import com.sudaotech.core.web.serialize.EnumTypeSerializer;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntity;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public interface UnitTierInfoService extends BaseService {

    public UnitTierInfo getById(Long id);

    public Long create(UnitTierInfo obj);

    public void update(UnitTierInfo obj);

    public Long save(UnitTierInfo obj);

    public Page<UnitTierInfo> find(Query query);

    public static class Query extends Pagination {
        private EnableStatus EnableStatus;
        private Long resInfoId;
        private Boolean isBase;
        private String name;
        private Long parkInfoId;

        public Long getParkInfoId() {
            return parkInfoId;
        }

        public void setParkInfoId(Long parkInfoId) {
            this.parkInfoId = parkInfoId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public EnableStatus getEnableStatus() {
            return EnableStatus;
        }

        public void setEnableStatus(EnableStatus EnableStatus) {
            this.EnableStatus = EnableStatus;
        }

        public Long getResInfoId() {
            return resInfoId;
        }

        public void setResInfoId(Long resInfoId) {
            this.resInfoId = resInfoId;
        }

        public Boolean getBase() {
            return isBase;
        }

        public void setBase(Boolean base) {
            isBase = base;
        }
    }



    public static class UnitTierInfo extends UnitTierInfoEntity {

        @JsonSerialize(using = DateSerializer.class)
        private Date startTime, closeTime;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private EnableStatus enableStatus;

        @Override
        public Date getCloseTime() {
            return closeTime;
        }

        @Override
        public void setCloseTime(Date closeTime) {
            this.closeTime = closeTime;
        }

        @Override
        public Date getStartTime() {
            return startTime;
        }

        @Override
        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        @Override
        public EnableStatus getEnableStatus() {
            return enableStatus;
        }

        @Override
        public void setEnableStatus(EnableStatus enableStatus) {
            this.enableStatus = enableStatus;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
