package com.agenda.treinamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.Doctor;
import com.agenda.treinamento.repository.DoctorRepository;

@Service
public class DoctorService implements DoctorIService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwardEncoder;
	
	@Override
	public Doctor findbyid(long id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).get();
	}

	@Override
	public Doctor save(Doctor doctor) {
		doctor.setPassword(passwardEncoder.encode(doctor.getPassword()));
		return doctorRepository.save(doctor);
	}

	public Doctor findbyEmail(String email) {
		// TODO Auto-generated method stub
		return doctorRepository.findByEmail(email);
	}
}
