package com.epam.patterns.decorator;

import javax.swing.*;
import java.awt.*;

public class Runner
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Administrative Panel");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(4, 1));
		AdministrativePanel administrativePanel = new AdministrativePanel();
		f.add(administrativePanel);
		f.setSize(400, 250);
		f.setVisible(true);
	}
}
