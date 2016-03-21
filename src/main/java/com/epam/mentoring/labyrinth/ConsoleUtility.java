package com.epam.mentoring.labyrinth;

import com.epam.mentoring.labyrinth.businessobject.Labyrinth;

/**
 * Provides utility methods to interact with console.
 * These methods are taken out from {@link Labyrinth } class
 * to ensures the 'Single responsibility principle'
 */
public class ConsoleUtility {

    /**
     * Prints the Object[][] to console in matrix template
     * @param labyrinthRepresentation
     */
    public void printToConsole(Object[][] labyrinthRepresentation) {
        for (int i = 0; i < labyrinthRepresentation.length; i++) {
            for (int j = 0; j < labyrinthRepresentation[i].length; j++) {
                System.out.print(labyrinthRepresentation[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Clears the console
     */
    public void clearConsole() {
        for (int i = 0; i < 4; ++i) System.out.println("");
    }
}
