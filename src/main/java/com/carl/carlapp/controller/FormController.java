package com.carl.carlapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carl.carlapp.model.Subscriber;

@Controller
public class FormController {
	@ResponseBody
	 @RequestMapping(value="/form", method=RequestMethod.POST)
	    public Subscriber submitForm(@Valid Subscriber subscriber, BindingResult result, Model m) {
		List<FieldError> errors = result.getFieldErrors();
		for(FieldError e: errors){
			String field = e.getField();
			String message = e.getDefaultMessage();
			Object value = e.getRejectedValue();
			System.out.println(field+","+message+","+value);
		}
		 	System.out.println(".....name...");
	        return subscriber;
	    }
	 
	 @RequestMapping(value="/form", method=RequestMethod.GET)
	    public String getForm() {
	        return "formPage";
	    }
}
