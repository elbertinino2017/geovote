package com.geovote.data;

import java.util.List;

import com.geovote.context.administrative.domain.Parish;
import com.geovote.context.administrative.domain.Voter;

public interface ParishDao {
	
	public void create(Parish parish);
	public void delete(Parish parish);
	public List<Voter> getParishesVotersByParhishCode(String code);
	public Parish getParishByCode(String code);
	public List<Parish> getAllParishes();

}
