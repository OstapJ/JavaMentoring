package com.epam.mentoring.labyrinth.businessobject;

import com.epam.mentoring.labyrinth.*;
import com.epam.mentoring.labyrinth.behaviour.FlyBehaviour;
import com.epam.mentoring.labyrinth.behaviour.QuackBehaviour;
import com.epam.mentoring.labyrinth.state.AirState;
import com.epam.mentoring.labyrinth.state.DuckState;
import com.epam.mentoring.labyrinth.state.EarthState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class serves as a general type for all type of Ducks and
 * contains the common functionality.
 * <p/>
 * <p>The changable behaviour is taken out to make the system more flexible.
 * The {@link QuackBehaviour quackBehaviour} {@link FlyBehaviour quackBehaviour}.
 * It implements the 'Strategy' pattern.
 * <p/>
 * <p>This class serves as a subject to {@link Observer} interface.
 *
 * @author Ievgen Ostapenko
 */
public abstract class Duck implements Subject
{

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected QuackBehaviour quackBehaviour;
	protected FlyBehaviour flyBehaviour;
	protected DuckState state;
	protected int stepCount;
	protected boolean hungerIndicator;
	private List<Observer> observersList = new ArrayList<>();

	/**
	 * Registers the new observer
	 *
	 * @param observer
	 */
	public void registerObserver(Observer observer)
	{
		observersList.add(observer);
	}

	/**
	 * Removes the new observer
	 *
	 * @param observer
	 */
	public void removeObserver(Observer observer)
	{
		observersList.remove(observer);
	}

	/**
	 * Notifies the observes
	 *
	 * @param x
	 * @param y
	 */
	public void setCoordinates(int x, int y)
	{
		for (Observer observer : observersList)
		{
			observer.setCoordinates(x, y);
		}
	}

	/**
	 * Notifies the observes
	 *
	 * @param stepCount
	 */
	public void setStepCount(int stepCount)
	{
		for (Observer observer : observersList)
		{
			observer.setStepCount(stepCount);
		}
	}

	/**
	 * Sets the state to the current instance
	 *
	 * @param state
	 */
	public void setState(DuckState state)
	{
		this.state = state;
	}

	/**
	 * Performs the movement up if hungerIndicator is false and
	 * does nothing if is true. Notifies the observer about the movement.
	 */
	public void moveUp()
	{
		if (!hungerIndicator)
		{
			setStepCount(++stepCount);
			notifyThatDuckIsHungry();
			setCoordinates(-1, 0);
		}
	}

	/**
	 * Performs the movement down if hungerIndicator is false and
	 * does nothing if is true. Notifies the observer about the movement.
	 */
	public void moveDown()
	{
		if (!hungerIndicator)
		{
			setStepCount(++stepCount);
			notifyThatDuckIsHungry();
			setCoordinates(1, 0);
		}
	}

	/**
	 * Performs the movement left if hungerIndicator is false and
	 * does nothing if is true. Notifies the observer about the movement.
	 */
	public void moveLeft()
	{
		if (!hungerIndicator)
		{
			setStepCount(++stepCount);
			notifyThatDuckIsHungry();
			setCoordinates(0, -1);
		}
	}

	/**
	 * Performs the movement right if hungerIndicator is false and
	 * does nothing if is true. Notifies the observer about the movement.
	 */
	public void moveRight()
	{
		if (!hungerIndicator)
		{
			setStepCount(++stepCount);
			notifyThatDuckIsHungry();
			setCoordinates(0, 1);
		}
	}

	/**
	 * Performs the Quack
	 */
	public void performQuack()
	{
		quackBehaviour.quack();
	}

	/**
	 * Performs the Fly and set according state to the Duck
	 */
	public void performFly()
	{
		flyBehaviour.fly();
		setState(new AirState());
	}

	/**
	 * Performs the Walk and set according state to the Duck
	 */
	public void performWalk()
	{
		logger.info("Walk");
		setState(new EarthState());
	}

	/**
	 * Notifies when the duck is hungry
	 */
	public abstract void notifyThatDuckIsHungry();

	/**
	 * Performs the feed depending on the state of the Duck
	 */
	public abstract void performFeed();
}
