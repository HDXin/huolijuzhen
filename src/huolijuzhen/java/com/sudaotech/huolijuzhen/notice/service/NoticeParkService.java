/**
 * 
 */
package com.sudaotech.huolijuzhen.notice.service;

/**
 * 
 * @Describe:       通知 服务
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        vacances
 *
 * @Package:        com.sudaotech.vacances.service
 *
 * @Date:           2016年9月30日 下午1:24:40
 *
 */
public interface NoticeParkService {
	
	
    /**
     *       注册用户
     * @param record
     * 
     * @return
     */
	Object  registerUser(Long userId);
	
	/**
	 *       发送环信通知
	 * @param receiver
	 *        接收人
	 * @param msg
	 *        消息推送通知提示内容 
	 * @param bizType
	 *        业务类型（服务，账单，活动，任务）
	 * @param bizId
	 *        业务Id
     * @param bizStatus
     *        业务状态
	 * @return
	 */
    Object sendNoicMessage(String receiver,String msg,String bizType,String bizId,String bizStatus);
    
    /**
	 *        发送环信通知
	 * @param receiver
	 *        接收人
	 * @param msg
	 *        消息推送通知提示内容 
	 * @param bizType
	 *        业务类型（服务，账单，活动，任务）
	 * @param bizId
	 *        业务Id
	 * @return
	 */
    Object sendNoicMessage(String receiver,String msg,String bizType,String bizId);
    
    /**
	 *        发送环信通知
	 * @param receiver
	 *        接收人
	 * @param msg
	 *        消息推送通知提示内容 
	 * @return
	 *  
	 */      
    Object sendNoicMessage(String receiver, String msg);
}
