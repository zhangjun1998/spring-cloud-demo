package com.zjcoding.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 暂无描述
 *
 * @author ZhangJun
 * @date 9:38 2020/11/3
 */

@Component
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        // 防止中文乱码
        response.setContentType("text/html;charset=UTF-8");
        String token = request.getParameter("token");
        if (token == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("张三：token is empty");
            return null;
        }

        return null;
    }
}
