package com.epam.mentoring.labyrinth.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaterState implements DuckState{

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void feed(){
        logger.info("drink");
    }
}
