package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntity;

public interface EnterpriseCorrBusinessService extends BaseService {

    public EnterpriseCorrBusiness getById(Long id);

    public Long create(EnterpriseCorrBusiness obj);

    public void update(EnterpriseCorrBusiness obj);

    public Long save(EnterpriseCorrBusiness obj);

    public Page<EnterpriseCorrBusiness> find(Query query);
    
    public List<EnterpriseCorrBusiness> findByObj(EnterpriseCorrBusiness obj);
    
    public static class Query extends Pagination {
    }
    
    public static class EnterpriseCorrBusiness extends EnterpriseCorrBusinessEntity {
    }
}
