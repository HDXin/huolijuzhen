package com.sudaotech.picture.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.picture.dao.PictureEntity;

public interface PictureService extends BaseService {

    public Picture getById(Long pictureId);

    public Long create(Picture obj);

    public void update(Picture obj);

    public Page<Picture> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class Picture extends PictureEntity {
    }
}
