package com.weavus.board.controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		// IDとパスワードが一致しない場合
		if(result == null) {
			model.addAttribute("msg", "IDとパスワードを確認してください。");
			return "login";
		// IDとパスワードが一致する場合
		} else {
			return "main";
		}
		
		
//		if(id.equals("123") && password.equals("123")) {
//			return "main";
//		} else {
//			return "login";
//		}
	}
	
	@RequestMapping("modify/{id}")
	public String modify(Model model, @PathVariable("id") int id) {
		
		
		Optional<Member> member =  repo.findById(id);
		
		model.addAttribute("member", member.get());
		
		return "modify";
	}
	
	@RequestMapping("register")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("registerproc")
	public String registerproc(Member member) {
		
		repo.save(member);
		
		return "login";
	}
	
	@RequestMapping("update")
	public String update(Member member) {
		System.out.println(member);
		
		return "main";
		
	}
	
	@RequestMapping("logout")
	public String logout() {
		
		return "login";
		
	}
}
