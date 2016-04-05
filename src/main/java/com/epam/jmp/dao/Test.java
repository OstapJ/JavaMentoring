package com.epam.jmp.dao;

import javax.persistence.*;

@Entity
@Table(name = "Test")
public class Test implements AbstractPojo
{

	@Id
	@GeneratedValue
	public int id;
	@Basic
	public String className;
	@Basic
	public String name;
	@Basic
	public String description;
	@Basic
	public String result;
	@Basic
	public String failReason;
	@Basic
	public long duration;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public String getFailReason()
	{
		return failReason;
	}

	public void setFailReason(String failReason)
	{
		this.failReason = failReason;
	}

	public long getDuration()
	{
		return duration;
	}

	public void setDuration(long duration)
	{
		this.duration = duration;
	}

	@Override
	public String toString()
	{
		return "Test {" +
				"id=" + id +
				", name='" + name + '\'' +
				", description=" + description +
				", className=" + className +
				", result=" + result +
				", duration=" + duration +
				'}';
	}
}
