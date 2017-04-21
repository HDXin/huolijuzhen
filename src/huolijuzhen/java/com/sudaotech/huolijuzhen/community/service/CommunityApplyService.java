package com.sudaotech.huolijuzhen.community.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntity;
import com.sudaotech.huolijuzhen.enums.CreateSide;

public interface CommunityApplyService extends BaseService {

    public CommunityApply getById(Long id);

    public Long create(CommunityApply obj);

    public void update(CommunityApply obj);

    public Long save(CommunityApply obj);

    public Page<CommunityApply> find(Query query);
    
    public List<Long> findAllByEnterpriseIdAndParkId(Long enterpriseId,Long parkId);
    
    public Page<CommunityApply> findByCondition(Query query) throws ParseException;
   
    public Page<CommunityApply> findHistoryByCondition(Query query) throws ParseException;
    
	public List<Map<String, Object>> statistics(List<Long> communityIds);
    
    public static class Query extends Pagination {
    	private String startDate;
    	private String endDate;
    	private String companyName;
    	private String communityName;
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCommunityName() {
			return communityName;
		}
		public void setCommunityName(String communityName) {
			this.communityName = communityName;
		}


		//活动申请表所属企业
		private Long companyId;
		//获取申请企业所属园区
		private Long parkId;
		
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}

		//活动创建方
		private CreateSide createSide;
		//活动创建园区方 ID
		private Long createParkId;
		public CreateSide getCreateSide() {
			return createSide;
		}
		public void setCreateSide(CreateSide createSide) {
			this.createSide = createSide;
		}
		public Long getCreateParkId() {
			return createParkId;
		}
		public void setCreateParkId(Long createParkId) {
			this.createParkId = createParkId;
		}
    }
    
    public static class CommunityApply extends CommunityApplyEntity {
    	
    	private Long communityId;
    	
    	private Long parkId;

		public Long getCommunityId() {
			return communityId;
		}

		public void setCommunityId(Long communityId) {
			this.communityId = communityId;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		
    }


	
}
