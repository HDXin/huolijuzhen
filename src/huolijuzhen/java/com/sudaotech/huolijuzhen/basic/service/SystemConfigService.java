package com.sudaotech.huolijuzhen.basic.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntity;

public interface SystemConfigService extends BaseService {

    public SystemConfig getById(Long id);
    
    /**
     * 通过园区id查询
     * */
    public List<SystemConfig> getByParkId(Long parkId);

    public Long create(SystemConfig obj);

    public void update(SystemConfig obj);

    public Long save(SystemConfig obj);

    public Page<SystemConfig> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class SystemConfig extends SystemConfigEntity {
    	
    	private String parkLogo;

		public String getParkLogo() {
			return parkLogo;
		}

		public void setParkLogo(String parkLogo) {
			this.parkLogo = parkLogo;
		}
    	
    }
}
