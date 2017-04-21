package com.sudaotech.core.web.resteasy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ResteasyViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;

@Provider
public class RestEasyExceptionHandler implements ExceptionMapper<ResteasyViolationException> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Response toResponse(ResteasyViolationException e) {
        final List<String> error = new ArrayList<String>();
        
        List<ResteasyConstraintViolation> violations = e.getViolations();
        for (ResteasyConstraintViolation violation : violations) {
            error.add(violation.getMessage());
        }
        Result<String> result = new Result<String>(ResultCode.BAD_REQUEST);

        logger.error("BAD_REQUEST: Violations: {}", error);

        return Response.status(200).entity(result).build();
    }
}
