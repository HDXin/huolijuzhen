package com.sudaotech.core.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService;

public abstract class BusinessBaseServiceImpl<T> extends BaseServiceImpl{
	
	@Inject
	protected ApprovalTypeItemService approvalTypeItemService;
	
	//封装额外信息
	protected List<T> packList(List<T> list) {
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		for(T item:list){
			packItem(item);
		}
		return list;
	}
	//封装额外信息
	protected abstract T packItem(T item);
	
}
