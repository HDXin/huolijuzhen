package com.sudaotech.core.web.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.exception.PermissionException;

@Provider
public class PermissionExceptionHandler implements ExceptionMapper<PermissionException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(PermissionException e) {
        logger.error(e.getMessage());
        
        return Response.status(200).entity(ResultSupport.forbidden()).build();
    }
}
