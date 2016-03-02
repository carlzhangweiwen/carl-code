package com.carl.carlapp.controller.idb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsController {
	@RequestMapping(value="goods", method = RequestMethod.GET)
	public String goods(){
		
		return "idb/goods";
	}
	
	@RequestMapping(value="lately", method = RequestMethod.GET)
	public String latestOpen(){
		
		return "idb/zxjx";
	}

}
