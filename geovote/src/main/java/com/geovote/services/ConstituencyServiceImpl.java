package com.geovote.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.data.ConstituencyDao;
import com.geovote.domain.Constituency;


@Service
@Transactional
public class ConstituencyServiceImpl implements ConstituencyService {

	
	@Autowired
	ConstituencyDao dao;
	
	@Override
	public void createNewDConstituency(Constituency constituency) {
		dao.create(constituency);		
	}

	@Override
	public void deleteExistingConstituency(Constituency constituency) {
		dao.delete(constituency);		
	}

}
