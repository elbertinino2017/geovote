package com.geovote.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.context.administrative.domain.Constituency;
import com.geovote.data.ConstituencyDao;


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

	@Override
	public List<Constituency> retrieveAllConstituencies() {
		return dao.allConstituencies();
	}

	@Override
	public Constituency findConstituencyByCode(String code) {
		
		return dao.getConstituencyByCode(code);
	}

}
