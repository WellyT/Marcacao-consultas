package com.agenda.treinamento.service;

import java.util.List;

import com.agenda.treinamento.model.AppointmentConsultation;

public interface AppointmentConsultationIservice {

	AppointmentConsultation findbyid(long id);
	AppointmentConsultation save(AppointmentConsultation consultation);
	List<AppointmentConsultation> findAll();
}
