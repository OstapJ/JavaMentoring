package com.epam.jmp.listener;

import org.testng.ISuite;

public class ISuiteListener implements org.testng.ISuiteListener
{
	@Override public void onStart(ISuite iSuite)
	{

	}

	@Override public void onFinish(ISuite iSuite)
	{
		String suiteName = iSuite.getName();

	}
}
