package com.sudaotech.huolijuzhen.notice.easemob.api.impl;

import com.sudaotech.huolijuzhen.notice.easemob.api.EasemobRestAPI;
import com.sudaotech.huolijuzhen.notice.easemob.api.SendMessageAPI;
import com.sudaotech.huolijuzhen.notice.easemob.comm.constant.HTTPMethod;
import com.sudaotech.huolijuzhen.notice.easemob.comm.helper.HeaderHelper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.BodyWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.HeaderWrapper;

public class EasemobSendMessage extends EasemobRestAPI implements SendMessageAPI {
    private static final String ROOT_URI = "/messages";

    @Override
    public String getResourceRootURI() {
        return ROOT_URI;
    }

    public Object sendMessage(Object payload) {
        String  url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
    }

}
