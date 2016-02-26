package com.epam.mentoring.memory.task07;

import javassist.ClassPool;

/**
 * The goal is to reach a java.lang.OutOfMemoryError: Metaspace. Load classes continuously and make them stay in memory.
 * <p>
 * We iterate through infinity loop and load new class definitions which are stored in the Permanent Generation memory domain.
 * To observe the perm gen curve the VisualVm is being used.
 * In order to start we should configure the Heap structure: 3-Eden, 3-S0, 3-S1, 1m to thread stack. Project source code is Java 8
 * VM options:-Xms60m -Xmx60m -Xmn30m -Xss10m -XX:SurvivorRatio=1 -XX:-UseGCOverheadLimit
 * Investigated with different collectors:
 * 1.Serial Collector = -XX:+UseSerialGC
 * 2.Parallel Collector = -XX:+UseParallelGC
 * 3.Parallel Old Collector = -XX:-UseParallelOldGC
 * 4.Concurrent Mark Sweep (CMS) Collector  with 2 Parallel CMS Threads = -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2
 * 5.G1 Garbage Collector = -XX:+UseG1GC
 */
public class MetaspaceErrorRunner
{
	public static void main(String[] args) throws Exception
	{
		for (int i = 0;; i++)
		{
			create("com.epam.mentoring.NewClass" + i);
			System.out.println("com.epam.mentoring.NewClass" + i);
		}
	}

	public static Class create(String name) throws Exception
	{
		ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(name).toClass();
	}
}
