package com.sudaotech.huolijuzhen.sys.common.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import org.apache.commons.collections4.CollectionUtils;

import com.sudaotech.huolijuzhen.announcement.service.AnnouncementService.Announcement;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;
import com.sudaotech.message.MsgBizType;

@SuppressWarnings("Duplicates")
@Path("/app/enterprise/message")
public abstract class MessageBaseResource extends BusinessBaseResource {

	
    /**
     * 将消息列表转换成处理后的消息列表
     * @param temps
     * @return
     */
    protected List<Message> messagesToMessages(List<Message> temps){
    	
    	List<Message> messages = new ArrayList<Message>();
    	if(CollectionUtils.isEmpty(temps)){
    		return messages;
    	}
    	for(Message item:temps){
       	 
         messages.add(messageToMessage(item));
    	}
    	return messages;
    }
    
    /**
     * 将消息处理后返回
     * @param temp
     * @return
     */
    protected Message messageToMessage(Message temp){
    	
    	Map<String, Object> contentMap = new HashMap<String, Object>();
    	MsgBizType msgBizType = temp.getMsgBizType();
    	contentMap.put("detailUrl", "");
		if(MsgBizType.NOTICE.equals(msgBizType)){
		    //详情页面（h5）
		    contentMap.put("detailUrl", HuolijuzhenConfig.getInstance().getDomainHtmlUrl() + "/static/notice.html?id=" + temp.getBizId());
		    //详情内容
		    Announcement announcement = announcementService.getById(temp.getBizId());
		    contentMap.put("detailContent", "");
		    if(announcement != null){
		    	contentMap.put("detailContent", announcement.getContent());
		    }
		    contentMap.put("detailTitle", notNull(announcement.getTitle()));
		}
    	temp.setContentMap(contentMap);
    	return temp;
    }
}
