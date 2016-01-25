package com.epam.patterns.bridge;

import javax.swing.*;

public class JTableMerger implements ComponentMerger
{

	public void merge(String[][] array, JComponent component)
	{
		if(component instanceof JTable)
		{
			JTable table = (JTable) component;
			table.setModel(new TableModule(array));
		}
	}}
