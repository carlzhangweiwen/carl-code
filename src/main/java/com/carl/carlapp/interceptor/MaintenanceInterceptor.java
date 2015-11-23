package com.carl.carlapp.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MaintenanceInterceptor extends HandlerInterceptorAdapter{
	private int maintenanceStartTime;
	private int maintenanceEndTime;
	private String maintenanceMapping;

	public void setMaintenanceStartTime(int maintenanceStartTime) {
		this.maintenanceStartTime = maintenanceStartTime;
	}

	public void setMaintenanceEndTime(int maintenanceEndTime) {
		this.maintenanceEndTime = maintenanceEndTime;
	}

	public void setMaintenanceMapping(String maintenanceMapping) {
		this.maintenanceMapping = maintenanceMapping;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour:"+hour+",maintenanceEndTime:"+maintenanceEndTime+","+maintenanceStartTime);
		if(maintenanceEndTime>=hour && maintenanceStartTime<=hour){
			response.sendRedirect(maintenanceMapping);
			return true;
		}else{
			return false;
		}
	}
	

}
