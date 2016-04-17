package com.epam.jmp;

/**
 * Class represents the common calculator functionality
 * @author Ievgen_Ostapenko
 */
public class Calculator
{
	public long sum(long a, long b)
	{
		return a + b;
	}

	public double sum(double a, double b)
	{
		return a + b;
	}

	public long subtract(long a, long b)
	{
		return a - b;
	}

	public double subtract(double a, double b)
	{
		return a - b;
	}

	public long multiply(long a, long b)
	{
		return a * b;
	}

	public double multiply(double a, double b)
	{
		return Math.floor(a * b);
	}


	public long divide(long a, long b)
	{
		if (b == 0L)
		{
			throw new IllegalArgumentException("Attempt to divide by zero");
		}
		else
		{
			return a / b;
		}
	}

	public double divide(double a, double b)
	{
		if (b == 0D)
		{
			throw new IllegalArgumentException("Attempt to divide by zero");
		}
		else
		{
			return a / b;
		}
	}

	public double power(double a, double b)
	{
		if (a == 0D || b == 0D)
		{
			throw new IllegalArgumentException("Attempt to divide by zero");
		}
		else
		{
			return Math.pow(a, Math.floor(b));
		}
	}

	public double sqrt(double a)
	{
		if (a == 0D)
		{
			throw new IllegalArgumentException("Attempt to divide by zero");
		}
		else
		{
			return Math.sqrt(Math.abs(a));
		}

	}

	public boolean isPrime(int a)
	{
		if (a < 2)
			return false;
		if (a == 2)
			return true;
		if (a % 2 == 0)
			return false;
		for (int i = 3; i * i <= a; i += 2)
			if (a % i == 0)
				return false;
		return true;
	}

	public int fibonacci(int n)
	{
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
