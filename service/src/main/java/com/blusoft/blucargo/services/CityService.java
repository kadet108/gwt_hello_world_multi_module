package com.blusoft.blucargo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.dao.CityDao;
import com.blusoft.blucargo.model.City;

@Service
@Transactional
public class CityService {

	private final CityDao cityDao;

	@Autowired
	public CityService(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public synchronized void saveCities(List<City> cities) {
		for (City c : cities) {
			saveCity(c);
		}
	}

	public synchronized void saveCity(City c) {
		cityDao.saveOrUpdate(c);
	}

	public synchronized List<City> findAll() {
		return cityDao.findAll();
	}

	public synchronized City findById(long id) {
		return cityDao.findById(id);
	}

	public List<City> findCitiesByCountry(String country) {
		return cityDao.findCitiesByCountry(country);
	}

	public List<String> findCityNamesByCountry(String country) {
		return cityDao.findCityNamesByCountry(country);
	}

}
