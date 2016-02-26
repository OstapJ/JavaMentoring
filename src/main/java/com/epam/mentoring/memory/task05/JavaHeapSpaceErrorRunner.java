package com.epam.mentoring.memory.task05;

import com.epam.mentoring.memory.task03.Person;

import java.util.*;

/**
 * The goal is to reach a java.lang.OutOfMemoryError: Java heap space. Do not use arrays or collections.
 * <p/>
 * To observe the Java heap space curve the VisualVm is being used.
 * In order to reach the exception quickly please point the following VM options: -Xmx5m -XX:-UseGCOverheadLimit
 */
public class JavaHeapSpaceErrorRunner
{


	public static void main(String[] args)
	{
		String message= "";
		String result;

		while (true){
			result = message +  new Random().nextInt(10000000);
			System.out.println(message);
		}

	}

}