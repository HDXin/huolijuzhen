package com.sudaotech.huolijuzhen.enterprise.web.admin.park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.account.service.AccountService;
import com.sudaotech.account.service.AccountService.Account;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseDossierService.EnterpriseDossier;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.Query;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.CreateSource;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.util.MapHelper;

/**
 * 
 * @Describe:       企业信息
 *
 * @Author:			chenjs
 *
 * @Company:        kuaicto
 * 
 * @Project:        huolijuzhen
 *
 * @Package:        com.sudaotech.huolijuzhen.enterprise.web.admin.park
 *
 * @Date:           2016年11月26日 下午3:47:47
 *
 */
@Path("/admin/park/enterpriseInfo")
public class EnterpriseInfoResource extends BaseResource {

    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private AdminUserService adminUserService;
    
    @Inject
    private AccountService accountService;
    
    @Inject
    private EnterpriseDossierService enterpriseDossierService;
    
    @Inject
    private GenCodeService genCodeService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    
    /**
     * 创建企业信息
     * @param obj
     * @return
     */
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final EnterpriseInfo obj) {
    	try{
        	Long userId = getSessionQuietly().getUserId();
        	
            //创建企业主信息
            obj.setOperator(userId);
            obj.setCreateSource(CreateSource.PARK);
            Long id = enterpriseInfoService.create(obj);
            
            //创建企业档案信息
            if(CollectionUtils.isNotEmpty(obj.getEnterpriseDossiers())){
            	for (EnterpriseDossier dossier : obj.getEnterpriseDossiers()) {
            		dossier.setEnterpriseId(id);
            		enterpriseDossierService.create(dossier);
    			}
            }
            
            //创建企业管理员用户
            AdminUser au=new AdminUser();
            au.setCellphone(obj.getPhone());
            au.setUsername(obj.getAdminAccount());
            au.setName(obj.getName());
            au.setPassword(Constants.Enterprise.ADMIN_USER_PWD);
            au.setTel(obj.getPhone());
            au.setPlatformSource(PlatformSource.ENTERPRISE);
            au.setPlatformSourceId(id);
            au.setOperator(userId);
            //默认管理员用户
            au.setUserType(UserType.ADMIN_USER);
            
    	    Long newUserId = adminUserService.create(au);
    	   
    	    //赋值管理员角色
    	    Account account = new Account();
    	    account.setUserId(newUserId);
    	    account.setRoleIds(Arrays.asList(Constants.Enterprise.ADMIN_ROLE_ID));
    	    accountService.createAccount(account);
            
            Map<String, Long> map = MapHelper.put("id", id).getMap();
            Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
            result.setLocation(String.format("/enterpriseInfo/%s", id));
            result.setData(map);
            return result;
    		
    	}catch(Exception e){
    		logger.error("创建企业信息 error:{}",e);
    		return new Result<Map<String,Long>>(ResultCode.INTERNAL_SERVER_ERROR);
    	}
    }
    
    

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final EnterpriseInfo obj) {
        
    	//编辑企业主信息
    	obj.setId(id);
        obj.setOperator(getSessionQuietly().getUserId());
        enterpriseInfoService.update(obj);
        
        //创建企业档案信息
        //1.删除所有相关文件
        EnterpriseDossier enterpriseDossier = new EnterpriseDossier();
        enterpriseDossier.setEnterpriseId(id);
        List<EnterpriseDossier> enterpriseDossiers = enterpriseDossierService.findByObj(enterpriseDossier);
        if(CollectionUtils.isNotEmpty(enterpriseDossiers)){
        	for(EnterpriseDossier item:enterpriseDossiers){
        		item.setStatus(Status.DELETED);
        		item.setUpdateBy(getSessionQuietly().getUserId());
        		enterpriseDossierService.update(item);
        	}
        }
        //2.更新文件
        if(CollectionUtils.isNotEmpty(obj.getEnterpriseDossiers())){
        	for (EnterpriseDossier dossier : obj.getEnterpriseDossiers()) {
        		Long fileId = dossier.getId();
        		if(fileId == null){
        			dossier.setEnterpriseId(id);
        			dossier.setOperator(getSessionQuietly().getUserId());
        			enterpriseDossierService.create(dossier);
        		}else{
        			dossier.setStatus(Status.NORMAL);
        			dossier.setUpdateBy(getSessionQuietly().getUserId());
        			enterpriseDossierService.update(dossier);
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
        EnterpriseInfo obj = new EnterpriseInfo();
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
    public Result<EnterpriseInfo> get(@NotNull @PathParam("id") final Long id) {
    	
        EnterpriseInfo obj = enterpriseInfoService.getById(id);
        
        if(obj != null){
        	 //企业档案
        	EnterpriseDossier ed=new EnterpriseDossier();
        	ed.setEnterpriseId(obj.getId());
            obj.setEnterpriseDossiers(enterpriseDossierService.findByObj(ed));
        }
        return new Result<EnterpriseInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    
    @GET
    @Path("detail/{code}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<EnterpriseInfo> getEnterpriseByCode(@NotNull @PathParam("code") final String code) {
    	
        EnterpriseInfo obj = enterpriseInfoService.findByCode(code);
        if(obj != null){
       	 //企业档案
       	   EnterpriseDossier ed=new EnterpriseDossier();
           ed.setEnterpriseId(obj.getId());
           obj.setEnterpriseDossiers(enterpriseDossierService.findByObj(ed));
       }
        
        return new Result<EnterpriseInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<EnterpriseInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<EnterpriseInfo> page = enterpriseInfoService.find(query);
        return new Result<Page<EnterpriseInfo>>(ResultCode.OK, page);
    }
    
    @GET
    @Path("/listAll/condition")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<EnterpriseInfo>> find(
            @QueryParam("name") String name
            ) {
    	
    	List<EnterpriseInfo> eiList=null;
    	
    	Session session=getSessionQuietly();
    	
    	if(session ==null){
    		return new Result<List<EnterpriseInfo>>(ResultCode.SESSION_IS_NULL);
    	}
    	if(session.getPlatformId() == null || session.getPlatformId() == 0){
    		return new Result<List<EnterpriseInfo>>(ResultCode.BAD_REQUEST);
    	}
    	//查询当前园区关联的企业
    	EnterpriseCott ec =new EnterpriseCott();
    	
        ec.setParkId(session.getPlatformId());
        ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);
        
    	List<EnterpriseCott> ecList = enterpriseCottService.findList(ec);
    	
    	if(CollectionUtils.isEmpty(ecList)){
    		return new Result<List<EnterpriseInfo>>(ResultCode.OK,eiList);
    	}
    	List<Long> ecIds=new ArrayList<Long>();
    	
		for (EnterpriseCott enterpriseCott : ecList) {
			ecIds.add(enterpriseCott.getEnterpriseId());
		}
		
		//条件查询已关联的企业
		EnterpriseInfo ei=new EnterpriseInfo();
		ei.setIds(ecIds);
		ei.setName(name);
		eiList=enterpriseInfoService.findByObj(ei);
    	
        return new Result<List<EnterpriseInfo>>(ResultCode.OK, eiList);
    }
    
    @GET
    @Path("/adminAccount/generate")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> getAdminUesr() {
    	
        String adminAccount = genCodeService.nextCodeByType(Constants.Enterprise.ADMIN_USER_PREFIX);

        return new Result<String>(adminAccount == null ? ResultCode.NOT_FOUND : ResultCode.OK, adminAccount);
    }
}
