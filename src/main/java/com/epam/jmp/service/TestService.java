package com.epam.jmp.service;

import com.epam.jmp.dao.Test;
import com.epam.jmp.dao.TestSuite;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service for processing Tests
 *
 * @author Ievgen_Ostapenko
 */
@Service("testService")
@Transactional
public class TestService extends AbstractService<Test, Integer>
{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all Tests
	 *
	 * @return a list of tests
	 */
	public List getAll()
	{
		LOGGER.debug("Retrieving all tests");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT t FROM Test t");
		return query.list();
	}

	/**
	 * Returns a test by id from DB
	 *
	 * @param id
	 */
	public Test get(Integer id)
	{
		Session session = sessionFactory.getCurrentSession();
		return (Test) session.get(Test.class, id);
	}

	/**
	 * Adds a new test
	 *
	 * @param test
	 */
	public void add(Test test)
	{
		LOGGER.debug("Adding new Test");
		Session session = sessionFactory.getCurrentSession();
		session.save(test);
	}

	public void add(Integer suiteId, Test test)
	{
		LOGGER.debug("Adding new Test to the test Suite with '{}' id", suiteId);
		Session session = sessionFactory.getCurrentSession();
		session.save(test);
		TestSuite testSuite = (TestSuite) session.get(TestSuite.class, suiteId);
		testSuite.getTests().add(test);
		session.save(testSuite);
	}

	/**
	 * Deletes an existing test
	 *
	 * @param id the id of the existing test
	 */
	public void delete(Integer id)
	{
		LOGGER.debug("Deleting the existing Test");
		Session session = sessionFactory.getCurrentSession();
		Test test = (Test) session.get(Test.class, id);
		session.delete(test);
	}

	@Override public void edit(Test resource)
	{
		//TODO should be implemented
	}
}
