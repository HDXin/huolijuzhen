package com.sudaotech.user.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.user.dao.ExternalUserEntity;

public interface ExternalUserService extends BaseService {

    public ExternalUser getById(Long id);

    public Long create(ExternalUser obj);

    public void update(ExternalUser obj);

    public Long save(ExternalUser obj);

    public ExternalUser getByOpenId(String openId);

    
    public Page<ExternalUser> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class ExternalUser extends ExternalUserEntity {
    }
}
