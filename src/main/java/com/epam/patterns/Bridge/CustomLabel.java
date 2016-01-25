package com.epam.patterns.bridge;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Предстовляет собой обобщенную абстракцию для всех типов панелей.
 * Абстракция и реализация разделены мостом и независимы друг от друга.
 * Конструктор принимает {@Link ComponentMerger} который и является реализацией.
 * Метод {@Link mergeValuesWithComponent} будет использваоться во всей классах
 * наследниках и предостовлять разную реализацию в зависимости от переданного ComponentMerger
 */
public abstract class CustomLabel extends JPanel
{
	protected List<ComponentMerger> mergers = new ArrayList<ComponentMerger>();

	public CustomLabel(ComponentMerger... mergers)
	{
		for (ComponentMerger arg : mergers)
		{
			this.mergers.add(arg);
		}
		init();
	}

	public abstract void mergeValuesWithComponent(String[][] values, JComponent component);
	protected void init(){
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridBagLayout());
	}
}
