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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resgistrationId == null) ? 0 : resgistrationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (resgistrationId == null) {
			if (other.resgistrationId != null)
				return false;
		} else if (!resgistrationId.equals(other.resgistrationId))
			return false;
		return true;
	}
	
	
	
	

}
