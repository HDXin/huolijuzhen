package com.sudaotech.huolijuzhen.basic.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.core.web.serialize.DateOnlySerializer;
import com.sudaotech.core.web.serialize.EnumTypeSerializer;
import com.sudaotech.huolijuzhen.dao.MessageEntity;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息的发送demo,业务代码嵌入以下即可
 * MessageService.Middleware middleware = new MessageService.Middleware();
 * middleware.setContext("拓展");                        //1.拓展字段,一般不用
 * middleware.setMessageContent("消息内容");             //2.消息内容
 * middleware.setUserIdList(new ArrayList<Long>() {{
 * add(10672l);                                         //3.给哪个用户发,继续添加即可
 * }});
 * messageService.sendToMiddleware(middleware);
 *
 * @author simon
 */
public interface MessageService extends BaseService {

    public Message getById(Long id);

    public Long create(Message obj);

    public void update(Message obj);

    public Long save(Message obj);

    public List<Message> findAllByQuery(Query query);

    public Page<Message> find(Query query);


    /**
     * 注册中间件
     *
     * @param deviceId 设备Id
     *                 demo
     * @Test public void reg() {
     * try {
     *      Map<String, String> headers = new HashMap<>();
     *      headers.put("appId", Contains.Base.appId);
     *      headers.put("token",getSession().token);
     *      messageService.regMiddleware(headers, "100001");
     * } catch (IOException e) {
     *      e.printStackTrace();
     * }
     * }
     */
    public void regMiddleware(Map<String, String> headers, String deviceId) throws IOException;

    /**
     * 主动查询通知
     *
     * @param limit  限制大小
     * @param offset 偏离
     * @param page   页码
     * @param id     用户id
     * @return 查询结果 json格式的数据
     * Demo:
     * @Test public void list() {
     * <p>
     * try {
     * Map<String, String> headers = new HashMap<>();
     * headers.put("appId", Contains.Base.appId);
     * headers.put("token", "75FPWpH6LTEkxcrJuwe6SVAxwCaLB%2BD1q0qzCE%2FNt2uBNw0lQ6kPeF1kFU2wfnB51z8WDP4NQZ6vh4doWvaTnw9QoyAbE8sX3iCqSyY6vfq85cLgxOGnZ3F9ey46dobEnyupI23OQnuuZlPBs4hNPQ%3D%3D");
     * String body = messageService.queryMiddleware(headers, 1, 1, 1, 10672l);
     * System.out.println(body);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */
    public String queryMiddleware(Map<String, String> headers, Integer offset, Integer limit, Integer page, Long id) throws IOException;


    /**
     * 主动查询通知(单个)
     *
     * @param id 消息id
     * @return 查询结果 json格式的数据
     * <p>
     * demo:
     * @Test public void single() {
     * <p>
     * try {
     * Map<String, String> headers = new HashMap<>();
     * headers.put("appId", Contains.Base.appId);
     * headers.put("token", "75FPWpH6LTEkxcrJuwe6SVAxwCaLB%2BD1q0qzCE%2FNt2uBNw0lQ6kPeF1kFU2wfnB51z8WDP4NQZ6vh4doWvaTnw9QoyAbE8sX3iCqSyY6vfq85cLgxOGnZ3F9ey46dobEnyupI23OQnuuZlPBs4hNPQ%3D%3D");
     * messageService.queryMiddlewareById(headers, 3l);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */
    public String queryMiddlewareById(Map<String, String> headers, Long id) throws IOException;


    /**
     * 发送异步消息到消息中间件
     *
     * @Test public void send() {
     * 	MessageService.Middleware middleware = new MessageService.Middleware();
     * MessageService.NotifyBiz biz=new MessageService.NotifyBiz();
     * biz.setExtId(1l);
     * biz.setMsgBizType(MsgBizType.ACCOUNT);
     * <p>
     * middleware.setNotifyBiz(biz);
     * middleware.setMessageContent("消息内容");
     * middleware.setUserIdList(new ArrayList<Long>() {{
     * add(10672l);
     * }});
     * messageService.sendToMiddleware(middleware);
     * }
     */
    public void sendToMiddleware(Middleware middleware);

    /**
     * 通知,专用类
     *
     * @author simon
     * @[param extId 关联Id
     * @ param  msgBizType 跳转类型
     */
    public static class NotifyBiz {
        private Long extId;

        @JsonSerialize(using = EnumTypeSerializer.class)
        private MsgBizType msgBizType;

        public Long getExtId() {
            return extId;
        }

        public void setExtId(Long extId) {
            this.extId = extId;
        }

        public MsgBizType getMsgBizType() {
            return msgBizType;
        }

        public void setMsgBizType(MsgBizType msgBizType) {
            this.msgBizType = msgBizType;
        }
    }


    public static class Middleware extends Pagination {


        /**
         * displayOrder : 0
         * status : NORMAL
         * createBy : 116
         * createTime : 1481005956932
         * updateBy : 116
         * updateTime : 1481005956932
         * version : 0
         * lastUpdate : 1481005956000
         * id : 3
         * batchNo : c8bfcdc5-0d5c-48f0-a3b0-cf598e414083
         * systemId : 20
         * senderId : 116
         * receiverDeviceId : 100001
         * receiverId : 10672
         * notifyType : SYSTEM_NOTIFY
         * notifyContent : 通知的内容2
         * context : {"notifyType":"SYSTEM_NOTIFY"}
         * resultCode : 200
         * userIdList : [1,2]
         * messageContent :
         * appId :
         */

        private int displayOrder;
        private String status;
        private int createBy;
        private long createTime;
        private int updateBy;
        private long updateTime;
        private int version;
        private long lastUpdate;
        private int id;
        private String batchNo;
        private int systemId;
        private int senderId;
        private String receiverDeviceId;
        private int receiverId;
        private String notifyType = "SYSTEM_NOTIFY";//默认
        private String notifyContent;
        private NotifyBiz notifyBiz;
        private String resultCode;
        private Map<String,Object> extMap;
        private String appId;
        private List<Long> userIdList;

        public int getDisplayOrder() {
            return displayOrder;
        }

        public void setDisplayOrder(int displayOrder) {
            this.displayOrder = displayOrder;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(int updateBy) {
            this.updateBy = updateBy;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public long getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(long lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public int getSystemId() {
            return systemId;
        }

        public void setSystemId(int systemId) {
            this.systemId = systemId;
        }

        public int getSenderId() {
            return senderId;
        }

        public void setSenderId(int senderId) {
            this.senderId = senderId;
        }

        public String getReceiverDeviceId() {
            return receiverDeviceId;
        }

        public void setReceiverDeviceId(String receiverDeviceId) {
            this.receiverDeviceId = receiverDeviceId;
        }

        public int getReceiverId() {
            return receiverId;
        }

        public void setReceiverId(int receiverId) {
            this.receiverId = receiverId;
        }

        public String getNotifyType() {
            return notifyType;
        }

        public void setNotifyType(String notifyType) {
            this.notifyType = notifyType;
        }

        public String getNotifyContent() {
            return notifyContent;
        }

        public void setNotifyContent(String notifyContent) {
            this.notifyContent = notifyContent;
        }

        public NotifyBiz getNotifyBiz() {
            return notifyBiz;
        }

        public void setNotifyBiz(NotifyBiz notifyBiz) {
            this.notifyBiz = notifyBiz;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public Map<String, Object> getExtMap() {
			return extMap;
		}

		public void setExtMap(Map<String, Object> extMap) {
			this.extMap = extMap;
		}

		public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public List<Long> getUserIdList() {
            return userIdList;
        }

        public void setUserIdList(List<Long> userIdList) {
            this.userIdList = userIdList;
        }
    }

    public static class Query extends Pagination {
        private MsgStatus msgStatus;
        private Long dst;
        private Long src;
        private MsgBizType msgBizType;
        private MsgType msgType;
        private Date startTime;
        private Date endTime;
        private Long parkId;

        public Long getParkId() {
            return parkId;
        }

        public void setParkId(Long parkId) {
            this.parkId = parkId;
        }

        public MsgStatus getMsgStatus() {
            return msgStatus;
        }

        public void setMsgStatus(MsgStatus msgStatus) {
            this.msgStatus = msgStatus;
        }

        public Long getDst() {
            return dst;
        }

        public void setDst(Long dst) {
            this.dst = dst;
        }

        public Long getSrc() {
            return src;
        }

        public void setSrc(Long src) {
            this.src = src;
        }

        public MsgBizType getMsgBizType() {
            return msgBizType;
        }

        public void setMsgBizType(MsgBizType msgBizType) {
            this.msgBizType = msgBizType;
        }

        public MsgType getMsgType() {
            return msgType;
        }

        public void setMsgType(MsgType msgType) {
            this.msgType = msgType;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }

    public static class Message extends MessageEntity {

        @JsonSerialize(using = DateOnlySerializer.class)
        private Date createTime;

        //是否是推送到园区
        private Boolean toPark = false;
        
        public Boolean getToPark() {
			return toPark;
		}

		public void setToPark(Boolean toPark) {
			this.toPark = toPark;
		}

		@Override
        public Date getCreateTime() {
            return createTime;
        }

        @Override
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
        
        private Map<String,Object> contentMap = new HashMap<String, Object>();

		public Map<String, Object> getContentMap() {
			return contentMap;
		}

		public void setContentMap(Map<String, Object> contentMap) {
			this.contentMap = contentMap;
		}
		
    }
}
