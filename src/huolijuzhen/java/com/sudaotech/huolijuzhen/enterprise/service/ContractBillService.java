package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntity;

public interface ContractBillService extends BaseService {

    public ContractBill getById(Long id);

    public Long create(ContractBill obj);

    public void update(ContractBill obj);

    public Long save(ContractBill obj);

    public Page<ContractBill> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class ContractBill extends ContractBillEntity {
    }

	public List<ContractBill> findAllPast(ContractBill contractBill);
}
