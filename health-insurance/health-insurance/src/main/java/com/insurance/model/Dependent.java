package com.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dependent")
public class Dependent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String birthDate;
	@Column(name = "enrollee_id")
	private long enrolleeId;
	
	public Dependent() {
		super();
	}
	
	public Dependent(long id, String name, String birthDate, long enrolleeId) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.enrolleeId = enrolleeId;
	}
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
	
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	@Override
	public String toString() {
		return "Dependent [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", enrolleeId=" + enrolleeId
				+ "]";
	}
	
	

}
