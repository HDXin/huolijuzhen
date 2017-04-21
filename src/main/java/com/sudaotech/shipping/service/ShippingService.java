package com.sudaotech.shipping.service;


import java.util.List;

import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseService;

public interface ShippingService extends BaseService{

    int createShipping(Shipping shipping, Session session);

    void deleteShipping(int id, Session session);
    
    void updateShipping(Shipping Shipping, Session session);
    
    Shipping getShippingById(int id, Session session);
    
    Shipping getShippingByNum(String num, Session session);
    
	int createShipping(Shipping shipping, Session session, boolean subscribe);

	List<Shipping> getSaleOrderShippings(Integer saleOrderId);

	/**
	 * 向kuaidi100订阅运单
	 */
	boolean postOrderOnKuaide100(Shipping shipping);

}
