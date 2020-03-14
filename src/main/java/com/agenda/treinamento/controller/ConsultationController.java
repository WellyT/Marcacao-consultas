package com.agenda.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.treinamento.model.MedicalConsultation;
import com.agenda.treinamento.service.ConsultationIService;


@Controller
public class ConsultationController {

	@Autowired
	ConsultationIService consultationIService;
	
	@GetMapping("/mark")
	public String mark(){
		return "mark";
	}
	
	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	public String appointment(@Valid MedicalConsultation mc, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/mark";
		}
		consultationIService.save(mc);
		System.out.println("OK");
		return "redirect:/mark";
	}
}
