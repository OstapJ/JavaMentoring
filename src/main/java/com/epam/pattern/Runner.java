package com.epam.pattern;

import com.epam.pattern.listeners.ButtonClickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Ievgen_Ostapenko on 12/21/2015.
 */
public class Runner
{
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public Runner()
	{
		prepareGUI();
	}

	public static void main(String[] args)
	{
		Runner Runner = new Runner();
		Runner.showEventDemo();
	}

	private void prepareGUI()
	{
		mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(350, 100);
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showEventDemo()
	{
		headerLabel.setText("Control in action: Button");

		JButton okButton = new JButton("OK");
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");

		okButton.addActionListener(new ButtonClickListener(statusLabel));
		submitButton.addActionListener(new ButtonClickListener(statusLabel));
		cancelButton.addActionListener(new ButtonClickListener(statusLabel));

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);

		mainFrame.setVisible(true);
	}
}
