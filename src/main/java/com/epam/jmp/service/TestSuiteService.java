package com.epam.jmp.service;

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
 * Service for processing Test Suites
 *
 * @author Ievgen_Ostapenko
 */
@Service("testSuiteService")
@Transactional
public class TestSuiteService extends AbstractService<TestSuite, Integer>
{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestSuiteService.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all Test Suites
	 *
	 * @return a list of Test Suites
	 */
	public List getAll()
	{
		LOGGER.debug("Retrieving all Test Suites");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT t FROM TestSuite t");
		return query.list();
	}

	/**
	 * Returns a Test Suite by id from DB
	 *
	 * @param id
	 */
	public TestSuite get(Integer id)
	{
		LOGGER.debug("Retrieving the Test Suite by '{}' id", id);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM TestSuite as p LEFT JOIN FETCH  p.tests WHERE p.id=" + id);
		return (TestSuite) query.uniqueResult();
	}

	/**
	 * Adds a new Test Suite
	 *
	 * @param testSuite
	 */
	public void add(TestSuite testSuite)
	{
		LOGGER.debug("Adding new Test Suite");
		Session session = sessionFactory.getCurrentSession();
		session.save(testSuite);
	}

	@Override public void add(Integer id, TestSuite item)
	{

	}

	/**
	 * Deletes an existing Test Suite
	 *
	 * @param id the id of the existing Test Suite
	 */
	public void delete(Integer id)
	{
		LOGGER.debug("Deleting the Test Suite by '{}' id", id);
		Session session = sessionFactory.getCurrentSession();
		TestSuite testSuite = (TestSuite) session.get(TestSuite.class, id);
		session.delete(testSuite);
	}

	/**
	 * Edits an existing Test Suite
	 *
	 * @param testSuite
	 */
	@Override public void edit(TestSuite testSuite)
	{
		LOGGER.debug("Editing current TestSuite");
		Session session = sessionFactory.getCurrentSession();
		TestSuite currentTestSuite = (TestSuite) session.get(TestSuite.class, testSuite.getId());

		currentTestSuite.setName(testSuite.getName());
		currentTestSuite.setResult(testSuite.getResult());
		currentTestSuite.setTestsTotal(testSuite.getTestsTotal());
		currentTestSuite.setTestsPassed(testSuite.getTestsPassed());
		currentTestSuite.setTestsFailed(testSuite.getTestsFailed());
		currentTestSuite.setDuration(testSuite.getDuration());

		session.save(currentTestSuite);
	}
}
