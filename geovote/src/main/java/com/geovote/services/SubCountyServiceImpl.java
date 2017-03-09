package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.context.administrative.domain.SubCounty;
import com.geovote.data.SubCountyDao;

@Service
@Transactional
public class SubCountyServiceImpl implements SubCountyService {

	@Autowired
	SubCountyDao dao;

	@Override
	public void createNewSubCountyn(SubCounty newSubCounty) {
		dao.create(newSubCounty);

	}

	@Override
	public void deleteExistingSubCounty(SubCounty subCountyToDelete) {
		dao.delete(subCountyToDelete);
	}

	@Override
	public List<SubCounty> retrieveAllSubCounties() {
		return dao.allSubCountyes();
	}


	@Override
	public SubCounty findSubCountyByCode(String code) {
		
		return dao.getSubCountyByCode(code);
	}

	

}
