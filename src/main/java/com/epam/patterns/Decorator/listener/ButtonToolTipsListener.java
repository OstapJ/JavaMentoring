package com.epam.patterns.decorator.listener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class ButtonToolTipsListener implements MouseListener
{
	private static final String TOOL_TIP_MESSAGE = "Feel free to click the %s button";
	private static final String OUTPUT_MESSAGE = "The %s button is clicked";
	private String buttonName;
	private JLabel outputLabel;
	private HashMap<String, JButton> buttonSet;

	public HashMap<String, JButton> getButtonSet()
	{
		return buttonSet;
	}

	public ButtonToolTipsListener(JLabel outputLabel, HashMap<String, JButton> buttonSet)
	{
		this.outputLabel = outputLabel;
		this.buttonSet = buttonSet;
	}

	private String createToolTipMessageTemplate(String buttonName)
	{
		return String.format(TOOL_TIP_MESSAGE, buttonName);
	}

	public void mouseClicked(MouseEvent e)
	{
		outputLabel.setText(String.format(OUTPUT_MESSAGE, buttonName));
	}

	public void mousePressed(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{
		buttonName = e.getComponent().getName();
		buttonSet.get(buttonName).setToolTipText(createToolTipMessageTemplate(buttonName));
	}

	public void mouseExited(MouseEvent e)
	{

	}
}
