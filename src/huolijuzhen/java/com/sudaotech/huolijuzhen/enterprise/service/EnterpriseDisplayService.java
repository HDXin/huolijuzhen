package com.sudaotech.huolijuzhen.enterprise.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntity;

public interface EnterpriseDisplayService extends BaseService {

    public EnterpriseDisplay getById(Long id);

    public Long create(EnterpriseDisplay obj);

    public void update(EnterpriseDisplay obj);

    public Long save(EnterpriseDisplay obj);

    public Page<EnterpriseDisplay> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class EnterpriseDisplay extends EnterpriseDisplayEntity {
    }
}
