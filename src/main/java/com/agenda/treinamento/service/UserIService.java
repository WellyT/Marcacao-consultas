package com.agenda.treinamento.service;

import java.util.List;

import com.agenda.treinamento.model.User;

public interface UserIService {

	User findbyid(long id);
	User save(User user);
	List<User> findAll();
}
