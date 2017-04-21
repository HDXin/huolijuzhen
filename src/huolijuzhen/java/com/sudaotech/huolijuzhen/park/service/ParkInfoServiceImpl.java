package com.sudaotech.huolijuzhen.park.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.ParkInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ParkInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.park.dao.LocationParkInfoEntityMapper;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class ParkInfoServiceImpl extends BaseServiceImpl implements ParkInfoService {
    private static final String TRACKING_TYPE = "ParkInfo";

    @Inject
    private LocationParkInfoEntityMapper parkInfoEntityMapper;

    @Override
    public ParkInfo getById(Long id) {
        ParkInfoEntity entity = this.parkInfoEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ParkInfo.class);
        }

        return null;
    }

    @Override
    public ParkInfo getByPositionId(Long id) {
        ParkInfoEntityExample example = new ParkInfoEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL).andPositionIdEqualTo(id);
        List<ParkInfoEntity> entities = this.parkInfoEntityMapper.selectByExample(example);
        if (entities.isEmpty() == false) {
            return BeanUtils.copyProperties(entities.get(0), ParkInfo.class);
        }
        return null;
    }

    @Override
    public Long create(ParkInfo obj) {
        logger.debug("Creating ParkInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_PARK));

        ParkInfoEntity entity = BeanUtils.copyProperties(obj, ParkInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.parkInfoEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ParkInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(ParkInfo obj) {
        logger.debug("Updating ParkInfo: {}", obj);

        ParkInfoEntity entity = BeanUtils.copyProperties(obj, ParkInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.parkInfoEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ParkInfo: {}", obj);
    }

    @Override
    public Long save(ParkInfo obj) {
        logger.debug("Saving ParkInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<ParkInfo> find(Query query) {
        Page<ParkInfo> page = new Page<ParkInfo>(query);
        ParkInfoEntityExample example = new ParkInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        if(StringUtils.isNotBlank(query.getName())){
            criteria.andNameLike(CodeUtil.replaceLikeWord(query.getName()));
        }
        if(query.getProvinceId()!=null){
            criteria.andProvinceIdEqualTo(query.getProvinceId());
        }
        if(query.getCityId()!=null){
            criteria.andCityIdEqualTo(query.getCityId());
        }
        if(query.getCounId()!=null){
            criteria.andRegionIdEqualTo(query.getCounId());
        }
        if(query.getLocationId()!=null){
            criteria.andPositionIdEqualTo(query.getLocationId());
        }
        if(query.getEnableStatus() !=null){
        	criteria.andEnableStatusEqualTo(query.getEnableStatus());
        }
        
        page.setTotal(this.parkInfoEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ParkInfoEntity> list = this.parkInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ParkInfo.class));
        }

        return page;
    }

    /**
     * 根据行政区信息获取所有的园区 ID
     */
	@Override
	public List<Long> findAllParkIds(Map<String, Object> locationIds) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.putAll(locationIds);
		params.put("status", Status.NORMAL.code());

		List<Long> parkIds =  parkInfoEntityMapper.findAllParkIdsByLocation(params);
		
		return parkIds;
	}

	/**
	 * 根据园区ID获取园区列表
	 */
	@Override
	public List<ParkInfo> findParkInfosByParkIds(List<Long> parkIds) {
		
		ParkInfoEntityExample example = new ParkInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        criteria.andIdIn(parkIds);
        
        example.setOrderByClause("id DESC");
		List<ParkInfoEntity> parkInfoEntitys = this.parkInfoEntityMapper.selectByExample(example);
		return BeanUtils.copyListProperties(parkInfoEntitys, ParkInfo.class);
	}

	@Override
	public Integer statisticsPark(Map<String, Object> params) {
		return this.parkInfoEntityMapper.statisticsPark(params);
	}
}
