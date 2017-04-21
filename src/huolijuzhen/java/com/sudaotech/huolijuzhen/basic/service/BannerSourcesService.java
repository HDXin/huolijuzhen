package com.sudaotech.huolijuzhen.basic.service;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.DateSerializer;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntity;
import com.sudaotech.huolijuzhen.enums.ReqSourceType;

public interface BannerSourcesService extends BaseService {

    public BannerSources getById(Long id, ReqSourceType reqSourceType);

    public Long create(BannerSources obj);

    public void update(BannerSources obj);

    public Long save(BannerSources obj);

    public Page<BannerSources> find(Query query, ReqSourceType reqSourceType);
    
    public static class Query extends Pagination {
    }
    
    public static class BannerSources extends BannerSourcesEntity {
    	
    	@JsonSerialize(using=DateSerializer.class)
    	private Date createTime;
    	
    	@JsonSerialize(using=DateSerializer.class)
    	private Date updateTime;

    	@JsonSerialize(using=DateSerializer.class)
        private Date lastUpdate;
    	
		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public Date getLastUpdate() {
			return lastUpdate;
		}

		public void setLastUpdate(Date lastUpdate) {
			this.lastUpdate = lastUpdate;
		}
    	
    }
}