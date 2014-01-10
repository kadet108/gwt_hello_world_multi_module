package com.blusoft.blucargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.dao.AcceptedOfferDao;
import com.blusoft.blucargo.dao.CargoOfferDao;
import com.blusoft.blucargo.dao.OfferAcceptanceDao;
import com.blusoft.blucargo.model.AcceptedOffer;
import com.blusoft.blucargo.model.CargoOffer;
import com.blusoft.blucargo.model.OfferAcceptance;

@Service
@Transactional
public class OfferAcceptanceService {

	private final OfferAcceptanceDao offerAcceptanceDao;
	private final CargoOfferDao cargoOfferDao;
	private final AcceptedOfferDao acceptedOfferDao;

	@Autowired
	public OfferAcceptanceService(OfferAcceptanceDao offerAcceptanceDao, CargoOfferDao cargoOfferDao, AcceptedOfferDao acceptedOfferDao) {
		this.offerAcceptanceDao = offerAcceptanceDao;
		this.cargoOfferDao = cargoOfferDao;
		this.acceptedOfferDao = acceptedOfferDao;
	}

	public synchronized void save(List<OfferAcceptance> offerList) {
		for (OfferAcceptance oa : offerList) {
			offerAcceptanceDao.saveOrUpdate(oa);
		}
	}

	public synchronized void save(OfferAcceptance offer) {
		offerAcceptanceDao.saveOrUpdate(offer);
	}

	public synchronized void remove(List<OfferAcceptance> offerList) {
		for (OfferAcceptance oa : offerList) {
			this.removeOfferAcceptance(oa);
		}
	}

	public synchronized void removeOfferAcceptance(OfferAcceptance offerAcceptance) {
		offerAcceptanceDao.delete(offerAcceptance);

	}

	public synchronized List<OfferAcceptance> findAll() {
		return offerAcceptanceDao.findAll();
	}

	public synchronized OfferAcceptance findById(long id) {
		return offerAcceptanceDao.findById(id);
	}

	public void initiatorLogsOut(String string) {
		offerAcceptanceDao.deleteByInitiator(string);
	}

	public void initiateOffer(String initiator, String initiated, CargoOffer co) {

		OfferAcceptance offerAcceptance = offerAcceptanceDao.find(initiated, initiator, co.getId());

		// I dette tillfellet offerAcceptance er allrede i databasen.
		// Vi skal fjerne dette offerAcceptance og lage ny acceptOffer
		if (offerAcceptance != null) {

			AcceptedOffer acceptedOffer = new AcceptedOffer();
			CargoOffer cargoOffer = cargoOfferDao.findById(offerAcceptance.getOfferId());
			String owner = cargoOffer.getOwner();
			if (owner == initiated) {
				acceptedOffer.setUserName(initiator);
			} else {
				acceptedOffer.setUserName(initiated);
			}

			acceptedOffer.setOfferId(cargoOffer.getId());
			acceptedOfferDao.saveOrUpdate(acceptedOffer);
			offerAcceptanceDao.delete(offerAcceptance);

		} else {
			OfferAcceptance offer = new OfferAcceptance();
			offer.setInitiator(initiator);
			offer.setInitiated(initiated);
			offer.setOfferId(co.getId());
			offerAcceptanceDao.save(offer);
		}

	}

}
