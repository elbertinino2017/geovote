package com.geovote.services;

import java.util.List;

import com.geovote.domain.Constituency;

public interface ConstituencyService {
	
	
	public void createNewDConstituency(Constituency constituency);
	public void deleteExistingConstituency(Constituency constituency);
	public List<Constituency> retrieveAllConstituencies();
	public Constituency findConstituencyByCode(String code);

}
