package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService.EnterpriseDossier;
import com.sudaotech.huolijuzhen.enums.CreateSource;

public interface EnterpriseInfoService extends BaseService {

    public EnterpriseInfo getById(Long id);

    public Long create(EnterpriseInfo obj);

    public void update(EnterpriseInfo obj);

    public Long save(EnterpriseInfo obj);

    public Page<EnterpriseInfo> find(Query query);
    
    public Integer enterpriseInfoStatistics(Map<String, Object> params);
    
    public List<EnterpriseInfo> findByObj(EnterpriseInfo ei);
    
    //通过统一社会信用代码/工商注册号获取企业信息
    public EnterpriseInfo findByCode(String code);
    
    public static class Query extends Pagination {
    	private String name;
    	
    	private CreateSource createSource;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public CreateSource getCreateSource() {
			return createSource;
		}

		public void setCreateSource(CreateSource createSource) {
			this.createSource = createSource;
		}
    	
    	
    	
    	
    }
    
    public static class EnterpriseInfo extends EnterpriseInfoEntity {
    	
    	//
    	private List<Long> ids;
    	
    	//手机验证码
    	private String phoneCode;
    	
    	
    	public List<Long> getIds() {
			return ids;
		}

		public void setIds(List<Long> ids) {
			this.ids = ids;
		}

		//档案信息
        private List<EnterpriseDossier>  enterpriseDossiers;

		public List<EnterpriseDossier> getEnterpriseDossiers() {
			return enterpriseDossiers;
		}

		public void setEnterpriseDossiers(List<EnterpriseDossier> enterpriseDossiers) {
			this.enterpriseDossiers = enterpriseDossiers;
		}

		public String getPhoneCode() {
			return phoneCode;
		}

		public void setPhoneCode(String phoneCode) {
			this.phoneCode = phoneCode;
		}

        
        
    	
    }
}
