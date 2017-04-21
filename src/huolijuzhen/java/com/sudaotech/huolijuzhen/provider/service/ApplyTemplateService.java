package com.sudaotech.huolijuzhen.provider.service;

import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntity;
import com.sudaotech.huolijuzhen.provider.service.TemplateLabelService.TemplateLabel;

public interface ApplyTemplateService extends BaseService {

    public ApplyTemplate getById(Long id);

    public Long create(ApplyTemplate obj);

    public void update(ApplyTemplate obj);

    public Long save(ApplyTemplate obj);

    public Page<ApplyTemplate> find(Query query);
    
    public static class Query extends Pagination {
    	
    }
    
    public static class ApplyTemplate extends ApplyTemplateEntity {
    	
    	private List<TemplateLabel> templateLabels = new ArrayList<TemplateLabelService.TemplateLabel>();

		public List<TemplateLabel> getTemplateLabels() {
			return templateLabels;
		}

		public void setTemplateLabels(List<TemplateLabel> templateLabels) {
			this.templateLabels = templateLabels;
		}
    	
    	
    	
    }
}
