package com.example.startdemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

//	@GetMapping("/hello")
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello world";
	}
}
