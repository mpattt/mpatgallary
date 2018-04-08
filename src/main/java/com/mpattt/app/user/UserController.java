package com.mpattt.app.user;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mpattt.domain.component.PageWrapper;
import com.mpattt.domain.entity.User;
import com.mpattt.domain.service.UserService;

@Controller

public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@RequestMapping("/list")
	public String list(Model model, Pageable pageable) {
		Page<User> pageUserList = userService.getAllUsers(pageable);
		PageWrapper<User> page = new PageWrapper<User>(pageUserList, "/list");
		model.addAttribute("page", page);
		model.addAttribute("users", page.getContent());
		return "user/list";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/user/user")
	public String user() {
		return "user/gall";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/admin/user")
	public String admin() {
		return "user/upload";
	}
	
	
		

}
