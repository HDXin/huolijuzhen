package com.sudaotech.huolijuzhen.sys.common.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.sys.common.dao.OperatorHistoryEntity;

public interface OperatorHistoryService extends BaseService {

    public OperatorHistory getById(Long id);

    public Long create(OperatorHistory obj);

    public void update(OperatorHistory obj);

    public Long save(OperatorHistory obj);
    
    public Page<OperatorHistory> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class OperatorHistory extends OperatorHistoryEntity {
    }
}
