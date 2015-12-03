package com.epam.mentoring.labyrinth.runner;

import com.epam.mentoring.labyrinth.ConsoleUtility;
import com.epam.mentoring.labyrinth.behaviour.FlyWithWings;
import com.epam.mentoring.labyrinth.behaviour.Quack;
import com.epam.mentoring.labyrinth.businessobject.Duck;
import com.epam.mentoring.labyrinth.businessobject.GameInterface;
import com.epam.mentoring.labyrinth.businessobject.Labyrinth;
import com.epam.mentoring.labyrinth.businessobject.LiveDuck;
import com.epam.mentoring.labyrinth.state.EarthState;

public class Runner {

    public static void main(String[] args)  {

        Labyrinth labyrinth = new Labyrinth("src/main/resources/labyrinth.txt");
        new ConsoleUtility().printToConsole(labyrinth.normalize());

        Duck forestDuck = new LiveDuck(new Quack(), new FlyWithWings(), new EarthState());
//        Duck macDuck = new ArtificialDuck(new Quack(), new FlyWithWings());
        forestDuck.registerObserver(labyrinth);

        new GameInterface().runGame(forestDuck);
    }
}