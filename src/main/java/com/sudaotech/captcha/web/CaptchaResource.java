package com.sudaotech.captcha.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.sudaotech.captcha.service.CaptchaService;
import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.SecureToken;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;

/**
 * 防机器人验证码
 */
@Path("/captcha")
public class CaptchaResource extends BaseResource {

    @Inject
    private CaptchaService captchaService;

    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<Map<String, String>> createCaptchaCode() throws UnsupportedEncodingException {
        logger.debug("Creating captcha");

        // TODO add more logic to create captcha code

        Map<String, String> map = new HashMap<String, String>();
        String code = this.captchaService.createCaptchaCode();

        long active = System.currentTimeMillis();
        long expiry = active + 1000 * 60 * 5; // active + 5min
        SecureToken secureToken = new SecureToken(code, active, expiry);

        String token = secureToken.token();
        map.put("captcha", token);

        map.put("image", "/captcha/" + URLEncoder.encode(token, Constants.UTF8));

        return ResultSupport.ok(map);
    }

    @GET
    @Path("/captcha/{token}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response getCaptchaImage(@PathParam("token") String token) {
        logger.debug("Loading captcha image, captcha token: {}", token);
        SecureToken secureToken;
        try {
            secureToken = SecureToken.parse(token);
        } catch (Exception e) {
            logger.error("Error parsing captcha token: {} - {}", token, e.getMessage());
            return Response.ok(new Result<String>(ResultCode.BAD_REQUEST)).build();
        }
        if (SecureToken.isActive(secureToken)) {
            try {
                byte[] buf = this.captchaService.createCaptchaImage(secureToken.raw);
                return Response.ok(buf).type(MediaTypeExt.IMAGE_JPEG).build();
            } catch (IOException e) {
                return Response.ok(ResultSupport.serverError()).build();
            }
        }

        logger.error("Inactive captcha token: {}", token);

        return Response.ok(new Result<String>(ResultCode.NOT_FOUND)).build();
    }
    
    
    @GET
    @Path("/captcha")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response getCaptchaImages(@QueryParam("token") String token) {
        logger.debug("Loading captcha image, captcha token: {}", token);
        SecureToken secureToken;
        try {
            secureToken = SecureToken.parse(token);
        } catch (Exception e) {
            logger.error("Error parsing captcha token: {} - {}", token, e.getMessage());
            return Response.ok(new Result<String>(ResultCode.BAD_REQUEST)).build();
        }
        if (SecureToken.isActive(secureToken)) {
            try {
                byte[] buf = this.captchaService.createCaptchaImage(secureToken.raw);
                return Response.ok(buf).type(MediaTypeExt.IMAGE_JPEG).build();
            } catch (IOException e) {
                return Response.ok(ResultSupport.serverError()).build();
            }
        }

        logger.error("Inactive captcha token: {}", token);

        return Response.ok(new Result<String>(ResultCode.NOT_FOUND)).build();
    }

}
