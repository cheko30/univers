package com.spo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UNIVERSITY")
public class University
{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@NotNull(message = "Can not be null")
	@Column(name = "university_name")
	private String universityName;
	
	@NotNull(message = "Can not be null")
	@Column(name = "university_country")
	private String universityCountry;
	
	@NotNull(message = "Can not be null")
	@Column(name = "uninversity_city")
	private String universityCity; 
	
	public University() 
	{
	
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityCountry() {
		return universityCountry;
	}

	public void setUniversityCountry(String universityCountry) {
		this.universityCountry = universityCountry;
	}
	
	public String getUniversityCity() {
		return universityCity;
	}

	public void setUniversityCity(String universityCity) {
		this.universityCity = universityCity;
	}

	@Override
	public String toString() 
	{
		return this.universityName;
	}
	
	

}
