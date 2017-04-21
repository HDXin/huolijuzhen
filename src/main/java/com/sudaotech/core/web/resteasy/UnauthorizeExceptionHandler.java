package com.sudaotech.core.web.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.exception.UnauthorizeException;

@Provider
public class UnauthorizeExceptionHandler implements ExceptionMapper<UnauthorizeException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(UnauthorizeException e) {
        logger.error(e.getMessage());
        
        return Response.status(200).entity(new Result<String>(ResultCode.UNAUTHORIZED)).build();
    }
}
