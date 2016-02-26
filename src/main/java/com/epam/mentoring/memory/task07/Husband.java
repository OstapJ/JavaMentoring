package com.epam.mentoring.memory.task07;

public class Husband
{
	private String gender;
	private Wife wife;

	public Husband()
	{
		this.gender = "Male";
		this.wife = new Wife();
	}

	@Override
	public String toString()
	{
		return "";
	}
}
