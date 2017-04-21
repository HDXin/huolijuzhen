package com.sudaotech.huolijuzhen.provider.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.TemplateLabelEntity;

public interface TemplateLabelService extends BaseService {

    public TemplateLabel getById(Long id);

    public Long create(TemplateLabel obj);

    public void update(TemplateLabel obj);

    public Long save(TemplateLabel obj);

    public Page<TemplateLabel> find(Query query);

    public List<TemplateLabel> findByObj(TemplateLabel templateLabel);
    
	public List<TemplateLabel> findUpItem(TemplateLabel templateLabel);

	public List<TemplateLabel> findDownItem(TemplateLabel templateLabel);
    
    public List<Map<String, Object>> findByApplyTemplateId(Long applateTemplateId);
    
    public static class Query extends Pagination {
    	
    	private Long applyTemplateId;

		public Long getApplyTemplateId() {
			return applyTemplateId;
		}

		public void setApplyTemplateId(Long applyTemplateId) {
			this.applyTemplateId = applyTemplateId;
		}
    }
    
    public static class TemplateLabel extends TemplateLabelEntity {
    }

	

}
