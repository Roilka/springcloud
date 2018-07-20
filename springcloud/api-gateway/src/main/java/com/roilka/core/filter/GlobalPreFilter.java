package com.roilka.core.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class GlobalPreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(GlobalPreFilter.class);
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		Object accessToken = request.getParameter("accessToken");
		
		if (accessToken == null) {
			
			try {
				HttpServletResponse response = ctx.getResponse();
				response.setHeader("Content-Type", "text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("对不起，你没有权限哟！ ");
				log.warn("access token is empty");
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(403);
				ctx.setResponse(response);
			} catch (IOException e) {
                e.printStackTrace();   
			}
			
		}
		return null;
	}

	/**
	 * 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 通过int值来定义过滤器的执行顺序，数值越小优先级越高。
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return FilterConstants.SEND_ERROR_FILTER_ORDER;
	}

	/**
	 * 该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在HTTP请求过程中定义的各个阶段。在Zuul中默认定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用。
     * routing：在路由请求时候被调用。
     * post：在routing和error过滤器之后被调用。
     * error：处理请求时发生错误时被调用。
	 */
	@Override
	public String filterType() {
//		pre：可以在请求被路由之前调用。
//		routing：在路由请求时候被调用。
//		post：在routing和error过滤器之后被调用。
//		error：处理请求时发生错误时被调用。
		return FilterConstants.PRE_TYPE;
	}

}
