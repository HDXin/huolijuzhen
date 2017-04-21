package com.sudaotech.huolijuzhen.notice.easemob.api;

import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.BodyWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.HeaderWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.QueryWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.ResponseWrapper;

import java.io.File;

public interface RestAPIInvoker {
	ResponseWrapper sendRequest(String method, String url, HeaderWrapper header, BodyWrapper body, QueryWrapper query);
	ResponseWrapper uploadFile(String url, HeaderWrapper header, File file);
    ResponseWrapper downloadFile(String url, HeaderWrapper header, QueryWrapper query);
}
