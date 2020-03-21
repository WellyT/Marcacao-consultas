package com.agenda.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.treinamento.model.Doctor;
import com.agenda.treinamento.service.DoctorIService;

@Controller
public class DoctorController {

	@Autowired
	DoctorIService docservice;
	
	
	@GetMapping(value = "/registerDoctor")
	public String registerDoctor() {
		return "doctor/registerDoctor";
	}
	
	@PostMapping(value = "/registerDoctor")
	public String signup(@Valid Doctor doctor, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/registerDoctor";
		}
		docservice.save(doctor);
		return "redirect:/registerDoctor";
	}

}
