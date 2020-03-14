package com.agenda.treinamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.Doctor;
import com.agenda.treinamento.repository.DoctorRepository;

@Service
public class DoctorService implements DoctorIService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public Doctor findbyid(long id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

	@Override
	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

}
