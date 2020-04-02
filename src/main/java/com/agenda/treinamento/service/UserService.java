package com.agenda.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agenda.treinamento.model.User;
import com.agenda.treinamento.repository.UserRepository;

@Service
public class UserService implements UserIService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwardEncoder;

	
	@Override
	public User findbyid(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		user.setPassword(passwardEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findbyEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	
}
