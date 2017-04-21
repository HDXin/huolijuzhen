package com.sudaotech.account.web.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sudaotech.account.web.app.AppPasswordResource.PasswordParam;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.commons.constant.Constants.Enterprise;
import com.sudaotech.huolijuzhen.commons.constant.Constants.Platform;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;
import com.sudaotech.user.service.AppUserService.AppUser;
import com.sudaotech.util.BeanUtils;

/**
 * 用户账户资源
 */
@Path("/app/profile")
public class AppProfileResource extends BaseResource {
	
    @Inject
    private AdminUserService userService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> getMyProfile() throws SQLException {
    	
    	Map<String,Object> resultMap = new HashMap<String,Object>();
    	
        Session session = getSessionQuietly();
        
        if(session.getUserId() == null){
        	return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
        }
        
        AdminUser user = userService.getById(session.getUserId());
        
        if (user == null) {
            return new Result<Map<String, Object>>(ResultCode.NOT_FOUND);
        }
        //app获取用户信息只开放给 园区用户和 企业用户
        if (user.getPlatformSource() ==PlatformSource.UNKNOWN || user.getPlatformSource() == PlatformSource.PLATFORM){
        	return new Result<Map<String, Object>>(ResultCode.UNAUTHORIZED);
        }
        if(user.getPlatformSource() == PlatformSource.PARK){
            //查询园区信息
            ParkInfo park=parkInfoService.getById(user.getPlatformSourceId());
            return new Result<Map<String, Object>>(ResultCode.OK,mergerUserAndPark(user, park));
        
        }
        if(user.getPlatformSource() == PlatformSource.ENTERPRISE){
        	//查询企业信息
        	EnterpriseInfo enterprise=enterpriseInfoService.getById(user.getPlatformSourceId());
        	resultMap.put("user", user);
            resultMap.put("enterprise", enterprise);
            
            //查询关联园区
            EnterpriseCott ec=new EnterpriseCott();
            ec.setEnterpriseId(enterprise.getId());
            ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);
            
            List<EnterpriseCott> ecs=enterpriseCottService.findList(ec);
            
            return new Result<Map<String, Object>>(ResultCode.OK,mergerUserAndEnterprise(user, enterprise, ecs));
        
        }
        
        return new Result<Map<String, Object>>(ResultCode.OK,resultMap);
    }
    
    @GET
    @Path("/{userName}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> getUserByUserName(@NotNull @PathParam("userName") final String userName) {
    	
    	AdminUser user = this.userService.getByUsername(userName);
    	
    	if(null != user)
    	return new Result<Map<String, Object>>(ResultCode.OK,mergerUser(user));
        
    	return new Result<Map<String, Object>>(ResultCode.OK,null); 
    }
    
    /**
     * 封装vo（包括用户和园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUser(AdminUser user){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("userId", user.getUserId());
    	infoMap.put("userName", notNull(user.getUsername()));
    	infoMap.put("cellPhone", notNull(user.getCellphone()));
    	
    	return infoMap;
    }

    /**
     * 封装vo（包括用户和园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUserAndPark(AdminUser user,ParkInfo park){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("userId", user.getUserId());
    	infoMap.put("userName", notNull(user.getUsername()));
    	infoMap.put("cellPhone", notNull(user.getCellphone()));
    	infoMap.put("userAttribute", notNull(user.getUserAttribute()));
    	if(park !=null){
    	infoMap.put("parkId", notNull(park.getId()));
    	infoMap.put("parkName", notNull(park.getName()));
    	}
    	return infoMap;
    }
    
    
    /**
     * 封装vo（包括用户和企业信息和管理的园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUserAndEnterprise(AdminUser user,EnterpriseInfo enterprise,List<EnterpriseCott>  ecs){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("userId", user.getUserId());
    	infoMap.put("userName", notNull(user.getUsername()));
    	infoMap.put("cellPhone", notNull(user.getCellphone()));
    	infoMap.put("userAttribute", notNull(user.getUserAttribute()));
    	infoMap.put("enterpriseId", notNull(enterprise.getId()));
    	infoMap.put("enterpriseName", notNull(enterprise.getName()));
    	
    	List<Map<String,Object>> ecMap=new ArrayList<Map<String,Object>>();
    	
    	if(CollectionUtils.isNotEmpty(ecs)){
		    Map<String,Object> objMap=null;
		    ParkInfo pi=null;
    		for (EnterpriseCott enterpriseCott : ecs) {
    			pi=parkInfoService.getById(enterpriseCott.getParkId());
    			if(pi !=null && pi.getEnableStatus() != EnableStatus.DISABLE){
    			objMap=new HashedMap<String, Object>();
    			objMap.put("parkId", pi.getId());
    			objMap.put("parkName", pi.getName());
    			objMap.put("accountManager", pi.getAccountManager());
    			objMap.put("managerPhone", pi.getManagerPhone());
    			ecMap.add(objMap);
    			}
			}
    		
       	}
    	infoMap.put("cottParks", ecMap);	
    	
    	return infoMap;
    }
    
    
    /**
     * 判断是否为空，为空返回空串
     * @param obj
     * @return
     */
    private Object notNull(Object obj){
    	if(obj == null){
    		return "";
    	}else{
    		return obj;
    	}
    }
    

}
