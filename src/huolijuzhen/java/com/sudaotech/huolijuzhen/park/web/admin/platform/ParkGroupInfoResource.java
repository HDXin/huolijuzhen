package com.sudaotech.huolijuzhen.park.web.admin.platform;

import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.park.service.ParkGroupInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupInfoService.ParkGroupInfo;
import com.sudaotech.huolijuzhen.park.service.ParkGroupInfoService.Query;
import com.sudaotech.huolijuzhen.park.service.ParkGroupParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkGroupUserInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.util.MapHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Path("/admin/platform/parkGroupInfo")
public class ParkGroupInfoResource extends BaseResource {

    @Inject
    private ParkGroupInfoService parkGroupInfoService;

    @Inject
    private AdminUserService adminUserService;

    @Inject
    private ParkGroupUserInfoService parkGroupUserInfoService;

    @Inject
    private ParkGroupParkInfoService parkGroupParkInfoService;

    @Inject
    private AccountService accountService;


    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ParkGroupInfo obj) {
        //检查该名字是否已经存在
        ParkGroupInfoService.Query query = new Query();
        query.setName(obj.getName());
        ParkGroupInfo find = this.parkGroupInfoService.findByQuery(query);
        if (find != null) {
            return new Result<>(ResultCode.PARK_NAME_EXIST);
        }

        // create
        obj.setOperator(getSession().getUserId());
        Long id = parkGroupInfoService.create(obj);

        if (obj.getAdminUserList() != null && !obj.getAdminUserList().isEmpty()) {
            //关联园区组账户
            if (obj.getAdminUserList() != null && !obj.getAdminUserList().isEmpty()) {
                for (AdminUserService.AdminUser adminUser : obj.getAdminUserList()) {
                    ParkGroupUserInfoService.ParkGroupUserInfo parkGroupUserInfo = new ParkGroupUserInfoService.ParkGroupUserInfo();
                    parkGroupUserInfo.setAdminUserId(adminUser.getUserId());
                    parkGroupUserInfo.setParkGroupId(id);
                    parkGroupUserInfo.setUsername(adminUser.getUsername());
                    parkGroupUserInfo.setMobilePhone(adminUser.getCellphone());
                    parkGroupUserInfo.setContacts(adminUser.getName());
                    parkGroupUserInfoService.create(parkGroupUserInfo);//create
                }
            }
        }


        //关联园区
        if (obj.getParkInfoList() != null && !obj.getParkInfoList().isEmpty()) {
            for (ParkInfoService.ParkInfo parkInfo : obj.getParkInfoList()) {
                ParkGroupParkInfoService.ParkGroupParkInfo parkGroupParkInfo = new ParkGroupParkInfoService.ParkGroupParkInfo();
                parkGroupParkInfo.setParkGroupId(id);
                parkGroupParkInfo.setParkId(parkInfo.getId());
                parkGroupParkInfo.setParkname(parkInfo.getName());
                parkGroupParkInfo.setPosition(parkInfo.getPosition());
                parkGroupParkInfoService.create(parkGroupParkInfo);//create
            }
        }
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<>(ResultCode.OK);
        result.setLocation(String.format("/admin/parkGroupInfo/%s", id));
        result.setData(map);
        return result;
    }

    @POST
    @Path("/addAdminUser")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> addAdminUser(@Valid final AdminUserService.AdminUser obj) {
    	try{
            //查询用户的username,cellphone,是否已经存在
            Result<String> find = this.checkAdminUsernameAndCellphoneIsConflict(obj.getUsername(), obj.getCellphone(),PlatformSource.PLATFORM);
            if (find != null) {
                if (find.getCode().equals(ResultCode.USER_CELLPHONE_DUPLICATED.getCode()))
                    return new Result<>(ResultCode.USER_CELLPHONE_DUPLICATED);
                if (find.getCode().equals(ResultCode.USER_USERNAME_DUPLICATED.getCode()))
                    return new Result<>(ResultCode.USER_USERNAME_DUPLICATED);
            }
            // create
            obj.setOperator(getSession().getUserId());
            obj.setUserType(UserType.PARK_GROUP_USER);
            obj.setPasswordStatus(0);//0:表示为设置密码,1:表示设置密码
            obj.setPlatformSource(PlatformSource.PLATFORM);   //登录平台限制为平台
            obj.setPassword(Constants.Park.PARK_GROUP_ADMIN_USER_PWD);
            obj.setPlatformSourceId(getSession().getPlatformId());//设置为园区id

            Long id = adminUserService.create(obj);

            //赋值园区组管理员角色
            AccountService.Account account = new AccountService.Account();
            account.setUserId(id);
            account.setRoleIds(Arrays.asList(Constants.Park.PARK_GROUP_ADMIN_ROLE_ID));

            accountService.createAccount(account);

            Map<String, Long> map = MapHelper.put("id", id).getMap();

            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/admin/adminUser/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("创建用户 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }

    /**
     * 检查账号和手机号是否已经存在
     *
     * @param username  账户
     * @param cellphone 手机号
     * @return true:已经存在 false:不存在
     * @author simon
     */
    private Result<String> checkAdminUsernameAndCellphoneIsConflict(String username, String cellphone,PlatformSource platformSource) {
        AdminUserService.AdminUser adminUser = this.adminUserService.getByCellphoneAndPlatformSource(cellphone,platformSource);
        if (adminUser != null) {
            return new Result<String>(ResultCode.USER_CELLPHONE_DUPLICATED);
        }
        adminUser = this.adminUserService.getByUsernameAndPlatformSource(username,platformSource);
        if (adminUser != null) {
            return new Result<String>(ResultCode.USER_USERNAME_DUPLICATED);
        }
        return null;
    }

    @PUT
    @Path("/editAdminUser/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> editAdminUser(@PathParam("id") Long id,
                                        @Valid final AdminUserService.AdminUser obj) {
        //查询用户的username,cellphone,是否已经存在
        Result<String> find = this.checkAdminUsernameAndCellphoneIsConflict(obj.getUsername(), obj.getCellphone(),PlatformSource.PLATFORM);
        if (find != null)
            return find;

        // update
        obj.setUserType(UserType.PARK_GROUP_USER);
        obj.setOperator(getSession().getUserId());
        obj.setPlatformSourceId(getSession().getPlatformId());//设置为当前园区Id
        obj.setUserId(id);
        obj.setPasswordStatus(0);//0:表示为设置密码,1:表示设置密码
        adminUserService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/delAdminUser/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delAdminUser(@PathParam("id") Long id) {
        AdminUserService.AdminUser obj = new AdminUserService.AdminUser();
        obj.setUserId(id);
        obj.setStatus(Status.DELETED);
        adminUserService.update(obj);
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/delAdminUser")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delAdminUser(final List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                delAdminUser(id);
            }
        }
        return ResultSupport.ok();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final ParkGroupInfo obj) {
        //检查该名字是否已经存在
        if (StringUtils.isNotBlank(obj.getName())) {
            ParkGroupInfoService.Query query = new Query();
            query.setName(obj.getName());
            ParkGroupInfo find = this.parkGroupInfoService.findByQuery(query);
            if (find != null) {
                return new Result<>(ResultCode.PARK_NAME_EXIST);
            }

        }

        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        parkGroupInfoService.update(obj);

        //修改关联用户账户关系
        if (obj.getAdminUserList() != null && !obj.getAdminUserList().isEmpty()) {
            //逻辑:干掉原来的关系,新增目前的关系
            List<ParkGroupUserInfoService.ParkGroupUserInfo> parkGroupUserInfoList = this.parkGroupUserInfoService.getByParkGroupId(id);
            this.parkGroupUserInfoService.updateStatusByParkGroupIds(Status.DELETED, parkGroupUserInfoList);
            //关联园区组账户
            if (obj.getAdminUserList() != null && !obj.getAdminUserList().isEmpty()) {
                for (AdminUserService.AdminUser adminUser : obj.getAdminUserList()) {
                    ParkGroupUserInfoService.ParkGroupUserInfo parkGroupUserInfo = new ParkGroupUserInfoService.ParkGroupUserInfo();
                    parkGroupUserInfo.setAdminUserId(adminUser.getUserId());
                    parkGroupUserInfo.setParkGroupId(id);
                    parkGroupUserInfo.setUsername(adminUser.getUsername());
                    parkGroupUserInfo.setMobilePhone(adminUser.getCellphone());
                    parkGroupUserInfo.setContacts(adminUser.getName());
                    parkGroupUserInfoService.create(parkGroupUserInfo);//create
                }
            }
        }
        //修改关联园区关系
        if (obj.getParkInfoList() != null && !obj.getParkInfoList().isEmpty()) {
            //逻辑:干掉原来的关系,新增目前的关系
            List<ParkGroupParkInfoService.ParkGroupParkInfo> parkGroupParkInfoList = this.parkGroupParkInfoService.getByParkGroupId(id);
            this.parkGroupParkInfoService.updateStatusByParkGroupIds(Status.DELETED, parkGroupParkInfoList);
            //关联园区
            if (obj.getParkInfoList() != null && !obj.getParkInfoList().isEmpty()) {
                for (ParkInfoService.ParkInfo parkInfo : obj.getParkInfoList()) {
                    ParkGroupParkInfoService.ParkGroupParkInfo parkGroupParkInfo = new ParkGroupParkInfoService.ParkGroupParkInfo();
                    parkGroupParkInfo.setParkGroupId(id);
                    parkGroupParkInfo.setParkId(parkInfo.getId());
                    parkGroupParkInfo.setParkname(parkInfo.getName());
                    parkGroupParkInfo.setPosition(parkInfo.getPosition());
                    parkGroupParkInfoService.create(parkGroupParkInfo);//create
                }
            }

        }

        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        ParkGroupInfo obj = new ParkGroupInfo();
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
    public Result<ParkGroupInfo> get(@NotNull @PathParam("id") final Long id) {
        ParkGroupInfo obj = parkGroupInfoService.getById(id);
        if (obj == null)
            return new Result<ParkGroupInfo>(ResultCode.NOT_FOUND);

        //获取关联的账户
        List<ParkGroupUserInfoService.ParkGroupUserInfo> parkGroupUserInfoList = this.parkGroupUserInfoService.getByParkGroupId(obj.getId());
        obj.setParkGroupUserInfoList(parkGroupUserInfoList == null ? new ArrayList<ParkGroupUserInfoService.ParkGroupUserInfo>() : parkGroupUserInfoList)
        ;

        //获取关联的园区
        List<ParkGroupParkInfoService.ParkGroupParkInfo> parkGroupParkInfoList = this.parkGroupParkInfoService.getByParkGroupId(obj.getId());
        obj.setParkGroupParkInfoList(parkGroupParkInfoList == null ? new ArrayList<ParkGroupParkInfoService.ParkGroupParkInfo>() : parkGroupParkInfoList);

        return new Result<ParkGroupInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ParkGroupInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("name") String name,
            @QueryParam("enableStatus") EnableStatus enableStatus
    ) {
        Query query = new Query();
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setName(name);
        query.setEnableStatus(enableStatus);

        Page<ParkGroupInfo> page = parkGroupInfoService.find(query);
        return new Result<Page<ParkGroupInfo>>(ResultCode.OK, page);
    }
}
