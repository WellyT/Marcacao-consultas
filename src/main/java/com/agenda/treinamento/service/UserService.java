package com.agenda.treinamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.User;
import com.agenda.treinamento.repository.UserRepository;

@Service
public class UserService implements UserIService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findbyid(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
}
