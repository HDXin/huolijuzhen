package com.sudaotech.tag.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.tag.dao.TagEntity;

public interface TagService extends BaseService {

    public Tag getById(Long tagId);

    public Long create(Tag obj);

    public void update(Tag obj);

    public Long save(Tag obj);

    public Page<Tag> find(TagQuery query);
    
    public static class TagQuery extends Pagination {
        private String parent;
        public String getParent() {
            return parent;
        }
        public void setParent(String parent) {
            this.parent = parent;
        }
    }
    
    public static class Tag extends TagEntity {
    }
}
