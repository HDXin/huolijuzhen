package com.sudaotech.picture.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Pagination;

public interface SwiperService extends BaseService {

	/**
	 * 创建轮播图
	 * @param swiperVo
	 * @return
	 */
	long createSwiper(SwiperVo swiperVo);
	
	/**
	 * 修改轮播图
	 * @param swiperVo
	 * @return
	 */
	int updSwiper(SwiperVo swiperVo);
	
	/**
	 * 分页查询-后端调用
	 * @return
	 */
	List<SwiperVo> getSwiperList4Page(Query query);
	
	/**
	 * 首页轮播图获取
	 * @return
	 */
	List<SwiperVo> getSwiperList();
	
	public static class Query extends Pagination{}
	public static class SwiperVo{}
}
