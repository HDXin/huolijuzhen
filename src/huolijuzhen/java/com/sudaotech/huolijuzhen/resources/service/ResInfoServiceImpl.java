package com.sudaotech.huolijuzhen.resources.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.ResInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableAvg;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class ResInfoServiceImpl extends BaseServiceImpl implements ResInfoService {
    private static final String TRACKING_TYPE = "ResInfo";

    @Inject
    private ResInfoEntityMapper resInfoEntityMapper;

    @Override
    public ResInfo getById(Long id) {
        ResInfoEntity entity = this.resInfoEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ResInfo.class);
        }

        return null;
    }

    @Override
    public Long create(ResInfo obj) {
        logger.debug("Creating ResInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_RESOURCE));

        ResInfoEntity entity = BeanUtils.copyProperties(obj, ResInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.resInfoEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ResInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(ResInfo obj) {
        logger.debug("Updating ResInfo: {}", obj);

        ResInfoEntity entity = BeanUtils.copyProperties(obj, ResInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.resInfoEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ResInfo: {}", obj);
    }

    @Override
    public Long save(ResInfo obj) {
        logger.debug("Saving ResInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<ResInfo> find(Query query) {
        Page<ResInfo> page = new Page<ResInfo>(query);
        ResInfoEntityExample example = new ResInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        if (StringUtils.isNotBlank(query.getName())) {
            criteria.andNameLike(CodeUtil.replaceLikeWord(query.getName()));
        }
        if (query.getEnableStatus() != null) {
            criteria.andEnableStatusEqualTo(query.getEnableStatus());
        }
        if (query.getResType() != null) {
            criteria.andResTypeEqualTo(query.getResType());
        }
        if(query.getParkInfoId()!=null){
            criteria.andGardenIdEqualTo(query.getParkInfoId());
        }
        page.setTotal(this.resInfoEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ResInfoEntity> list = this.resInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ResInfo.class));
        }

        return page;
    }

    @Override
    public List<ResInfo> findAll(Query query) {
        ResInfoEntityExample example = new ResInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        if(query.getParkInfoId()!=null){
            criteria.andGardenIdEqualTo(query.getParkInfoId());
        }
        example.setOrderByClause("name ASC");
        List<ResInfoEntity> resInfoEntityList = this.resInfoEntityMapper.selectByExample(example);
        if (!resInfoEntityList.isEmpty()) {
            return BeanUtils.copyListProperties(resInfoEntityList, ResInfo.class);
        }
        return null;
    }
    
    @Override
    public List<ResInfo> findAllByParkId(Long parkId) {
        ResInfoEntityExample example = new ResInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        criteria.andEnableAvgEqualTo(EnableAvg.ENABLE);
        if(parkId != null){
            criteria.andGardenIdEqualTo(parkId);
        }
        example.setOrderByClause("name ASC");
        List<ResInfoEntity> resInfoEntityList = this.resInfoEntityMapper.selectByExample(example);
        if (!resInfoEntityList.isEmpty()) {
            return BeanUtils.copyListProperties(resInfoEntityList, ResInfo.class);
        }
        return null;
    }
}
