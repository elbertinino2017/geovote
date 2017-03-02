package com.geovote.data;

import com.geovote.domain.Constituency;

public interface ConstituencyDao {
	
	public void create(Constituency constituency);
	public void delete(Constituency constituency);

}
