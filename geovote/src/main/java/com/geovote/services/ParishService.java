package com.geovote.services;

import java.util.List;

import com.geovote.domain.Parish;

public interface ParishService {
	
	public void createNewParish(Parish newParish);
	public void deleteExistingDistrict(Parish parishToDelete);
	public List<Parish> getAllParishes();


}
