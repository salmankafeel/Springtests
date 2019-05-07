package com.fs.springtests.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	
	@RequestMapping(value="getAll", method = RequestMethod.GET )
	public String getAllEmployees() {
		
		
		
		return null;
	}
	
}
