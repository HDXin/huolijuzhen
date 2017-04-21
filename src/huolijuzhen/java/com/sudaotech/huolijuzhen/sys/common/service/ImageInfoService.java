package com.sudaotech.huolijuzhen.sys.common.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.sys.common.dao.ImageInfoEntity;

public interface ImageInfoService extends BaseService {

    public ImageInfo getById(Long id);

    public Long create(ImageInfo obj);

    public void update(ImageInfo obj);

    public Long save(ImageInfo obj);

    public Page<ImageInfo> find(Query query);
    
    public List<ImageInfo> findAllByImageTypeAndTargetId(ImageType imageType,Long targetId);
    
//    public List<ImageInfo> findAll(ImageType imageType,Long targetId);
    
    public static class Query extends Pagination {
    }
    
    public static class ImageInfo extends ImageInfoEntity {
    	
    	private boolean isAll = false;

		public Boolean getIsAll() {
			return isAll;
		}

		public void setIsAll(Boolean isAll) {
			this.isAll = isAll;
		}
    }

	public int deleteMore(ImageType imageType, Long targetId);

	public List<ImageInfo> findByObj(ImageInfo imageInfo);
}
