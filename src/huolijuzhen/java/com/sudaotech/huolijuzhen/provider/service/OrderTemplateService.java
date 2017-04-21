package com.sudaotech.huolijuzhen.provider.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntity;

public interface OrderTemplateService extends BaseService {

    public OrderTemplate getById(Long id);

    public Long create(OrderTemplate obj);

    public void update(OrderTemplate obj);

    public Long save(OrderTemplate obj);

    public Page<OrderTemplate> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class OrderTemplate extends OrderTemplateEntity {
    }
}
