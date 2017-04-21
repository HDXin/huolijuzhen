package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntity;

public interface EnterpriseDossierService extends BaseService {

    public EnterpriseDossier getById(Long id);

    public Long create(EnterpriseDossier obj);

    public void update(EnterpriseDossier obj);

    public Long save(EnterpriseDossier obj);

    public Page<EnterpriseDossier> find(Query query);
    
    public List<EnterpriseDossier> findByObj(EnterpriseDossier obj);
    
    public static class Query extends Pagination {
    }
    
    public static class EnterpriseDossier extends EnterpriseDossierEntity {
    	
    	
    }
}
