package com.xinyuan.config.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "gitFilter", urlPatterns = "/*")
public class GitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = new String(httpServletRequest.getRequestURI());

        if (!url.equalsIgnoreCase("/actuator/bus-refresh")) ;
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        CustomeRequestWrapper requestWrapper = new CustomeRequestWrapper(httpServletRequest);

        filterChain.doFilter(requestWrapper, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
