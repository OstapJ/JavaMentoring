package com.epam.jmp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorComplexOperationTest extends BaseClassTest
{

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testPowerDoublePositive(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.power(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "expectedResult" })
	public void testRootDoublePositive(Double firstInput, Double expectedResult)
	{
		double result = calculator.sqrt(firstInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Parameters({ "firstInput", "secondInput" })
	@Test(expectedExceptions = IllegalArgumentException.class, groups = { "negative" })
	public void testPowerDoubleNegative(Double firstInput, Double secondInput)
	{
		calculator.power(firstInput, secondInput);
	}

	@Parameters({ "firstInput" })
	@Test(expectedExceptions = IllegalArgumentException.class, groups = { "negative" })
	public void testRootDoubleNegative(Double firstInput)
	{

		calculator.sqrt(firstInput);
	}

	@Test(timeOut = 500, groups = { "positive" })
	@Parameters({ "firstInput" })
	public void testIsPrimePositive(int firstInput)
	{
		calculator.isPrime(firstInput);
	}

	@Test(timeOut = 10, groups = { "negative" })
	@Parameters({ "firstInput" })
	public void testIsPrimeNegative(int firstInput) throws InterruptedException
	{
		calculator.isPrime(firstInput);
	}

	@Parameters({ "firstInput", "expectedResult" })
	@Test(dataProvider = "positiveFibonacciData", groups = { "positive" })
	public void testFibonacciPositive(int firstInput, int expectedResult)
	{
		int result = calculator.fibonacci(firstInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@DataProvider(name = "positiveFibonacciData")
	public Object[][] positiveFibonacciData()
	{
		return new Object[][] {
				{ 8, 21 },
				{ 9, 34 },
				{ 10, 55 },
				{ 11, 89 },
				{ 12, 144 }
		};
	}

}
