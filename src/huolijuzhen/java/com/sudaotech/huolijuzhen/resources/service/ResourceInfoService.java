package com.sudaotech.huolijuzhen.resources.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.EnumTypeSerializer;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enums.CalcDimension;
import com.sudaotech.huolijuzhen.enums.EnableAvg;
import com.sudaotech.huolijuzhen.enums.UseStatus;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ResourceInfoService extends BaseService {

	public ResourceInfo getById(Long id);

    public Long create(ResourceInfo obj);

    public List<ResourceInfo> getByParentId(Long parentId);

    public List<ResourceInfo> getByQuery(Query query);
    
    public List<ResourceInfo> getByResInfoIds(List<Long> resInfoIds);

    public void update(ResourceInfo obj);

    public Long save(ResourceInfo obj);

    public Page<ResourceInfo> find(Query query);
    
	public List<Map<String, Object>> resOfAreaAll(Map<String, Object> paramsMap);
	
	public List<Map<String, Object>> resOfAreaUse(Map<String, Object> paramsMap);
	
	public List<Map<String, Object>> resOfNumAll(Map<String, Object> paramsMap);
	
	public List<Map<String, Object>> resOfNumUse(Map<String, Object> paramsMap);

	public Map<String, Object> resAvgBasicPrice(Map<String, Object> paramsMap);

	public Map<String, Object> resAvgRentPrice(Map<String, Object> paramsMap);
	
	public Map<String, Object> resNoRentInfo(Map<String, Object> paramsMap);
	
    public static class Batch {
        @NotNull
        private String prefix, suffix;
        @NotNull
        private Integer digit;
        @NotNull
        private Integer start;
        @NotNull
        private Integer nums;
        @NotNull
        private Long parentId;
        @NotNull
        private Boolean isSeat, isRoot;
        @NotNull
        private Long resInfoId;
        @NotNull
        private Long tierId;
        @NotNull
        private String tierName;
        @NotNull
        private Integer tierNum;
        @NotNull
        private BigDecimal price;
        @NotNull(message = "area is null")
        private String area;

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Boolean getSeat() {
            return isSeat;
        }

        public void setSeat(Boolean seat) {
            isSeat = seat;
        }

        public Boolean getRoot() {
            return isRoot;
        }

        public void setRoot(Boolean root) {
            isRoot = root;
        }

        public Long getResInfoId() {
            return resInfoId;
        }

        public void setResInfoId(Long resInfoId) {
            this.resInfoId = resInfoId;
        }

        public Long getTierId() {
            return tierId;
        }

        public void setTierId(Long tierId) {
            this.tierId = tierId;
        }

        public String getTierName() {
            return tierName;
        }

        public void setTierName(String tierName) {
            this.tierName = tierName;
        }

        public Integer getTierNum() {
            return tierNum;
        }

        public void setTierNum(Integer tierNum) {
            this.tierNum = tierNum;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public Integer getDigit() {
            return digit;
        }

        public void setDigit(Integer digit) {
            this.digit = digit;
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getNums() {
            return nums;
        }

        public void setNums(Integer nums) {
            this.nums = nums;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    public static class Query extends Pagination {
        private Long parentId, resInfoId, tierId;
        private String name;
        private List<String> codeList;
        private Boolean isRoot;
        private Long parkInfoId;

        public Long getParkInfoId() {
            return parkInfoId;
        }

        public void setParkInfoId(Long parkInfoId) {
            this.parkInfoId = parkInfoId;
        }

        public List<String> getCodeList() {
            return codeList;
        }

        public void setCodeList(List<String> codeList) {
            this.codeList = codeList;
        }

        public Long getParentId() {
            return parentId;
        }

        public Boolean getRoot() {
            return isRoot;
        }

        public void setRoot(Boolean root) {
            isRoot = root;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public Long getResInfoId() {
            return resInfoId;
        }

        public void setResInfoId(Long resInfoId) {
            this.resInfoId = resInfoId;
        }

        public Long getTierId() {
            return tierId;
        }

        public void setTierId(Long tierId) {
            this.tierId = tierId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    public static class ResourceInfo extends ResourceInfoEntity {

        @JsonSerialize(using = EnumTypeSerializer.class,include = JsonSerialize.Inclusion.NON_NULL)
        private EnableAvg enableAvg ;

        @JsonSerialize(using = EnumTypeSerializer.class,include = JsonSerialize.Inclusion.NON_NULL)
        private CalcDimension calcDimension;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private UseStatus useStatus;

        @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
        private String resInfoName;
        
        //占用资源的合同
        private ContractInfo contractInfo;
        
		public EnableAvg getEnableAvg() {
            return enableAvg;
        }

        public void setEnableAvg(EnableAvg enableAvg) {
            this.enableAvg = enableAvg;
        }

        public CalcDimension getCalcDimension() {
            return calcDimension;
        }

        public void setCalcDimension(CalcDimension calcDimension) {
            this.calcDimension = calcDimension;
        }

        public String getResInfoName() {
            return resInfoName;
        }

        public void setResInfoName(String resInfoName) {
            this.resInfoName = resInfoName;
        }

        private List<ResourceInfo> resourceInfoList;

        @Override
        public UseStatus getUseStatus() {
            return useStatus;
        }

        @Override
        public void setUseStatus(UseStatus useStatus) {
            this.useStatus = useStatus;
        }

        public List<ResourceInfo> getResourceInfoList() {
            return resourceInfoList;
        }

        public void setResourceInfoList(List<ResourceInfo> resourceInfoList) {
            this.resourceInfoList = resourceInfoList;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

		public ContractInfo getContractInfo() {
			return contractInfo;
		}

		public void setContractInfo(ContractInfo contractInfo) {
			this.contractInfo = contractInfo;
		}
        
    }


}
