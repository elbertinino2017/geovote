package com.geovote.services;

import java.util.List;

import com.geovote.domain.SubCounty;

public interface SubCountyService {

	public void createNewSubCountyn(SubCounty newSubCounty);

	public void deleteExistingSubCounty(SubCounty subCountyToDelete);

	public List<SubCounty> retrieveAllSubCounties();

	public SubCounty findSubCountyByCode(String code);

}
