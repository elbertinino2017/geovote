package com.geovote.data;

import java.util.List;

import com.geovote.context.administrative.domain.SubCounty;

public interface SubCountyDao {
	
	public void create(SubCounty subCounty);
	public void delete(SubCounty subCounty);
	public List<SubCounty> allSubCountyes();
	public SubCounty getSubCountyByCode(String code);

}
