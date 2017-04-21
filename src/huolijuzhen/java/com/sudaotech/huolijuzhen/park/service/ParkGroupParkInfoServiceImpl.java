package com.sudaotech.huolijuzhen.park.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.ParkGroupParkInfoMapper;
import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntityExample;
import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntityExample.Criteria;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

import java.util.Date;
import java.util.List;

public class ParkGroupParkInfoServiceImpl extends BaseServiceImpl implements ParkGroupParkInfoService {
    private static final String TRACKING_TYPE = "ParkGroupParkInfo";

    @Inject
    private ParkGroupParkInfoMapper parkGroupParkMapper;

    @Override
    public ParkGroupParkInfo getById(Long id) {
        ParkGroupParkInfoEntity entity = this.parkGroupParkMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, ParkGroupParkInfo.class);
        }

        return null;
    }

    @Override
    public List<ParkGroupParkInfo> getByParkGroupId(Long id) {
        ParkGroupParkInfoEntityExample example = new ParkGroupParkInfoEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL).andParkGroupIdEqualTo(id);
        List<ParkGroupParkInfoEntity> entities = this.parkGroupParkMapper.selectByExample(example);
        if (entities.isEmpty() == false) {
            return BeanUtils.copyListProperties(entities, ParkGroupParkInfo.class);
        }
        return null;
    }

    @Override
    public Long create(ParkGroupParkInfo obj) {
        logger.debug("Creating ParkGroupParkInfo: {}", obj);

        obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_PARK_GROUP));

        ParkGroupParkInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupParkInfoEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.parkGroupParkMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created ParkGroupParkInfo: {}", obj);

        return obj.getId();
    }

    @Override
    public void updateStatusByParkGroupIds(Status status, List<ParkGroupParkInfo> parkGroupIds) {
        if (parkGroupIds != null && parkGroupIds.isEmpty() == false) {
            StringBuffer ids = new StringBuffer();
            for (ParkGroupParkInfo o : parkGroupIds) {
                ids.append(",").append(o.getParkGroupId());
            }
            String params = ids.toString().substring(1);
            this.parkGroupParkMapper.updateByStatusByParkGroupIds(status, params);
        }
    }

    @Override
    public void update(ParkGroupParkInfo obj) {
        logger.debug("Updating ParkGroupParkInfo: {}", obj);

        ParkGroupParkInfoEntity entity = BeanUtils.copyProperties(obj, ParkGroupParkInfoEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.parkGroupParkMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated ParkGroupParkInfo: {}", obj);
    }

    @Override
    public Long save(ParkGroupParkInfo obj) {
        logger.debug("Saving ParkGroupParkInfo: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<ParkGroupParkInfo> find(Query query) {
        Page<ParkGroupParkInfo> page = new Page<ParkGroupParkInfo>(query);
        ParkGroupParkInfoEntityExample example = new ParkGroupParkInfoEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("id DESC");
        page.setTotal(this.parkGroupParkMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<ParkGroupParkInfoEntity> list = this.parkGroupParkMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, ParkGroupParkInfo.class));
        }

        return page;
    }
}
