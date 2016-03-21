package com.epam.mentoring.labyrinth.behaviour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyWithWings implements FlyBehaviour {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void fly() {
        logger.info("Fly with wings");
    }
}
