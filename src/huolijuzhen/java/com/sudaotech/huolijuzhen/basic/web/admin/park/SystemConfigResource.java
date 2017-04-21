package com.sudaotech.huolijuzhen.basic.web.admin.park;

import java.util.ArrayList;
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
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService.Query;
import com.sudaotech.huolijuzhen.basic.service.SystemConfigService.SystemConfig;
import com.sudaotech.huolijuzhen.enums.ImageType;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService;
import com.sudaotech.huolijuzhen.sys.common.service.ImageInfoService.ImageInfo;
import com.sudaotech.huolijuzhen.sys.common.web.BusinessBaseResource;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/SystemConfig")
public class SystemConfigResource extends BusinessBaseResource {

    @Inject
    private SystemConfigService systemConfigService;
    
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final SystemConfig obj) {
        // create
        obj.setOperator(getSessionQuietly().getUserId());
        
        Long parkId = obj.getParkId();
        ResultCode code = verifyByParkId(parkId);
    	if(ResultCode.OK.equals(code))
    		return new Result<Map<String, Long>>(ResultCode.SYSTEM_CONFIG_EXIST);
    	else if(!ResultCode.SYSTEM_CONFIG_NOT_FOUND_BY_PARKID.equals(code))
    		return new Result<Map<String, Long>>(code);
        
        Long id = systemConfigService.create(obj);

        //保存园区logo
        String parkLogo = obj.getParkLogo();
        if(StringUtils.isNotBlank(parkLogo)){
            List<ImageInfo> imageInfos = new ArrayList<ImageInfoService.ImageInfo>();
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setPath(parkLogo);
            imageInfos.add(imageInfo);
            createImageInfo(ImageType.PARK_LOGO, parkId, imageInfos);
        }
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/SystemConfig/%s", id));
        result.setData(map);
        return result;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> update(
            @NotNull @PathParam("id") final Long id,
            @Valid final SystemConfig obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        systemConfigService.update(obj);
        
        //修改园区logo
        SystemConfig systemConfig = systemConfigService.getById(id);
        if(systemConfig == null){
        	return new Result<String>(ResultCode.NOT_FOUND_ITEM);
        }
        
        String parkLogo = obj.getParkLogo();
        List<ImageInfo> imageInfos = new ArrayList<ImageInfoService.ImageInfo>();
        if(StringUtils.isNotBlank(parkLogo)){
            
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setPath(parkLogo);
            imageInfo.setOperator(getSessionQuietly().getUserId());
            imageInfos.add(imageInfo);
        }
        updateImageInfo(ImageType.PARK_LOGO, systemConfig.getParkId(), imageInfos);
        
        return ResultSupport.ok();
    }
    
    /**
     * 根据园区id修改
     * */
    @PUT
    @Path("/parkid/{parkId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> updateByParkId(
            @NotNull @PathParam("parkId") final Long parkId,
            @Valid final SystemConfig obj) {
    	ResultCode code = verifyByParkId(parkId);
    	if(!ResultCode.OK.equals(code))
    		return new Result<String>(code);
    	SystemConfig systemConfig = systemConfigService.getByParkId(parkId).get(0);
        obj.setId(systemConfig.getId());
        obj.setOperator(getSession().getUserId());
        systemConfigService.update(obj);
        
      //修改园区logo
        String parkLogo = obj.getParkLogo();
        List<ImageInfo> imageInfos = new ArrayList<ImageInfoService.ImageInfo>();
        if(StringUtils.isNotBlank(parkLogo)){
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setPath(parkLogo);
            imageInfo.setOperator(getSessionQuietly().getUserId());
            imageInfos.add(imageInfo);
        }
        updateImageInfo(ImageType.PARK_LOGO, parkId, imageInfos);
        
        return ResultSupport.ok();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        SystemConfig obj = new SystemConfig();
        obj.setStatus(Status.DELETED);
        
        //删除园区所对应的logo
        SystemConfig systemConfig = systemConfigService.getById(id);
        if(systemConfig == null){
        	return new Result<String>(ResultCode.NOT_FOUND_ITEM);
        }
        updateImageInfo(ImageType.PARK_LOGO, systemConfig.getParkId(), new ArrayList<ImageInfoService.ImageInfo>());
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
    public Result<SystemConfig> get(@NotNull @PathParam("id") final Long id) {
        SystemConfig obj = systemConfigService.getById(id);
        
        //获取园区对应的logo
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setTargetId(obj.getParkId());
        imageInfo.setImageType(ImageType.PARK_LOGO);
        List<ImageInfo> imageInfos = imageInfoService.findByObj(imageInfo);
        if(CollectionUtils.isNotEmpty(imageInfos)){
        	imageInfo = imageInfos.get(0);
        	obj.setParkLogo(imageInfo.getPath());
        }
        return new Result<SystemConfig>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }
    
    //根据园区id查询
    @GET
    @Path("/parkid/{parkId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<SystemConfig> getByParkId(@NotNull @PathParam("parkId") final Long parkId) {
    	ResultCode code = verifyByParkId(parkId);
    	if(!ResultCode.OK.equals(code))
    		return new Result<SystemConfig>(code, null);
    	
    	SystemConfig obj = systemConfigService.getByParkId(parkId).get(0);
    	ImageInfo imageInfo = new ImageInfo();
        imageInfo.setTargetId(parkId);
        imageInfo.setImageType(ImageType.PARK_LOGO);
        List<ImageInfo> imageInfos = imageInfoService.findByObj(imageInfo);
        if(CollectionUtils.isNotEmpty(imageInfos)){
        	imageInfo = imageInfos.get(0);
        	obj.setParkLogo(imageInfo.getPath());
        }
    	
        return new Result<SystemConfig>(ResultCode.OK, obj);
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<SystemConfig>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum
            ) {
		Query query = new Query();
		query.setOffset(offset);
		query.setLimit(limit);
		query.setPage(pageNum);
		
		Page<SystemConfig> page = systemConfigService.find(query);
		List<SystemConfig> systemConfigs = page.getItems();
		if(CollectionUtils.isNotEmpty(systemConfigs)){
			for(SystemConfig item:systemConfigs){
				ImageInfo imageInfo = new ImageInfo();
		        imageInfo.setTargetId(item.getParkId());
		        imageInfo.setImageType(ImageType.PARK_LOGO);
		        List<ImageInfo> imageInfos = imageInfoService.findByObj(imageInfo);
		        if(CollectionUtils.isNotEmpty(imageInfos)){
		        	imageInfo = imageInfos.get(0);
		        	item.setParkLogo(imageInfo.getPath());
		        }
			}
		}
		
        return new Result<Page<SystemConfig>>(ResultCode.OK, page);
    }
    
    /**
     * 根据园区id校验合法性
     * */
    public ResultCode verifyByParkId(Long parkId){
    	if(parkId==null) return ResultCode.SYSTEM_CONFIG_PARKID_IS_NULL;
    	List<SystemConfig> systemList = systemConfigService.getByParkId(parkId);
        if(systemList.size()==1){
        	return ResultCode.OK;
        }else if(systemList.size()>1){
        	return ResultCode.SYSTEM_CONFIG_ERROR_QUERY;
        }else{
        	return ResultCode.SYSTEM_CONFIG_NOT_FOUND_BY_PARKID;
        }
    }
    
}
