package com.epam.mentoring.labyrinth.businessobject;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Serves as a game interface. It is responsible for the input from keyboard.
 * Also it delegates the action entered from keyboard to the associated classes
 *
 * @author Ievgen Ostapenko
 */
public class GameInterface {

    private static final String UP = "u";
    private static final String DOWN = "d";
    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String EXIT = "e";
    private static final String HINT = "h";
    private static final String FEED = "f";

    private String getAvailableOptions() {
        String availableOptions = "";
        for (Field field : getClass().getDeclaredFields()) {
            availableOptions += field.getName() + " ";
        }
        return availableOptions;
    }

    public void runGame(Duck duck) {
        showRule();
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input) {
                case UP:
                    duck.moveUp();
                    break;
                case DOWN:
                    duck.moveDown();
                    break;
                case LEFT:
                    duck.moveLeft();
                    break;
                case RIGHT:
                    duck.moveRight();
                    break;
                case EXIT:
                    exit = true;
                    break;
                case HINT:
                    showRule();
                    break;
                case FEED:
                    duck.performFeed();
                    break;
                default:
                    throw new RuntimeException(String.format("'%s' isn't allowed command. Please see the list of " +
                            "available commands: %s", input, getAvailableOptions()));
            }
        }
    }

    private void showRule() {
        String gameRules = "Hello my friend! Help the Duck to reach the end of labyrinth!\n"
                + "The start is 'I' letter, the Duck is '@' symbol, the labyrinth end is 'X' letter.\nThe list of actions below:\n"
                + getAvailableOptions() + "\nIn order to perform an action to should type the first letter from the word\n"
                + "Enjoy Game!";
        System.out.println(gameRules);
    }

}
