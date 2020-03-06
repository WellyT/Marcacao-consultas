package com.agenda.treinamento.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private Date date;
	private String description;
	private int value;
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
