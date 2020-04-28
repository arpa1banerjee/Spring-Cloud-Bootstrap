package com.example.gatewayservice.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		if(log.isInfoEnabled()) {
	    	log.info("In route filter");
	    }
		return null;
	}

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
