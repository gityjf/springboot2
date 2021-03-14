package com.example.intercept;

import com.example.annotation.AutoIdempotent;
import com.example.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIntercept extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        AutoIdempotent annotation = ((HandlerMethod) handler).getMethod().getAnnotation(AutoIdempotent.class);
        if (annotation != null) {
            if (tokenService.checkToken(request)) {
                System.out.println("token multi...........................");
                return false;
            }
        }
        return true;
    }
}
