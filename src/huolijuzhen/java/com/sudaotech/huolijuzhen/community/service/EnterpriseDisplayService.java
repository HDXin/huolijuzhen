package com.sudaotech.huolijuzhen.community.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayEntity;
import com.sudaotech.huolijuzhen.community.dao.EnterpriseDisplayExtendsEntity;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;

public interface EnterpriseDisplayService extends BaseService {

    public EnterpriseDisplay getById(Long id);

    public Long create(EnterpriseDisplay obj);

    public void update(EnterpriseDisplay obj);

    public Long save(EnterpriseDisplay obj);
    
    //获取所有记录的id集合
    public List<Long> getAllIDs();

//    public Page<EnterpriseDisplay> find(Query query);
    
    public Map<String, Object> findWithinParkId(Query query, long parkId, ReqSourceType reqSourceType, EnterpriseDisplayExtends extendsEntity);
    public Map<String, Object> findWithinParkId(Query query, ReqSourceType reqSourceType, EnterpriseDisplayExtends extendsEntity);
    
    public Map<String, Object> findByParkIdAndEnterpriseId(Query query, long parkId, EnterpriseDisplayExtends extendsEntity);
    
    public Map<String, Object> findForHomepage(Query query, EnterpriseDisplayExtends extendsEntity);
    
    
    
    public static class Query extends Pagination {
    }
    
    public static class EnterpriseDisplay extends EnterpriseDisplayEntity {
    }
    
    public static class EnterpriseDisplayExtends extends EnterpriseDisplayExtendsEntity{
    	//企业id
    	private Long enterpriseId;

		public Long getEnterpriseId() {
			return enterpriseId;
		}

		public void setEnterpriseId(Long enterpriseId) {
			this.enterpriseId = enterpriseId;
		}
    }
}
