package com.shop.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import com.shop.entities.User;

public class CookieUtil
{
    public static final String COOKIE_SEPARATOR = "###";
    private static final String COOKIE_NAME = "JAY_BHAIRAV";

    public static String readFromCookie(HttpServletRequest request)
    {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    return new String(Base64.decodeBase64(cookie.getValue().getBytes()));
                }
            }
        }
        return null;

    }

    public static void writeToCookie(HttpServletResponse response, User user)
    {
        String cookieValue = user.getEmail() + COOKIE_SEPARATOR + user.getName();
        String encodedCookie = new String(Base64.encodeBase64(cookieValue.getBytes()));
        response.addCookie(new Cookie(COOKIE_NAME, encodedCookie));
    }

    public static void clearCookies(HttpServletResponse response)
    {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
