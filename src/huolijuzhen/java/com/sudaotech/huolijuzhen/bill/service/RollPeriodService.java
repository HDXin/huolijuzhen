package com.sudaotech.huolijuzhen.bill.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntity;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;

public interface RollPeriodService extends BaseService {

    public RollPeriod getById(Long id);

    public Long create(RollPeriod obj);

    public void update(RollPeriod obj);

    public Long save(RollPeriod obj);

    public Page<RollPeriod> find(Query query);

	public List<RollPeriod> findByObj(BillCostCalRules obj);
    
    public static class Query extends Pagination {
    }
    
    public static class RollPeriod extends RollPeriodEntity {
    }

}
