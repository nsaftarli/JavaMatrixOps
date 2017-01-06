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

    MatrixFrame mFrame1;
    MatrixFrame mFrame2;

    int mat1rows = -1;
    int mat1cols = -1;
    int mat2rows = -1;
    int mat2cols = -1;
    int size1;
    int size2;
    JButton save = new JButton("Multiply");
    JOptionPane sizePane;

    ArrayList<Integer> m1;
    ArrayList<Integer> m2;

    public void actionPerformed(ActionEvent e)
    {
        m1 = new ArrayList<Integer>();
        m2 = new ArrayList<Integer>();
        sizePane = new JOptionPane();
        String sizes = sizePane.showInputDialog("Enter dimensions of matrix 1, separated by comma");
        Scanner scanner = new Scanner(sizes).useDelimiter(",");
        mat1rows = scanner.nextInt();
        mat1cols = scanner.nextInt();
        sizes = sizePane.showInputDialog("Enter dimensions of matrix 2, separated by comma");
        scanner = new Scanner(sizes).useDelimiter(",");
        mat2rows = scanner.nextInt();
        mat2cols = scanner.nextInt();

        size1 = mat1rows * mat1cols;
        size2 = mat2rows * mat2cols;

        if(mat1cols == mat2rows)
        {
            mFrame1 = new MatrixFrame(mat1rows, mat1cols, "Matrix 1");
            mFrame2 = new MatrixFrame(mat2rows, mat2cols, "Matrix 2");
            mFrame1.setSize(200,300);
            mFrame2.setSize(200,300);
            mFrame1.setVisible(true);
            mFrame2.setVisible(true);
            mFrame2.setLocation(200, 0);
            mFrame2.add(save, BorderLayout.SOUTH);
        }
        else
        {
            System.out.println("Error: Mismatched matrix sizes.");
        }

        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                for(int i = 0; i < size1; i++)
                {
                    String textFieldVal = mFrame1.getFields().get(i).getText();
                    Scanner scanner = new Scanner(textFieldVal);
                    m1.add(scanner.nextInt());
                }
                for(int i = 0; i < size2; i++)
                {
                    String textFieldVal = mFrame2.getFields().get(i).getText();
                    Scanner scanner = new Scanner(textFieldVal);
                    m2.add(scanner.nextInt());
                }
                ArrayList<Integer> m3 = matMult();
                getM3(m3);
            }
        });
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
                    int x = m1.get(i * mat1cols + k);
                    int y = m2.get(k * mat2cols + j);
                    d += x*y;

                }
                m.add(d);
            }
        }
        return m;
    }

    public void getM1()
    {
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat1cols; j++)
            {
                System.out.println(m1.get(i*mat1cols + j));
            }

        }
    }
    public void getM2()
    {
        for(int i = 0; i < mat2rows; i++)
        {
            for(int j = 0; j < mat2cols; j++)
            {
                System.out.println(m2.get(i*mat2cols + j));
            }
        }
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
