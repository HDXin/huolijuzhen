/**
 * 
 */
package com.sudaotech.huolijuzhen.notice.service;
import java.util.HashMap;
import java.util.Map;

import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.notice.easemob.api.IMUserAPI;
import com.sudaotech.huolijuzhen.notice.easemob.api.SendMessageAPI;
import com.sudaotech.huolijuzhen.notice.easemob.comm.ClientContext;
import com.sudaotech.huolijuzhen.notice.easemob.comm.EasemobRestAPIFactory;
import com.sudaotech.huolijuzhen.notice.easemob.comm.body.IMUserBody;
import com.sudaotech.huolijuzhen.notice.easemob.comm.body.TextMessageBody;
import com.sudaotech.huolijuzhen.notice.easemob.comm.constant.MsgTargetType;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.BodyWrapper;

/**
 * @Describe:       
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        vacances
 *
 * @Package:        com.sudaotech.vacances.service.notice
 *
 * @Date:           2016年9月30日 下午1:29:04
 *
 */
public class NoticeParkServiceImpl extends BaseServiceImpl implements NoticeParkService {

	EasemobRestAPIFactory factory = ClientContext.getInstance(ClientContext.PARK_APP).init().getAPIFactory();

	@SuppressWarnings("unchecked")
	@Override
	public Object registerUser(Long userId) {
		
		IMUserAPI user = (IMUserAPI)factory.newInstance(EasemobRestAPIFactory.USER_CLASS);
		BodyWrapper userBody = new IMUserBody(userId.toString(),Constants.Notice.USER_PWD, userId.toString());
		
		return user.createNewIMUserSingle(userBody);
	}

	@Override
	public  Object sendNoicMessage(String receiver,String msg,String bizType,String bizId,String bizStatus){

	    SendMessageAPI message = (SendMessageAPI)factory.newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
	    Map<String, String> extMap=new HashMap<String, String>(); 
	    extMap.put("bizType",bizType);
	    extMap.put("bizId", bizId);
	    extMap.put("msgType", "NOTIFY");  //只发送通知
	    BodyWrapper  messageWrapper = new TextMessageBody(MsgTargetType.USERS,
								    		 new String[]{receiver},
								    		 null,
								    		 extMap, 
								    		 msg);
	    return message.sendMessage(messageWrapper);
	
	 }
	@Override
	public Object sendNoicMessage(String receiver, String msg, String bizType,
			String bizId) {
		return sendNoicMessage(receiver, msg, bizType, bizId, null);
	}

	
	@Override
	public Object sendNoicMessage(String receiver, String msg) {
		return sendNoicMessage(receiver, msg, null,null);
	}
	

	
}
