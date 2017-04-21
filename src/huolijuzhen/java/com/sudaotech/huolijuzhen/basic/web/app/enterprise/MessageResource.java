package com.sudaotech.huolijuzhen.basic.web.app.enterprise;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Message;
import com.sudaotech.huolijuzhen.basic.service.MessageService.Query;
import com.sudaotech.huolijuzhen.sys.common.web.MessageBaseResource;
import com.sudaotech.message.MsgBizType;
import com.sudaotech.message.MsgStatus;
import com.sudaotech.message.MsgType;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

@SuppressWarnings("Duplicates")
@Path("/app/enterprise/message")
public class MessageResource extends MessageBaseResource {

    @Inject
    private MessageService messageService;

//    @POST
//    @Path("/")
//    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
//    @Transactional
//    public Result<Map<String, Long>> create(@Valid final Message obj) {
//        // create
//        obj.setOperator(getSession().getUserId());
//        Long id = messageService.create(obj);
//        Map<String, Long> map = MapHelper.put("msgId", id).getMap();
//
//        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
//        result.setLocation(String.format("/admin/message/%s", id));
//        result.setData(map);
//        return result;
//    }

    //修改消息为已读
    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final Message obj) {
        obj.setMsgId(id);
        obj.setOperator(getSession().getUserId());
        messageService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Message obj = new Message();
        obj.setStatus(Status.DELETED);
        return update(id, obj);
    }

    @DELETE
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> deleteMore(final List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                delete(id);
            }
        }
        return ResultSupport.ok();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Message> get(@NotNull @PathParam("id") final Long id) {
        try {
            Session session = getSession();
            if (session == null) {
                return new Result<MessageService.Message>(ResultCode.INTERNAL_SERVER_ERROR);
            }
            Long userId = session.getUserId();
            Message obj = messageService.getById(id);
            if (obj == null || obj.getDst().compareTo(userId) != 0) {
                return new Result<Message>(ResultCode.NOT_FOUND);
            }
            Message temp = messageToMessage(obj);
            return new Result<Message>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, temp);
        } catch (Exception e) {
            logger.error("用户获取系统消息 error:{}", e);
            return new Result<MessageService.Message>(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取未读的消息列表
     */
    @GET
    @Path("/noRead")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Integer> findNoRead(@QueryParam("parkId") Long parkId) {
        Long userId = getSession().getUserId();
        if (userId == null) {
            return new Result<>(ResultCode.NOT_FOUND);
        }
        Query query = new Query();
        query.setDst(userId);
        query.setParkId(parkId);
        query.setMsgStatus(MsgStatus.CREATE);
        List<Message> messageList = messageService.findAllByQuery(query);
        if (messageList != null)
            return new Result<>(ResultCode.OK, messageList.size());
        else {
            return new Result<>(ResultCode.OK, 0);
        }
    }

    /**
     * 分页获取用户的消息列表
     */
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<Message>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("msgStatus") MsgStatus msgStatus,
            @QueryParam("msgBizType") MsgBizType msgBizType,
            @QueryParam("msgType") MsgType msgType,
            @QueryParam("parkId") Long parkId
    ) {
        Long userId = getSession().getUserId();
        if (userId == null) {
            return new Result<>(ResultCode.NOT_FOUND);
        }
        Query query = new Query();
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setMsgStatus(msgStatus);
        query.setMsgBizType(msgBizType);
        query.setMsgType(msgType);
        query.setDst(userId);
        query.setParkId(parkId);

        Page<Message> page = messageService.find(query);
        List<Message> items = page.getItems();
        if (CollectionUtils.isNotEmpty(items)) {
            page.setItems(messagesToMessages(items));
        }
        return new Result<Page<Message>>(ResultCode.OK, page);
    }
}
