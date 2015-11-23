package com.carl.carlapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		long starttime = System.currentTimeMillis();
		request.setAttribute("starttime", starttime);
		System.out.println("starttime:"+starttime);
		return true;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView model) throws Exception {
		// TODO Auto-generated method stub
		long starttime = (Long)request.getAttribute("starttime");
		long endtime = System.currentTimeMillis();
		System.out.println("endtime:"+endtime);
		logger.info("logger.....");
		long exectime = endtime - starttime;
		model.addObject("executeTime", exectime);
	}

}
