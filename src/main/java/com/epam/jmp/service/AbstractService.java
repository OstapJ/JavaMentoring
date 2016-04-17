package com.epam.jmp.service;

import java.util.List;

/**
 * It provides the common interface for all tests/suites in order to manage them in scope
 * of interacting with DB
 *
 * @author Ievgen_Ostapenko
 */
public abstract class AbstractService<E, K>
{
	/**
	 * Adds a resource into DB
	 */
	public abstract void add(E resource);

	/**
	 * Adds a resource into DB
	 */
	public abstract void add(K id, E resource);

	/**
	 * Returns a resource by id from DB
	 */
	public abstract E get(K id);

	/**
	 * Returns all resources from DB
	 */
	public abstract List<E> getAll();

	/**
	 * Deletes a resource by specified id
	 *
	 * @param id
	 */
	public abstract void delete(K id);

	/**
	 * Edits a resource
	 *
	 * @param resource
	 */
	public abstract void edit(E resource);
}
