package com.geovote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voter 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String resgistrationId;
	private String Name;
	private String city;
	private String sex;
	
	
	public Voter(String resgistrationId, String name, String city, String sex) {
		super();
		this.resgistrationId = resgistrationId;
		Name = name;
		this.city = city;
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "Voter [id=" + id + ", resgistrationId=" + resgistrationId + ", Name=" + Name + ", city=" + city
				+ ", sex=" + sex + "]";
	}
	
	
	
	
	

}
