package com.agenda.treinamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.agenda.treinamento.model.MedicalConsultation;

public interface ConsultationRepository extends CrudRepository<MedicalConsultation, Long>{

}
