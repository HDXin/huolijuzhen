package com.sudaotech.huolijuzhen.basic.service;

import java.math.BigDecimal;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.CostProEntity;
import com.sudaotech.huolijuzhen.enums.ChargeMode;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

public interface CostProService extends BaseService {

    public CostPro getById(Long id);

    public Long create(CostPro obj);

    public void update(CostPro obj);

    public Long save(CostPro obj);

    public Page<CostPro> find(Query query);
    
    public List<CostPro> findByObj(CostPro cp);
    
    public static class Query extends Pagination {
    	
    	private String code;
    	
    	private String name;
    	
    	private ChargeMode chargeMode;
    	
    	private CreateSource createSource;
    	
    	private EnableStatus enableStatus;
    	
    	private Long parkId;
    	
    	private Integer isDefault;

		public EnableStatus getEnableStatus() {
			return enableStatus;
		}

		public void setEnableStatus(EnableStatus enableStatus) {
			this.enableStatus = enableStatus;
		}

		public CreateSource getCreateSource() {
			return createSource;
		}

		public void setCreateSource(CreateSource createSource) {
			this.createSource = createSource;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}

		public void setIsDefault(Integer isDefault) {
			this.isDefault = isDefault;
		}

		public Integer getIsDefault() {
			return isDefault;
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

		public ChargeMode getChargeMode() {
			return chargeMode;
		}

		public void setChargeMode(ChargeMode chargeMode) {
			this.chargeMode = chargeMode;
		}
    	
    }
    
    public static class CostProQuery extends Query {
    	
    }
    
    public static class CostPro extends CostProEntity {
    	
    	public static final String STATIC_CODE = "ES8080";
    	
    	public static final String  STATIC_NAME = "维修费";

    	public static final String  STATIC_COST_RATE = "0.06";
    	
    	private BigDecimal dosage = new BigDecimal("0");
		public BigDecimal getDosage() {
			return dosage;
		}
		public void setDosage(BigDecimal dosage) {
			this.dosage = dosage;
		}
    }
}
