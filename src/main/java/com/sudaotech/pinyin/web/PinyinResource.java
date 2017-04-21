package com.sudaotech.pinyin.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.inject.Inject;
import com.sudaotech.core.web.MediaTypeExt;
import com.sudaotech.core.web.resource.BaseResource;
import com.sudaotech.core.web.result.Result;
import com.sudaotech.core.web.result.ResultSupport;
import com.sudaotech.pinyin.service.PinyinService;

/**
 * 汉字获取拼音
 */
@Path("/pinyin")
public class PinyinResource extends BaseResource {

    @Inject
    private PinyinService pinyinService;

    /**
     * <pre>
     * 1) 若不指定abbrev，则返回全拼和简拼
     * 2) 若abbrev=false，则返回全拼
     * 3) 若abbrev=true，则返回简拼
     * </pre>
     * @param input
     * @param abbrev
     * @return
     */
    @GET
    @Path("/{input}")
    @Produces(MediaTypeExt.APPLICATION_JSON_UTF8)
    @Consumes(MediaTypeExt.APPLICATION_JSON_UTF8)
    public Result<List<String>> getPinyin(
            @PathParam("input") String input,
            @QueryParam("abbrev") Boolean abbrev
            ) {
        List<String> result = new ArrayList<String>();

        if (abbrev == null) {
            result.addAll(pinyinService.getMixedPinyinByWords(input));
        } else {
            if (abbrev) {
                result.addAll(pinyinService.getAbbrevPinyinByWords(input));
            } else {
                result.addAll(pinyinService.getPinyinByWords(input));
            }
        }
        
        return ResultSupport.ok(result);
    }
    
}
