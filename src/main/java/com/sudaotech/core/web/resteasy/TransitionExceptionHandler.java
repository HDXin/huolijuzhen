package com.sudaotech.core.web.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.exception.TransitionException;

@Provider
public class TransitionExceptionHandler implements ExceptionMapper<TransitionException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(TransitionException e) {
        logger.error(e.getMessage());
        
        return Response.status(200).entity(ResultSupport.forbidden()).build();
    }
}
