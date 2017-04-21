package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntity;
import com.sudaotech.huolijuzhen.enums.ChargeMode;

public interface BillCostDetailService extends BaseService {

    public BillCostDetail getById(Long id);

    public Long create(BillCostDetail obj);

    public void update(BillCostDetail obj);
    
    public void updateObj(BillCostDetail obj) ;

    public Long save(BillCostDetail obj);

    public Page<BillCostDetail> find(Query query);
    
    public List<BillCostDetail> findByObj(BillCostDetail bcd);
    
    /**
     * 通过账单Id 获得已分摊总额
     * @param bill
     */
    public BigDecimal getTotalApportion(Long billId);
    
    public static class Query extends Pagination {
    }
    
    public static class BillCostDetail extends BillCostDetailEntity {
    	//计费方式
    	private ChargeMode chargeMode;

		public ChargeMode getChargeMode() {
			return chargeMode;
		}

		public void setChargeMode(ChargeMode chargeMode) {
			this.chargeMode = chargeMode;
		}

		
		//维修申报
    	private List<Long> taskIds = new ArrayList<Long>();
		public List<Long> getTaskIds() {
			return taskIds;
		}
		public void setTaskIds(List<Long> taskIds) {
			this.taskIds = taskIds;
		}

    }
}
