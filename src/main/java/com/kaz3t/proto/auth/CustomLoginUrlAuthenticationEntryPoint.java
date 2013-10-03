package com.kaz3t.proto.auth;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("loginUrlAuthenticationEntryPoint")
public class CustomLoginUrlAuthenticationEntryPoint extends
        LoginUrlAuthenticationEntryPoint {

    public CustomLoginUrlAuthenticationEntryPoint() {
        super("/login.html");
    }

    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        if (isAjaxRequest(request)) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(),
                    "Request needs authentication");
        } else {
            super.commence(request, response, authException);
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}
