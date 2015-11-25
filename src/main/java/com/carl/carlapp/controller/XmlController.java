package com.carl.carlapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carl.carlapp.model.Coffee;

@Controller
@RequestMapping(value="/coffee")
public class XmlController {
	@RequestMapping(value="{name}", method=RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXml(@PathVariable String name){
		Coffee coffee = new Coffee(name, 100);
		return coffee;
	}
}
