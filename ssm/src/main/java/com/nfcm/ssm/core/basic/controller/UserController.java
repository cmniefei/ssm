package com.nfcm.ssm.core.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nfcm.common.page.Pagination;
import com.nfcm.ssm.core.basic.pojo.User;
import com.nfcm.ssm.core.basic.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/toList"})
	public String toIndex(Model model , @RequestParam(required=true,defaultValue="1") Integer pageNo,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		//分页，会自动给下面的sql进行分页，下面使用了mybatis的分页插件
		PageHelper.startPage(pageNo,pageSize);
		List<User> userList = userService.findAllUser();
		PageInfo<User> p=new PageInfo<User>(userList);
		
		model.addAttribute("userList", userList);
		
		
		//分页对象,下面的是我自己的分页工具，用于前端jsp显示分页栏
		Pagination pagination =  new Pagination(pageNo,pageSize,p.getTotal());
		
		pagination.setList(userList);
		pagination.pageView("toList", null);
		
		model.addAttribute("pagination", pagination);
		
		return "user";
	}
	
	@RequestMapping(value={"/add"})
	public String addUser(User user){
		
		userService.addUser(user);
		
		return "redirect:toList";
	}

}
