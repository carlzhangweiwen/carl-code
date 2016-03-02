package com.carl.carlapp.controller.cx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carl.carlapp.model.User;
import com.carl.carlapp.util.TokenG;

@Controller
public class CUserController {
	private String errCode = "0";
	private String errMsg = "ok";
	
	@ResponseBody
	@RequestMapping(value="/clogin")
	public Map<String,String> login(User user){
		String username = user.getName();
		String pwd = user.getPassword();
		
		Map<String, String> map = new HashMap<String, String>();
		
		if("carl".equals(username) && "carl123".equals(pwd)){
			try {
				String token = TokenG.getToken("carl");
				map.put("token", token);
			} catch (Exception e) {
				errCode = "1001";
				errMsg = "error";
				e.printStackTrace();
			}
		}else{
			errCode = "1001";
			errMsg = "error";
		}
		map.put("errCode", errCode);
		map.put("errMsg", errMsg);
		return map;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	

}
