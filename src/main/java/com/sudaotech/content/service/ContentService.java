package com.sudaotech.content.service;

import java.util.List;

import com.sudaotech.content.dao.ContentEntity;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;

public interface ContentService extends BaseService {

    public Content getById(Long contentId);

    public Long create(Content obj);

    public void update(Content obj);

    public Long save(Content obj);

    public Page<Content> find(ContentQuery query);
    
    public static class ContentQuery extends Pagination {
        private String title;
        private List<Integer> contentTypes;
        private String parent;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getParent() {
            return parent;
        }
        public void setParent(String parent) {
            this.parent = parent;
        }
        public List<Integer> getContentTypes() {
            return contentTypes;
        }
        public void setContentTypes(List<Integer> contentTypes) {
            this.contentTypes = contentTypes;
        }
    }
    
    public static class Content extends ContentEntity {
    }
}
