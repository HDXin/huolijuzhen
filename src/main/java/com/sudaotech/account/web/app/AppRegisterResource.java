package com.sudaotech.account.web.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.apache.commons.lang3.StringUtils;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.account.service.AppAuthService;
import com.sudaotech.account.web.vo.RegisterVo;
import com.sudaotech.core.Constants;
import com.sudaotech.core.EnvConstants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.user.service.AppUserService;
import com.sudaotech.user.service.AppUserService.AppUser;
import com.sudaotech.util.BeanUtils;
import com.sudaotech.util.CookieUtils;

/**
 * 用户账户注册
 */
@Path("/app/register")
public class AppRegisterResource extends BaseResource {
    @Inject
    private AppAuthService authService;

    @Inject
    private AppUserService userService;

    
//    @Inject
//    private MqService mqService;
    private String url;
    
    @Inject
    public AppRegisterResource(@Named(EnvConstants.PLATFORM_URL_IMAGE) String url) throws IOException {
        this.url = url;
    }
    
    @POST
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response register(@Valid RegisterVo registerVo) {
        logger.debug("Registering: {}", registerVo);

        if (StringUtils.isBlank(registerVo.getNickname())) {
            registerVo.setNickname(registerVo.getCellphone()); // 默认使用手机号作为昵称
        }

        if (userService.getByCellphone(registerVo.getCellphone()) != null) {
            logger.info("duplicated: {}", registerVo);
            return Response.ok(new Result<String>(ResultCode.CONFLICT)).build();
        }
        if(null == registerVo.getUserType() || 0L == registerVo.getUserType()){
        	//普通用户
        }

        Map<String, Object> map = new HashMap<String, Object>();
        AppUser user = BeanUtils.copyProperties(registerVo, AppUser.class);
        logger.info("Register OK. {}", registerVo);
        
        AuthToken authToken = this.authService.createAuthToken(user.getUserId(), user.getUserType());
        
        map.put("token", authToken);
        
        return this.buildResponse(map);
    }
    
    private Response buildResponse(Map<String, Object> map) {
    	AuthToken authToken = (AuthToken) map.get("token");
        this.sessionService.createSession(authToken);

        final String token = authToken.token();
        map.put("token", token);
        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok(map));
        // add cookie
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, token, "/", CookieUtils.getCookieDomain());
        NewCookie newCookie = new NewCookie(cookie, "", Constants.AUTH_TOKEN_AGE_MAX, false);
        responseBuilder.cookie(newCookie);
        return responseBuilder.build();
    }
}
