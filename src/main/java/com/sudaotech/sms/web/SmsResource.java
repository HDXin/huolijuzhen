package com.sudaotech.sms.web;

import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.sms.service.Sms;
import com.sudaotech.sms.service.SmsService;
import com.sudaotech.util.MapHelper;

@Path("/sms")
public class SmsResource extends BaseResource {

    @Inject
    private SmsService smsService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, String>> sendShortMessage(
                    @Valid final Sms shortMessage) {
        boolean sendStatus = this.smsService.sendSms(shortMessage, getSession());

        Map<String, String> map = MapHelper.put("sendStatus", String.valueOf(sendStatus)).getMap();
        Result<Map<String, String>> result = new Result<Map<String, String>>(ResultCode.OK);
        result.setData(map);
        return result;
    }
}
