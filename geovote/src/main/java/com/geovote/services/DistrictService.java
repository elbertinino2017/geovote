package com.geovote.services;

import java.util.List;

import com.geovote.domain.District;

public interface DistrictService {
	
	public void createNewDistrict(District newDistrict);
	public void deleteExistingDistrict(District districtToDelete);
	public List<District> retrieveAllDistricts();
	public District findDistrictByCode(String string);

}
