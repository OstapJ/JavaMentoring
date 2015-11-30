package com.epam.mentoring.labyrinth;

/**
 * Interface serves as a hub to notify their observers
 *
 * @author Ievgen Ostapenko
 */
public interface Subject {
    void setCoordinates(int y, int x);
    void setStepCount(int stepCount);
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
