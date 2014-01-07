package com.blucargo.persistence;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class OpenJPAModule extends AbstractModule {

	@Override
	protected void configure() {
		// bindConstant().annotatedWith(JpaPersistModule.class).to("main");
		install(new JpaPersistModule("create_schema"));
		bind(PersistenceInitializer.class).asEagerSingleton();
	}

}
