package com.sudaotech.core.web.resteasy;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.ReaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;

@Provider
public class ReaderExceptionHandler implements ExceptionMapper<ReaderException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(ReaderException e) {
        logger.error(e.getMessage());
        
        //TODO
        return Response.status(200).entity(new Result<String>(ResultCode.BAD_REQUEST)).build();
    }
}
