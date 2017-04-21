package com.sudaotech.core.web.resteasy;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(NotFoundException e) {
        logger.error(e.getMessage());
        
        return Response.status(200).type(MediaTypeExt.APPLICATION_JSON_UTF8).entity(new Result<String>(ResultCode.NOT_FOUND)).build();
    }
}
