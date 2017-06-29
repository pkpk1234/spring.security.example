package com.example.spring.security.example.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pkpk1234 on 2017/6/29.
 */
public class HomeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(authentication.isAuthenticated() && !response.isCommitted()) {
            response.sendRedirect("/");
        } else if(response.isCommitted()){
            throw new RuntimeException("response is closed");
        } else {
            response.sendRedirect("/login");
        }
    }
}
