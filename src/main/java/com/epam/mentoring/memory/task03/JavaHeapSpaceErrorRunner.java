package com.epam.mentoring.memory.task03;

import java.util.HashSet;

/**
 * The goal is to reach a java.lang.OutOfMemoryError: Java heap space. Create big objects continuously and make them stay in memory.
 * <p/>
 * We iterate through infinity loop and create a new Objects which are stored in the HashSet collection. Objects are stored in
 * the Heap space.
 * To observe the Java heap space curve the VisualVm is being used.
 * In order to reach the exception quickly please point the following VM options: -Xmx5m -XX:-UseGCOverheadLimit
 */
public class JavaHeapSpaceErrorRunner
{
	public static void populateEarth()
	{
		HashSet population = new HashSet();
		boolean life = true;
		while (life)
		{
			Person person = new Person();
			population.add(person);
			System.out.println(person);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException
	{
		populateEarth();
	}
}
