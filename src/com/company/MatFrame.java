package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                JMenuItem sum;
                JMenuItem adj;

        //Create general frame and menus
        bar = new JMenuBar();
            file = new JMenu("File");
                close = new JMenuItem("Quit");
            file.add(close);
            ops = new JMenu("Operations");
                mult = new JMenuItem("Multiply");
                sum = new JMenuItem("Add/Subtract");
                adj = new JMenuItem("Adjoint");
            ops.add(mult);
            ops.add(sum);
            ops.add(adj);
        bar.add(file);
        bar.add(ops);




        //Adds action listeners to the JMenuItems
        ActionListener multiplyListener = new MultiplyListener();
        mult.addActionListener(multiplyListener);

        ActionListener sumListener = new SumListener();
        sum.addActionListener(sumListener);

        ActionListener adjListener = new AdjointListener();
        adj.addActionListener(adjListener);




        class ExitListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        ActionListener exitListener = new ExitListener();
        close.addActionListener(exitListener);


        this.add(bar, BorderLayout.NORTH);



    }

}
