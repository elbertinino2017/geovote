package com.geovote.data;

import com.geovote.domain.PollingStation;

public interface PollingStationDao {
	
	public void create(PollingStation pollingStation);
	public void delete(PollingStation pollingStation);

}
