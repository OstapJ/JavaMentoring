package com.epam.mentoring.labyrinth.behaviour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Squeak implements QuackBehaviour {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void quack() {
        logger.info("Squeak");
    }
}
