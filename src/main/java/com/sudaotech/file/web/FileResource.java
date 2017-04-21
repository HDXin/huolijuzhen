package com.sudaotech.file.web;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.annotation.RequirePermission;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.file.FilePermissionDef;
import com.sudaotech.file.service.FileStorageService;

@Path("/file")
public class FileResource extends BaseResource {

    @Inject
    private FileStorageService fileStorageService;

    @RequirePermission(FilePermissionDef.CREATE_FILE)
    @POST
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Result<List<String>> uploadMuliPartFile() throws Exception {
        List<String> list = new ArrayList<String>();
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator fileIterator = upload.getItemIterator(this.httpRequest);
        while (fileIterator.hasNext()) {
            FileItemStream item = fileIterator.next();
            String path = this.fileStorageService.save(item.getName(), item.openStream(), this.getSession());
            list.add(path);
        }

        return ResultSupport.ok(list);
    }
    
    @RequirePermission(FilePermissionDef.CREATE_FILE)
    @POST
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Result<String> uploadFile(@NotNull @QueryParam("fileName") String fileName) throws Exception {
    	Session session = this.getSessionQuietly();
    	if(session == null || null == session.getUserId() || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
    	
        String path = this.fileStorageService.save(fileName, this.httpRequest.getInputStream(), session);
        return ResultSupport.ok(path);
    }
    
    @GET
    @Path("{path:(.)+}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Response getFile(@PathParam("path") String path) throws Exception {
        InputStream input = this.fileStorageService.read(path);
        if (input == null) {
            return Response.ok(new Result<String>(ResultCode.NOT_FOUND)).build();
        }
        return Response.ok(input).type(MediaType.APPLICATION_OCTET_STREAM).build();
    }

    @RequirePermission(FilePermissionDef.CREATE_FILE)
    @POST
    @Path("/named/{path:(.)+}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> createNamedFile(
            @PathParam("path") String path,
            @DefaultValue("true") @QueryParam("append") Boolean append,
            @DefaultValue("true") @QueryParam("timestamp") Boolean timestamp
            ) throws Exception {
        this.fileStorageService.write(path, this.httpRequest.getInputStream(), append, timestamp);
        return ResultSupport.ok(path);
    }

}