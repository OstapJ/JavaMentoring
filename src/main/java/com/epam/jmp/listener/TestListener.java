package com.epam.jmp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
	private static long startTime;

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		LOGGER.info("Method started: '{}'. Thread name is '{}'  Thread ID: '{}'",
				method.getTestMethod().getMethodName(), Thread.currentThread().getName(),
				Thread.currentThread().getId());
		startTime = method.getTestResult().getStartMillis();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		LOGGER.info("Method finished '{}'. Method name is '{}'", testResult.getName(),
				 method.getTestMethod().getMethodName());
		String className = method.getTestMethod().getTestClass().getName();
		String name = method.getTestMethod().getMethodName();
		String test = testResult.getTestContext().getName();
		boolean result = testResult.getStatus() == 1;
		long time = method.getTestResult().getEndMillis() - startTime;
	}
}

