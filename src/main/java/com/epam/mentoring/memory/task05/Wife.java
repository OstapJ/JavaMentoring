package com.epam.mentoring.memory.task05;

public class Wife
{
	private String gender;
	private Husband husband;

	public Wife()
	{
		this.gender = "Female";
		this.husband = new Husband();
	}

	@Override
	public String toString()
	{
		return "";
	}
}