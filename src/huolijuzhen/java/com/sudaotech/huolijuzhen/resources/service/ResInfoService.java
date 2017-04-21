package com.sudaotech.huolijuzhen.resources.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.DateSerializer;
import com.sudaotech.core.web.serialize.EnumTypeSerializer;
import com.sudaotech.huolijuzhen.dao.ResInfoEntity;
import com.sudaotech.huolijuzhen.enums.CalcDimension;
import com.sudaotech.huolijuzhen.enums.EnableAvg;
import com.sudaotech.huolijuzhen.enums.ResType;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

public interface ResInfoService extends BaseService {

    public ResInfo getById(Long id);

    public Long create(ResInfo obj);

    public void update(ResInfo obj);

    public Long save(ResInfo obj);

    public Page<ResInfo> find(Query query);

    public List<ResInfo> findAll(Query query);
    
	public List<ResInfo> findAllByParkId(Long parkId);

    public static class Query extends Pagination {
        private String name;
        private ResType resType;
        private EnableStatus enableStatus;
        private Long parkInfoId;

        public Long getParkInfoId() {
            return parkInfoId;
        }

        public void setParkInfoId(Long parkInfoId) {
            this.parkInfoId = parkInfoId;
        }

        public ResType getResType() {
            return resType;
        }

        public void setResType(ResType resType) {
            this.resType = resType;
        }

        public EnableStatus getEnableStatus() {
            return enableStatus;
        }

        public void setEnableStatus(EnableStatus EnableStatus) {
            this.enableStatus = EnableStatus;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ResInfo extends ResInfoEntity {


        @JsonSerialize(using = EnumTypeSerializer.class)
        private ResType resType;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private EnableStatus enableStatus ;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private EnableAvg enableAvg ;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private CalcDimension calcDimension;

        @JsonSerialize(using = DateSerializer.class)
        private Date startTime, closeTime;

        @Override
        public EnableAvg getEnableAvg() {
            return enableAvg;
        }

        @Override
        public void setEnableAvg(EnableAvg enableAvg) {
            this.enableAvg = enableAvg;
        }

        private List<ResourceInfoService.ResourceInfo> resourceInfoList;

        public List<ResourceInfoService.ResourceInfo> getResourceInfoList() {
            return resourceInfoList;
        }

        public void setResourceInfoList(List<ResourceInfoService.ResourceInfo> resourceInfoList) {
            this.resourceInfoList = resourceInfoList;
        }

        @Override
        public CalcDimension getCalcDimension() {
            return calcDimension;
        }

        @Override
        public void setCalcDimension(CalcDimension calcDimension) {
            this.calcDimension = calcDimension;
        }

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
        public ResType getResType() {
            return resType;
        }

        @Override
        public void setResType(ResType resType) {
            this.resType = resType;
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
