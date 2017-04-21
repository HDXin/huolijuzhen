package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntity;

public interface ContractDossierService extends BaseService {

    public ContractDossier getById(Long id);

    public Long create(ContractDossier obj);

    public void update(ContractDossier obj);

    public Long save(ContractDossier obj);

    public Page<ContractDossier> find(Query query);
    
    /**
     * 条件查询
     * @param query
     * @return
     */
    public List<ContractDossier> findByObj(ContractDossier obj);
    
    public static class Query extends Pagination {
    }
    
    public static class ContractDossier extends ContractDossierEntity {
    }
}
