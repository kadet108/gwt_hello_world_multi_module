package com.blusoft.blucargo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.blusoft.blucargo.model.Comment;

public class CommentDaoDbTest extends AbstractDAOTest {

	@Autowired
	CommentDao commentDao;

	@Before
	public void setUp() {
	}

	@Test
	public void testSaveComment() {

		Comment c = new Comment();
		c.setAuthor("a");
		commentDao.saveOrUpdate(c);

		List<Comment> comments = commentDao.findAll();

		assertEquals(1, comments.size());
		assertEquals(c.getId(), comments.get(0).getId());

	}

	@Test
	public void testCommentHasDate() {

		Comment c = new Comment();
		c.setAuthor("a");
		commentDao.saveOrUpdate(c);

		List<Comment> comments = commentDao.findAll();

		assertEquals(1, comments.size());
		assertNotNull(comments.get(0).getDate());

	}

}
