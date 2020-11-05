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
	private String bDate;
	@Column(name = "enrollee_id")
	private long enrolleeId;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "enrollee_id", nullable = false)
//	private Enrollee enrollee;
	
	
	public Dependent() {
		super();
	}
	
	public Dependent(long id, String name, String bDate) {
		super();
		this.id = id;
		this.name = name;
		this.bDate = bDate;
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
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
		
	}
//	public Enrollee getEnrollee() {
//		return enrollee;
//	}
//	public void setEnrollee(Enrollee enrollee) {
//		this.enrollee = enrollee;
//	}

	public long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}
	

}
