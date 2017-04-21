package com.sudaotech.huolijuzhen.notice.easemob.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.huolijuzhen.notice.easemob.api.EasemobRestAPI;
import com.sudaotech.huolijuzhen.notice.easemob.api.IMUserAPI;
import com.sudaotech.huolijuzhen.notice.easemob.comm.constant.HTTPMethod;
import com.sudaotech.huolijuzhen.notice.easemob.comm.helper.HeaderHelper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.BodyWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.HeaderWrapper;
import com.sudaotech.huolijuzhen.notice.easemob.comm.wrapper.QueryWrapper;

public class EasemobIMUsers extends EasemobRestAPI implements IMUserAPI {

	private static final Logger log = LoggerFactory.getLogger(EasemobIMUsers.class);
	
	private static final String ROOT_URI = "/users";

	public Object createNewIMUserSingle(Object payload) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
		BodyWrapper body = (BodyWrapper) payload;
		HeaderWrapper header =new  HeaderHelper(getContext()).getDefaultHeaderWithToken();
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
	}

	public Object createNewIMUserBatch(Object payload) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
		BodyWrapper body = (BodyWrapper) payload;
		HeaderWrapper header =new HeaderHelper(getContext()).getDefaultHeaderWithToken();
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
	}

	public Object getIMUsersByUserName(String userName) {
		String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName;
		HeaderWrapper header =new HeaderHelper(getContext()).getDefaultHeaderWithToken();
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getIMUsersBatch(Long limit, String cursor) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
		HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
		QueryWrapper query = QueryWrapper.newInstance().addLimit(limit).addCursor(cursor);
		
		return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, query);
	}

	public Object deleteIMUserByUserName(String userName) {
		String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

		return getInvoker().sendRequest(HTTPMethod.METHOD_DELETE, url, header, null, null);
	}

	public Object deleteIMUserBatch(Long limit) {
		String url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
        QueryWrapper query = QueryWrapper.newInstance().addLimit(limit);

        return getInvoker().sendRequest(HTTPMethod.METHOD_DELETE, url, header, null, query);
	}

	public Object modifyIMUserPasswordWithAdminToken(String userName, Object payload) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/password";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_PUT, url, header, body, null);
	}

	public Object modifyIMUserNickNameWithAdminToken(String userName, Object payload) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_PUT, url, header, body, null);
	}

	public Object addFriendSingle(String userName, String friendName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/contacts/users/" + friendName;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, null, null);
	}

	public Object deleteFriendSingle(String userName, String friendName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/contacts/users/" + friendName;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_DELETE, url, header, null, null);
	}

	public Object getFriends(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/contacts/users";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getBlackList(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/blocks/users";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object addToBlackList(String userName, Object payload) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/blocks/users";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
	}

	public Object removeFromBlackList(String userName, String blackListName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/blocks/users/" + blackListName;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_DELETE, url, header, null, null);
	}

	public Object getIMUserStatus(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/status";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getOfflineMsgCount(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/offline_msg_count";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getSpecifiedOfflineMsgStatus(String userName, String msgId) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/offline_msg_status/" + msgId;
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object deactivateIMUser(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/deactivate";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, null, null);
	}

	public Object activateIMUser(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/activate";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, null, null);
	}

	public Object disconnectIMUser(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/disconnect";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getIMUserAllChatGroups(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/joined_chatgroups";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	public Object getIMUserAllChatRooms(String userName) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + userName + "/joined_chatrooms";
        HeaderWrapper header = new HeaderHelper(getContext()).getDefaultHeaderWithToken();

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, null);
	}

	@Override
	public String getResourceRootURI() {
		return ROOT_URI;
	}
}
