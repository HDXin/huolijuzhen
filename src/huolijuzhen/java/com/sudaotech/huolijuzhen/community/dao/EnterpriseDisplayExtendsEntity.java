package com.sudaotech.huolijuzhen.community.dao;

public class EnterpriseDisplayExtendsEntity {

	private String startTime;
	private String endTime;
	private String enterpriseName;
	private Integer publishLevel = -1;
	private Integer approvalStatus = -1;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public Integer getPublishLevel() {
		return publishLevel;
	}
	public void setPublishLevel(Integer publishLevel) {
		if(publishLevel!=null && publishLevel>=0)
			this.publishLevel = publishLevel;
	}
	public Integer getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(Integer approvalStatus) {
		if(approvalStatus!=null && approvalStatus>=0)
			this.approvalStatus = approvalStatus;
	}
	
	@Override
	public String toString() {
		return "EnterpriseDisplayExtendsEntity [startTime=" + startTime
				+ ", endTime=" + endTime + ", enterpriseName=" + enterpriseName
				+ ", publishLevel=" + publishLevel + ", approvalStatus="
				+ approvalStatus + "]";
	}
	
}
