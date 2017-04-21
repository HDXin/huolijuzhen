package com.sudaotech.huolijuzhen.provider.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntity;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;

public interface ApplyLabelService extends BaseService {

    public ApplyLabel getById(Long id);

    public Long create(ApplyLabel obj);

    public void update(ApplyLabel obj);

    public Long save(ApplyLabel obj);

    public Page<ApplyLabel> find(Query query);
    
    public List<ApplyLabel> findAllByApplyOrderId(ApplyOrder applyOrder);
    
    public static class Query extends Pagination {
    }
    
    public static class ApplyLabel extends ApplyLabelEntity {
    }
}
