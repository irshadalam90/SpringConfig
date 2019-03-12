package com.springmvc.config.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	public String getUsers(){
		return "users";
	}
		
}
