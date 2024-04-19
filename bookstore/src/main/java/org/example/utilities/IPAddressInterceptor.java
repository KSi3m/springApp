package org.example.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IPAddressInterceptor implements HandlerInterceptor {

    private final String[] allowedIpAddresses = {
            "185.68.14.10",
            "185.68.14.11",
            "185.68.14.12",
            "185.68.14.26",
            "185.68.14.27",
            "185.68.14.28",
            "127.0.0.1",
            "localhost",
            "0:0:0:0:0:0:0:1"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIpAddress = request.getRemoteAddr();
        if (!isIpAddressAllowed(clientIpAddress)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied.");
            return false;
        }
        return true;
    }

    private boolean isIpAddressAllowed(String ipAddress) {
        System.out.println(ipAddress);
        for (String allowedIpAddress : allowedIpAddresses) {
            if (allowedIpAddress.equals(ipAddress)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Not used in this example
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Not used in this example
    }
}