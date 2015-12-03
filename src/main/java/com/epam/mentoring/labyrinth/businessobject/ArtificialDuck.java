package com.epam.mentoring.labyrinth.businessobject;

import com.epam.mentoring.labyrinth.behaviour.FlyBehaviour;
import com.epam.mentoring.labyrinth.behaviour.QuackBehaviour;

/**
 * It is the concrete implementation of {@link Duck} class.
 * It doesn't change the super class implementation it just extends it.
 * According to "Liskov substitution principle".
 */
public class ArtificialDuck extends Duck {

    public ArtificialDuck(QuackBehaviour quackBehaviour, FlyBehaviour flyBehaviour) {
        this.quackBehaviour = quackBehaviour;
        this.flyBehaviour = flyBehaviour;
        logger.info("{} is created", this.getClass().getSimpleName());
    }

    @Override
    public void performFeed() {
        logger.info("There is no battery available. Sorry");
    }

    /**
     * Turns off the Duck
     */
    public void turnOff() {
        for (int i = 0; i < 5; i++) {
            quackBehaviour.quack();
        }
        logger.info("The battery is discharged. There is no way to proceed");
        System.exit(0);
    }

    /**
     * Notifies that the Duck is hungry after 10 steps passed and
     * turns off the Duck at the end.
     */
    @Override
    public void notifyThatDuckIsHungry() {
        if (stepCount == 10) {
            System.out.println("The Duck is hungry!!!");
            turnOff();
        }
    }
}
