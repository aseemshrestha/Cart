package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.shop.entities.User;
import com.shop.util.Constants;
import com.shop.util.CookieUtil;

public class AdminInterceptor extends HandlerInterceptorAdapter
{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(Constants.SESSION_KEY_ADMIN);
        String cookie = CookieUtil.readFromCookie(request);

        if (user == null && StringUtils.isBlank(cookie)) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
        Object handler, Exception ex) throws Exception
    {

    }

}
