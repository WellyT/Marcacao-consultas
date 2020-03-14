package com.agenda.treinamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.MedicalConsultation;
import com.agenda.treinamento.repository.ConsultationRepository;

@Service
public class ConsultationService implements ConsultationIService{

	@Autowired
	ConsultationRepository consultationRepository;
	
	@Override
	public MedicalConsultation findbyid(long id) {
		// TODO Auto-generated method stub
		return consultationRepository.findById(id).get();
	}

	@Override
	public MedicalConsultation save(MedicalConsultation mc) {
		// TODO Auto-generated method stub
		return consultationRepository.save(mc);
	}

}
