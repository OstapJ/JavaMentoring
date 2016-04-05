package com.epam.jmp.dao;

import java.util.List;

/**
 * It provides the common interface for all tests/suites in order to manage them in scope
 * of interacting with DB
 *
 * @author Ievgen_Ostapenko
 */
public interface AbstractTestDao
{
	/**
	 * Adds a test into DB
	 */
	void add(AbstractPojo test);

	/**
	 * Returns a test by id from DB
	 */
	AbstractTestDao get(int id);

	/**
	 * Returns all tests from DB
	 */
	List getAll();
}
