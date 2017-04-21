package com.sudaotech.comment.service;

import java.util.Date;
import java.util.List;

import com.sudaotech.comment.dao.CommentEntity;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;

public interface CommentService extends BaseService {

    public Comment getById(Long commentId);

    public Long create(Comment obj);

    public void update(Comment obj);

    public Long save(Comment obj);

    public List<Comment> list(ListQuery query);

    public Page<Comment> find(CommentQuery query);
    
    public static class ListQuery extends Pagination {
        /**最小评论ID，即返回的commentId>=minCommentId*/
        private Long minCommentId;
        /**开始时间，返回数据的createTime > startTime*/
        private Date startTime;
        
        private String parent;
        
        public Long getMinCommentId() {
            return minCommentId;
        }
        public void setMinCommentId(Long minCommentId) {
            this.minCommentId = minCommentId;
        }
        public Date getStartTime() {
            return startTime;
        }
        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }
        public String getParent() {
            return parent;
        }
        public void setParent(String parent) {
            this.parent = parent;
        }
    }

    public static class CommentQuery extends Pagination {
        private String parent;
        public String getParent() {
            return parent;
        }
        public void setParent(String parent) {
            this.parent = parent;
        }
    }
    

    public static class Comment extends CommentEntity {
    }
}
