package com.example.startdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("host","aaaaaaaaaaaaaa");
		return "index";
	}
}
