package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nariman on 2016-12-31.
 */
public class MultiplyListener implements ActionListener
{
    int mat1rows, mat1cols, mat2rows, mat2cols, size1, size2;
    Scanner scanner;
    String sizes;
    JButton mult;
    JOptionPane sizePane;
    MatrixFrame mFrame1, mFrame2;

    public void actionPerformed(ActionEvent e)
    {
        getDimensions();
        if(mat1cols == mat2rows)
        {
            mult = new JButton("Multiply");
            setMatrices();
        }
        else
        {
            System.out.println("Error: Mismatched matrix sizes.");
        }

        mult.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                for(int i = 0; i < size1; i++)
                {
                    String textFieldVal = mFrame1.getFields().get(i).getText();
                    Scanner scanner = new Scanner(textFieldVal);
                    mFrame1.addNums(scanner.nextInt());
                }
                for(int i = 0; i < size2; i++)
                {
                    String textFieldVal = mFrame2.getFields().get(i).getText();
                    Scanner scanner = new Scanner(textFieldVal);
                    mFrame2.addNums(scanner.nextInt());
                }
                ArrayList<Integer> m3 = matMult();
                getM3(m3);
            }
        });
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

    public void setMatrices()
    {
        mFrame1 = new MatrixFrame(mat1rows, mat1cols, "Matrix 1");
        mFrame2 = new MatrixFrame(mat2rows, mat2cols, "Matrix 2");
        mFrame1.setSize(200,300);
        mFrame2.setSize(200,300);
        mFrame1.setVisible(true);
        mFrame2.setVisible(true);
        mFrame2.setLocation(200,0);
        mFrame2.add(mult, BorderLayout.SOUTH);
    }

    public ArrayList<Integer> matMult()
    {
        ArrayList<Integer> m = new ArrayList<Integer>();
        //d = d + m1.get(a * mat1cols + c) * m2.get(c * mat2rows + b);
        for(int i = 0; i < mat1rows; i++)
        {

            for(int j = 0; j < mat2cols; j++)
            {
                int d = 0;

                for(int k = 0; k < mat2rows; k++)
                {
                    //int x = m1.get(i * mat1cols + k);
                    int x = mFrame1.getNums().get(i * mat1cols + k);
                    //int y = m2.get(k * mat2cols + j);
                    int y = mFrame2.getNums().get(k * mat2cols + j);
                    d += x*y;

                }
                m.add(d);
            }
        }
        return m;
    }



    public void getM3(ArrayList<Integer> m)
    {
        JFrame solFrame = new JFrame("Solution");
        JPanel solution = new JPanel();
        JPanel tempPanel;
        solution.setLayout(new GridLayout(mat1rows,mat2cols));
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat2cols; j++)
            {
                tempPanel = new JPanel();
                tempPanel.add(new JLabel("" + m.get(i*mat2cols + j)), BorderLayout.CENTER);
                solution.add(tempPanel);
            }
        }
        solFrame.add(solution, BorderLayout.CENTER);
        solFrame.setSize(300,400);
        solFrame.setVisible(true);
    }




}
