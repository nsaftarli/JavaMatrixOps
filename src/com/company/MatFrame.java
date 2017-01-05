package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Nariman on 2016-12-31.
 */

public class MatFrame extends JFrame
{
    int x1, x2, y1, y2;
    public MatFrame()
    {
        JMenuBar bar;
        JMenu file;
        JMenu ops;
        JMenu diagnose;
        JMenuItem mult;
        JMenuItem showDims1;
        JMenuItem showDims2;
        JPanel panel;
        JButton mulButton, invButton, adjButton;


        bar = new JMenuBar();
            file = new JMenu("File");
            ops = new JMenu("Operations");
                mult = new JMenuItem("Multiply");
            ops.add(mult);
            diagnose = new JMenu("Diagnostics");
                showDims1 = new JMenuItem("Matrix 1 Dimensions");
                showDims2 = new JMenuItem("Matrix 2 Dimensions");
            diagnose.add(showDims1);
            diagnose.add(showDims2);
        bar.add(file);
        bar.add(ops);
        bar.add(diagnose);

        ActionListener multiplyListener = new MultiplyListener();
        mult.addActionListener(multiplyListener);

        MultiplyListener multListener = (MultiplyListener) multiplyListener;



        this.add(bar, BorderLayout.NORTH);
        


    }

}
