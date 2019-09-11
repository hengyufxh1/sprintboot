package com.dove.spring.boot.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dove.spring.boot.hello.service.StudentService;

@RestController
public class HelloController {
	
	
	@Autowired
	private StudentService service;

	@GetMapping
	public String hello(String str){
		
		return service.findById(str);
	}
}
