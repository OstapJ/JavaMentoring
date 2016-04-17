package com.epam.jmp;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;

public class CalculatorSimpleOperationTest extends BaseTest
{

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSumDoublePositive(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.sum(firstInput, secondInput);
		assertEquals(expectedResult, result);
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSumLongPositive(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.sum(firstInput, secondInput);
		assertEquals(expectedResult, result);
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSubtractDoublePositive(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.subtract(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSubtractLongPositive(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.subtract(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testMultiplyDoublePositive(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.multiply(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testMultiplyLongPositive(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.multiply(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testDivideDoublePositive(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.divide(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(groups = { "positive" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testDivideLongPositive(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.divide(firstInput, secondInput);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	@Parameters({ "firstInput", "secondInput" })
	public void testDivideByZeroDoublePositive(Double firstInput, Double secondInput)
	{
		calculator.divide(firstInput, secondInput);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	@Parameters({ "firstInput", "secondInput" })
	public void testDivideByZeroLongPositive(long firstInput, long secondInput)
	{
		calculator.divide(firstInput, secondInput);
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSumDoubleNegative(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.sum(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSumLongNegative(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.sum(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSubtractDoubleNegative(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.subtract(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testSubtractLongNegative(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.subtract(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testMultiplyDoubleNegative(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.multiply(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testMultiplyLongNegative(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.multiply(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testDivideDoubleNegative(Double firstInput, Double secondInput, Double expectedResult)
	{
		double result = calculator.divide(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}

	@Test(groups = { "negative" })
	@Parameters({ "firstInput", "secondInput", "expectedResult" })
	public void testDivideLongNegative(long firstInput, long secondInput, long expectedResult)
	{
		long result = calculator.divide(firstInput, secondInput);
		assertThat(result, is(not(equalTo(expectedResult))));
	}
}
