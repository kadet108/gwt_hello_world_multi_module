package com.blusoft.blucargo.dao;

import com.blusoft.blucargo.model.RegistrationData;

public interface RegistrationDataDao extends BaseDao<RegistrationData> {

	public abstract RegistrationData getUserByRegistrationNumber(String number);

}
