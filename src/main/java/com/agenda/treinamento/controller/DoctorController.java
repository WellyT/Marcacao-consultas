package com.agenda.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.treinamento.model.Doctor;
import com.agenda.treinamento.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	DoctorService docservice;
	
	
	@GetMapping(value = "/registerDoctor")
	public ModelAndView registerDoctor() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/registerDoctor");
		mv.addObject("doctor", new Doctor());
		return mv;
	}
	
	
	@PostMapping(value = "/registerDoctor")
	public ModelAndView registration(@Valid Doctor doc, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Doctor doctor = docservice.findbyEmail(doc.getEmail());
		if (doctor != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if (result.hasErrors()) {
			mv.setViewName("redirect:/registerDoctor");
			mv.addObject("doctor", doctor);
		} else {
			docservice.save(doctor);
			mv.setViewName("redirect:/doctorIndex");
		}
		return mv;
	}
	

}
