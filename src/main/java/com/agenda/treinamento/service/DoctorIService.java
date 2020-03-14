package com.agenda.treinamento.service;

import com.agenda.treinamento.model.Doctor;

public interface DoctorIService {

	Doctor findbyid(long id);
	Doctor save(Doctor doctor);
}
