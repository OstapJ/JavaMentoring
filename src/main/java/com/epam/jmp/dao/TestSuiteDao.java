package com.epam.jmp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteDao implements AbstractTestDao
{

	public EntityManager entityManager;
	public TestSuiteDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	/**
	 * Adds a test into DB
	 */
	@Override public void add(AbstractPojo test)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		try
		{
			transaction.begin();
			entityManager.persist(test);
			transaction.commit();
		}
		catch (Exception e)
		{
			transaction.rollback();
		}
	}

	/**
	 * Returns a test by id from DB otherwise returns null
	 *
	 * @param id
	 */
	@Override public AbstractTestDao get(final int id)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		TestSuiteDao result = null;
		try
		{
			transaction.begin();
			result = (TestSuiteDao) entityManager.createQuery("SELECT t FROM TestSuite t WHERE id = " + id).getSingleResult();
			transaction.commit();
		}
		catch (Exception e)
		{
			transaction.rollback();
		}
		return result;
	}

	/**
	 * Returns all tests from DB
	 */
	@Override public List getAll()
	{
		List result = new ArrayList<>();
		EntityTransaction transaction = entityManager.getTransaction();
		try
		{
			transaction.begin();
			result = entityManager.createQuery("SELECT t FROM TestSuite t").getResultList();
			transaction.commit();
		}
		catch (Exception e)
		{
			transaction.rollback();
		}
		return result;
	}

}
