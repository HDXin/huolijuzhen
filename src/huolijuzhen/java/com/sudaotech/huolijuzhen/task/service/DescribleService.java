package com.sudaotech.huolijuzhen.task.service;

import java.util.List;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.task.dao.DescribleEntity;

public interface DescribleService extends BaseService {

    public Describle getById(Long id);

    public Long create(Describle obj);

    public void update(Describle obj);

    public Long save(Describle obj);

    public Page<Describle> find(Query query);
    
    public List<Describle> findAll(Long parkId);
    
    public static class Query extends Pagination {
    	
    	private String description;
    	private String enableStatus;
    	private Long parkId;
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(String enableStatus) {
			this.enableStatus = enableStatus;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    }
    
    public static class Describle extends DescribleEntity {
    }
}
