package com.epam.mentoring.labyrinth.exception;

/**
 * Custom exception to reflect precisely the business logic
 */
public class OutOfLabyrinth extends RuntimeException {

    public OutOfLabyrinth(String message, Throwable cause) {
        super(message, cause);
    }
}
