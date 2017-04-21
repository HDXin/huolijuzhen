package com.sudaotech.huolijuzhen.transaction.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntity;

public interface TransactionRecordService extends BaseService {

    public TransactionRecord getById(Long id);

    public Long create(TransactionRecord obj);

    public void update(TransactionRecord obj);

    public Long save(TransactionRecord obj);

    public Page<TransactionRecord> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class TransactionRecord extends TransactionRecordEntity {
    }
}
