package com.example.apigateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型标识
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            log.warn("accessToken is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        try {
            doSomething();
        } catch (Exception e) {
            //过滤器异常处理
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.excep巨on", e);
        }


        log.info("accessToken is ok!");
        return null;
    }

    private void doSomething() throws Exception{
        log.info("doing something...");
    }
}
