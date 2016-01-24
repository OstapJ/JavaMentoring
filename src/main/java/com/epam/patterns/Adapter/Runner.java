package com.epam.patterns.adapter;

import javax.swing.*;
import java.awt.*;

public class Runner
{
	public static String[] createUserStories(int amount)
	{
		String[] array = new String[amount];

		for (int i = 0; i < amount; i++)
		{
			array[i] = "User Story: AEEF-" + (i + 1);
		}
		return array;
	}

	public static void main(String[] args)
	{
		JFrame f = new JFrame("Kanban Board");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		KanbanBoard kanbanBoard = new KanbanBoard();
		kanbanBoard.addToDoElements(createUserStories(20));
		f.getContentPane().add(kanbanBoard, BorderLayout.CENTER);
		f.setSize(1000, 500);
		f.setVisible(true);
	}

}
