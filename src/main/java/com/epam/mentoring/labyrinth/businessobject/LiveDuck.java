package com.epam.mentoring.labyrinth.businessobject;

import com.epam.mentoring.labyrinth.behaviour.FlyBehaviour;
import com.epam.mentoring.labyrinth.behaviour.QuackBehaviour;
import com.epam.mentoring.labyrinth.state.DuckState;
import com.epam.mentoring.labyrinth.state.WaterState;

/**
 * It is the concrete implementation of {@link Duck} class.
 * It doesn't change the super class implementation it just extends it.
 * According to "Liskov substitution principle".
 */
public class LiveDuck extends Duck {

    public LiveDuck(QuackBehaviour quackBehaviour, FlyBehaviour flyBehaviour, DuckState state) {
        this.quackBehaviour = quackBehaviour;
        this.flyBehaviour = flyBehaviour;
        this.state = state;
        logger.info("{} is created", this.getClass().getSimpleName());
    }

    /**
     * Performs the Fly and set according state to the Duck
     */
    public void performSwim() {
        logger.info("Swim");
        super.setState(new WaterState());
    }

    /**
     * Notifies that the Duck is hungry after 10 steps passed.
     */
    @Override
    public void notifyThatDuckIsHungry() {
        if (stepCount % 10 == 0) {
            hungerIndicator = true;
            System.out.println("The Duck is hungry!!! You need to feed the duck in order to proceed");
        }
    }

    /**
     * Performs the Feed according to the state of the Duck
     */
    @Override
    public void performFeed() {
        state.feed();
        hungerIndicator = false;
    }

}
