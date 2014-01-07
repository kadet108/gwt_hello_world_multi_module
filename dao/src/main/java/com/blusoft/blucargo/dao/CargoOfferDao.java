package com.blusoft.blucargo.dao;

import com.blusoft.blucargo.model.CargoOffer;

public interface CargoOfferDao extends BaseDao<CargoOffer> {

	public abstract CargoOffer findOfferById(Long id);

}