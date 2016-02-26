package com.epam.mentoring.memory.task03;

import javassist.ClassPool;

/**
 * The goal is to reach a java.lang.OutOfMemoryError: PermGen space. Load classes continuously and make them stay in memory.
 * <p/>
 * We iterate through infinity loop and load new class definitions which are stored in the Permanent Generation memory domain.
 * To observe the perm gen curve the VisualVm is being used.
 */
public class PermGenSpaceErrorRunner
{
	public static void main(String[] args) throws Exception
	{
		for (int i = 0; ; i++)
		{
			create("com.epam.mentoring.NewClass" + i);
			System.out.println("com.epam.mentoring.NewClass" + i);
		}
	}

	public static Class create(String name) throws Exception
	{
		ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(name).toClass();
	}
}
