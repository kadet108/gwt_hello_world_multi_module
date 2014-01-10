package com.blusoft.blucargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.dao.FavouriteOfferDao;
import com.blusoft.blucargo.model.CargoOffer;
import com.blusoft.blucargo.model.FavouriteOffer;

@Service
@Transactional
public class FavouriteOfferService {

	private final FavouriteOfferDao favouriteOfferDao;

	@Autowired
	public FavouriteOfferService(FavouriteOfferDao favouriteOfferDao) {
		this.favouriteOfferDao = favouriteOfferDao;
	}

	public synchronized void saveFavouriteOffers(List<FavouriteOffer> favouriteOffers) {
		for (FavouriteOffer c : favouriteOffers) {
			saveFavouriteOffer(c);
		}
	}

	private synchronized void saveFavouriteOffer(FavouriteOffer ao) {
		favouriteOfferDao.saveOrUpdate(ao);
	}

	public synchronized List<FavouriteOffer> findAll() {
		return favouriteOfferDao.findAll();
	}

	public synchronized FavouriteOffer findById(long id) {
		return favouriteOfferDao.findById(id);
	}

	public synchronized void removeFavouriteOfferByCargoOfferAndOwner(CargoOffer co, String owner) {
		favouriteOfferDao.removeFavouriteOfferByCargoOfferAndOwner(co, owner);
	}

	public synchronized void removeFavouriteOffersByCargoOfferAndOwner(List<CargoOffer> offers, String owner) {
		for (CargoOffer co : offers) {
			this.removeFavouriteOfferByCargoOfferAndOwner(co, owner);
		}
	}

	public synchronized List<CargoOffer> getFavouriteCargoOffersByOwner(String owner) {
		return favouriteOfferDao.getFavouriteCargoOffersByOwner(owner);
	}
}
