package com.sudaotech.core.web.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.exception.IllegalOperationException;

@Provider
public class IllegalOperationExceptionHandler implements ExceptionMapper<IllegalOperationException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(IllegalOperationException e) {
        logger.error(e.getMessage());
        
        Result<String> result = new Result<String>(ResultCode.BAD_REQUEST);
        result.setMessage(e.getMessage());
        
        return Response.status(200).entity(result).build();
    }
}
