package com.sudaotech.core.web.resource;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.sudaotech.core.Constants;
import com.sudaotech.core.EnvConstants;
import com.sudaotech.core.Session;
import com.sudaotech.core.SessionAware;
import com.sudaotech.core.Updatable;
import com.sudaotech.core.config.ConfigLoader;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.core.service.SessionService;
import com.sudaotech.exception.UnauthorizeException;
import com.sudaotech.huolijuzhen.commons.conf.HuolijuzhenConfig;

public abstract class BaseResource implements SessionAware {
    /**
     * 平台image url前缀
     */
    private static final String PLATFORM_URL_IMAGE;
    
    public static final String PLATFORM_URL_H5;
    static {
        String url = ConfigLoader.loadEnvConfig().get(EnvConstants.PLATFORM_URL_IMAGE);
        if (StringUtils.endsWith(url, "/")) {
            url = url.substring(0, url.length() - 1);
        }
        PLATFORM_URL_IMAGE = url;
        
        url = HuolijuzhenConfig.getInstance().getDomainHtmlUrl();
        if (StringUtils.endsWith(url, "/")) {
            url = url.substring(0, url.length() - 1);
        }
        PLATFORM_URL_H5 = url;
        
    }
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Context
    protected HttpServletRequest httpRequest;

    @Context
    protected HttpServletResponse httpResponse;

    @Inject
    protected SessionService sessionService;

    protected SessionService getSessionService() {
        return this.sessionService;
    }
    
    /**
     * 获取当前会话
     * @return the Session or null
     */
    @Override
    public Session getSession() {
        Session session = getSessionQuietly();
        
        if (session == null || session.getUserId() == 0) {
            Integer userId = (Integer) httpRequest.getAttribute(Constants.SESSION_USER_ID);
            throw new UnauthorizeException("session inactive, userId: " + userId);
        }
        return session;
    }

    public Session getSessionQuietly() {
        Session session = (Session)httpRequest.getAttribute(Constants.SESSION);
        if (session == null) {
            session = this.getSessionService().getSession(getSessionAuthToken());
            httpRequest.setAttribute(Constants.SESSION, session);
        }
        return session;
    }
    
    /**
     * 清除当前会话
     * @return the Session or null
     */
    @Override
    public void clearSession() {
        this.getSessionService().deleteSession(getSessionAuthToken());
    }

    private AuthToken getSessionAuthToken() {
        AuthToken authToken = (AuthToken) httpRequest.getAttribute(Constants.SESSION_AUTH_TOKEN);
        return authToken;
    }
    
    /**
     * 设置操作者
     * @param obj Updatable
     */
    protected void setOperator(Updatable obj) {
        if (obj == null) {
            logger.warn("operator is null");
            return;
        }
        
        final Long operator = getSession().getUserId();
        obj.setOperator(operator);
    }
    
    protected String buildImageUrl(String origin) {
        if (StringUtils.isBlank(origin)) {
            return origin;
        }
        
        String lowerCase = origin.toLowerCase();
         
        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
            return origin;
        }
        
        if (lowerCase.startsWith("/")) {
            return PLATFORM_URL_IMAGE + origin;    
        }
        return PLATFORM_URL_IMAGE + "/" + origin;
    }
    
    protected boolean isIOS() {
        // TODO 优化
        // if ios
        boolean b = false;
        if (StringUtils.contains(this.httpRequest.getHeader("user-agent"), "iPhone")) {
            b = true;
        }
        
        logger.debug("isIOS: headernames>>>");
        Enumeration<String> headerNames = this.httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            logger.debug("isIOS: {}={}", nextElement, httpRequest.getHeader(nextElement));
        }
        
        logger.debug("isIOS: {}", b);
        
        return b;
    }
}
