package com.nfcm.ssm.core.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nfcm.ssm.core.basic.pojo.User;
import com.nfcm.ssm.core.basic.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/toList"})
	public String toIndex(Model model){
		model.addAttribute("userList", userService.findAllUser());
		model.addAttribute("aaa", "bbb");
		return "user";
	}
	
	@RequestMapping(value={"/add"})
	public String addUser(User user){
		
		userService.addUser(user);
		
		return "redirect:toList";
	}

}
