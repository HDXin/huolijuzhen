package com.sudaotech.core.web.resteasy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultCode;
import com.sudaotech.util.JsonUtil;

@Provider
public class RestEasyContainerFilter implements ContainerRequestFilter, ContainerResponseFilter {
    private static final String STREAM = "(...stream...)";
    private static final String EMPTY = "";
    private static final Pattern SCRIPT_PATTERN = Pattern.compile("<script.*>", Pattern.CASE_INSENSITIVE);

    private static final String START_TIME = "START_TIME";
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public void filter(ContainerRequestContext reqCtx) throws IOException {
        // 记录请求参数
        reqCtx.setProperty(START_TIME, System.currentTimeMillis());
        String body = EMPTY;
        
        if (!"GET".equalsIgnoreCase(reqCtx.getMethod()) && isPrintable(reqCtx)) {
            try {
                byte[] buffer = IOUtils.toByteArray(reqCtx.getEntityStream());
                body = new String(buffer);
                if (isSpam(body)) {
                    reqCtx.abortWith(Response.ok(new Result<String>(ResultCode.BAD_REQUEST)).build());
                }
                reqCtx.setEntityStream(new ByteArrayInputStream(buffer));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        
        logger.debug("> Request\n{} {}\n{}", reqCtx.getMethod(), reqCtx.getUriInfo().getRequestUri(), body);
    }

    private boolean isSpam(String body) {
        return body != null && SCRIPT_PATTERN.matcher(body).find();
    }

    @Override
    public void filter(ContainerRequestContext reqCtx, ContainerResponseContext respCtx) throws IOException {
        // QueryString参数(_format=restful)用于是否采用RESTful风格输出
        Object entity = respCtx.getEntity();
        if (entity instanceof Result && isRestful(reqCtx)) {
            Result<?> result = (Result<?>)entity;
            Object data = result.getData();
            respCtx.setEntity(data == null ? "" : data);
            respCtx.setStatus(Integer.valueOf(result.getCode()));
        }
        
        // 请求记录返回结果
        String body = entity instanceof InputStream ? STREAM : JsonUtil.toJsonQuietly(entity);
        Long start = (Long)reqCtx.getProperty(START_TIME);
        long time = System.currentTimeMillis() - (start == null ? 0 : start);
        logger.debug("< Response, time-taken: {}\n{}", time, body);
    }

    private boolean isRestful(ContainerRequestContext reqCtx) {
        MultivaluedMap<String, String> map = reqCtx.getUriInfo().getQueryParameters();
        List<String> list = map.get("_format");
        return list != null && list.contains("restful");
    }

    /**
     * 是否支持预处理请求数据
     * @param reqCtx
     * @return
     */
    private boolean isPrintable(ContainerRequestContext reqCtx) {
        // 文件/图片上传除外
        String path = reqCtx.getUriInfo().getPath();
        MediaType mediaType = reqCtx.getMediaType();
        if (mediaType == null) {
            this.logger.warn("mediaType is null");
            return false;
        }
        String type = mediaType.getType();
        
        boolean b = path.startsWith("/image")
                || path.startsWith("/file")
                || MediaType.APPLICATION_OCTET_STREAM_TYPE.equals(mediaType)
                || MediaType.MULTIPART_FORM_DATA_TYPE.equals(mediaType)
                || type.startsWith("image")
                || type.startsWith("multipart");
        
        return !b;
    }
}
