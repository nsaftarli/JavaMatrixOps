package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nariman on 2017-01-07.
 */
public class AdjointListener implements ActionListener
{
    MatrixFrame mFrame;
    JOptionPane sizePane;
    JButton adj;
    Scanner scanner;
    String sizes;
    ArrayList<Integer> m1 = new ArrayList<Integer>();
    int matrows, matcols, x, y, msize;

    public void actionPerformed(ActionEvent e)
    {
        getDimensions();
        if(matrows == matcols)
        {
            adj = new JButton("Adjoint");
            setMatrix();
            setListener();

        }
        else
        {
            System.out.println("Error: Matrix must be square");
        }

    }
    public void getDimensions()
    {
        sizePane = new JOptionPane();
        sizes = sizePane.showInputDialog("Enter size of Matrix 1 separated by a comma (rows,columns)");
        scanner = new Scanner(sizes).useDelimiter(",");
        matrows = scanner.nextInt();
        matcols = scanner.nextInt();
        msize = matrows * matcols;
    }
    public void setMatrix()
    {
        mFrame = new MatrixFrame(matrows, matcols, "Matrix");
        mFrame.setSize(200,300);
        mFrame.setVisible(true);
        mFrame.add(adj, BorderLayout.SOUTH);
    }
    public void setListener()
    {
        adj.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i < msize; i++)
                {
                    String textFieldVal = mFrame.getFields().get(i).getText();
                    scanner = new Scanner(textFieldVal);
                    m1.add(scanner.nextInt());
                    ArrayList<Integer> adjoint = getAdj();
                }
            }
        });
    }

    public ArrayList<Integer> getAdj()
    {
        ArrayList<Integer> adjoint = new ArrayList<Integer>();
        for(int i = 0; i < matrows; i++)
        {
            for(int j = 0; j < matcols; j++)
            {
                int x = m1.get(i*matcols + j);
            }
        }
        return adjoint;
    }

}
