package com.carl.carlapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carl.carlapp.bean.User;

@Controller
public class JsonController {
	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);
	//向页面直接输出Json字符串
    @ResponseBody
    @RequestMapping(value="/showUser", method = RequestMethod.GET)
    public List showUserJson(){
    	logger.info("test json....");
        List<User> list  = new ArrayList<User>();
        list.add(new User("carl", 20));
        list.add(new User("a", 23));
        list.add(new User("b", 22));
        return list;
    }

    @ResponseBody
    @RequestMapping(value="/content", method=RequestMethod.GET)
    public User getContent() {
        return new User("carl", 20);
    }
    
}
