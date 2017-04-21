package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntity;

public interface BillCollectionRecordService extends BaseService {

    public BillCollectionRecord getById(Long id);

    public Long create(BillCollectionRecord obj);

    public void update(BillCollectionRecord obj);

    public Long save(BillCollectionRecord obj);

    public Page<BillCollectionRecord> find(Query query);
    
    public List<BillCollectionRecord> findByOBj(BillCollectionRecord record);
    
    public void deteleByBillId(BillCollectionRecord obj);
    
    /**
     * 通过账单Id 获得收款总额
     * @param bill
     */
    public BigDecimal getTotalCollectioin(Long billId);
    
    
    public static class Query extends Pagination {
    }
    
    public static class BillCollectionRecord extends BillCollectionRecordEntity {
    	
    	private List<Long> billIds;

		public List<Long> getBillIds() {
			return billIds;
		}

		public void setBillIds(List<Long> billIds) {
			this.billIds = billIds;
		}
    	
    	
    	
    	
    }
}