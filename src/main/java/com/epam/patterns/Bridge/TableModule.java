package com.epam.patterns.bridge;

import javax.swing.table.AbstractTableModel;

public class TableModule extends AbstractTableModel
{
	private String[] columnNames = { "User Stories" };

	public TableModule(String[][] data)
	{
		this.data = data;
	}

	private String[][] data;



	public int getColumnCount()
	{
		return columnNames.length;
	}

	public int getRowCount()
	{
		return data.length;
	}

	public Object getValueAt(int row, int col)
	{
		return data[row][col];
	}

}
