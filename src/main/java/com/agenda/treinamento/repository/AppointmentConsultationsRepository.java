package com.agenda.treinamento.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.treinamento.model.AppointmentConsultation;


public interface AppointmentConsultationsRepository extends JpaRepository<AppointmentConsultation, Long>{

	@Query("SELECT t FROM AppointmentConsultation t WHERE t.user.email = :emailUsuario")
	List<AppointmentConsultation> loadByUser(@Param ("emailUsuario") String email);
	
}
