package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nariman on 2017-01-06.
 */
public class SumListener implements ActionListener
{
    MatrixFrame mFrame1, mFrame2;
    JOptionPane sizePane;
    JButton sum;
    Scanner scanner;
    String sizes;
    ArrayList<Integer> m1 = new ArrayList<Integer>();
    ArrayList<Integer> m2 = new ArrayList<Integer>();
    int mat1rows, mat1cols, mat2rows, mat2cols, size1, size2;

    public void actionPerformed(ActionEvent e)
    {
        getDimensions();

        if(mat1rows == mat2rows && mat1cols == mat2cols)
        {
            sum = new JButton("Add");
            setMatrices();

            sum.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    for(int i = 0; i < size1; i++)
                    {
                        String textFieldVal = mFrame1.getFields().get(i).getText();
                        scanner = new Scanner(textFieldVal);
                        m1.add(scanner.nextInt());
                    }
                    for(int i = 0; i < size1; i++)
                    {
                        String textFieldVal = mFrame2.getFields().get(i).getText();
                        scanner = new Scanner(textFieldVal);
                        m2.add(scanner.nextInt());
                    }
                    ArrayList<Integer> m3 = doSum();
                }

            });
        }
        else
        {
            System.out.println("Error: Mismatched matrix sizes.");
        }


    }
    public ArrayList<Integer> doSum()
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat1cols; j++)
            {

            }
        }
        return tempList;

    }

    public void getDimensions()
    {
        sizePane = new JOptionPane();
        sizes = sizePane.showInputDialog("Enter size of Matrix 1 separated by a comma (rows,columns)");
        scanner = new Scanner(sizes).useDelimiter(",");
        mat1rows = scanner.nextInt();
        mat1cols = scanner.nextInt();
        sizes = sizePane.showInputDialog("Enter size of Matrix 2 separated by a comma (rows, columns)");
        scanner = new Scanner(sizes).useDelimiter(",");
        mat2rows = scanner.nextInt();
        mat2cols = scanner.nextInt();
        size1 = mat1rows * mat1cols;
        size2 = mat2rows * mat2cols;
    }
    public int setMatrices()
    {
        mFrame1 = new MatrixFrame(mat1rows, mat1cols, "Matrix 1");
        mFrame2 = new MatrixFrame(mat2rows, mat2cols, "Matrix 2");
        mFrame1.setSize(200,300);
        mFrame2.setSize(200,300);
        mFrame1.setVisible(true);
        mFrame2.setVisible(true);
        mFrame2.setLocation(200,0);
        mFrame2.add(sum, BorderLayout.SOUTH);
        return 0;
    }
}
