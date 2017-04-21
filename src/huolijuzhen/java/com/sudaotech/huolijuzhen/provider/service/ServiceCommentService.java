package com.sudaotech.huolijuzhen.provider.service;

import java.math.BigDecimal;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCommentEntity;

public interface ServiceCommentService extends BaseService {

    public ServiceComment getById(Long id);

    public Long create(ServiceComment obj);

    public void update(ServiceComment obj);

    public Long save(ServiceComment obj);

    public Page<ServiceComment> find(Query query);
    
    public List<Integer> findGradeNum(Long serviceProId);
    
    public static class Query extends Pagination {
    	
    	private Long serviceProId;

		public Long getServiceProId() {
			return serviceProId;
		}

		public void setServiceProId(Long serviceProId) {
			this.serviceProId = serviceProId;
		}
    	
    }
    
    public static class ServiceComment extends ServiceCommentEntity {
    	
    	private String tempPrice;

		public String getTempPrice() {
			return tempPrice;
		}

		public void setTempPrice(String tempPrice) {
			this.tempPrice = tempPrice;
			BigDecimal price = new BigDecimal(tempPrice);
			setPrice(price);
		}
    }
}
