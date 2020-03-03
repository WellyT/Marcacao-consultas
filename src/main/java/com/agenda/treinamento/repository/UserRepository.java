package com.agenda.treinamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.agenda.treinamento.model.User;


public interface UserRepository extends CrudRepository<User, Long>{
	

}
