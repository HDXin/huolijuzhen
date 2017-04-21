
package com.sudaotech.account.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseCottService.EnterpriseCott;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseInfoService.EnterpriseInfo;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottService;
import com.sudaotech.huolijuzhen.enterprise.service.EnterpriseUserCottService.EnterpriseUserCott;
import com.sudaotech.huolijuzhen.enums.CorrStatus;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.provider.service.ProviderService;
import com.sudaotech.huolijuzhen.provider.service.ProviderService.Provider;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.user.UserType;
import com.sudaotech.user.service.AdminUserService;
import com.sudaotech.user.service.AdminUserService.AdminUser;

/**
 * 用户账户资源
 */
@Path("/admin/profile")
public class AdminProfileResource extends BaseResource {
	
    
    @Inject
    private AdminUserService userService;
    
    @Inject
    private ProviderService providerService;
    
    @Inject
    private ParkInfoService parkInfoService;
    
    @Inject
    private EnterpriseInfoService enterpriseInfoService;
    
    @Inject
    private EnterpriseCottService enterpriseCottService;
    
    @Inject
    private EnterpriseUserCottService enterpriseUserCottService;
    
    @Inject
    private ImageInfoService imageInfoService;
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Object>> getMyProfile() {
    	
     Map<String,Object> resultMap = new HashMap<String,Object>();	
     try {
	        Session session = getSessionQuietly();
	        if(session.getUserId() == null){
	        	return new Result<Map<String,Object>>(ResultCode.SESSION_IS_NULL);
	        }
	        AdminUser user = userService.getById(session.getUserId());
	        
	        if (user == null) {
	            return new Result<Map<String, Object>>(ResultCode.NOT_FOUND);
	        }
	        user.setPermissions(session.getPermissions());
	        //平台
	        if(user.getPlatformSource() == PlatformSource.PLATFORM){
	        	
	        	return new Result<Map<String, Object>>(ResultCode.OK,mergerUser(user));
	        }
	        //园区
	        if(user.getPlatformSource() == PlatformSource.PARK){
	            //服务商
	            if(user.getUserType() == UserType.SERVICE_PROVIDER_USER){
	            	 Provider provider=providerService.getById(user.getProviderId());
	            	 return new Result<Map<String, Object>>(ResultCode.OK,mergerUserAndProvider(user, provider));
	            }
	        	//查询园区信息
	            ParkInfo park=parkInfoService.getById(user.getPlatformSourceId());

	            ImageInfo imageInfo = new ImageInfo();
	            imageInfo.setTargetId(park.getId());
	            imageInfo.setImageType(ImageType.PARK_LOGO);
	            List<ImageInfo> imageInfos = imageInfoService.findByObj(imageInfo);
	            if(CollectionUtils.isNotEmpty(imageInfos)){
	            	park.setParkLogo(imageInfos.get(0).getPath());
	            }
	            
	            return new Result<Map<String, Object>>(ResultCode.OK,mergerUserAndPark(user, park));
	        }
	        //企业
	        if(user.getPlatformSource() == PlatformSource.ENTERPRISE){
	        	//查询企业信息
	        	EnterpriseInfo enterprise=enterpriseInfoService.getById(user.getPlatformSourceId());
	            //查询关联园区
	            EnterpriseCott ec=new EnterpriseCott();
	            ec.setEnterpriseId(enterprise.getId());
	            ec.setCorrStatus(CorrStatus.ALREADY_SETTLED);
	            //普通用户需要筛选绑定的园区
	            if(user.getUserType() == UserType.NORMAL_USER){
	            	EnterpriseUserCott euc = new EnterpriseUserCott();
	            	euc.setEnterpriseUserId(user.getUserId());
	            	List<EnterpriseUserCott> eucs= enterpriseUserCottService.findByObj(euc);
	            	List<Long> ids = null;
	            	if(CollectionUtils.isNotEmpty(eucs)){
	            		ids =new ArrayList<Long>();
	            		for (EnterpriseUserCott enterpriseUserCott : eucs) {
	            			ids.add(enterpriseUserCott.getCottId());
						}
	            	}
	            	ec.setIds(ids);
	            }
	            List<EnterpriseCott> ecs=enterpriseCottService.findList(ec);
	            return new Result<Map<String, Object>>(ResultCode.OK,mergerUserAndEnterprise(user, enterprise, ecs));
	        }
	 	} catch (Exception e) {
			logger.error("获取用户信息异常：{}",e);
		}
        
        return new Result<Map<String, Object>>(ResultCode.OK, resultMap);
    }
    
    @GET
    @Path("/{userName}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, Object>> getUserByUserName(@NotNull @PathParam("userName") final String userName) {
    	
    	AdminUser user = this.userService.getByUsername(userName);
    	
    	if(null != user)
    	return new Result<Map<String, Object>>(ResultCode.OK,mergerSimpleUser(user));
        
    	return new Result<Map<String, Object>>(ResultCode.OK,null); 
    }
    
    /**
     * 封装vo（包括用户和园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerSimpleUser(AdminUser user){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("username", notNull(user.getUsername()));
    	infoMap.put("cellPhone", notNull(user.getCellphone()));
    	infoMap.put("passwordStatus", user.getPasswordStatus());
    	return infoMap;
    }
    /**
     * 封装vo（包括用户和园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUser(AdminUser user){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	
    	infoMap.put("userId", user.getUserId());
    	infoMap.put("username", notNull(user.getUsername()));
    	infoMap.put("cellPhone", notNull(user.getCellphone()));
    	infoMap.put("passwordStatus", user.getPasswordStatus());
    	infoMap.put("nickname", user.getNickname());
    	infoMap.put("name", user.getName());
    	infoMap.put("userAttribute", notNull(user.getUserAttribute()));
    	infoMap.put("userType", notNull(user.getUserType()));
    	
    	infoMap.put("permissions", user.getPermissions());
    	
    	return infoMap;
    }
    
    /**
     * 封装vo（包括用户和服务商信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUserAndProvider(AdminUser user,Provider provider){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
        infoMap.putAll(mergerUser(user));
    	if(provider !=null){
    		
	    	infoMap.put("providerName", notNull(provider.getName()));
	    	infoMap.put("createSide", notNull(provider.getCreateSide()));
	    	infoMap.put("providerId", provider.getId());
    	
    	}
    	return infoMap;
    }

    /**
     * 封装vo（包括用户和园区信息）
     * @param comm
     * @return
     */
    private Map<String, Object> mergerUserAndPark(AdminUser user,ParkInfo park){
    	Map<String, Object> infoMap = new HashedMap<String, Object>();
    	infoMap.putAll(mergerUser(user));
    	if(park !=null){
	    	infoMap.put("parkId", notNull(park.getId()));
	    	infoMap.put("parkName", notNull(park.getName()));
	    	infoMap.put("parkLogo", notNull(park.getParkLogo()));
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
    	infoMap.putAll(mergerUser(user));
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
    			objMap.put("cottId",enterpriseCott.getId());
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
