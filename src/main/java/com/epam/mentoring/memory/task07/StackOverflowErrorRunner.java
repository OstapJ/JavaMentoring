package com.epam.mentoring.memory.task07;

/**
 * The goal is to reach a java.lang.StackOverflowError. Do not use recursive methods.
 * The classes {@Link Husband} and {@Link Wife} have cyclic relationships between each other that leads to overloading
 * Stack space.
 * In order to start we should configure the Heap structure: 3-Eden, 3-S0, 3-S1, 1m to thread stack. Project source code is Java 8
 * VM options:-Xms60m -Xmx60m -Xmn30m -Xss10m -XX:SurvivorRatio=1 -XX:-UseGCOverheadLimit
 */
public class StackOverflowErrorRunner
{
	public static void main(String[] args)
	{
		Husband husband = new Husband();
		System.out.println(husband);
	}
}
