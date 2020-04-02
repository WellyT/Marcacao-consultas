package com.agenda.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.treinamento.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
