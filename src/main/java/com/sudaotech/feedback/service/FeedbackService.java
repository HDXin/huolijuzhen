package com.sudaotech.feedback.service;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.feedback.dao.FeedbackEntity;

public interface FeedbackService extends BaseService {

    public Feedback getById(Long feedbackId);

    public Long create(Feedback obj);

    public void update(Feedback obj);

    public Long save(Feedback obj);

    public Page<Feedback> find(Query query);
    
    public static class Query extends Pagination {
        private Date beginTime;
        private Date endTime;
        public Date getBeginTime() {
            return beginTime;
        }
        public void setBeginTime(Date beginTime) {
            this.beginTime = beginTime;
        }
        public Date getEndTime() {
            return endTime;
        }
        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Feedback extends FeedbackEntity {
    }
}
