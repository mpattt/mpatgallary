package com.mpattt.app.user;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {


	@RequestMapping("/")
	public ModelAndView home(ModelAndView modelAndView, Principal principal) {
		modelAndView.setViewName("/home");
		return modelAndView;
	}
}