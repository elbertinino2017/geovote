package com.geovote.services;

import com.geovote.domain.Parish;

public interface ParishService {
	
	public void createNewParish(Parish newParish);
	public void deleteExistingDistrict(Parish parishToDelete);


}
