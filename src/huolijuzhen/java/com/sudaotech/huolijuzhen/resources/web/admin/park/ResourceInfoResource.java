package com.sudaotech.huolijuzhen.resources.web.admin.park;

import java.util.ArrayList;
import java.util.Date;
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
import org.apache.commons.collections4.map.HashedMap;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService;
import com.sudaotech.huolijuzhen.enterprise.service.ContractResourceService.ContractResource;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.huolijuzhen.resources.service.ResInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.Query;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.ResourceInfo;
import com.sudaotech.huolijuzhen.util.CodeUtil;
import com.sudaotech.util.MapHelper;

@Path("/admin/park/resourceInfo")
public class ResourceInfoResource extends BaseResource {

    @Inject
    private ResourceInfoService resourceInfoService;

    @Inject
    private ResInfoService resInfoService;
    
    @Inject
    private ContractResourceService contractResourceService;
    
    @Inject
    private ContractInfoService contractInfoService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<Map<String, Long>> create(@Valid final ResourceInfo obj) {
        Session session = getSession();
        obj.setGardenId(session.getPlatformId());
        obj.setUseStatus(UseStatus.NOUSE);
        // create
        obj.setOperator(getSession().getUserId());
        Long id = resourceInfoService.create(obj);
        Map<String, Long> map = MapHelper.put("id", id).getMap();

        Result<Map<String, Long>> result = new Result<Map<String, Long>>(ResultCode.OK);
        result.setLocation(String.format("/admin/resourceInfo/%s", id));
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
            @Valid final ResourceInfo obj) {
        obj.setId(id);
        obj.setOperator(getSession().getUserId());
        resourceInfoService.update(obj);
        return ResultSupport.ok();
    }

    @POST
    @Path("/batch")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<List<ResourceInfoService.ResourceInfo>> createBatch(@Valid final ResourceInfoService.Batch batch) {
        logger.warn("batct={}", batch);
        Session session = getSession();
        //检测要生成的code是否已经生成过

        List<String> codeList = CodeUtil.genStationNo(batch);//按照规则生成code
        Query query = new Query();
        query.setParentId(batch.getParentId());
        query.setCodeList(codeList);
        List<ResourceInfoService.ResourceInfo> resourceInfoList = this.resourceInfoService.getByQuery(query);
        if (resourceInfoList != null) {
            return new Result<>(ResultCode.BATCH_ADD_FAILD, resourceInfoList);
        }
        for (String code : codeList) {
            ResourceInfoService.ResourceInfo obj = new ResourceInfoService.ResourceInfo();
            obj.setGardenId(session.getPlatformId());
            obj.setIsRoot(batch.getRoot());
            obj.setIsSeat(batch.getSeat());
            obj.setParentId(batch.getParentId());
            obj.setResInfoId(batch.getResInfoId());
            obj.setTierId(batch.getTierId());
            obj.setTierName(batch.getTierName());
            obj.setTierNum(batch.getTierNum());
            obj.setUseStatus(UseStatus.NOUSE);
            obj.setCode(code);
            obj.setName(code);
            obj.setArea(Double.valueOf(batch.getArea()));
            obj.setPrice(batch.getPrice());
            // create
            obj.setOperator(session.getUserId());
            resourceInfoService.create(obj);
        }
        return new Result<List<ResourceInfo>>(ResultCode.OK);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Transactional
    public Result<String> delete(@NotNull @PathParam("id") final Long id) {
        Long userId = getSession().getUserId();
        ResourceInfo obj = new ResourceInfo();
        obj.setStatus(Status.DELETED);
        obj.setDeleteBy(userId);
        obj.setDeleteTime(new Date());
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
    public Result<ResourceInfo> get(@NotNull @PathParam("id") final Long id) {
        ResourceInfo obj = resourceInfoService.getById(id);

        return new Result<ResourceInfo>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }

    @GET
    @Path("/parentId/{parentId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<ResourceInfo>> getByParentId(@NotNull @PathParam("parentId") final Long parentId) {
        List<ResourceInfo> obj = resourceInfoService.getByParentId(parentId);

        return new Result<List<ResourceInfo>>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }


    @GET
    @Path("/parentIdAndPage/{parentId}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ResourceInfo>> getByParentIdAndPage(@NotNull @PathParam("parentId") final Long parentId,
                                                           @QueryParam("offset") Integer offset,
                                                           @QueryParam("limit") Integer limit,
                                                           @QueryParam("page") Integer pageNum) {
        Query query = new Query();
        query.setParentId(parentId);
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        Page<ResourceInfo> obj = resourceInfoService.find(query);

        return new Result<>(obj == null ? ResultCode.NOT_FOUND : ResultCode.OK, obj);
    }


    @GET
    @Path("/findAll")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<ResInfoService.ResInfo>> findAll() {
        ResInfoService.Query query = new ResInfoService.Query();
        query.setParkInfoId(getSession().getPlatformId());

        //1.获取所有的资源类型
        List<ResInfoService.ResInfo> resInfoList = this.resInfoService.findAll(query);//找到所有的资源类型
        if (resInfoList == null) {
            resInfoList = new ArrayList<>();
        }
        
        //2.获取所有的已被暂用的资源
        ContractResource contractResource = new ContractResource();
        //资源合同关联管理列表
        List<ContractResource>  contractResources = contractResourceService.findAllUseReslurce(contractResource);
        //所有已被占用资源 ID
        List<Long> useResourceIds = new ArrayList<Long>();
        //已被占用的资源ID 对应的 合同 ID
        Map<Long, Long> contractResourceMap = new HashedMap<Long, Long>();
        //合同 IDs 
        List<Long> contractInfoIds = new ArrayList<Long>();
        if(CollectionUtils.isNotEmpty(contractResources)){
        	for(ContractResource item:contractResources){
        		useResourceIds.add(item.getResourceId());
        		contractResourceMap.put(item.getResourceId(), item.getContractId());
        		
        		contractInfoIds.add(item.getContractId());
        	}
        }
        
        //3.获取已占用资源的合同信息
        Map<Long, ContractInfo> contractInfoMap = new HashedMap<Long, ContractInfoService.ContractInfo>();
        if(CollectionUtils.isNotEmpty(contractInfoIds)){
        	ContractInfo ci = new ContractInfo();
        	ci.setIds(contractInfoIds);
        	List<ContractInfo> contractInfos = contractInfoService.findByObj(ci);
        	if(CollectionUtils.isNotEmpty(contractInfos)){
        		for(ContractInfo item:contractInfos){
        			contractInfoMap.put(item.getId(), item);
        		}
        	}
        }
        
        //4.遍历资源类型
        for (ResInfoService.ResInfo resInfo : resInfoList) {
            ResourceInfoService.Query query1 = new Query();
            query1.setRoot(true);
            query1.setResInfoId(resInfo.getId());
            List<ResourceInfoService.ResourceInfo> resourceInfoList = this.resourceInfoService.getByQuery(query1);
            if (resourceInfoList != null) {
                //开始递归查询
                for (ResourceInfoService.ResourceInfo resourceInfo : resourceInfoList) {
                    queryBySelf(resourceInfo, resInfo, useResourceIds, contractResourceMap,contractInfoMap);
                }
                resInfo.setResourceInfoList(resourceInfoList);
            }
        }
        return new Result<>(ResultCode.OK, resInfoList);
    }

    private ResourceInfoService.ResourceInfo queryBySelf(ResourceInfoService.ResourceInfo resourceInfo, 
    		ResInfoService.ResInfo resInfoType, List<Long> useResourceIds, Map<Long, Long> contractResourceMap, Map<Long, ContractInfo> contractInfoMap) {
        List<ResourceInfoService.ResourceInfo> resourceInfoList = this.resourceInfoService.getByParentId(resourceInfo.getId());
        if (CollectionUtils.isEmpty(resourceInfoList)) {
            return resourceInfo;
        }
        resourceInfo.setResourceInfoList(resourceInfoList);
        for (ResourceInfoService.ResourceInfo o : resourceInfoList) {
        	//如果是基础层级,就设置其类型(web要显示)
            if (o.getIsSeat() != null && !o.getIsSeat()) {
                queryBySelf(o, resInfoType, useResourceIds, contractResourceMap, contractInfoMap);
            }
            
        	ResInfoService.ResInfo resInfo = this.resInfoService.getById(o.getResInfoId());
            if (resInfo != null) {
                o.setResInfoName(resInfo.getName());
            }
            o.setCalcDimension(resInfoType.getCalcDimension());
            o.setEnableAvg(resInfoType.getEnableAvg());
            
            //占用状况
            o.setUseStatus(UseStatus.NOUSE);
            if(CollectionUtils.isNotEmpty(useResourceIds) && useResourceIds.contains(o.getId())){
            	o.setUseStatus(UseStatus.USE);
                //暂用资源的合同信息
                o.setContractInfo(contractInfoMap.get(contractResourceMap.get(o.getId())));
            }
            
            
        }
        return resourceInfo;
        
    }

    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Page<ResourceInfo>> find(
            @QueryParam("offset") Integer offset,
            @QueryParam("limit") Integer limit,
            @QueryParam("page") Integer pageNum,
            @QueryParam("parentId") Long parentId,
            @QueryParam("name") String name,
            @QueryParam("resInfoId") Long resInfoId,
            @QueryParam("tierId") Long tierId,
            @QueryParam("isRoot") Boolean isRoot
    ) {
        Session session = getSession();
        Query query = new Query();
        query.setName(name);
        query.setParentId(parentId);
        query.setResInfoId(resInfoId);
        query.setTierId(tierId);
        query.setOffset(offset);
        query.setLimit(limit);
        query.setPage(pageNum);
        query.setRoot(isRoot);
        query.setParkInfoId(session.getPlatformId());


        Page<ResourceInfo> page = resourceInfoService.find(query);
        return new Result<Page<ResourceInfo>>(ResultCode.OK, page);
    }
}
