package com.epam.jmp.listener;

import com.epam.jmp.BaseClassTest;
import com.epam.jmp.dao.TestSuite;
import com.epam.jmp.dao.TestSuiteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteResult;

import javax.persistence.EntityManager;
import java.util.Map;

public class ISuiteListener implements org.testng.ISuiteListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ISuiteListener.class);

	private EntityManager entityManager;
	private TestSuiteDao testSuiteDao;

	@Override public void onStart(ISuite iSuite)
	{
	}

	@Override public void onFinish(ISuite iSuite)
	{
		entityManager = BaseClassTest.getEntityManager();
		testSuiteDao = new TestSuiteDao(entityManager);
		int testsPassed = 0;
		int testsFailed = 0;
		Map<String, ISuiteResult> resultMap = iSuite.getResults();
		for (Map.Entry<String, ISuiteResult> ent : resultMap.entrySet())
		{
			ISuiteResult result = ent.getValue();
			testsFailed += result.getTestContext().getFailedTests().size();
			testsPassed += result.getTestContext().getPassedTests().size();
		}
		String result = iSuite.getSuiteState().isFailed() ? "FAILED" : "PASSED";

		TestSuite testSuite = new TestSuite();
		testSuite.setName(iSuite.getName());
		testSuite.setResult(result);
		testSuite.setTestsTotal(testsPassed + testsFailed);
		testSuite.setTestsPassed(testsPassed);
		testSuite.setTestsFailed(testsFailed);
		testSuiteDao.add(testSuite);

		LOGGER.info("Suite '{}' is finished and put into DB:\n '{}'",
				iSuite.getName(), testSuite.toString());
	}
}