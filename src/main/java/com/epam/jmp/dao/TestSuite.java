package com.epam.jmp.dao;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TestSuite")
@Component
public class TestSuite
{

	@Id
	@GeneratedValue
	public int id;
	@Basic
	public String name;
	@Basic
	public int testsPassed;
	@Basic
	public int testsFailed;
	@Basic
	public int testsTotal;
	@Basic
	public String result;
	@Basic
	public long duration;

	@OneToMany
	private Set<Test> tests;

	public int getTestsTotal()
	{
		return testsTotal;
	}

	public void setTestsTotal(int testsTotal)
	{
		this.testsTotal = testsTotal;
	}

	public int getTestsPassed()
	{
		return testsPassed;
	}

	public void setTestsPassed(int testsPassed)
	{
		this.testsPassed = testsPassed;
	}

	public int getTestsFailed()
	{
		return testsFailed;
	}

	public void setTestsFailed(int testsFailed)
	{
		this.testsFailed = testsFailed;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public long getDuration()
	{
		return duration;
	}

	public void setDuration(long duration)
	{
		this.duration = duration;
	}

	public Set<Test> getTests()
	{
		return tests;
	}

	public void setTests(Set<Test> tests)
	{
		this.tests = tests;
	}

	@Override
	public String toString()
	{
		return "Test {" +
				"id=" + id +
				", name='" + name + '\'' +
				", testsPassed=" + testsPassed +
				", testsFailed=" + testsFailed +
				", testsTotal=" + testsTotal +
				", result=" + result +
				", duration=" + duration +
				'}';
	}

}
