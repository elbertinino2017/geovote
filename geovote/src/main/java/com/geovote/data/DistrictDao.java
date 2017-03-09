package com.geovote.data;

import java.util.List;

import com.geovote.context.administrative.domain.District;

public interface DistrictDao {
	
	public void create(District district);
	public void delete(District district);
	public List<District> allDistricts();
	public District getDistrictByCode(String code);
	

}
