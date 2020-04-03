package com.agenda.treinamento.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.treinamento.model.AppointmentConsultation;
import com.agenda.treinamento.model.Doctor;
import com.agenda.treinamento.model.User;
import com.agenda.treinamento.repository.AppointmentConsultationsRepository;
import com.agenda.treinamento.repository.DoctorRepository;
import com.agenda.treinamento.service.AppointmentConsultationIservice;
import com.agenda.treinamento.service.UserService;

@Controller
public class AppointmentConsultationController {

	@Autowired
	AppointmentConsultationIservice appointmentIService;
	
	@Autowired
	AppointmentConsultationsRepository appointmentRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/doctorIndex")
	public ModelAndView getAppointment() {
		ModelAndView mv = new ModelAndView("doctor/doctorIndex");
		mv.addObject("doctorIndex", appointmentRepository.findAll());
				return mv;
	}
	
	@PostMapping(value = "/mark")
	public ModelAndView Consultation(@Valid AppointmentConsultation consultation, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (consultation.getDate().before(new Date())) {
			result.rejectValue("date", "appointmentConsultation.dateInvalid", "Invalid date, date can't be less than today");
			
		}else if(result.hasErrors()) {
			mv.setViewName("redirect:/mark");
			mv.addObject(consultation);
			
		}else {
			String emailUsuario = request.getUserPrincipal().getName();
			User usuarioLogado = userService.findbyEmail(emailUsuario);
			consultation.setUser(usuarioLogado);
			mv.setViewName("redirect:/");
			appointmentIService.save(consultation);
		}
		return mv;
		
	}
	@GetMapping("/mark")
	public ModelAndView medicalAppointment() {
		ModelAndView mv = new ModelAndView("user/mark");
		AppointmentConsultation ac = new AppointmentConsultation();
		ac.setDoctor(new Doctor());
		mv.addObject("doctorIndex", ac);
		mv.addObject("doctors", doctorRepository.findAll());
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView userIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/index");
		String emailUsuario = request.getUserPrincipal().getName();
		mv.addObject("appointments", appointmentRepository.loadByUser(emailUsuario));
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		AppointmentConsultation ac = appointmentRepository.getOne(id);
		ModelAndView resultado = new ModelAndView("/appointment/edit");
		resultado.addObject("appointment", ac);
		resultado.addObject("doctors", doctorRepository.findAll());
		return resultado;
	}
	
	@PostMapping("/edit")
	public String edit(@Valid AppointmentConsultation appointmentConsultation, BindingResult result) {
		if (appointmentConsultation.getDate().before(new Date())) {
			result.rejectValue("date", "appointmentConsultation.dateInvalid", "Invalid date, date can't be less than today");
			
		}else {
			appointmentRepository.save(appointmentConsultation);
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		appointmentRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/conclude/{id}")
	public String conclude(@PathVariable Long id ) {
		AppointmentConsultation appointmentCon = appointmentRepository.getOne(id);
		appointmentCon.setDone(true);
		appointmentRepository.save(appointmentCon);
		return "redirect:/doctorIndex";
	}
	
}
