package com.epam.jmp.webdriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BrowserPool<T>
{

	private final BlockingQueue<T> browserQueue;
	private final ReentrantLock lock = new ReentrantLock();
	private int createdObjects = 0;
	private int size;
	private final static Logger LOGGER = LoggerFactory.getLogger(BrowserPool.class);

	protected BrowserPool(final int size)
	{
		this.size = size;
		browserQueue = new ArrayBlockingQueue<>(size, true);
		LOGGER.info("The '{}' browser pool is instantiated with '{}' Max size. Thread '{}' ID '{}'",
				this.getClass().getSimpleName(), this.size, Thread.currentThread().getName(),
				Thread.currentThread().getId());
	}

	public T borrow() throws Exception
	{
		if (!lock.isLocked())
		{
			if (lock.tryLock())
			{
				try
				{
					++createdObjects;
					LOGGER.info("We create a new instance. Amount of created instances is '{}' . Thread '{}' ID '{}'",
							createdObjects, Thread.currentThread().getName(), Thread.currentThread().getId());
					return createObject();
				}
				finally
				{
					if (createdObjects < size)
					{
						lock.unlock();
					}
					LOGGER.info("Created browsers size is '{}' Max size is '{}'. isLocked = '{}'. Thread '{}' ID '{}'",
							createdObjects, size, lock.isLocked(), Thread.currentThread().getName(),
							Thread.currentThread().getId());
				}
			}
		}
		LOGGER.info(
				" Amount of created instances is '{}' .That's why we will wait for the available browser instance to take from the pool. Thread '{}' ID '{}'",
				createdObjects, Thread.currentThread().getName(), Thread.currentThread().getId());
		return browserQueue.take();
	}

	public void returnBack(T resource) throws Exception
	{
		browserQueue.add(resource);
		LOGGER.info("The '{}' browser instance is returned into the pull. Pull size is '{}'. Thread '{}' ID '{}'",
				resource.getClass().getSimpleName(), size(), Thread.currentThread().getName(),
				Thread.currentThread().getId());
	}

	protected abstract T createObject();

	public int size() throws InterruptedException
	{
		return browserQueue.size();
	}
}
