package com.agenda.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.treinamento.model.AppointmentConsultation;

public interface AppointmentConsultationsRepository extends JpaRepository<AppointmentConsultation, Long>{

}
