package com.mpattt.app.user;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mpattt.domain.service.UserService;


@Controller
public class RegisterController {
	@Autowired
	UserService userService;

	@RequestMapping("/user/signup")
	public ModelAndView signup(ModelAndView modelAndView) {
		modelAndView.setViewName("user/register");
		modelAndView.addObject("userAddForm", new UserRegisterForm());
		return modelAndView;
	}

	@RequestMapping("/user/add")
	public Object add(@ModelAttribute("userAddForm") @Valid UserRegisterForm userAddForm, BindingResult bindingResult,
			RedirectAttributes attributes, ModelAndView modelAndView) throws NoSuchAlgorithmException {
		if (bindingResult.hasErrors()) {
			return "user/register";
		}
		userService.createUser(userAddForm);
		attributes.addFlashAttribute("messageDialog", "User was created.");
		return "redirect:/";
	}
}
