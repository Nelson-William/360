package edu.nelson.mvc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import JosAertsBeans.*;


public class AgeView extends JPanel {
	
	private JLabel labelYear = new JLabel("Enter birth year: ");
	private JLabel labelMonth = new JLabel("Enter birth month: ");
	private JLabel labelDay = new JLabel("Enter birth day: ");
	private JNumberField yearField = new JNumberField(4);
	private JNumberField monthField = new JNumberField(2);
	private JNumberField dayField = new JNumberField(2);
	private JButton calculateButton = new JButton("Calculate");
	
	public AgeView() {
		
		JPanel newPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(labelYear, constraints);
		
		constraints.gridx = 1;
		newPanel.add(yearField, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(labelMonth, constraints);
		
		constraints.gridx = 1;
		newPanel.add(monthField, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		newPanel.add(labelDay, constraints);
		
		constraints.gridx = 1;
		newPanel.add(dayField, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(calculateButton, constraints);
	}

}
