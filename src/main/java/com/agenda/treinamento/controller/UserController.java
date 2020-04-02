package com.agenda.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.treinamento.model.User;
import com.agenda.treinamento.service.UserService;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "home/login";
	}
	
	
	@GetMapping("/signup")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/register");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registration(@Valid User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		User usr = userService.findbyEmail(user.getEmail());
		if (usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if (result.hasErrors()) {
			mv.setViewName("user/register");
			mv.addObject("user", user);
		} else {
			userService.save(user);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
}
