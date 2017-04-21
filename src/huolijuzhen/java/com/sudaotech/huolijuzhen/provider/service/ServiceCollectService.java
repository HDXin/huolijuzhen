package com.sudaotech.huolijuzhen.provider.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCollectEntity;

public interface ServiceCollectService extends BaseService {

    public ServiceCollect getById(Long id);

    public Long create(ServiceCollect obj);

    public void update(ServiceCollect obj);

    public Long save(ServiceCollect obj);
    
    public Integer findCollectNum(Long serviceProId);
    
    public Long isCollect(Long serviceProId,Long collectBy,Long parkId);

    public Page<ServiceCollect> find(Query query);
    
    public static class Query extends Pagination {
    	
    	private Long collectBy;
    	
    	private Long parkId;

		public Long getCollectBy() {
			return collectBy;
		}

		public void setCollectBy(Long collectBy) {
			this.collectBy = collectBy;
		}

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    }
    /**
     * 根据 服务项目 ID 与当前登录 用户 ID 获取收藏记录
     * @param collectService
     * @return
     */
	public Page<ServiceCollect> findByServiceCollect(
			CollectService collectService);
    
    public static class CollectService extends Pagination{
    	
    	private Long serviceCollectId;
    	private Long serviceProId;
    	private Long collectBy;
    	private Long parkId;
    	
		public Long getServiceProId() {
			return serviceProId;
		}
		public void setServiceProId(Long serviceProId) {
			this.serviceProId = serviceProId;
		}
		public Long getCollectBy() {
			return collectBy;
		}
		public void setCollectBy(Long collectBy) {
			this.collectBy = collectBy;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public Long getServiceCollectId() {
			return serviceCollectId;
		}
		public void setServiceCollectId(Long serviceCollectId) {
			this.serviceCollectId = serviceCollectId;
		}
    }
    
    public static class ServiceCollect extends ServiceCollectEntity {
    }

}
