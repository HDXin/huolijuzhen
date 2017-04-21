package com.sudaotech.core.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudaotech.core.Constants;
import com.sudaotech.core.crypt.AuthToken;
import com.sudaotech.util.CookieUtils;

public class AuthTokenFilter extends AbstractAuthTokenFilter {

    @Override
    protected boolean checkAuth(ServletResponse resp, FilterChain chain, HttpServletRequest httpRequest) throws IOException, ServletException {
        // Get token string from cookie
        String tokenString = getTokenString(httpRequest);

        if (tokenString == null) {
            logger.warn("Not found authToken in cookie");
            return false;
        }

        // parse AuthToken
        AuthToken authToken = null;
        try {
            authToken = AuthToken.parse(tokenString);
        } catch (Exception e) {
            logger.error("Failed decrypt token: {}, exception: {}", tokenString, e.getMessage());
            clearAuthTokenCookie(resp);
            return false;
        }

        if (AuthToken.isActive(authToken)) {
            setLog4jXUID(String.valueOf(authToken.userId + "-" + authToken.rand));

            // place user info
            httpRequest.setAttribute(Constants.SESSION_USER_ID, authToken.userId);
            httpRequest.setAttribute(Constants.SESSION_AUTH_TOKEN, authToken);
            return true;
        }

        logger.warn("authToken cookie expired: {}={}", Constants.AUTH_TOKEN_NAME, tokenString);
        clearAuthTokenCookie(resp);
        return false;
    }

    private void clearAuthTokenCookie(ServletResponse resp) {
        // clear cookie
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        Cookie cookie = new Cookie(Constants.AUTH_TOKEN_NAME, null);
        cookie.setDomain(CookieUtils.getCookieDomain());
        cookie.setPath("/");
        cookie.setMaxAge(0);
        httpResponse.addCookie(cookie);
    }

}
