package com.agenda.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name", length = 50)
	@NotNull(message = "An Name is required")
	private String name;
	private String cpf;
	private int age;
	
	@Column(nullable = false, length = 20)
	@NotNull(message = "An E-mail is required.")
	private String email;
	
	@Column(nullable = false, length = 100)
	@NotNull(message = "An Password is required.")
	private String password;
		
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<AppointmentConsultation> contultation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
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
	public void setAge(int idade) {
		this.age = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<AppointmentConsultation> getContultation() {
		return contultation;
	}
	public void setContultation(List<AppointmentConsultation> contultation) {
		this.contultation = contultation;
	}
	
	
}
