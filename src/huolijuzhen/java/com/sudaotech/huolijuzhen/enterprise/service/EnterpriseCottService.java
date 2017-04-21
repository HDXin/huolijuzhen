package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntity;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrBusinessService.EnterpriseCorrBusiness;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCorrContractService.EnterpriseCorrContract;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;

public interface EnterpriseCottService extends BaseService {

    public EnterpriseCott getById(Long id);

    public Long create(EnterpriseCott obj);

    public void update(EnterpriseCott obj);

    public Long save(EnterpriseCott obj);

    public Page<EnterpriseCott> find(Query query);
    
    /**
     * 通过企业Id、园区Id获取关联关系
     * @return
     */
    public List<EnterpriseCott> getEnterPriseCottByEnterpriseId(Long enterPriseId,Long parkId);
    
    /**
     * 通过园区Id获取关联关系
     * @return
     */
    public List<EnterpriseCott> getEnterPriseCottByParkId(Long parkId);
    
    
    /**
     * 多表条件查询关联企业信息
     * @param query
     * @return
     */
    
    public Page<EnterpriseCottInfo> findByObj(Query query);
    
    //条件查询列表
    public List<EnterpriseCott> findList(EnterpriseCott obj);
    
    public static class Query extends Pagination {
    	
    	//园区Id
    	private Long parkId;
    	private Long enterpriseId;
    	private String enterpriseName;
    	//关联状态
    	private CorrStatus corrStatus;

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}

		public Long getEnterpriseId() {
			return enterpriseId;
		}

		public void setEnterpriseId(Long enterpriseId) {
			this.enterpriseId = enterpriseId;
		}

		public CorrStatus getCorrStatus() {
			return corrStatus;
		}

		public void setCorrStatus(CorrStatus corrStatus) {
			this.corrStatus = corrStatus;
		}
    	
		
		
    	
    	
    }
    
    public static class EnterpriseCott extends EnterpriseCottEntity {
    	
    	
    	//合同关联
        private List<EnterpriseCorrContract>  corrContract;
        
        //合同流程是否启用
        private boolean approvalEnableStatus;

        //业务关联
        private List<EnterpriseCorrBusiness>  corrBusiness;
        
        //园区信息
        private ParkInfo pi;
        
        //企业名称
        private String enterpriseName;
        
        //ids
        private List<Long> ids;

		public List<EnterpriseCorrContract> getCorrContract() {
			return corrContract;
		}

		public void setCorrContract(List<EnterpriseCorrContract> corrContract) {
			this.corrContract = corrContract;
		}

		public ParkInfo getPi() {
			return pi;
		}

		public void setPi(ParkInfo pi) {
			this.pi = pi;
		}

		public List<EnterpriseCorrBusiness> getCorrBusiness() {
			return corrBusiness;
		}

		public void setCorrBusiness(List<EnterpriseCorrBusiness> corrBusiness) {
			this.corrBusiness = corrBusiness;
		}

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}

		public List<Long> getIds() {
			return ids;
		}

		public void setIds(List<Long> ids) {
			this.ids = ids;
		}

		public boolean isApprovalEnableStatus() {
			return approvalEnableStatus;
		}

		public void setApprovalEnableStatus(boolean approvalEnableStatus) {
			this.approvalEnableStatus = approvalEnableStatus;
		}
		
    }
    
    public static class EnterpriseCottInfo{
    	
        private Long id;
        private Integer corrType;
        private Integer corrStatus;
        private Long parkId;
        private Long enterpriseId;
        private String name;
        private Integer createSource;
        private String contacts;
        private String phone;
        private Integer type;
        private String code;
        private String parkName;
        
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getCorrType() {
			return corrType;
		}
		public void setCorrType(Integer corrType) {
			this.corrType = corrType;
		}
		public Integer getCorrStatus() {
			return corrStatus;
		}
		public void setCorrStatus(Integer corrStatus) {
			this.corrStatus = corrStatus;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public Long getEnterpriseId() {
			return enterpriseId;
		}
		public void setEnterpriseId(Long enterpriseId) {
			this.enterpriseId = enterpriseId;
		}
		public Integer getCreateSource() {
			return createSource;
		}
		public void setCreateSource(Integer createSource) {
			this.createSource = createSource;
		}
		public String getContacts() {
			return contacts;
		}
		public void setContacts(String contacts) {
			this.contacts = contacts;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getParkName() {
			return parkName;
		}
		public void setParkName(String parkName) {
			this.parkName = parkName;
		}
        
    	
    }

}
