package com.epam.patterns.bridge;

import javax.swing.*;

/**
 * Конкретная реализация
 */
public class MultiplyElementLabel extends CustomLabel
{
	public MultiplyElementLabel(ComponentMerger... mergers)
	{
		super(mergers);
	}

	@Override public void mergeValuesWithComponent(String[][] values, JComponent component)
	{
		for (ComponentMerger merger : mergers)
		{
			merger.merge(values, component);
		}

	}
}
