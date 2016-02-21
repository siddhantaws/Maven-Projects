package com.manh.functional;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionListenerTest 
{
	public static void main(String[] args) 
	{
		 JButton testButton1 = new JButton("Click to call Anonymous ActionListener");
		 testButton1.addActionListener(e->{System.out.println("Button is clicked1") ;
		 System.out.println("Button is clicked2");
		 });
		 JFrame frame = new JFrame("Listener Test");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.add(testButton1, BorderLayout.WEST);
	     frame.pack();
	     frame.setVisible(true);
	}
}
