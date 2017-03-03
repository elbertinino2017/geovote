package com.geovote.data;

import java.util.List;

import com.geovote.domain.Parish;

public interface ParishDao {
	
	public void create(Parish parish);
	public void delete(Parish parish);
	public List<Parish> getAllParishes();

}
