package com.epam.mentoring.memory.task03;

import org.kohsuke.randname.RandomNameGenerator;

import java.util.Random;

public class Person
{
	private int age;
	private String name;

	public Person()
	{
		this.age = new Random().nextInt(9);
		this.name = new RandomNameGenerator().next();
	}

	@Override public String toString()
	{
		return String.format("%s is %03d years old", name, age);
	}
}
