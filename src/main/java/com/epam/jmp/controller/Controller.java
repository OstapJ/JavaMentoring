package com.epam.jmp.controller;

import com.epam.jmp.dao.TestSuite;
import com.epam.jmp.service.TestSuiteService;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Responsible for getting and posting response/request
 */
@org.springframework.stereotype.Controller
@RequestMapping("/main")
public class Controller
{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Resource(name="testSuiteService")
    private TestSuiteService testSuiteService;

    /**
     * Processes and retrieves all testSuites and show them on a JSP page
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/testsuites", method = RequestMethod.GET)
    public String getTestSuites(Model model) {

        LOGGER.debug("Received request to display all Test Suites");
        List<TestSuite> testSuites = testSuiteService.getAll();
        model.addAttribute("testsuites", testSuites);
        return "testsuitespage";
    }

}