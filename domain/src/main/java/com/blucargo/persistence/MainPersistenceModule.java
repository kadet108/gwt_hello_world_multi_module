package com.blucargo.persistence;

import com.google.inject.AbstractModule;

public class MainPersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new OpenJPAModule());
		// install(PersistService.across(UnitOfWork.TRANSACTION).forAll(Matchers.annotatedWith(Transactional.class),Matchers.any()).buildModule());
	}

}
