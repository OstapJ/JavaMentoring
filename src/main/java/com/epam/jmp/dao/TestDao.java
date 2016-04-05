package com.epam.jmp.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TestDao implements AbstractTestDao
{

	public EntityManager entityManager;
	public TestDao(EntityManager entityManager)
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
		TestDao result = null;
		try
		{
			transaction.begin();
			result = (TestDao) entityManager.createQuery("SELECT t FROM Test t WHERE id = " + id).getSingleResult();
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
			result = entityManager.createQuery("SELECT t FROM Test t").getResultList();
			transaction.commit();
		}
		catch (Exception e)
		{
			transaction.rollback();
		}
		return result;
	}

}
