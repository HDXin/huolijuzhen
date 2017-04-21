package com.sudaotech.huolijuzhen.announcement.service;

import java.text.ParseException;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntity;
import com.sudaotech.huolijuzhen.enums.CreateSide;


public interface AnnouncementService extends BaseService {

    public Announcement getById(Long id);

    public Long create(Announcement obj);

    public void update(Announcement obj);

    public Long save(Announcement obj);

    public Page<Announcement> find(Query query);
    
    public Page<Announcement> findByCondition(Query query) throws ParseException;
    
    public static class Query extends Pagination {
    	
    	private CreateSide querySide;
    	private String startDate;
    	private String endDate;
    	private String title;
    	private String approvalStatus;
    	
    	private Long parkId;
    	
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getApprovalStatus() {
			return approvalStatus;
		}
		public void setApprovalStatus(String approvalStatus) {
			this.approvalStatus = approvalStatus;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public CreateSide getQuerySide() {
			return querySide;
		}
		public void setQuerySide(CreateSide querySide) {
			this.querySide = querySide;
		}
    }
    public static class Announcement extends AnnouncementEntity {
    }
}
