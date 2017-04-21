package com.sudaotech.huolijuzhen.park.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.ParkGroupUserMapper;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntityExample.Criteria;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

import java.util.Date;
import java.util.List;

public class ParkGroupUserInfoServiceImpl extends BaseServiceImpl implements ParkGroupUserInfoService {
    private static final String TRACKING_TYPE = "ParkGroupUserInfo";

    @Inject
    private ParkGroupUserMapper parkGroupUserMapper;

    @Override
    public ParkGroupUserInfo getById(Long id) {
        ParkGroupUserInfoEntity entity = this.parkGroupUserMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ParkGroupUserInfo.class);
        }

        return null;
    }

    @Override
    public List<ParkGroupUserInfo> getByParkGroupId(Long parkGroupId) {
        ParkGroupUserInfoEntityExample example = new ParkGroupUserInfoEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL).andParkGroupIdEqualTo(parkGroupId);
        List<ParkGroupUserInfoEntity> entities = this.parkGroupUserMapper.selectByExample(example);
        if (entities.isEmpty() == false) {
            return BeanUtils.copyListProperties(entities, ParkGroupUserInfo.class);
        }

        return null;
    }

    @Override
    public Long create(ParkGroupUserInfo obj) {
        logger.debug("Creating ParkGroupUserInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_PARK_GROUP));

        ParkGroupUserInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupUserInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.parkGroupUserMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ParkGroupUserInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(ParkGroupUserInfo obj) {
        logger.debug("Updating ParkGroupUserInfo: {}", obj);

        ParkGroupUserInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupUserInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.parkGroupUserMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ParkGroupUserInfo: {}", obj);
    }

    @Override
    public void updateStatusByParkGroupIds(Status status, List<ParkGroupUserInfo> parkGroupIds) {
        if (parkGroupIds != null && parkGroupIds.isEmpty() == false) {
            StringBuffer ids = new StringBuffer();
            for (ParkGroupUserInfo o : parkGroupIds) {
                ids.append(",").append(o.getParkGroupId());
            }
            String params =ids.toString().substring(1);
            this.parkGroupUserMapper.updateByStatusByParkGroupIds(status, params);
        }
    }

    @Override
    public Long save(ParkGroupUserInfo obj) {
        logger.debug("Saving ParkGroupUserInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<ParkGroupUserInfo> find(Query query) {
        Page<ParkGroupUserInfo> page = new Page<ParkGroupUserInfo>(query);
        ParkGroupUserInfoEntityExample example = new ParkGroupUserInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        page.setTotal(this.parkGroupUserMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ParkGroupUserInfoEntity> list = this.parkGroupUserMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ParkGroupUserInfo.class));
        }

        return page;
    }
}
