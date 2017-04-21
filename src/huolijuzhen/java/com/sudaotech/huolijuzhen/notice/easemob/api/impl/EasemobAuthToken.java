package com.sudaotech.huolijuzhen.notice.easemob.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.huolijuzhen.notice.easemob.api.AuthTokenAPI;
import com.sudaotech.huolijuzhen.notice.easemob.api.EasemobRestAPI;
import com.sudaotech.huolijuzhen.notice.easemob.comm.body.AuthTokenBody;
import com.sudaotech.huolijuzhen.notice.easemob.comm.constant.HTTPMethod;
import com.sudaotech.huolijuzhen.notice.easemob.comm.helper.HeaderHelper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.BodyWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.HeaderWrapper;

public class EasemobAuthToken extends EasemobRestAPI implements AuthTokenAPI{
	
	public static final String ROOT_URI = "/token";
	
	private static final Logger log = LoggerFactory.getLogger(EasemobAuthToken.class);
	
	@Override
	public String getResourceRootURI() {
		return ROOT_URI;
	}

	public Object getAuthToken(String clientId, String clientSecret) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
		BodyWrapper body = new AuthTokenBody(clientId, clientSecret);
		HeaderWrapper header = HeaderHelper.getDefaultHeader();
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
	}
}
