package com.sudaotech.image.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.image.ImageSize;
import com.sudaotech.image.service.ImageService;

@Path("/image")
public class ImageResource extends BaseResource {

    @Inject
    private ImageService imageService;

//    @RequirePermission(ImagePermissionDef.CREATE_IMAGE)
    @POST
    @Path("/")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Result<List<String>> uploadMultiPartFile(
            ) throws Exception {
        List<String> list = new ArrayList<String>();
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator fileIterator = upload.getItemIterator(this.httpRequest);
        while (fileIterator.hasNext()) {
            FileItemStream item = fileIterator.next();
            String path = this.imageService.save(item.getName(), item.openStream(), this.getSessionQuietly());
            list.add(path);
        }

        return ResultSupport.ok(list);
    }
    
    @POST
    @Path("/vague")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Result<List<String>> uploadMultiPartFileToVague() throws Exception {
        List<String> list = new ArrayList<String>();
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator fileIterator = upload.getItemIterator(this.httpRequest);
        while (fileIterator.hasNext()) {
            FileItemStream item = fileIterator.next();
            String path = this.imageService.saveToVague(item.getName(), item.openStream(), this.getSessionQuietly());
            list.add(path);
        }

        return ResultSupport.ok(list);
    }
    
//    @RequirePermission(ImagePermissionDef.CREATE_IMAGE)
    @POST
    @Path("")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Result<String> uploadFile(@NotNull(message="fileName required") @QueryParam("fileName") String fileName) throws Exception {
    	Session session = this.getSessionQuietly();
    	if(session == null || null == session.getUserId() || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
    	
    	String path = this.imageService.saveToVague(fileName, this.httpRequest.getInputStream(), session);
        return ResultSupport.ok(path);
    }
    
    @POST
    @Path("/internetImageDownload")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<String> downloadImageFromIntenet(@NotNull(message="imageURL required") @QueryParam("imageURL") String imageURL) throws Exception {
    	Session session = this.getSessionQuietly();
    	if(session == null || session.getUserId() == 0){
    		return new Result<String>(ResultCode.SESSION_IS_NULL);
    	}
    	
    	String path = this.imageService.downloadImageFromUri(imageURL, session);
    	return ResultSupport.ok(path);
    }

    @GET
    @Path("/barcode/{barcode}")
    public Response getBarcodeImage(
                @PathParam("barcode") String barcode
                )
            throws Exception {
        if (StringUtils.length(barcode) != 12) {
            throw new BadRequestException("barcode invalid");
        }
        
        JBarcode jBarcode = new JBarcode(EAN13Encoder.getInstance(),
                WidthCodedPainter.getInstance(),
                BaseLineTextPainter.getInstance()
                /*EAN13TextPainter.getInstance()*/);
        jBarcode.setXDimension(0.8); // 尺寸，面积，大小
        jBarcode.setBarHeight(30); // 条形码高度
        jBarcode.setWideRatio(20); // 宽度率
        jBarcode.setShowCheckDigit(true); // 是否校验最后一位，默认是false
        BufferedImage bufferedImage = jBarcode.createBarcode(barcode);
        byte[] buf = ImageUtil.encode(bufferedImage, "jpeg");
        return Response.ok(new ByteArrayInputStream(buf))
                .type(MediaTypeExt.IMAGE_JPEG).build();
    }

    @GET
    @Path("{path:(.)+}")
    public Response getFile(@PathParam("path") String path) throws Exception {
        InputStream input = this.imageService.read(path);
        if (input == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(input).type(MediaTypeExt.IMAGE_JPEG).build();
    }

}