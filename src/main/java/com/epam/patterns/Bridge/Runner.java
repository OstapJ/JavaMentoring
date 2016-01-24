package com.epam.patterns.bridge;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Runner
{

	public static String[][] createUserStories(int amount)
	{
		String[][] data = new String[amount][1];
		for (int i = 0; i < amount; i++)
		{
			Arrays.fill(data[i], "User Story: AEEF-" + (i + 1));
		}
		return data;
	}

	public static void main(String[] args)
	{
		JFrame f = new JFrame("Multiply Element Label");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		CustomLabel multiplyElementLabel = new MultiplyElementLabel(new ComboBoxMerger(), new JTableMerger());
		JComboBox comboBox = new JComboBox();
		JTable table = new JTable();
		multiplyElementLabel.add(comboBox);
		multiplyElementLabel.add(table);
		multiplyElementLabel.mergeValuesWithComponent(createUserStories(20), comboBox);
		multiplyElementLabel.mergeValuesWithComponent(createUserStories(20), table);
		f.getContentPane().add(multiplyElementLabel, BorderLayout.CENTER);
		f.setSize(500, 500);
		f.setVisible(true);
	}
}
