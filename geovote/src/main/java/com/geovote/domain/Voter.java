package com.geovote.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Voter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String resgistrationId;
	private String Name;
	private String city;
	private String sex;

	public Voter() {
	}

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

	// get and set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResgistrationId() {
		return resgistrationId;
	}

	public void setResgistrationId(String resgistrationId) {
		this.resgistrationId = resgistrationId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
