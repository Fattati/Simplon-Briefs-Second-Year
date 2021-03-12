package com.reservationapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String demo(ModelMap model) {
		
		model.addAttribute("message", "wlc");
		
		return "welcome";
	}
	
	@RequestMapping(value = "/bruh", method = RequestMethod.GET)
	public String sayBruh(ModelMap model) {
		
		model.addAttribute("message", "bruhMoment");
		
		return "imagine";
	}

}
