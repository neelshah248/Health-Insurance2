package com.insurance.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enrollee")
public class Enrollee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private boolean activationStatus;
	private String birthDate;
	private long phone;
	
	@OneToMany(targetEntity=Dependent.class,cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "enrollee_id", referencedColumnName = "id")
	private List<Dependent> dependents;
	
	
	public Enrollee() {
	}
	
	public Enrollee(long id, String name, boolean activationStatus, String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.activationStatus = activationStatus;
		this.birthDate = birthDate;
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
	public boolean isActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}
	
	public String getBirthDate() {
		return birthDate;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	@Override
	public String toString() {
		return "Enrollee [id=" + id + ", name=" + name + ", activationStatus=" + activationStatus + ", birthDate="
				+ birthDate + ", phone=" + phone + ", dependents=" + dependents + "]";
	}
	
	
}
