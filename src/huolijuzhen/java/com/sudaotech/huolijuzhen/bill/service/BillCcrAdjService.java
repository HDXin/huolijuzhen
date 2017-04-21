package com.sudaotech.huolijuzhen.bill.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntity;

public interface BillCcrAdjService extends BaseService {

    public BillCcrAdj getById(Long id);

    public Long create(BillCcrAdj obj);

    public void update(BillCcrAdj obj);

    public Long save(BillCcrAdj obj);
    
    public List<BillCcrAdj> findByBccrId(Long id);
    
    public Map<String, Object> findByBccrIdAndMonth(Long bccrId,List<String> months);

    public Page<BillCcrAdj> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class BillCcrAdj extends BillCcrAdjEntity {
    }

	
}
