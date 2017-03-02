package com.geovote.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.SubCountyDao;
import com.geovote.domain.SubCounty;

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

}
