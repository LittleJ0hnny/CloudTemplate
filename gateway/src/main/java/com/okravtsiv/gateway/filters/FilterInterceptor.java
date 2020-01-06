package com.okravtsiv.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilterInterceptor extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(FilterInterceptor.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() { return null; }
}
