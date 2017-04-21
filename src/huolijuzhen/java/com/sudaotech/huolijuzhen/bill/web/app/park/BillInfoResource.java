package com.sudaotech.huolijuzhen.bill.web.app.park;

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
import com.sudaotech.huolijuzhen.basic.service.GenCodeService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService;
import com.sudaotech.huolijuzhen.bill.service.BillChangeLogsService.BillChangeLogs;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService;
import com.sudaotech.huolijuzhen.bill.service.BillCostDetailService.BillCostDetail;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.BillInfo;
import com.sudaotech.huolijuzhen.bill.service.BillInfoService.Query;
import com.sudaotech.huolijuzhen.commons.constant.Constants;
import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;
import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;
import com.sudaotech.huolijuzhen.enums.BillPushStatus;
import com.sudaotech.huolijuzhen.enums.BillStatus;
import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.huolijuzhen.enums.BillOperType;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.huolijuzhen.util.SystemUtil;
import com.sudaotech.util.MapHelper;

@Path("/app/park/billInfo")
public class BillInfoResource extends BaseResource {

    @Inject
    private BillInfoService billInfoService;
    
    @Inject
    private GenCodeService genCodeService;
    
    @Inject
    private BillCostDetailService  billCostDetailService;
    
    @Inject
    private BillChangeLogsService billChangeLogsService;
    
    
    
    
}
