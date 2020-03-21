package com.agenda.treinamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.treinamento.model.AppointmentConsultation;
import com.agenda.treinamento.service.AppointmentConsultationIservice;

@Controller
public class AppointmentConsultationController {

	@Autowired
	AppointmentConsultationIservice appointmentIService;
	
	@GetMapping("/doctorIndex")
	public ModelAndView getAppointment() {
		ModelAndView mv = new ModelAndView("doctorIndex");
		mv.setViewName("doctor/doctorIndex");
		List<AppointmentConsultation> appointmentConsultations = appointmentIService.findAll();
		mv.addObject("doctorIndex", appointmentConsultations);
		return mv;
	}
	
	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	public String Consultation(@Valid AppointmentConsultation consultation, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		appointmentIService.save(consultation);
		return "redirect:user/mark";
		
	}
	@GetMapping("/mark")
	public String medicalAppointment() {
		return "user/mark";
	}
}
