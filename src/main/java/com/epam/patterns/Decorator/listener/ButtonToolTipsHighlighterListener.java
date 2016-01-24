package com.epam.patterns.Decorator.listener;

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

	@Override public void mouseClicked(MouseEvent e)
	{
		buttonToolTipsListener.mouseClicked(e);
	}

	@Override public void mousePressed(MouseEvent e)
	{

	}

	@Override public void mouseReleased(MouseEvent e)
	{

	}

	@Override public void mouseEntered(MouseEvent e)
	{
		buttonToolTipsListener.mouseEntered(e);
		String buttonName = e.getComponent().getName();
		buttonToolTipsListener.getButtonSet().get(buttonName).setBackground(Color.yellow);
	}

	@Override public void mouseExited(MouseEvent e)
	{
		String buttonName = e.getComponent().getName();
		buttonToolTipsListener.getButtonSet().get(buttonName).setBackground(new Color(238, 238, 238));
	}
}
