package com.blusoft.blucargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.dao.AcceptedOfferDao;
import com.blusoft.blucargo.model.AcceptedOffer;
import com.blusoft.blucargo.model.CargoOffer;

@Transactional
public class AcceptedOfferService {

	private final AcceptedOfferDao acceptedOfferDao;

	@Autowired
	public AcceptedOfferService(AcceptedOfferDao acceptedOfferDaoParam) {
		acceptedOfferDao = acceptedOfferDaoParam;
	}

	public synchronized void saveAcceptedOffers(List<AcceptedOffer> acceptedOffers) {
		for (AcceptedOffer c : acceptedOffers) {
			save(c);
		}
	}

	public synchronized void save(AcceptedOffer ao) {
		acceptedOfferDao.saveOrUpdate(ao);
	}

	public synchronized void removeAcceptedOffer(AcceptedOffer ao) {
		acceptedOfferDao.delete(ao);
	}

	public synchronized void removeAcceptedOffers(List<AcceptedOffer> list) {
		for (AcceptedOffer offer : list) {
			acceptedOfferDao.delete(offer);
		}
	}

	public synchronized void removeAcceptedOfferByCargoOfferAndOwner(CargoOffer co, String owner) {
		acceptedOfferDao.removeAcceptedOfferByCargoOfferAndOwner(co, owner);
	}

	public synchronized void removeAcceptedOffersByCargoOfferAndOwner(List<CargoOffer> offers, String owner) {
		for (CargoOffer co : offers) {
			this.removeAcceptedOfferByCargoOfferAndOwner(co, owner);
		}
	}

	public synchronized List<AcceptedOffer> findAll() {
		return acceptedOfferDao.findAll();
	}

	public synchronized AcceptedOffer findById(long id) {
		return acceptedOfferDao.findById(id);
	}

	public synchronized List<CargoOffer> getAcceptedCargoOffersByOwner(String owner) {
		return acceptedOfferDao.getAcceptedCargoOffersByOwner(owner);
	}

	public synchronized AcceptedOffer getAcceptedOfferByCargoOfferIdAndUserName(Long cargoOfferId, String userName) {
		return acceptedOfferDao.getAcceptedOfferByCargoOfferIdAndUserName(cargoOfferId, userName);
	}

}
