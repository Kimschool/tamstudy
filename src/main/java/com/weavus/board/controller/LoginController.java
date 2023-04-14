package com.weavus.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String init() {
		
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String id, String password) {
		
		if(id.equals("123") && password.equals("123")) {
			return "main";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("modify")
	public String modify() {
		
		return "modify";
	}
	
	@RequestMapping("register")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("update")
	public String update() {
		
		return "main";
		
	}
	
	@RequestMapping("logout")
	public String logout() {
		
		return "login";
		
	}
}
