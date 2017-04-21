package com.sudaotech.huolijuzhen.provider.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntity;

public interface ServiceProjectHistoryService extends BaseService {

    public ServiceProjectHistory getById(Long id);

    public Long create(ServiceProjectHistory obj);

    public void update(ServiceProjectHistory obj);

    public Long save(ServiceProjectHistory obj);

    public Page<ServiceProjectHistory> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class ServiceProjectHistory extends ServiceProjectHistoryEntity {
    }

	public List<ServiceProjectHistory> findByObj(
			ServiceProjectHistory serviceProjectHistory);
}
