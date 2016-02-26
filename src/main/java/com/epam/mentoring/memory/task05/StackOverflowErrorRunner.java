package com.epam.mentoring.memory.task05;

/**
 * The goal is to reach a java.lang.StackOverflowError. Do not use recursive methods.
 * The classes {@Link Husband} and {@Link Wife} have cyclic relationships between each other that leads to overloading
 * Stack space.
 */
public class StackOverflowErrorRunner
{
	public static void main(String[] args)
	{
		Husband husband = new Husband();
		System.out.println(husband);
	}
}
