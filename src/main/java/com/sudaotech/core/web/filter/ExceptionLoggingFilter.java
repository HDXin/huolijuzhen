package com.sudaotech.core.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.ResultSupport;

public class ExceptionLoggingFilter implements javax.servlet.Filter {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {
        long startTime = System.currentTimeMillis();
        
        ThreadContext.put("X-UUID", UUID.randomUUID().toString());

        HttpServletRequest h = (HttpServletRequest)req;
        String requestURI = h.getRequestURI();
        if (h.getQueryString() != null) {
            requestURI += "?" + h.getQueryString();
        }
        logger.info("> {} {}", h.getMethod(), requestURI);
        
        try {
            chain.doFilter(req, resp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ResultSupport.serverError(resp);
        }
        logger.info("< Response, time-taken: {}", (System.currentTimeMillis() - startTime));
        
        ThreadContext.clearAll();
    }

    @Override
    public void init(FilterConfig cfg) throws ServletException {
    }

}
