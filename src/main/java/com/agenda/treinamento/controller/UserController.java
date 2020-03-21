package com.agenda.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.treinamento.model.User;
import com.agenda.treinamento.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String userIndex() {
		return "user/index";
	}
	
	@GetMapping("/signup")
	public String registration() {
		return "user/register";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@Valid User user,BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:user/signup";
		}
		userService.save(user);
		return "redirect:user/signup";
	}
	
}
