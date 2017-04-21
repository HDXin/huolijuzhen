package com.sudaotech.huolijuzhen.provider.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;
import com.sudaotech.huolijuzhen.enums.ApplyOrderType;
import com.sudaotech.huolijuzhen.provider.dao.ApplyOrderEntity;
import com.sudaotech.huolijuzhen.provider.service.ApplyLabelService.ApplyLabel;

public interface ApplyOrderService extends BaseService {

    public ApplyOrder getById(Long id);

    public Long create(ApplyOrder obj);

    public void update(ApplyOrder obj);

    public Long save(ApplyOrder obj);
    
    public ApplyOrder findByApplyOrderNo(String applyOrderNo);
    
    public int updateStatusByPay(ApplyOrder applyOrder);
    
    public Integer findApplyOrOrderCount(Long serviceProId,ApplyOrderType applyOrderType);
    
    public Page<ApplyOrder> findAllOfEnterprise(FindCondition findCondition);
    
    public Integer findApplyOrderCount(Long serviceProId);

    public Page<ApplyOrder> findAll(FindCondition findCondition);

    public static class Query extends Pagination {
    }

    public static class FindCondition extends Pagination {
    	private Boolean isPlatform = false;
        private Long enterpriseId;
        private Date startDate;
        private Date endDate;
        private String enterpriseName;
        private String applyOrderNo;
        private ApplyOrderType applyOrderType;
        private List<ApplyOrderStatus> applyOrderStatusList = new ArrayList<ApplyOrderStatus>();
        private List<Long> serviceProIds = new ArrayList<Long>();

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getApplyOrderNo() {
            return applyOrderNo;
        }

        public void setApplyOrderNo(String applyOrderNo) {
            this.applyOrderNo = applyOrderNo;
        }

        public ApplyOrderType getApplyOrderType() {
            return applyOrderType;
        }

        public List<ApplyOrderStatus> getApplyOrderStatusList() {
            return applyOrderStatusList;
        }

        public void setApplyOrderStatusList(List<ApplyOrderStatus> applyOrderStatusList) {
            this.applyOrderStatusList = applyOrderStatusList;
        }

        public void setApplyOrderType(ApplyOrderType applyOrderType) {
            this.applyOrderType = applyOrderType;
        }

        public List<Long> getServiceProIds() {
            return serviceProIds;
        }

        public void setServiceProIds(List<Long> serviceProIds) {
            this.serviceProIds = serviceProIds;
        }

        public Long getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(Long enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

		public Boolean getIsPlatform() {
			return isPlatform;
		}

		public void setIsPlatform(Boolean isPlatform) {
			this.isPlatform = isPlatform;
		}
    }

    public static class ApplyOrder extends ApplyOrderEntity {

    	private String tempPrice;
    	
        private List<ApplyLabel> applyLabelItems = new ArrayList<ApplyLabel>();

		public List<ApplyLabel> getApplyLabelItems() {
			return applyLabelItems;
		}

		public void setApplyLabelItems(List<ApplyLabel> applyLabelItems) {
			this.applyLabelItems = applyLabelItems;
		}

		public String getTempPrice() {
			return tempPrice;
		}

		public void setTempPrice(String tempPrice) {
			this.tempPrice = tempPrice;
			BigDecimal price = new BigDecimal(tempPrice);
			setPrice(price);
		}
    }

	
}
