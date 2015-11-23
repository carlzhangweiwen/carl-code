package com.carl.carlapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping(value="/h", method=RequestMethod.GET)
	public String printWelcome(ModelMap model){
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}
	@RequestMapping(value="/hello/{name:.+}",method=RequestMethod.GET)
	public ModelAndView hello(@PathVariable String name){
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		logger.info("hello() is executed - "+name);
		System.out.println("name:"+name);
		model.addObject("msg", name);
		return model;
	}

}
