package com.blucargo.persistence.testing;

import com.blucargo.persistence.PersistenceInitializer;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestOpenJPAModule extends AbstractModule {

	@Override
	protected void configure() {
		// bindConstant().annotatedWith(JpaUnit.class).to("test");
		install(new JpaPersistModule("test"));
		bind(PersistenceInitializer.class).asEagerSingleton();
	}

}
