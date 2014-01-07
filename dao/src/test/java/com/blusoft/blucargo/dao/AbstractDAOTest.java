package com.blusoft.blucargo.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/META-INF/spring/blucargo-dao-test-context.xml" })
@Transactional
public class AbstractDAOTest {

	@Test
	public void shouldObjectFactoryBeNotNull() {
		assertNotNull(new Long(1L));
	}

}
