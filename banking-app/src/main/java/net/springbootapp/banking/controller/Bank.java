package net.springbootapp.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank {
	
	@GetMapping("/simple_msg")
	public String display() {
		return "hello";
	}

}
