package com.blusoft.blucargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.dao.impl.CarBodyDao;
import com.blusoft.blucargo.model.CarBody;

@Transactional
@Service
public class CarBodyService {

	private final CarBodyDao bodyDao;

	@Autowired
	public CarBodyService(CarBodyDao dao) {
		bodyDao = dao;
	}

	public synchronized void saveBodies(List<CarBody> bodies) {
		// CargoConnectionManager.getInstance().getEntityManager().getTransaction().begin();
		for (CarBody b : bodies) {
			saveBody(b);
		}
		// CargoConnectionManager.getInstance().getEntityManager().getTransaction().commit();

	}

	private synchronized void saveBody(CarBody b) {
		bodyDao.saveOrUpdate(b);
	}

	public synchronized List<CarBody> findAll() {
		return bodyDao.findAll();
	}

	public synchronized CarBody findById(long id) {
		return bodyDao.findById(id);
	}
}
