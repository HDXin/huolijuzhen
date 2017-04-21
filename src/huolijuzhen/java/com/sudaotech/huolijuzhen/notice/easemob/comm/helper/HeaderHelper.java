package com.sudaotech.huolijuzhen.notice.easemob.comm.helper;

import com.sudaotech.huolijuzhen.notice.easemob.comm.ClientContext;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.HeaderWrapper;


public class HeaderHelper {
	
	private static ClientContext context;
	
	public HeaderHelper(ClientContext context){
		HeaderHelper.context=context;
	}
	
	public static HeaderWrapper getDefaultHeader() {
		return HeaderWrapper.newInstance().addJsonContentHeader();
	}
	
	public HeaderWrapper getDefaultHeaderWithToken() {
		return getDefaultHeader().addAuthorization(context.getAuthToken());
	}

	public static HeaderWrapper getUploadHeaderWithToken() {
		return HeaderWrapper.newInstance().addAuthorization(context.getAuthToken()).addRestrictAccess();
	}

	public static HeaderWrapper getDownloadHeaderWithToken(String shareSecret, Boolean isThumb) {
		HeaderWrapper headerWrapper = HeaderWrapper.newInstance().addAuthorization(context.getAuthToken()).addMediaAccept().addShareSecret(shareSecret);
		if(isThumb) {
			headerWrapper.addThumbnail();
		}

		return headerWrapper;
	}

	public static ClientContext getContext() {
		return context;
	}

	public static void setContext(ClientContext context) {
		HeaderHelper.context = context;
	}
	
	
}
