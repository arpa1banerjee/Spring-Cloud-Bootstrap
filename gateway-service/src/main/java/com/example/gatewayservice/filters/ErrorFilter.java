package com.example.gatewayservice.filters;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ErrorFilter extends ZuulFilter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        log.error("this is a ErrorFilter :{}",throwable.getCause().getMessage());
        
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.message",throwable.getCause().getMessage());
        
        return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
