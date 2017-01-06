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
    public MatFrame() {
        JMenuBar bar;
            JMenu file;
                JMenuItem close;
            JMenu ops;
                JMenuItem mult;

        bar = new JMenuBar();
            file = new JMenu("File");
                close = new JMenuItem("Quit");
            file.add(close);
            ops = new JMenu("Operations");
                mult = new JMenuItem("Multiply");
            ops.add(mult);
        bar.add(file);
        bar.add(ops);

        ActionListener multiplyListener = new MultiplyListener();
        mult.addActionListener(multiplyListener);



        class ExitListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        ActionListener exitListener = new ExitListener();
        close.addActionListener(exitListener);

        //MultiplyListener multListener = (MultiplyListener) multiplyListener;





        this.add(bar, BorderLayout.NORTH);



    }

}
