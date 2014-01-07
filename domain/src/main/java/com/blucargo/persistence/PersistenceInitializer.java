package com.blucargo.persistence;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class PersistenceInitializer {

	@Inject
	public PersistenceInitializer(PersistService service) {
		service.start();
	}

}
