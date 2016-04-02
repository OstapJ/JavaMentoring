package com.epam.jmp.test.runner;

import com.epam.jmp.db.DBSupport;
import com.epam.jmp.listener.ISuiteListener;
import com.epam.jmp.listener.TestListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner
{

	public static void main(String[] args)
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		ISuiteListener iSuiteListener = new ISuiteListener();
		TestNG tng = new TestNG();
		tng.addListener(tla);
		tng.addListener(iSuiteListener);
		tng.addListener(new TestListener());

		XmlSuite suite = new XmlSuite();
		suite.setName("All suites");
		DBSupport dbSupport = new DBSupport();
//		dbSupport.initiateDBStructure();
//		dbSupport.cleanDB();
		List<String> files = new ArrayList<>();
		files.addAll(new ArrayList<String>()
		{{
			add("src/main/resources/negative.xml");
			add("src/main/resources/positive.xml");
		}});
		suite.setSuiteFiles(files);

		List<XmlSuite> suites = new ArrayList<>();
		suites.add(suite);
		tng.setXmlSuites(suites);

		tng.run();
	}
}
