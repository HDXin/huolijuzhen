package com.sudaotech.huolijuzhen.provider.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ApplyEntity;

public interface ApplyService extends BaseService {

    public Apply getById(Long id);

    public Long create(Apply obj);

    public void update(Apply obj);

    public Long save(Apply obj);

    public Page<Apply> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class Apply extends ApplyEntity {
    }
}
