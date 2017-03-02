package com.geovote.services;

import com.geovote.domain.SubCounty;

public interface SubCountyService {
	
	public void createNewSubCountyn(SubCounty newSubCounty);
	public void deleteExistingSubCounty(SubCounty subCountyToDelete);

}
