package com.sudaotech.huolijuzhen.resources.web.admin.park;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.SessionService;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.resources.service.UnitTierInfoService;
import com.sudaotech.huolijuzhen.resources.service.UnitTierInfoService.Query;
import com.sudaotech.huolijuzhen.resources.service.UnitTierInfoService.UnitTierInfo;
import com.sudaotech.util.MapHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.*;

@SuppressWarnings("Duplicates")
@Path("/admin/park/unitTierInfo")
public class UnitTierInfoResource extends BaseResource {

    @Inject
    private UnitTierInfoService unitTierInfoService;

    @Inject
    private ResourceInfoService resourceInfoService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final UnitTierInfo obj) {
        Session session = getSession();

        //TODO 等待系统用户完善以后,在获取园区操作者的id
        obj.setGardenId(session.getPlatformId());
        if (EnableStatus.DISABLE.equals(obj.getEnableStatus())) {
            obj.setCloseBy(session.getUserId());
            obj.setCloseTime(new Date());
        } else if (EnableStatus.ENABLE.equals(obj.getEnableStatus())) {
            obj.setStartBy(session.getUserId());
            obj.setStartTime(new Date());
        } else {
            return new Result<Map<String, Long>>(ResultCode.PARAM_ERROR);
        }
        // create
        obj.setOperator(session.getUserId());
        Long id = unitTierInfoService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/unitTierInfo/%s", id));
        result.setData(map);
        return result;
    }

    @Override
    protected SessionService getSessionService() {
        return super.getSessionService();
    }


    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final UnitTierInfo obj) {
        Long userId = getSession().getUserId();

        if (EnableStatus.DISABLE.equals(obj.getEnableStatus())) {
            obj.setCloseBy(userId);
            obj.setCloseTime(new Date());
            //禁用检测是否已经被引用了
            ResourceInfoService.Query query = new ResourceInfoService.Query();
            query.setTierId(id);
            List<ResourceInfoService.ResourceInfo> resourceInfoList = this.resourceInfoService.getByQuery(query);
            if (resourceInfoList != null) {
                return new Result<String>(ResultCode.RES_CAN_NOT_DISBALE);
            }
        } else if (EnableStatus.ENABLE.equals(obj.getEnableStatus())) {
            obj.setStartBy(userId);
            obj.setStartTime(new Date());
        } else {
            return new Result<>(ResultCode.PARAM_ERROR);
        }
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        unitTierInfoService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        UnitTierInfo obj = new UnitTierInfo();
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
    public Result<UnitTierInfo> get(@NotNull @PathParam("id") final Long id) {
        UnitTierInfo obj = unitTierInfoService.getById(id);
        if (obj == null || !obj.getGardenId().equals(getSession().getPlatformId())) {
            return new Result<UnitTierInfo>(ResultCode.NOT_FOUND);
        }

        return new Result<UnitTierInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<UnitTierInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("name") String name,
            @QueryParam("enableStatus") EnableStatus EnableStatus,
            @QueryParam("resInfoId") Long resInfoId,
            @QueryParam("isBase") Boolean isBase
    ) {
        Query query = new Query();
        query.setOffset(offset);
        query.setEnableStatus(EnableStatus);
        query.setResInfoId(resInfoId);
        query.setName(name);
        query.setBase(isBase);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setParkInfoId(getSession().getPlatformId());


        Page<UnitTierInfo> page = unitTierInfoService.find(query);

        if (page != null & !page.getItems().isEmpty()) {
            Collections.sort(page.getItems(), new Comparator<UnitTierInfo>() {
                @Override
                public int compare(UnitTierInfo arg0, UnitTierInfo arg1) {
                    return arg0.getTierNum().compareTo(arg1.getTierNum());
                }
            });
        }
        return new Result<Page<UnitTierInfo>>(ResultCode.OK, page);
    }
}
