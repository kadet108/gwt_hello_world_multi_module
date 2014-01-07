package com.blusoft.blucargo.dao.impl;

import org.springframework.stereotype.Repository;

import com.blusoft.blucargo.model.CarBody;

@Repository("carBody")
public class CarBodyDao extends BaseDaoImpl<CarBody> {

	protected CarBodyDao() {
		super(CarBody.class);
	}

}
