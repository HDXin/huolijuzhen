package com.sudaotech.huolijuzhen.resources.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.resources.dao.LocationResourceInfoEntityMapper;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class ResourceInfoServiceImpl extends BaseServiceImpl implements ResourceInfoService {
    private static final String TRACKING_TYPE = "ResourceInfo";

    @Inject
    private LocationResourceInfoEntityMapper resourceInfoEntityMapper;

    @Override
    public ResourceInfo getById(Long id) {
        ResourceInfoEntity entity = this.resourceInfoEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ResourceInfo.class);
        }

        return null;
    }

    @Override
    public Long create(ResourceInfo obj) {
        logger.debug("Creating ResourceInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_RESOURCE));

        ResourceInfoEntity entity = BeanUtils.copyProperties(obj, ResourceInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.resourceInfoEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ResourceInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public List<ResourceInfo> getByParentId(Long parentId) {
        ResourceInfoEntityExample example = new ResourceInfoEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL).andParentIdEqualTo(parentId);
        List<ResourceInfoEntity> entities = this.resourceInfoEntityMapper.selectByExample(example);
        if (!entities.isEmpty()) { 
            return BeanUtils.copyListProperties(entities, ResourceInfo.class);
        }
        return null;
    }

    @Override
    public List<ResourceInfo> getByQuery(Query query) {
        ResourceInfoEntityExample example = new ResourceInfoEntityExample();
        Criteria criteria = example.createCriteria().andStatusEqualTo(Status.NORMAL);
        if (query.getParentId() != null) {
            criteria.andParentIdEqualTo(query.getParentId());
        }
        if (query.getCodeList() != null) {
            criteria.andCodeIn(query.getCodeList());
        }
        if (query.getRoot() != null) {
            criteria.andIsRootEqualTo(query.getRoot());
        }
        if (query.getResInfoId() != null) {
            criteria.andResInfoIdEqualTo(query.getResInfoId());
        }
        if (query.getTierId() != null) {
            criteria.andTierIdEqualTo(query.getTierId());
        }
        List<ResourceInfoEntity> entities = this.resourceInfoEntityMapper.selectByExample(example);
        if (!entities.isEmpty()) {
            return BeanUtils.copyListProperties(entities, ResourceInfo.class);
        }
        return null;
    }

    @Override
    public void update(ResourceInfo obj) {
        logger.debug("Updating ResourceInfo: {}", obj);

        ResourceInfoEntity entity = BeanUtils.copyProperties(obj, ResourceInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.resourceInfoEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ResourceInfo: {}", obj);
    }

    @Override
    public Long save(ResourceInfo obj) {
        logger.debug("Saving ResourceInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<ResourceInfo> find(Query query) {
        Page<ResourceInfo> page = new Page<ResourceInfo>(query);
        ResourceInfoEntityExample example = new ResourceInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("createTime ASC");
        if (query.getResInfoId() != null) {
            criteria.andResInfoIdEqualTo(query.getResInfoId());
        }
        if (query.getTierId() != null) {
            criteria.andTierIdEqualTo(query.getTierId());
        }
        if (query.getParentId() != null) {
            criteria.andParentIdEqualTo(query.getParentId());
        }
        if (StringUtils.isNotBlank(query.getName())) {
            criteria.andNameLike(CodeUtil.replaceLikeWord(query.getName()));
        }
        if (query.getParkInfoId() != null) {
            criteria.andGardenIdEqualTo(query.getParkInfoId());
        }
        if (query.getRoot() != null) {
            criteria.andIsRootEqualTo(query.getRoot());
        }
        page.setTotal(this.resourceInfoEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ResourceInfoEntity> list = this.resourceInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ResourceInfo.class));
        }

        return page;
    }

	@Override
	public List<ResourceInfo> getByResInfoIds(List<Long> resInfoIds) {
		ResourceInfoEntityExample example = new ResourceInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("createTime ASC");
        if(CollectionUtils.isNotEmpty(resInfoIds)){
        	criteria.andIdIn(resInfoIds);
        }
        List<ResourceInfo> resourceInfos = BeanUtils.copyListProperties(this.resourceInfoEntityMapper.selectByExample(example),ResourceInfo.class);
        return resourceInfos;
	}

	@Override
	public List<Map<String, Object>> resOfAreaAll(Map<String, Object> paramsMap) {
		return this.resourceInfoEntityMapper.resOfAreaAll(paramsMap);
	}

	@Override
	public List<Map<String, Object>> resOfAreaUse(Map<String, Object> paramsMap) {
		return this.resourceInfoEntityMapper.resOfAreaUse(paramsMap);
	}

	@Override
	public List<Map<String, Object>> resOfNumAll(Map<String, Object> paramsMap) {
		return this.resourceInfoEntityMapper.resOfNumAll(paramsMap);
	}

	@Override
	public List<Map<String, Object>> resOfNumUse(Map<String, Object> paramsMap) {
		return this.resourceInfoEntityMapper.resOfNumUse(paramsMap);
	}

	@Override
	public Map<String, Object> resAvgBasicPrice(Map<String, Object> paramsMap) {
		List<Map<String, Object>> listMap = this.resourceInfoEntityMapper.resAvgBasicPrice(paramsMap);
		if(CollectionUtils.isNotEmpty(listMap)){
			return listMap.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Map<String, Object> resAvgRentPrice(Map<String, Object> paramsMap) {
		List<Map<String, Object>> listMap = this.resourceInfoEntityMapper.resAvgRentPrice(paramsMap);
		if(CollectionUtils.isNotEmpty(listMap)){
			return listMap.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Map<String, Object> resNoRentInfo(Map<String, Object> paramsMap) {
		List<Map<String, Object>> listMap = this.resourceInfoEntityMapper.resNoRentInfo(paramsMap);
		if(CollectionUtils.isNotEmpty(listMap)){
			return listMap.get(0);
		}else{
			return null;
		}
	}
}
