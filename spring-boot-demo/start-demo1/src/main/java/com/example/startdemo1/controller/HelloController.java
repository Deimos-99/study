package com.example.startdemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world";
	}
}
