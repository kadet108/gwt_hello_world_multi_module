package com.blusoft.blucargo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.blusoft.blucargo.model.AcceptedOffer;
import com.blusoft.blucargo.model.CargoOffer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/META-INF/spring/blucargo-dao-test-context.xml" })
public class AcceptedOfferDaoDbTest extends AbstractDAOTest {

	@Autowired
	AcceptedOfferDao acceptedOfferDao;

	@Autowired
	CargoOfferDao cargoOfferDao;

	private CargoOffer co;
	private AcceptedOffer ao;

	@Before
	public void setUp() {
		co = new CargoOffer();
		co.setOwner("a");
		cargoOfferDao.saveOrUpdate(co);

		ao = new AcceptedOffer();
		ao.setOfferId(co.getId());
		ao.setUserName("b");
		acceptedOfferDao.saveOrUpdate(ao);
	}

	@Test
	public void testGetAcceptedCargoOffersByOwner() {
		List<AcceptedOffer> acceptedOffers = acceptedOfferDao.findAll();
		assertTrue(acceptedOffers.size() > 0);
		assertEquals(acceptedOffers.get(0).getUserName(), "b");
		assertEquals(acceptedOffers.get(0).getOfferId(), co.getId());
	}

	@Test
	@Transactional
	public void testRemoveAcceptedCargoOffersByOwner() {

		acceptedOfferDao.removeAcceptedOfferByCargoOfferAndOwner(co, "b");
		List<AcceptedOffer> acceptedOffers = acceptedOfferDao.findAll();
		assertTrue(acceptedOffers.size() == 0);

	}

	@Test
	@Transactional
	public void testRemoveAcceptedCargoOffersByOwner2() {

		acceptedOfferDao.removeAcceptedOfferByCargoOfferAndOwner(co, "b");
		List<AcceptedOffer> acceptedOffers = acceptedOfferDao.findAll();
		assertTrue(acceptedOffers.size() == 0);

	}

}
