package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StringController {

	@GetMapping("/teste")
	public String teste() {
		return "olá testee";
	}
	
	
}
