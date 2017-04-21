package com.sudaotech.account.web.app;

import com.google.inject.Inject;
import com.sudaotech.account.service.AppAuthService;
import com.sudaotech.account.service.Login;
import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.enums.PlatformSource;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.huolijuzhen.basic.service.MessageService;
import com.sudaotech.huolijuzhen.util.Contains;
import com.sudaotech.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登陆授权
 */
@SuppressWarnings("Duplicates")
@Path("/{platformSource}/app")
public class AppAuthResource extends BaseResource {

    @Inject
    private AppAuthService authService;

    @Inject
    private MessageService messageService;

    /**
     * 系统登陆
     *
     * @param login
     * @return
     */
    @POST
    @Path("/login")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response login(@Valid Login login, @NotNull @PathParam("platformSource") String platformSource) {
        login.setPlatformSource(PlatformSource.codeOf(platformSource.toUpperCase()));
        return this.createAuthToken(login, Constants.AUTH_TOKEN_NAME);
    }

    private Response createAuthToken(Login login, String... cookieNames) {

        login.setIp(this.httpRequest.getRemoteHost());
        System.out.println("IP = " + login.getIp());

        logger.info("Login...: {}", login);

        // try to authenticate the login request
        AuthToken authToken = this.authService.auth(login);
        if (authToken == null) {
            logger.error("Login FAIL. {}", login);
            return Response.ok(new Result<NewCookie>(ResultCode.AUTH_FAILED)).build();
        }

        this.sessionService.createSession(authToken);

        final String token = authToken.token();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok(map));
        // add cookie
        for (String cookieName : cookieNames) {
            Cookie cookie = new Cookie(cookieName, token, "/", CookieUtils.getCookieDomain());
            NewCookie newCookie;
            if (login.getRemember()) {
                newCookie = new NewCookie(cookie, "", Constants.AUTH_TOKEN_AGE_MAX, false);
            } else {
                newCookie = new NewCookie(cookie);
            }
            responseBuilder.cookie(newCookie);
        }

        //app登陆成功后,注册消息中间件,方便消息及时通知
        try {
            if (StringUtils.isNotBlank(login.getSystemId())) {
                Map<String, String> headers = new HashMap<>();
                headers.put("appId", Contains.Base.appId);
                headers.put("token", token);
                messageService.regMiddleware(headers, login.getSystemId());
            } else {
                logger.warn("login.getSystemId() is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseBuilder.build();
    }

    /**
     * 退出
     */
    @GET
    @Path("/logout")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response logout() {
        this.clearSession();

        final ResponseBuilder responseBuilder = Response.ok(ResultSupport.ok());
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, "", "/", CookieUtils.getCookieDomain());
        responseBuilder.cookie(new NewCookie(cookie, "", 0, false));
        return responseBuilder.build();
    }
}
