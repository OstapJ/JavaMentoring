package com.epam.pattern.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ievgen_Ostapenko on 12/21/2015.
 */
public class ButtonClickListener implements ActionListener
{

	private JLabel statusLabel;
	public ButtonClickListener(JLabel statusLabel)
	{
		this.statusLabel = statusLabel;
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.equals("OK"))
		{
			statusLabel.setText("Ok Button clicked.");
		}
		else if (command.equals("Submit"))
		{
			statusLabel.setText("Submit Button clicked.");
		}
		else
		{
			statusLabel.setText("Cancel Button clicked.");
		}
	}
}