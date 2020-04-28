package com.example.gatewayservice.filters;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = context.getResponse();
	    if(log.isInfoEnabled()) {
	    	log.info("In post filter");
	    	// log.info("Request Method : {}  Request URL : {}", request.getMethod(), request.getRequestURL());
	    }
	    servletResponse.addHeader("X-Foo", UUID.randomUUID().toString());
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 4;
	}

}
