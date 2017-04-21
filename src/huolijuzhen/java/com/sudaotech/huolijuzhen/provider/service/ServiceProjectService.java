package com.sudaotech.huolijuzhen.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService;
import com.sudaotech.huolijuzhen.basic.service.ServiceScenarioService.ServiceScenario;
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectEntity;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;

public interface ServiceProjectService extends BaseService {

    public ServiceProject getById(Long id);

    public Long create(ServiceProject obj);

    public void update(ServiceProject obj);

    public Long save(ServiceProject obj);
    
    public List<Long> findServiceProIdByServiceGrade(ServiceGrade serviceGrade);

    public Page<ServiceProject> find(Query query);
    
    public List<Long> findPlatformServiceIds();

	public Page<ServiceProject> findPlatformService(Query query);
    
    public Page<ServiceProject> findProviderServiceSql(Query query);
    
    public Page<ServiceProject> findParkServiceSql(Query query);
    
    public Page<ServiceProject> findParkValidServicePro(Query query,Long parkId,List<Long> ids);
    
    public List<Long> findServiceProIdByCurrentUser(FindServiceProByCurrentUser condition);
    
    public List<Map<String, Object>> statisticsToPlatform(Map<String, Object> paramsMap);
    
    public List<Map<String, Object>> statisticsToPark(Map<String, Object> paramsMap);
    
    /**
     * 按服务类型、点击数统计服务项目
     * @return
     */
	public List<Map<String, Object>> statisticsByServiceType();
	
    /**
     * 按点击数统计服务项目
     * @return
     */
	public List<Map<String, Object>> statisticsByReadNum();
    
    public static class Query extends Pagination {
    	
    	private String providerName;
    	private String mainTitle;
    	private ServiceGrade serviceGrade;
    	private Long serviceGradeId;
    	private String approvalStatu;
    	private Long serviceTypeId;
    	private String title;

    	//当前用户类型
    	private ServiceGrade currentServiceGrade;
		
    	private Long parkId;
    	//通过园区 ID 筛选的服务项目 ID
    	private List<Long> ids = new ArrayList<Long>();
    	//通过场景筛选的服务项目ID
    	private List<Long> serviceProIds = new ArrayList<Long>();
    	
		public List<Long> getServiceProIds() {
			return serviceProIds;
		}
		public void setServiceProIds(List<Long> serviceProIds) {
			this.serviceProIds = serviceProIds;
		}
		public String getProviderName() {
			return providerName;
		}
		public void setProviderName(String providerName) {
			this.providerName = providerName;
		}
		public String getMainTitle() {
			return mainTitle;
		}
		public void setMainTitle(String mainTitle) {
			this.mainTitle = mainTitle;
		}
		public String getApprovalStatu() {
			return approvalStatu;
		}
		public void setApprovalStatu(String approvalStatu) {
			this.approvalStatu = approvalStatu;
		}
		public Long getServiceTypeId() {
			return serviceTypeId;
		}
		public void setServiceTypeId(Long serviceTypeId) {
			this.serviceTypeId = serviceTypeId;
		}
		public Long getServiceGradeId() {
			return serviceGradeId;
		}
		public void setServiceGradeId(Long serviceGradeId) {
			this.serviceGradeId = serviceGradeId;
		}
		public ServiceGrade getServiceGrade() {
			return serviceGrade;
		}
		public void setServiceGrade(ServiceGrade serviceGrade) {
			this.serviceGrade = serviceGrade;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public List<Long> getIds() {
			return ids;
		}
		public void setIds(List<Long> ids) {
			this.ids = ids;
		}
		public ServiceGrade getCurrentServiceGrade() {
			return currentServiceGrade;
		}
		public void setCurrentServiceGrade(ServiceGrade currentServiceGrade) {
			this.currentServiceGrade = currentServiceGrade;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
    }
    
    public static class ServiceProject extends ServiceProjectEntity {
    	
    	//主图
    	private List<ImageInfo> mainImage = new ArrayList<ImageInfo>();
    	//轮播图
    	private List<ImageInfo> listImage = new ArrayList<ImageInfo>();
    	//园区 ID 
    	private List<Long> parkIds = new ArrayList<Long>();
    	//适用的服务场景
    	private List<ServiceScenario> serviceScenarios = new ArrayList<ServiceScenarioService.ServiceScenario>();
    	
		public List<ServiceScenario> getServiceScenarios() {
			return serviceScenarios;
		}
		public void setServiceScenarios(List<ServiceScenario> serviceScenarios) {
			this.serviceScenarios = serviceScenarios;
		}
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
		public List<Long> getParkIds() {
			return parkIds;
		}
		public void setParkIds(List<Long> parkIds) {
			this.parkIds = parkIds;
		}
		
    }
    
    public static class UpdateItemInfo{
    	
    	private ServiceApprovalStatus approvalStatus;
    	private List<Long> itemIds = new ArrayList<Long>();
    	private String approvalText;
    	
    	private Long id;
    	
		public List<Long> getItemIds() {
			return itemIds;
		}
		public void setItemIds(List<Long> itemIds) {
			this.itemIds = itemIds;
		}
		public String getApprovalText() {
			return approvalText;
		}
		public void setApprovalText(String approvalText) {
			this.approvalText = approvalText;
		}
		public ServiceApprovalStatus getApprovalStatus() {
			return approvalStatus;
		}
		public void setApprovalStatus(ServiceApprovalStatus approvalStatus) {
			if(ServiceApprovalStatus.PUBLISH.equals(approvalStatus) || ServiceApprovalStatus.NOPASS.equals(approvalStatus)){
				this.approvalStatus = approvalStatus;				
			}else{
				this.approvalStatus = ServiceApprovalStatus.NOPASS;
			}
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
    }
    
    public static class FindServiceProByCurrentUser{
    	
    	//当前用户级别 园区管理、园区服务商、平台服务商
    	private ServiceGrade currentGrade;
    	
    	//服务商类型
    	private List<ServiceGrade> serviceGradeList = new ArrayList<ServiceGrade>();
    	
    	//服务商ID 
    	private Long serviceGradeId;
    	
    	//园区 ID
    	private Long parkId;

		public List<ServiceGrade> getServiceGradeList() {
			return serviceGradeList;
		}

		public void setServiceGradeList(List<ServiceGrade> serviceGradeList) {
			this.serviceGradeList = serviceGradeList;
		}

		public Long getServiceGradeId() {
			return serviceGradeId;
		}

		public void setServiceGradeId(Long serviceGradeId) {
			this.serviceGradeId = serviceGradeId;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}

		public ServiceGrade getCurrentGrade() {
			return currentGrade;
		}

		public void setCurrentGrade(ServiceGrade currentGrade) {
			this.currentGrade = currentGrade;
		}
    	
    }

	public List<ServiceProject> findByObj(ServiceProject obj);

	



	
}
