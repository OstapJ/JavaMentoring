package com.epam.jmp.listener;

import com.epam.jmp.ApplicationContextProvider;
import com.epam.jmp.dao.TestSuite;
import com.epam.jmp.service.TestSuiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteResult;

import java.util.Calendar;
import java.util.Map;

public class ISuiteListener implements org.testng.ISuiteListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ISuiteListener.class);
	private static final String DEFAULT_SUITE = "Default Suite";
	private Calendar startTime;


	//for some reasons it returns null. That's why I've taken it from app context directly
	//	@Resource(name="testSuiteService")
	//	private TestSuiteService testSuiteService;

	@Override public void onStart(ISuite iSuite)
	{
		startTime = Calendar.getInstance();

	}

	@Override public void onFinish(ISuite iSuite)
	{
		int testsPassed = 0;
		int testsFailed = 0;
		Map<String, ISuiteResult> resultMap = iSuite.getResults();
		for (Map.Entry<String, ISuiteResult> ent : resultMap.entrySet())
		{
			ISuiteResult result = ent.getValue();
			testsFailed += result.getTestContext().getFailedTests().size();
			testsPassed += result.getTestContext().getPassedTests().size();
		}
		String result = testsFailed > 0 ? "FAILED" : "PASSED";
		TestSuite testSuite = (TestSuite) ApplicationContextProvider.getApplicationContext().getBean("testSuite");
		testSuite.setName(iSuite.getName());

		testSuite.setResult(result);
		testSuite.setTestsTotal(testsPassed + testsFailed);
		testSuite.setTestsPassed(testsPassed);
		testSuite.setTestsFailed(testsFailed);
		testSuite.setDuration(Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis());

		TestSuiteService testSuiteService = (TestSuiteService) ApplicationContextProvider.getApplicationContext()
				.getBean("testSuiteService");

		//It's a synthetic suite which is being used in custom runner. It should be omitted.
		if (!iSuite.getName().equals(DEFAULT_SUITE))
		{
			testSuiteService.edit(testSuite);
		}

		LOGGER.info("Suite '{}' is finished and put into DB:\n '{}'",
				iSuite.getName(), testSuite.toString());
	}

}