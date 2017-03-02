package com.geovote.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.DistrictDao;
import com.geovote.domain.District;


@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	DistrictDao dao;

	@Override
	public void createNewDistrict(District newDistrict) {

		dao.create(newDistrict);		
	}

	@Override
	public void deleteExistingDistrict(District districtToDelete) {

		dao.delete(districtToDelete);
	}

}
