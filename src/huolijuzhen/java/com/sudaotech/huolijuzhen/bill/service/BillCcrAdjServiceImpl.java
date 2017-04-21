package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCcrAdjEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BillCcrAdjServiceImpl extends BaseServiceImpl implements BillCcrAdjService {
	private static final String TRACKING_TYPE = "BillCcrAdj";

    @Inject
    private BillCcrAdjEntityMapper billCcrAdjEntityMapper;

	@Override
	public BillCcrAdj getById(Long id) {
		BillCcrAdjEntity entity = this.billCcrAdjEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillCcrAdj.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillCcrAdj obj) {
		logger.debug("Creating BillCcrAdj: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL_CCR_ADJ));
		
		BillCcrAdjEntity entity = BeanUtils.copyProperties(obj, BillCcrAdjEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billCcrAdjEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillCcrAdj: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillCcrAdj obj) {
		logger.debug("Updating BillCcrAdj: {}", obj);

		BillCcrAdjEntity entity = BeanUtils.copyProperties(obj, BillCcrAdjEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billCcrAdjEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCcrAdj: {}", obj);
	}

	@Override
	public Long save(BillCcrAdj obj) {
		logger.debug("Saving BillCcrAdj: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillCcrAdj> find(Query query) {
		Page<BillCcrAdj> page = new Page<BillCcrAdj>(query);
		BillCcrAdjEntityExample example = new BillCcrAdjEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billCcrAdjEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillCcrAdjEntity> list = this.billCcrAdjEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillCcrAdj.class));
		}
		
		return page;
	}

	@Override
	public List<BillCcrAdj> findByBccrId(Long bccrId) {
		BillCcrAdjEntityExample example = new BillCcrAdjEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andBccrIdEqualTo(bccrId);
		example.setOrderByClause("adjMonth ASC");
		
		return BeanUtils.copyListProperties(this.billCcrAdjEntityMapper.selectByExample(example), BillCcrAdj.class);
	}

	@Override
	public Map<String, Object> findByBccrIdAndMonth(Long bccrId, List<String> months) {
		
		BillCcrAdjEntityExample example = new BillCcrAdjEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andBccrIdEqualTo(bccrId);
		criteria.andAdjMonthIn(months);
		example.setOrderByClause("adjMonth ASC");
		
		List<BillCcrAdj> billCcrAdjs = BeanUtils.copyListProperties(this.billCcrAdjEntityMapper.selectByExample(example),BillCcrAdj.class);
		Map<String,Object> billCcrAdjMap = new HashedMap<String, Object>();
		if(CollectionUtils.isNotEmpty(billCcrAdjs)){
			for(BillCcrAdj item:billCcrAdjs){
				BigDecimal adjAMount = item.getAdjAmount();
				String month = item.getAdjMonth();
				
				Object currentAdjAmount = billCcrAdjMap.get(month);
				if(currentAdjAmount == null){
					billCcrAdjMap.put(month, adjAMount);
					continue;
				}
				BigDecimal adjAmountBigDecimal = (BigDecimal)currentAdjAmount;
				billCcrAdjMap.put(month, adjAmountBigDecimal.add(adjAMount));
			}
		}
		
		return billCcrAdjMap;
	}
}
