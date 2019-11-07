package com.aruistar.javastarter.core.interceptor

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LoginInterceptor implements HandlerInterceptor {

    @Value('${app.auth.login}')
    String login

    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        def user = request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(login)
            return false
        } else {
            return true
        }
    }
}
