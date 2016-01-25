package com.epam.patterns.bridge;

import javax.swing.*;

/**
 * Базовый тип для зазличный реализаций "соединителей"
 */
public interface ComponentMerger
{
	void merge(String[][] array, JComponent component);
}
