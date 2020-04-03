package com.agenda.treinamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name", length = 50)
	@NotNull(message = "An Name is required")
	private String name;
	
	@Column(length = 11)
	@NotNull(message = "An CPF is required")
	private String cpf;
	private int age;
	
	@Column(nullable = false, length = 20)
	@NotNull(message = "An E-mail is required.")
	private String email;
	
	@Column(nullable = false, length = 100)
	@NotNull(message = "An Password is required.")
	private String password;
	private String profission;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<AppointmentConsultation> appointment;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfission() {
		return profission;
	}

	public void setProfission(String formation) {
		this.profission = formation;
	}

	public List<AppointmentConsultation> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<AppointmentConsultation> appointment) {
		this.appointment = appointment;
	}




}
