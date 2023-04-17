package com.weavus.board.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weavus.board.dao.MemberRepo;
import com.weavus.board.entity.Member;

@Controller
public class LoginController {
	
	@Autowired
	MemberRepo repo;

	@RequestMapping("/")
	public String init() {
		
		return "login";
	}
	
	@RequestMapping("login")
	public String login(Model model, int id, String password) {
		
		// select * from member where id = :id and password = :password;
//		Option<Member> result = repo.findById(id);
		
		// DB -> Contoller
		Member result = repo.findByIdAndPassword(id, password);
		Iterable<Member> resultList = repo.findAll();
		
		model.addAttribute("member", result);
		model.addAttribute("memberList", resultList);
		
		return "main";
		
		
//		if(id.equals("123") && password.equals("123")) {
//			return "main";
//		} else {
//			return "login";
//		}
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
