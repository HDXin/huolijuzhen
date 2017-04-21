package com.sudaotech.shipping.kuaidu100;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.shipping.ShippingConfig;
import com.sudaotech.shipping.service.Shipping;
import com.sudaotech.util.HttpUtils;
import com.sudaotech.util.JsonUtil;

public class Kuaidi100Utils {
	private static final Logger logger = LoggerFactory.getLogger(Kuaidi100Utils.class);
	
	public static boolean postOrder(Shipping shipping, ShippingConfig config) {
		
		if (shipping == null ||
			shipping.getShippingNo() == null ||
			shipping.getShippingFrom() == null ||
			shipping.getShippingTo() == null) {
			logger.debug("订阅成功  kuaidi100 fail, missing required params {}", shipping);
    		return false;
    	}
		
		TaskRequest req = new TaskRequest();
		
		if (shipping.getShippingCompanyId() != null) {
			req.setCompany(shipping.getShippingCompanyId());
		} else {
			// 可能传了公司名称，需要用公司id
			String comName = shipping.getShippingCompany();
			String comId = config.getKuaidi100comId(comName);
			if ( comId != null) {
				req.setCompany(comId);
			} else {
				logger.debug("订阅成功  kuaidi100 fail, company must be id in params {}", shipping);
				return false;
			}
		}
		
		
		req.setFrom(shipping.getShippingFrom());
		req.setTo(shipping.getShippingTo());
		req.setNumber(shipping.getShippingNo());
		req.setKey(config.getKuaidi100Key());
		req.getParameters().put("callbackurl", config.getKuaidi100CallbackURL());
		
		Map<String, String> p = new HashMap<String, String>(); 
		p.put("schema", "json");
		p.put("param", JsonUtil.toJson(req));
		
		try {
			TaskResponse resp = HttpUtils.post(config.getKuaidi100SubscribeURL(), p, TaskResponse.class);
			if(resp != null && resp.getResult() == true){
				logger.debug("订阅成功  kuaidi100 OK, for number {}, params {}", shipping.getShippingNo(), p);
				return true;
			} else {
				logger.debug("订阅失败  kuaidi100 FAILED, for number {}, params {}, result {}", shipping.getShippingNo(), p, JsonUtil.toJson(resp));
				return false;
			}
		} catch (Exception e) {
			logger.error("订阅失败  kuaidi100 ERROR, for number {}, params {}", shipping.getShippingNo(), p, e);
			return false;
		}
		
	}
}
