package com.agenda.treinamento.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agenda.treinamento.model.User;
import com.agenda.treinamento.repository.UserRepository;


@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/mark")
	public String mark(){
		return "mark";
	}
	
	@RequestMapping(value = "/cadUser",method = RequestMethod.GET)
	public String cadUser() {
		return "register";
	}

	@RequestMapping(value = "/cadUser",method = RequestMethod.POST)
	public String cadUser(User user) {
		userRepository.save(user);	
		return "redirect:/cadUser";
	}

	/*@GetMapping("/register")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		mv.addObject("user", new User());
		return mv;
	}*/
	
	
}
