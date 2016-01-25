package com.epam.patterns.bridge;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ������������ ����� ���������� ���������� ��� ���� ����� �������.
 * ���������� � ���������� ��������� ������ � ���������� ���� �� �����.
 * ����������� ��������� {@Link ComponentMerger} ������� � �������� �����������.
 * ����� {@Link mergeValuesWithComponent} ����� �������������� �� ���� �������
 * ����������� � ������������� ������ ���������� � ����������� �� ����������� ComponentMerger
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
