package com.epam.jmp.listener;

import com.epam.jmp.BaseClassTest;
import com.epam.jmp.dao.Test;
import com.epam.jmp.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import javax.persistence.EntityManager;

public class TestListener implements IInvokedMethodListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
	private static long startTime;
	private EntityManager entityManager;
	private TestDao testDao;

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		startTime = method.getTestResult().getStartMillis();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		String result = (testResult.getStatus() == 1) ? "PASSED" : "FAILED";
		entityManager = BaseClassTest.getEntityManager();
		testDao = new TestDao(entityManager);
		Test test = new Test();
		test.setClassName(method.getTestMethod().getTestClass().getName());
		test.setName(method.getTestMethod().getMethodName());
		test.setDescription(testResult.getTestContext().getName());
		test.setResult(result);
		//		test.setFailReason(result.equals("PASSED") ? "" : testResult.getThrowable().getMessage());
		test.setFailReason("Stump");
		test.setDuration(method.getTestResult().getEndMillis() - startTime);
		testDao.add(test);

		LOGGER.info("Method '{}' is finished and put into DB:\n '{}'",
				method.getTestMethod().getMethodName(), test.toString());

	}
}

