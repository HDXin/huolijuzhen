package com.sudaotech.area.web;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.apache.commons.lang3.StringUtils;
import com.google.inject.Inject;
import com.sudaotech.area.service.Area;
import com.sudaotech.area.service.AreaService;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultSupport;

/**
 * 省市区区域信息
 */
@Path("/area")
public class AreaResource extends BaseResource {

    @Inject
    private AreaService areaService;
    
    @GET
    @Path("/{idOrName}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Area> listArea(@PathParam("idOrName") String idOrName) {
        Area area = null;
        if (StringUtils.isNumeric(idOrName)) {
            area = this.areaService.getByAreaId(Integer.parseInt(idOrName));
        } else {
            area = this.areaService.getByAreaName(idOrName);
        }
        
        if (area != null) {
            area.setItems(this.areaService.findByParentId(area.getAreaId()));
        }
        
        return ResultSupport.ok(area);
    }
    
    @GET
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<Area>> listArea(
            @DefaultValue("0") @QueryParam("parentId") Integer parentId) {
        List<Area> list = this.areaService.findByParentId(parentId);
        return ResultSupport.ok(list);
    }
}
