package com.sudaotech.huolijuzhen.resources.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntity;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntityMapper;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class UnitTierInfoServiceImpl extends BaseServiceImpl implements UnitTierInfoService {
    private static final String TRACKING_TYPE = "UnitTierInfo";

    @Inject
    private UnitTierInfoEntityMapper unitTierInfoEntityMapper;

    @Override
    public UnitTierInfo getById(Long id) {
        UnitTierInfoEntity entity = this.unitTierInfoEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, UnitTierInfo.class);
        }

        return null;
    }

    @Override
    public Long create(UnitTierInfo obj) {
        logger.debug("Creating UnitTierInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_RESOURCE));

        UnitTierInfoEntity entity = BeanUtils.copyProperties(obj, UnitTierInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.unitTierInfoEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created UnitTierInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(UnitTierInfo obj) {
        logger.debug("Updating UnitTierInfo: {}", obj);

        UnitTierInfoEntity entity = BeanUtils.copyProperties(obj, UnitTierInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.unitTierInfoEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated UnitTierInfo: {}", obj);
    }

    @Override
    public Long save(UnitTierInfo obj) {
        logger.debug("Saving UnitTierInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<UnitTierInfo> find(Query query) {
        Page<UnitTierInfo> page = new Page<UnitTierInfo>(query);
        UnitTierInfoEntityExample example = new UnitTierInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        if (StringUtils.isNotBlank(query.getName())) {
            criteria.andNameLike(CodeUtil.replaceLikeWord(query.getName()));
        }
        if (query.getEnableStatus() != null) {
            criteria.andEnableStatusEqualTo(query.getEnableStatus());
        }
        if (query.getResInfoId() != null) {
            criteria.andResInfoIdEqualTo(query.getResInfoId());
        }
        if (query.getBase() != null) {
            criteria.andIsBaseEqualTo(query.getBase());
        }
        if(query.getParkInfoId()!=null){
            criteria.andGardenIdEqualTo(query.getParkInfoId());
        }
        page.setTotal(this.unitTierInfoEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<UnitTierInfoEntity> list = this.unitTierInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, UnitTierInfo.class));
        }

        return page;
    }
}
