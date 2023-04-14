package com.weavus.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	@RequestMapping("/")
	public String init() {
		
		return "index";
	}
	
	@RequestMapping("login")
	public String login(Model model) {
		
		model.addAttribute("name", "kim");
		model.addAttribute("tel", "080-3584-2456");
		
		
		return "login";
		
	}
	
	@RequestMapping("logincheck")
	public String logincheck(Model model, String id, String password) {
		
		System.out.println(id);
		System.out.println(password);
		
		return "login";
		
	}
}
