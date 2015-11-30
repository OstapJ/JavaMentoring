package com.epam.mentoring.labyrinth.businessobject;

import com.epam.mentoring.labyrinth.ConsoleUtility;
import com.epam.mentoring.labyrinth.Observer;
import com.epam.mentoring.labyrinth.exception.OutOfLabyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Serves as a observe to the {@link Duck } class. It implements 'Observer' pattern.
 * <p>The class doesn't know anything about Duck class, it just takes the coordinates to display
 * on the labyrinth table
 *
 * @author Ievgen Ostapenko
 */
public class Labyrinth implements Observer {

    private String labyrinth;
    private Object[][] labyrinthRepresentation;
    private int currentY;
    private int currentX;
    private int stepAmount;
    ConsoleUtility consoleUtility = new ConsoleUtility();

    /**
     * Creates Labyrinth instance based on given txt file.
     * @param filePath
     */
    public Labyrinth(String filePath) {
        try {
            Scanner file = new Scanner(new File(filePath));
            StringBuilder sb = new StringBuilder();
            while (file.hasNext()) {
                sb.append(file.nextLine());
            }
            labyrinth = sb.toString();
        }
        catch (FileNotFoundException ex){
            throw new RuntimeException("Unable to find the file by " + filePath, ex);
        }
    }

    /**
     * Listens the count of step
     * @param stepAmount
     */
    public void setStepCount(int stepAmount){
        this.stepAmount = stepAmount;
    }

    /**
     * Listens the the current position and displays it on the labyrinth table
     * @param y
     * @param x
     */
    public void setCoordinates(int y, int x) {
        long startTime = System.currentTimeMillis();
        int finalY = currentY + y;
        int finalX = currentX + x;
        try {
            if (labyrinthRepresentation[finalY][finalX].equals('1')) {
                System.out.println("Here is a wall! Please choose the right direction!");
            } else if (labyrinthRepresentation[finalY][finalX].equals('X')) {
                long finishTime = System.currentTimeMillis() - startTime;
                System.out.println(String.format("Congratulations!!! you have reached the end!\nYou spent the %d steps." +
                        "\nThe %s seconds is spent", stepAmount, finishTime/1000));
            } else {
                labyrinthRepresentation[finalY][finalX] = '@';
                labyrinthRepresentation[currentY][currentX] = 0;
                consoleUtility.clearConsole();
                consoleUtility.printToConsole(labyrinthRepresentation);
                currentY = finalY;
                currentX = finalX;
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new OutOfLabyrinth("Wasted! You are fallen down from the labyrinth zone", ex);
        }
    }

    /**
     * Renders to the array[][] based on digit amount
     */
    public Object[][] normalize() {
        double size = Math.sqrt(labyrinth.length());
        int counter = 0;
        Object[][] labyrinthRepresentation = new Object[(int) size][(int) size];
        for (int i = 0; i < labyrinthRepresentation.length; i++) {
            for (int j = 0; j < labyrinthRepresentation[i].length; j++) {
                labyrinthRepresentation[i][j] = labyrinth.charAt(counter++);
            }
        }
        this.labyrinthRepresentation = labyrinthRepresentation;
        return labyrinthRepresentation;
    }
}
