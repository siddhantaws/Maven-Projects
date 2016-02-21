package com.manh.lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionListenerTest {

    public static void main(String[] args) {

        JButton testButton1 = new JButton("Click to call Anonymous ActionListener");
        JButton testButton2 = new JButton("Click to call Lambda ActionListener");
        
        JButton testButton3 = new JButton("Click to call Siddhanta Lambda ActionListener");
        
        // Anonymous ActionListener
        testButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click Detected by Anonymous Listener");
            }
        });

        // Lambda ActionListener
        testButton2.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));

        testButton3.addActionListener(e->System.out.println("Click Detected by Siddhanta Lambda Listner"));
        
        // Swing stuff
        JFrame frame = new JFrame("Listener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(testButton1, BorderLayout.WEST);
        frame.add(testButton2, BorderLayout.EAST);
        frame.add(testButton3, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);

    }
}
