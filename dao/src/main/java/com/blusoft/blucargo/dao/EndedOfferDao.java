package com.blusoft.blucargo.dao;

import java.util.List;

import com.blusoft.blucargo.model.CargoOffer;
import com.blusoft.blucargo.model.EndedOffer;

public interface EndedOfferDao extends BaseDao<EndedOffer> {

	public abstract List<CargoOffer> getEndedCargoOffersByOwner(String owner);

	public abstract List<EndedOffer> findEndedOfferByOwner(String owner);

}
