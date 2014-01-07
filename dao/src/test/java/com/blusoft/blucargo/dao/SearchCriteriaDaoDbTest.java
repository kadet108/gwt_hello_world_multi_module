package com.blusoft.blucargo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.blusoft.blucargo.model.SearchCriteria;

public class SearchCriteriaDaoDbTest extends AbstractDAOTest {

	@Autowired
	SearchCriteriaDao criteriaDao;

	@Before
	public void setUp() {
	}

	@Test
	public void testSaveSearchCriteria() {

		SearchCriteria s = new SearchCriteria();
		s.setUserName("123");
		s.setValue("aaa");
		criteriaDao.saveOrUpdate(s);

		List<SearchCriteria> searchCriteriaList = criteriaDao.findAll();
		assertEquals(1, searchCriteriaList.size());

	}

}
