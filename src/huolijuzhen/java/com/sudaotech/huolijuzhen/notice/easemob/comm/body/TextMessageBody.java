package com.sudaotech.huolijuzhen.notice.easemob.comm.body;

import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sudaotech.huolijuzhen.notice.easemob.comm.constant.MsgType;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class TextMessageBody extends MessageBody {
	private String msg;

	/**
	 * 
	 * @param targetType
	 *        发送类型
	 * @param targets
	 *        接收人（数组）
	 * @param from
	 *        发送人
	 * @param ext
	 *        扩展信息
	 * @param msg
	 *        消息内容
	 */
	public TextMessageBody(String targetType, String[] targets, String from, Map<String, String> ext, String msg) {
		super(targetType, targets, from, ext);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

    public ContainerNode<?> getBody() {
        if(!isInit()){
          ObjectNode extNode =this.getMsgBody().putObject("msg");
          extNode.put("type", MsgType.TEXT);
          extNode.put("msg", msg);
          this.setInit(true);
        }
       
        

        return this.getMsgBody();
    }

    public Boolean validate() {
		return super.validate() && StringUtils.isNotBlank(msg);
	}
}
