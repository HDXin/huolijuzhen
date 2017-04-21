package com.sudaotech.huolijuzhen.basic.service;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.dao.MessageEntity;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample.Criteria;
import com.sudaotech.huolijuzhen.dao.MessageEntityMapper;
import com.sudaotech.huolijuzhen.util.Contains;
import com.sudaotech.huolijuzhen.util.HttpClientUtils;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.JsonUtil;

import java.io.IOException;
import java.util.*;

@SuppressWarnings("Duplicates")
public class MessageServiceImpl extends BaseServiceImpl implements MessageService {
    private static final String TRACKING_TYPE = "Message";

    @Inject
    private MessageEntityMapper messageEntityMapper;

    @Override
    public Message getById(Long id) {
        MessageEntity entity = this.messageEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, Message.class);
        }

        return null;
    }

    @Override
    public Long create(Message obj) {
        logger.debug("Creating Message: {}", obj);

        obj.setMsgId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_MESSAGE));

        MessageEntity entity = BeanUtils.copyProperties(obj, MessageEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());

        this.messageEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getMsgId(), "create", entity);

        logger.info("Created Message: {}", obj);

        return obj.getMsgId();
    }

    @Override
    public void update(Message obj) {
        logger.debug("Updating Message: {}", obj);

        MessageEntity entity = BeanUtils.copyProperties(obj, MessageEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.messageEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getMsgId(), "update", entity);

        logger.info("Updated Message: {}", obj);
    }

    @Override
    public Long save(Message obj) {
        logger.debug("Saving Message: {}", obj);

        if (obj.getMsgId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getMsgId();
    }

    @Override
    public List<Message> findAllByQuery(final Query query) {
        MessageEntityExample example = new MessageEntityExample();
        Criteria criteria = example.createCriteria().andStatusEqualTo(Status.NORMAL);
        if (query.getDst() != null) {
            criteria.andDstEqualTo(query.getDst());
        }
        if (query.getMsgStatus() != null) {
            criteria.andMsgStatusEqualTo(query.getMsgStatus());
        }
        if (query.getParkId() != null) {
            List<Long> parkIds = new ArrayList() {{
                add(query.getParkId());
                add(-1l);
            }};
            criteria.andParkIdIn(parkIds);
        } else {
            criteria.andParkIdEqualTo(-1l);
        }


        List<MessageEntity> entities = this.messageEntityMapper.selectByExample(example);
        if (!entities.isEmpty()) {
            return BeanUtils.copyListProperties(entities, Message.class);
        }
        return null;
    }

    @Override
    public Page<Message> find(final Query query) {
        Page<Message> page = new Page<Message>(query);
        MessageEntityExample example = new MessageEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);

//        example.setOrderByClause("id DESC");
        example.setOrderByClause("msgId DESC");
        if (query.getDst() != null) {
            criteria.andDstEqualTo(query.getDst());
        }
        if (query.getSrc() != null) {
            criteria.andSrcEqualTo(query.getSrc());
        }
        if (query.getStartTime() != null && query.getEndTime() != null) {
            criteria.andCreateTimeBetween(query.getStartTime(), query.getEndTime());
        }
        if (query.getMsgBizType() != null) {
            criteria.andMsgBizTypeEqualTo(query.getMsgBizType());
        }
        if (query.getMsgStatus() != null) {
            criteria.andMsgStatusEqualTo(query.getMsgStatus());
        }
        if (query.getMsgType() != null) {
            criteria.andMsgTypeEqualTo(query.getMsgType());
        }
        if (query.getParkId() != null) {
            List<Long> parkIds = new ArrayList() {{
                add(query.getParkId());
                add(-1l);
            }};
            criteria.andParkIdIn(parkIds);
        } else {
            criteria.andParkIdEqualTo(-1l);
        }
        page.setTotal(this.messageEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<MessageEntity> list = this.messageEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, Message.class));
        }

        return page;
    }

    @Override
    public void regMiddleware(Map<String, String> headers, String deviceId) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("deviceId", deviceId);
        //注册
        HttpClientUtils.doPost(headers, Contains.Base.regUrl, JsonUtil.toJson(map));
    }

    @Override
    public String queryMiddleware(Map<String, String> headers, Integer offset, Integer limit, Integer page, Long id) throws IOException {
        StringBuffer url = new StringBuffer(Contains.Base.quertUrl);
        url.append("?");
        if (offset != null) {
            url.append("offset=").append(offset);
        }
        if (limit != null) {
            url.append("&limit=").append(limit);
        }
        if (page != null) {
            url.append("&page=").append(page);
        }
        if (id != null) {
            url.append("&id=").append(id);
        }
        String body = HttpClientUtils.get(headers, url.toString());
        return body;
    }

    @Override
    public String queryMiddlewareById(Map<String, String> headers, Long id) throws IOException {
        StringBuffer url = new StringBuffer(Contains.Base.quertSingle);
        url.append("/").append(id);
        String body = HttpClientUtils.get(headers, url.toString());
        return body;
    }

    @Override
    public void sendToMiddleware(final Middleware middleware) {
        Map<String, Object> map = new HashMap<>();
        map.put("userIdList", middleware.getUserIdList());
        map.put("extMap", middleware.getExtMap());
        map.put("notifyType", middleware.getNotifyType());
        map.put("notifyContent", middleware.getNotifyContent());
        //发送

        Map<String, String> headers = new HashMap<>();
        headers.put("systemId", Contains.Base.systemId);
        headers.put("token", Contains.Base.DEFAULT_TOKEN);
        try {
            HttpClientUtils.post(headers, Contains.Base.sendUrl, JsonUtil.toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("{}", e.getMessage());
        }
    }
}
