package com.blucargo.testing;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionRollbackTestBase {

	// @Inject
	// private WorkManager unitOfWork;
	@Inject
	private Provider<EntityManager> entityManagerProvider;

	// @Before
	// public void beginTransaction() {
	// unitOfWork.beginWork();
	// entityManagerProvider.get().getTransaction().begin();
	// }
	//
	// @After
	// public void rollbackTransaction() {
	// entityManagerProvider.get().getTransaction().rollback();
	// unitOfWork.endWork();
	// }

	public EntityManager getEntityManager() {
		return entityManagerProvider.get();
	}

}
