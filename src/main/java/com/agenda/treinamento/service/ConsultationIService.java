package com.agenda.treinamento.service;

import com.agenda.treinamento.model.MedicalConsultation;

public interface ConsultationIService {

	MedicalConsultation findbyid(long id);
	MedicalConsultation save(MedicalConsultation mc);
}
