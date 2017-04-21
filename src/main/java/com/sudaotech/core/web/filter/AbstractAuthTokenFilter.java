package com.sudaotech.core.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.Constants;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;

public abstract class AbstractAuthTokenFilter implements javax.servlet.Filter {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private List<String> authExcludes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParameter = filterConfig.getInitParameter("auth.excludes");
        this.logger.info("auth.excludes: {}", initParameter);

        String[] params = StringUtils.split(initParameter, ",");
        List<String> authExcludes = new ArrayList<String>();
        for (String param : params) {
            String str = StringUtils.trim(param);
            if (!StringUtils.isBlank(str)) {
                authExcludes.add(str);
            }
        }

        this.authExcludes = authExcludes;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        // 临时方案
        ThreadContext.put("cookie.domain", httpRequest.getServerName());

        if (checkAuth(resp, chain, httpRequest) || isAuthExcludes(httpRequest)) {
            chain.doFilter(httpRequest, resp);
        } else {
            ResultSupport.outputJson(ResultCode.UNAUTHORIZED, resp);
        }
    }

    protected abstract boolean checkAuth(ServletResponse resp, FilterChain chain, HttpServletRequest httpRequest) throws IOException, ServletException;
    
    protected String getTokenString(HttpServletRequest httpRequest) {
        String tokenString = null;
        
        // from querystring
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getParameter(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }
        
        // from header
        if (StringUtils.isBlank(tokenString)) {
            tokenString = httpRequest.getHeader(Constants.AUTH_TOKEN_NAME_DEFAULT);
        }

        // from cookie
        if (httpRequest.getCookies() != null) {
            for (Cookie c : httpRequest.getCookies()) {
                if (Constants.AUTH_TOKEN_NAME.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
                if (Constants.AUTH_TOKEN_NAME_DEFAULT.equals(c.getName())) {
                    tokenString = c.getValue();
                    break;
                }
            }
        }
        
        return tokenString;
    }


    private boolean isAuthExcludes(HttpServletRequest httpRequest) {
        String uri = httpRequest.getPathInfo();
        for (String item : this.authExcludes) {
            if (StringUtils.startsWith(uri, item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Set the Log4j MDC X-UID
     * @param xuid
     */
    protected void setLog4jXUID(String xuid) {
        // for log4j
        ThreadContext.put("X-UID", xuid);
    }

}
