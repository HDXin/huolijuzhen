package com.sudaotech.huolijuzhen.community.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.community.dao.CommunityEntityWithBLOBs;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;

public interface CommunityService extends BaseService {

    public Community getById(Long id);

    public Long create(Community obj);

    public void update(Community obj);

    public Long save(Community obj);

    public Page<Community> find(Query query);
    
    public Page<Community> find(Query query,CreateSide createSide,Long parkId) throws ParseException;
    
    public boolean hasEditPrivilegeById(Long itemId,Long userId);
    
    public Page<Community> findByCurrentUser(Query query, ParkInfo parkInfo);
    
    /**
     * 社群活动统计
     * @param query
     * @return
     */
	public Page<Community> statistics(StatisticsCondition statisticsCondition);

    
    public static class Query extends Pagination {
    	
    	private String startDate;
    	private String endDate;
    	private String approvalStatus;
    	private String title;
    	
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
		public String getApprovalStatus() {
			return approvalStatus;
		}
		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		private List<Long> communityIds = new ArrayList<Long>();
		private Long parkId;

		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public List<Long> getCommunityIds() {
			return communityIds;
		}
		public void setCommunityIds(List<Long> communityIds) {
			this.communityIds = communityIds;
		}
    }
    
    public static class StatisticsCondition extends Page<Community>{
    	private String title;
    	private CreateSide createSide;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public CreateSide getCreateSide() {
			return createSide;
		}
		public void setCreateSide(CreateSide createSide) {
			this.createSide = createSide;
		}
    }
    
    public static class Community extends CommunityEntityWithBLOBs {
    	
    	private List<ImageInfo> mainImage = new ArrayList<ImageInfo>();
    	
    	private List<ImageInfo> listImage = new ArrayList<ImageInfo>();

		public List<ImageInfo> getMainImage() {
			return mainImage;
		}

		public void setMainImage(List<ImageInfo> mainImage) {
			this.mainImage = mainImage;
		}

		public List<ImageInfo> getListImage() {
			return listImage;
		}

		public void setListImage(List<ImageInfo> listImage) {
			this.listImage = listImage;
		}
    }

}
