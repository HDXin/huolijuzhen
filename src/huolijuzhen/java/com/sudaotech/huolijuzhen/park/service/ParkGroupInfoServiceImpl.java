package com.sudaotech.huolijuzhen.park.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntityMapper;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class ParkGroupInfoServiceImpl extends BaseServiceImpl implements ParkGroupInfoService {
    private static final String TRACKING_TYPE = "ParkGroupInfo";

    @Inject
    private ParkGroupInfoEntityMapper parkGroupInfoEntityMapper;

    @Override
    public ParkGroupInfo getById(Long id) {
        ParkGroupInfoEntity entity = this.parkGroupInfoEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ParkGroupInfo.class);
        }

        return null;
    }

    @Override
    public Long create(ParkGroupInfo obj) {
        logger.debug("Creating ParkGroupInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_PARK_GROUP));

        ParkGroupInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.parkGroupInfoEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ParkGroupInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(ParkGroupInfo obj) {
        logger.debug("Updating ParkGroupInfo: {}", obj);

        ParkGroupInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.parkGroupInfoEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ParkGroupInfo: {}", obj);
    }

    @Override
    public Long save(ParkGroupInfo obj) {
        logger.debug("Saving ParkGroupInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public ParkGroupInfo findByQuery(Query query) {
        ParkGroupInfoEntityExample example = new ParkGroupInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        if (query.getName() != null) {
            criteria.andNameEqualTo(query.getName());
        }
        List<ParkGroupInfoEntity> entities = this.parkGroupInfoEntityMapper.selectByExample(example);
        if (entities.isEmpty() == false) {
            return BeanUtils.copyProperties(entities.get(0), ParkGroupInfo.class);
        }
        return null;
    }

    @Override
    public Page<ParkGroupInfo> find(Query query) {
        Page<ParkGroupInfo> page = new Page<ParkGroupInfo>(query);
        ParkGroupInfoEntityExample example = new ParkGroupInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        if (StringUtils.isNotBlank(query.getName())) {
            criteria.andNameLike(CodeUtil.replaceLikeWord(query.getName()));
        }
        if (query.getEnableStatus() != null) {
            criteria.andEnableStatusEqualTo(query.getEnableStatus());
        }
        page.setTotal(this.parkGroupInfoEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ParkGroupInfoEntity> list = this.parkGroupInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ParkGroupInfo.class));
        }

        return page;
    }
}
