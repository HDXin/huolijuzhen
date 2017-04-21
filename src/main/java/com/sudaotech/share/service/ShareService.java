package com.sudaotech.share.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.share.dao.ShareEntity;

public interface ShareService extends BaseService {

    public Share getById(Long shareId);
    public int getShareCountByTargetId(int type, Long targetId);
    public int getShareCountByTarget(int type, String target);

    public Long create(Share obj);

    public void update(Share obj);

    public Long save(Share obj);

    public Page<Share> find(ShareQuery query);
    
    public static class ShareQuery extends Pagination {
    }
    
    public static class Share extends ShareEntity {
    }
}
