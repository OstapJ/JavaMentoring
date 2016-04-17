package com.epam.jmp.listener;

import com.epam.jmp.ApplicationContextProvider;
import com.epam.jmp.dao.Test;
import com.epam.jmp.dao.TestSuite;
import com.epam.jmp.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Calendar;

public class TestListener implements IInvokedMethodListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
	private static Calendar startTime;

	//for some reasons it returns null. That's why I've taken it from app context directly
	//	@Autowired
	//	private TestService testService;

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		startTime = Calendar.getInstance();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		String result = (testResult.getStatus() == 1) ? "PASSED" : "FAILED";
		Test test = new Test();
		test.setClassName(method.getTestMethod().getTestClass().getName().replaceAll("(.)*\\.", ""));
		test.setName(method.getTestMethod().getMethodName());
		test.setDescription(testResult.getTestContext().getName());
		test.setResult(result);
		test.setFailReason(!result.equals("PASSED") ? testResult.getThrowable().getMessage() : "");
		test.setDuration(Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis());

		TestSuite testSuite = (TestSuite) ApplicationContextProvider.getApplicationContext().getBean("testSuite");
		int suiteId = testSuite.getId();
		TestService testService = (TestService) ApplicationContextProvider.getApplicationContext()
				.getBean("testService");
		if (method.getTestMethod().getMethodName().startsWith("test"))
		{
			testService.add(suiteId, test);
			LOGGER.info("Method '{}' is finished and put into DB:\n '{}'",
					method.getTestMethod().getMethodName(), test.toString());
		}

	}
}

