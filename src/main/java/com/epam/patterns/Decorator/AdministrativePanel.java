package com.epam.patterns.decorator;

import com.epam.patterns.decorator.listener.ButtonToolTipsHighlighterListener;
import com.epam.patterns.decorator.listener.ButtonToolTipsListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AdministrativePanel extends JPanel
{
	private static final String HOME_BUTTON = "Home";
	private static final String DASHBOARD_BUTTON = "Dashboard";
	private static final String CHARTS_BUTTON = "Charts";
	private static final String GALLERY_BUTTON = "Gallery";
	private JButton homeButton;
	private JButton dashboardButton;
	private JButton chartsButton;
	private JButton galleryButton;
	private HashMap<String, JButton> buttonSet = new HashMap<String, JButton>();

	private JLabel outputLabel;

	public AdministrativePanel()
	{
		initPanel();
	}

	private void initPanel()
	{
		setLayout(new FlowLayout());
		homeButton = new JButton(HOME_BUTTON);
		dashboardButton = new JButton(DASHBOARD_BUTTON);
		chartsButton = new JButton(CHARTS_BUTTON);
		galleryButton = new JButton(GALLERY_BUTTON);
		homeButton.setName(HOME_BUTTON);
		dashboardButton.setName(DASHBOARD_BUTTON);
		chartsButton.setName(CHARTS_BUTTON);
		galleryButton.setName(GALLERY_BUTTON);

		this.add(homeButton);
		this.add(dashboardButton);
		this.add(chartsButton);
		this.add(galleryButton);
		buttonSet.put(HOME_BUTTON, homeButton);
		buttonSet.put(DASHBOARD_BUTTON, dashboardButton);
		buttonSet.put(CHARTS_BUTTON, chartsButton);
		buttonSet.put(GALLERY_BUTTON, galleryButton);

		outputLabel = new JLabel("", JLabel.CENTER);
		outputLabel.setSize(150, 50);
		this.add(outputLabel);

		homeButton.addMouseListener(
				new ButtonToolTipsHighlighterListener(new ButtonToolTipsListener(outputLabel, buttonSet)));
		dashboardButton.addMouseListener(
				new ButtonToolTipsHighlighterListener(new ButtonToolTipsListener(outputLabel, buttonSet)));
		chartsButton.addMouseListener(
				new ButtonToolTipsHighlighterListener(new ButtonToolTipsListener(outputLabel, buttonSet)));
		galleryButton.addMouseListener(
				new ButtonToolTipsHighlighterListener(new ButtonToolTipsListener(outputLabel, buttonSet)));

	}
}

