package com.geovote.services;

import java.util.List;

import com.geovote.context.administrative.domain.Parish;
import com.geovote.context.administrative.domain.Voter;

public interface ParishService {
	
	public void createNewParish(Parish newParish);
	public void deleteExistingDistrict(Parish parishToDelete);
	public Parish getParishByCode(String code);
	public List<Voter> findParichesVotersByParishCode(String code);
	List<Parish> getAllParishes();


}
