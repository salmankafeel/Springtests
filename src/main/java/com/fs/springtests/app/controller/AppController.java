package com.fs.springtests.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {

	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String hello(ModelMap model) {

        model.put("name", "Salman");
        return "welcome";
	}
	
}
