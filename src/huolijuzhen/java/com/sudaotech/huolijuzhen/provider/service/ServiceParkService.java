package com.sudaotech.huolijuzhen.provider.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ServiceParkEntity;

public interface ServiceParkService extends BaseService {

    public ServicePark getById(Long id);

    public Long create(ServicePark obj);

    public void update(ServicePark obj);

    public Long save(ServicePark obj);

    public Page<ServicePark> find(Query query);
    
    public List<Long> findAllBySql(Map<String, Object> params);
    
    public List<Long> findAllValidServiceProId(Map<String, Object> parmas);
    
    public Map<String, Object> findBySql(Map<String, Object> params);
    
    public List<Long> findAllParkIdsByServiceProIdAndRelease(Long serviceProId,Integer serviceProRelease);
    
    public void updateByServiceProIdAndRelease(Long id,Integer serviceProRelease);
    
    public static class Query extends Pagination {
    }
    
    public static class ServicePark extends ServiceParkEntity {
    }

	
}
