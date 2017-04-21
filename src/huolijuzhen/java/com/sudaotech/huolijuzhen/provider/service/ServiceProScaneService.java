package com.sudaotech.huolijuzhen.provider.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntity;

public interface ServiceProScaneService extends BaseService {

    public ServiceProScane getById(Long id);

    public Long create(ServiceProScane obj);

    public void update(ServiceProScane obj);

    public Long save(ServiceProScane obj);

    public Page<ServiceProScane> find(Query query);
    
    public List<ServiceProScane> findByObj(ServiceProScane serviceProScane);
    
    public static class Query extends Pagination {
    }
    
    public static class ServiceProScane extends ServiceProScaneEntity {
    }
}
