package com.sudaotech.shipping.service;

import com.sudaotech.core.service.BaseServiceImpl;

public abstract class ShippingServiceImpl extends BaseServiceImpl implements ShippingService{
//
//    @Inject
//    private ShippingEntityMapper shippingEntityMapper;
//    
//    @Inject
//    private ConfigService configService;
//
//    @Override
//    public int createShipping(Shipping shipping,
//                    Session session) {
//    	
//    	if (shipping.getShippingCompanyId() == null) {
//    		ShippingConfig config = this.configService.getShippingConfig();
//    		String comId = config.getKuaidi100comId(shipping.getShippingCompany());
//    		if ( comId != null) {
//    			shipping.setShippingCompanyId(comId);
//    		} else {
//    			logger.debug("Shipping has no company id, set it to name {}", shipping);
//    			shipping.setShippingCompanyId(shipping.getShippingCompany());
//    		}
//    		
//    	}
//        ShippingEntity entity = BeanUtils.copyProperties(shipping, ShippingEntity.class);
//        int id = this.getSequenceService().next(SequenceType.DEFAULT);
//        entity.setShippingId(id);
//        EntityHelper.setCreateStatusFields(entity, Status.NORMAL, session);
//        shippingEntityMapper.insertSelective(entity);
//        return id;
//    }
//    
//    @Override
//    public int createShipping(Shipping shipping,
//                    Session session, boolean subscribe) {
//        int id = createShipping(shipping, session);
//        
//        // 向kuaidi100订阅请求
//        if (subscribe) {
//        	boolean success = postOrderOnKuaide100(shipping);
//        	if (!success) {
//        		// what if request failed?
//        		// maybe we should set a flag on shipping record
//        		logger.error("Failed to poll kuaidi100 when create shipping {}", id);
//        	}
//        }
//        return id;
//    }
//    
//    @Override
//    public boolean postOrderOnKuaide100(Shipping shipping) {
//    	boolean success = Kuaidi100Utils.postOrder(shipping, this.configService.getShippingConfig());
//    	if (!success) {
//    		// what if request failed?
//    		// maybe we should set a flag on shipping record
//    		logger.error("Failed to poll kuaidi100 shipping number {} of comapny {}", shipping.getShippingNo(), shipping.getShippingCompanyId());
//    	}
//    	return success;
//    }
//
//    @Override
//    public void deleteShipping(int id, Session session) {
//        ShippingEntity example = new ShippingEntity();
//        example.setShippingId(id);
//        deleteEntityByExampleLogically(example, session);
//    }
//
//
//    @Override
//    public void updateShipping(Shipping shipping,
//                    Session session) {
//        ShippingEntity entity = BeanUtils.copyProperties(shipping, ShippingEntity.class);
//        EntityHelper.setUpdateFields(entity, session);
//        shippingEntityMapper.updateByPrimaryKeySelective(entity);
//    }
//
//    @Override
//    public Shipping getShippingById(int id, Session session) {
//        ShippingEntity entity = shippingEntityMapper.selectByPrimaryKey(id);
//        Shipping shipping = BeanUtils.copyProperties(entity, Shipping.class);
//
//        return shipping;
//    }
//
//    @Override
//    public Shipping getShippingByNum(String num, Session session) {
//        ShippingEntityExample example = new ShippingEntityExample();
//        example.createCriteria().andShippingNoEqualTo(num);
//        example.setOrderByClause("createTime DESC");
//        List<ShippingEntity> list = this.shippingEntityMapper.selectByExample(example);
//        if(CollectionUtils.isEmpty(list)) {
//            return null;
//        }
//        
//        Shipping shipping = BeanUtils.copyProperties(list.get(0), Shipping.class);
//
//        return shipping;
//    }
//    
//    @Override
//    public List<Shipping> getSaleOrderShippings(Integer saleOrderId) {
//        ShippingEntityExample example = new ShippingEntityExample();
//        example.createCriteria().andSaleOrderIdEqualTo(saleOrderId);
//        
//        List<ShippingEntity> entityList = this.shippingEntityMapper.selectByExample(example);
//
//        List<Shipping> shippings = BeanUtils.copyListProperties(entityList, Shipping.class);
//        
//        return shippings;
//    }
}
