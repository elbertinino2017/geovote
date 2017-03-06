package com.geovote.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.geovote.helper.ConstituencyInfo;
import com.geovote.helper.DistrictInfo;
import com.geovote.helper.ParishInfo;
import com.geovote.helper.PollingStationInfo;
import com.geovote.helper.SubCountyInfo;

@Entity
@XmlRootElement
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String applicantId;
	@Column(unique = true, nullable = false)
	private String voterNumber;
	private String surname;
	private String othernames;
	private String dob;
	private String sex;
	private String village;
	private String picturePath;
	private String expiryDate;
	@Embedded
	private DistrictInfo districtInfo;
	@Embedded
	private ConstituencyInfo constituencyInfo;
	@Embedded
	private ParishInfo parishInfo;
	@Embedded
	private PollingStationInfo pollingStationInfo;
	@Embedded
	private SubCountyInfo subCountyInfo;

	public Voter() {
	}

	public Voter(String applicantId, String voterNumber, String surname, String othernames, String dob, String sex,
			String village, DistrictInfo districtInfo, ConstituencyInfo constituencyInfo, ParishInfo parishInfo,
			PollingStationInfo pollingStationInfo, SubCountyInfo subCountyInfo) {
		super();
		this.applicantId = applicantId;
		this.voterNumber = voterNumber;
		this.surname = surname;
		this.othernames = othernames;
		this.dob = dob;
		this.sex = sex;
		this.village = village;
		this.districtInfo = districtInfo;
		this.constituencyInfo = constituencyInfo;
		this.parishInfo = parishInfo;
		this.pollingStationInfo = pollingStationInfo;
		this.subCountyInfo = subCountyInfo;
		this.picturePath = "images/logo.png";
		this.expiryDate = "2015/2016";
	}

	// get and set
	public Long getId() {
		return id;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getVoterNumber() {
		return voterNumber;
	}

	public void setVoterNumber(String voterNumber) {
		this.voterNumber = voterNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOthernames() {
		return othernames;
	}

	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}


	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public DistrictInfo getDistrictInfo() {
		return districtInfo;
	}

	public void setDistrictInfo(DistrictInfo districtInfo) {
		this.districtInfo = districtInfo;
	}

	public ConstituencyInfo getConstituencyInfo() {
		return constituencyInfo;
	}

	public void setConstituencyInfo(ConstituencyInfo constituencyInfo) {
		this.constituencyInfo = constituencyInfo;
	}

	public ParishInfo getParishInfo() {
		return parishInfo;
	}

	public void setParishInfo(ParishInfo parishInfo) {
		this.parishInfo = parishInfo;
	}

	public PollingStationInfo getPollingStationInfo() {
		return pollingStationInfo;
	}

	public void setPollingStationInfo(PollingStationInfo pollingStationInfo) {
		this.pollingStationInfo = pollingStationInfo;
	}

	public SubCountyInfo getSubCountyInfo() {
		return subCountyInfo;
	}

	public void setSubCountyInfo(SubCountyInfo subCountyInfo) {
		this.subCountyInfo = subCountyInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((voterNumber == null) ? 0 : voterNumber.hashCode());
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
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (voterNumber == null) {
			if (other.voterNumber != null)
				return false;
		} else if (!voterNumber.equals(other.voterNumber))
			return false;
		return true;
	}

	

}
