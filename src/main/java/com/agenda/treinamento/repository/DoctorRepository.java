package com.agenda.treinamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.agenda.treinamento.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	Doctor findByEmail(String email);
}
