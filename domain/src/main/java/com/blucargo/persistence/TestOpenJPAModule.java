package com.blucargo.persistence;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestOpenJPAModule extends AbstractModule {

	@Override
	protected void configure() {
		// bindConstant().annotatedWith(JpaModule.class).to("create_schema");
		install(new JpaPersistModule("create_schema"));
		bind(PersistenceInitializer.class).asEagerSingleton();
	}

}
