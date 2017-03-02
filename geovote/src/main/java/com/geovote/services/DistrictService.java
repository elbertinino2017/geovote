package com.geovote.services;

import com.geovote.domain.District;

public interface DistrictService {
	
	public void createNewDistrict(District newDistrict);
	public void deleteExistingDistrict(District districtToDelete);

}
