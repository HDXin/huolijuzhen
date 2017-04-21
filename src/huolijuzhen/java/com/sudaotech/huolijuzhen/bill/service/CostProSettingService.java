package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.service.CostProService;
import com.sudaotech.huolijuzhen.basic.service.CostProService.CostPro;
import com.sudaotech.huolijuzhen.bill.dao.CostProSettingEntity;

public interface CostProSettingService extends BaseService {

    public CostProSetting getById(Long id);

    public Long create(CostProSetting obj);

    public void update(CostProSetting obj);

    public Long save(CostProSetting obj);

    public Page<CostProSetting> find(Query query);
    
    public CostProSetting findByObject(CostProSetting costProSetting);

	public List<CostProSetting> findAllByObject(CostProSetting costProSetting);
    
    public static class Query extends Pagination {
    	private String billMonth;

		public String getBillMonth() {
			return billMonth;
		}

		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}
    }
    
    public static class CostProSetting extends CostProSettingEntity {
    	
    	private List<CostPro> costPros = new ArrayList<CostPro>();

		public List<CostPro> getCostPros() {
			return costPros;
		}

		public void setCostPros(List<CostPro> costPros) {
			this.costPros = costPros;
		}
    }
    
    public static class costProSettingUpdate extends CostProSettingEntity{
    	private Long contractId;
    	private String billMont;
    	private BigDecimal dosage = new BigDecimal("0");
    	private Long costProType;
		public Long getContractId() {
			return contractId;
		}
		public void setContractId(Long contractId) {
			this.contractId = contractId;
		}
		public String getBillMont() {
			return billMont;
		}
		public void setBillMont(String billMont) {
			this.billMont = billMont;
		}
		public BigDecimal getDosage() {
			return dosage;
		}
		public void setDosage(BigDecimal dosage) {
			this.dosage = dosage;
		}
		public Long getCostProType() {
			return costProType;
		}
		public void setCostProType(Long costProType) {
			this.costProType = costProType;
		}
    }
    
    public static class NewCostProSetting extends CostProSettingEntity{
    	private Long enterpriseId;
    	private String enterpriseName;
    	private Long contractId;
    	private String contractNo;
    	private Long costProType;
    	private String billMonth;
    	private Long parkId;
    	private List<CostPro> costPros = new ArrayList<CostProService.CostPro>();
		public Long getEnterpriseId() {
			return enterpriseId;
		}
		public void setEnterpriseId(Long enterpriseId) {
			this.enterpriseId = enterpriseId;
		}
		public String getEnterpriseName() {
			return enterpriseName;
		}
		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}
		public Long getContractId() {
			return contractId;
		}
		public void setContractId(Long contractId) {
			this.contractId = contractId;
		}
		public String getContractNo() {
			return contractNo;
		}
		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}
		public List<CostPro> getCostPros() {
			return costPros;
		}
		public void setCostPros(List<CostPro> costPros) {
			this.costPros = costPros;
		}
		public Long getCostProType() {
			return costProType;
		}
		public void setCostProType(Long costProType) {
			this.costProType = costProType;
		}
		public String getBillMonth() {
			return billMonth;
		}
		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    }

}
