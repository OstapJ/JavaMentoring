package com.epam.jmp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		LOGGER.info("Method started: '{}'. Thread name is '{}'  Thread ID: '{}'",
				method.getTestMethod().getMethodName(), Thread.currentThread().getName(),
				Thread.currentThread().getId());
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		LOGGER.info("Method finished '{}'. Method name is '{}'", testResult.getName(),
				 method.getTestMethod().getMethodName());
	}
}

