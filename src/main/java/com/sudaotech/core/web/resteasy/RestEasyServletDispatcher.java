package com.sudaotech.core.web.resteasy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.ResultSupport;

public class RestEasyServletDispatcher extends HttpServletDispatcher {

    private static final long serialVersionUID = -116342833512817721L;
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            super.service(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ResultSupport.serverError(response);
        }
    }
}
