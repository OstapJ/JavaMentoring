package com.epam.patterns.bridge;

import javax.swing.*;

public class ComboBoxMerger implements ComponentMerger
{

	public void merge(String[][] array, JComponent component)
	{
		if(component instanceof JComboBox)
		{
			JComboBox comboBox = (JComboBox) component;
			for (String[] item : array)
			{
				int count = 0;
				comboBox.addItem(item[count]);
			}
		}
	}
}
