package com.blucargo.dao;

import java.util.List;

import com.blucargo.model.CargoOffer;
import com.blucargo.model.FavouriteOffer;

public interface FavouriteOfferDao extends BaseDao<FavouriteOffer, Long> {

	public void removeFavouriteOfferByCargoOfferAndOwner(CargoOffer co, String owner);

	public List<CargoOffer> getFavouriteCargoOffersByOwner(String owner);

}
