package com.epam.mentoring.creationalpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the singleton pattern to provide the global access point
 * from the application. Also it supports concurrent mode.
 */
public class SuperMan {

    private static final Logger logger = LoggerFactory.getLogger(SuperMan.class);

    private static SuperMan superMan;

    private SuperMan() {}

    public static synchronized SuperMan getInstance() {
        if (superMan == null) {
                superMan = new SuperMan();
            logger.info("'{}' hero is created", superMan.getClass().getSimpleName());
        }
        return superMan;
    }

    public void greetEveryone(){
        logger.info("Hello Everyone!!!");
    }
}
