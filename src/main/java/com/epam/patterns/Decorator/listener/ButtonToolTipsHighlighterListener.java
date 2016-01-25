package com.epam.patterns.decorator.listener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class decorates the {@link ButtonToolTipsListener} and adds
 * functionality to highlight the buttons when cursor is hovered.
 *
 * @author Ievgen_Ostapenko
 */
public class ButtonToolTipsHighlighterListener implements MouseListener
{
	ButtonToolTipsListener buttonToolTipsListener;

	public ButtonToolTipsHighlighterListener(ButtonToolTipsListener buttonToolTipsListener)
	{
		this.buttonToolTipsListener = buttonToolTipsListener;
	}

	public void mouseClicked(MouseEvent e)
	{
		buttonToolTipsListener.mouseClicked(e);
	}

	public void mousePressed(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{
		buttonToolTipsListener.mouseEntered(e);
		String buttonName = e.getComponent().getName();
		buttonToolTipsListener.getButtonSet().get(buttonName).setBackground(Color.yellow);
	}

	public void mouseExited(MouseEvent e)
	{
		String buttonName = e.getComponent().getName();
		buttonToolTipsListener.getButtonSet().get(buttonName).setBackground(new Color(238, 238, 238));
	}
}
