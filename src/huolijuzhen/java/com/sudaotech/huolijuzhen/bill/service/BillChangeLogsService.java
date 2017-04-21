package com.sudaotech.huolijuzhen.bill.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntity;

public interface BillChangeLogsService extends BaseService {

    public BillChangeLogs getById(Long id);

    public Long create(BillChangeLogs obj);

    public void update(BillChangeLogs obj);

    public Long save(BillChangeLogs obj);

    public Page<BillChangeLogs> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class BillChangeLogs extends BillChangeLogsEntity {
    }
}
