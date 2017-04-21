package com.sudaotech.huolijuzhen.bill.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntity;

public interface BillPayVoucherService extends BaseService {

    public BillPayVoucher getById(Long id);

    public Long create(BillPayVoucher obj);

    public void update(BillPayVoucher obj);

    public Long save(BillPayVoucher obj);

    public Page<BillPayVoucher> find(Query query);
    
    public List<BillPayVoucher> findByObj(BillPayVoucher record);
    
    public static class Query extends Pagination {
    }
    
    public static class BillPayVoucher extends BillPayVoucherEntity {
    	
    	 
    }
}
