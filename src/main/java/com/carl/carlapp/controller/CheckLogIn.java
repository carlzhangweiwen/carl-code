package com.carl.carlapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carl.carlapp.model.UserInfo;

@Controller
public class CheckLogIn {
	
	@ResponseBody
	@RequestMapping(value = "/tologin", method = RequestMethod.POST)
	public String login(UserInfo user ){
		if("carl".equals(user.getUsername()) && "123".equals(user.getPassword())){
			
			return "{\"errorCode\":\"0\",\"errorMsg\":\"ok\", \"token\":\"ss\"}";
		}
		
		return "{\"errorCode\":\"1001\",\"errorMsg\":\"password is wrong!\"}";
	}
}
