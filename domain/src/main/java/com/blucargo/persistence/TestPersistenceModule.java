package com.blucargo.persistence;

import com.google.inject.AbstractModule;

public class TestPersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new TestOpenJPAModule());
		// install(PersistenceService.usingJpa().across(UnitOfWork.TRANSACTION).forAll(Matchers.annotatedWith(Transactional.class),Matchers.any()).buildModule());
		// install(PersistService.usingJpa().across(UnitOfWork.TRANSACTION).forAll(Matchers.annotatedWith(Transactional.class),
		// Matchers.any()).buildModule());
	}

}
