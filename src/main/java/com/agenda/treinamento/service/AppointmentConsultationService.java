package com.agenda.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.AppointmentConsultation;
import com.agenda.treinamento.repository.AppointmentConsultationsRepository;

@Service
public class AppointmentConsultationService implements AppointmentConsultationIservice{

	@Autowired
	AppointmentConsultationsRepository appointmentConsultation;
	
	@Override
	public AppointmentConsultation findbyid(long id) {
		// TODO Auto-generated method stub
		return appointmentConsultation.findById(id).get();
	}

	@Override
	public AppointmentConsultation save(AppointmentConsultation consultation) {
		// TODO Auto-generated method stub
		return appointmentConsultation.save(consultation);
	}

	@Override
	public List<AppointmentConsultation> findAll() {
		// TODO Auto-generated method stub
		return appointmentConsultation.findAll();
	}

}
