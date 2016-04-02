package com.epam.jmp.listener;

import com.epam.jmp.db.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);
	private static long startTime;
	private Utility utility = new Utility();
	private static int increment;

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		//		LOGGER.info("Method started: '{}'. Thread name is '{}'  Thread ID: '{}'",
		//				method.getTestMethod().getMethodName(), Thread.currentThread().getName(),
		//				Thread.currentThread().getId());
		startTime = method.getTestResult().getStartMillis();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		LOGGER.info("Method finished '{}'",
				method.getTestMethod().getMethodName());
		String className = method.getTestMethod().getTestClass().getName();
		String testName = method.getTestMethod().getMethodName();
		String description = testResult.getTestContext().getName();
		String result = (testResult.getStatus() == 1) ? "PASSED" : "FAILED";
		String failReason = result.equals("PASSED") ? "" : testResult.getThrowable().getMessage();
		long time = method.getTestResult().getEndMillis() - startTime;
//		try (
//				Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
//				Statement statement = connection.createStatement())
//		{
//			Class.forName(utility.getProperty("connection.driver")).newInstance();
//			PreparedStatement ps = connection.prepareStatement(
//					"INSERT INTO UnitTestCase VALUES (?, ?, ?, ?, ?, ?, ?)");
//			ps.setInt(1, ++increment);
//			ps.setString(2, className);
//			ps.setString(3, testName);
//			ps.setString(4, description);
//			ps.setString(5, result);
//			ps.setString(6, failReason);
//			ps.setLong(7, time);
//			ps.execute();
//			connection.commit();
//			LOGGER.debug("The record is written into DB");
//			ResultSet rs = statement.executeQuery(
//					"SELECT * FROM UnitTestCase WHERE id = " + increment);
//			while (rs.next())
//			{
//				LOGGER.info("Method is written into DB '{}' wit ID '{}'",
//						rs.getString(3), rs.getInt(1));
//				System.out.println(
//						rs.getString(3)
//				);
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
}

