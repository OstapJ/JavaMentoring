package com.epam.patterns.adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KanbanBoard extends JPanel
{
	private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
	private static final String MOVE_RIGHT_BUTTON_LABEL = "Move Right >>";
	private static final String MOVE_LEFT_BUTTON_LABEL = "<< Move Left";
	private static final String FIRST_COLUMN = "TODO";
	private static final String SECOND_COLUMN = "In Progress";
	private static final String THIRD_COLUMN = "Done";

	private JLabel toDoLabel;
	private JList toDoList;
	private SortedListModel toDoListModel;

	private JLabel inProgressLabel;
	private JList inProgressList;
	private SortedListModel inProgressListModel;

	private JLabel doneLabel;
	private JList doneList;
	private SortedListModel doneListModel;

	private JButton moveRight;
	private JButton moveLeft;

	public KanbanBoard()
	{
		initEmptyBoard();
	}

	public void addToDoElements(Object newValue[])
	{
		fillListModel(toDoListModel, newValue);
	}

	public void addToDoElement(Object newValue)
	{
		fillModel(toDoListModel, newValue);
	}

	public void addInProgressElement(Object newValue)
	{
		fillModel(inProgressListModel, newValue);
	}

	public void addDoneElement(Object newValue)
	{
		fillModel(doneListModel, newValue);
	}

	private void fillModel(SortedListModel model, Object newValues)
	{
		model.add(newValues);
	}

	private void fillListModel(SortedListModel model, Object[] newValues)
	{
		model.addAll(newValues);
	}

	private void clearSelectedItemInToDoColumn()
	{
		Object selected = toDoList.getSelectedValue();
		toDoListModel.removeElement(selected);
		toDoList.getSelectionModel().clearSelection();
	}

	private void clearSelectedItemInProgressColumn()
	{
		Object selected = inProgressList.getSelectedValue();
		inProgressListModel.removeElement(selected);
		inProgressList.getSelectionModel().clearSelection();
	}

	private void clearSelectedItemInDoneColumn()
	{
		Object selected = doneList.getSelectedValue();
		doneListModel.removeElement(selected);
		doneList.getSelectionModel().clearSelection();
	}

	private void initEmptyBoard()
	{
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridBagLayout());
		toDoLabel = new JLabel(FIRST_COLUMN);
		toDoListModel = new SortedListModel();
		toDoList = new JList(toDoListModel);
		add(toDoLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		add(new JScrollPane(toDoList), new GridBagConstraints(0, 1, 1, 5, .5,
				1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				EMPTY_INSETS, 0, 0));

		inProgressLabel = new JLabel(SECOND_COLUMN);
		inProgressListModel = new SortedListModel();
		inProgressList = new JList(inProgressListModel);
		add(inProgressLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		add(new JScrollPane(inProgressList), new GridBagConstraints(2, 1, 1, 5, .5,
				1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				EMPTY_INSETS, 0, 0));

		doneLabel = new JLabel(THIRD_COLUMN);
		doneListModel = new SortedListModel();
		doneList = new JList(doneListModel);
		add(doneLabel, new GridBagConstraints(4, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				EMPTY_INSETS, 0, 0));
		add(new JScrollPane(doneList), new GridBagConstraints(4, 1, 1, 5, .5,
				1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				EMPTY_INSETS, 0, 0));

		moveRight = new JButton(MOVE_RIGHT_BUTTON_LABEL);
		add(moveRight, new GridBagConstraints());
		moveRight.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				Object selected = toDoList.getSelectedValue();
				if (selected != null)
				{
					addInProgressElement(selected);
					clearSelectedItemInToDoColumn();
				}
				else if (inProgressList.getSelectedValue() != null)
				{
					addDoneElement(inProgressList.getSelectedValue());
					clearSelectedItemInProgressColumn();
				}
			}
		});
		moveLeft = new JButton(MOVE_LEFT_BUTTON_LABEL);
		add(moveLeft, new GridBagConstraints());
		moveLeft.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				Object selected = inProgressList.getSelectedValue();
				if (selected != null)
				{
					addToDoElement(selected);
					clearSelectedItemInProgressColumn();
				}
				else if (doneList.getSelectedValue() != null)
				{
					addInProgressElement(doneList.getSelectedValue());
					clearSelectedItemInDoneColumn();
				}
			}
		});
	}
}

