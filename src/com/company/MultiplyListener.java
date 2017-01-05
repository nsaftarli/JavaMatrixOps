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

    int mat1rows = -1;
    int mat1cols = -1;
    int mat2rows = -1;
    int mat2cols = -1;
    int size1;
    int size2;
    JFrame frame1;
    JFrame frame2;
    JButton save1 = new JButton("Save Matrix 1");
    JButton save2 = new JButton("Save Matrix 2 and multiply");
    JPanel sizePanel = new JPanel();
    JOptionPane sizePane = new JOptionPane();

    ArrayList<Integer> m1 = new ArrayList<Integer>();
    ArrayList<Integer> m2 = new ArrayList<Integer>();
    ArrayList<JTextField> fields;

    public void actionPerformed(ActionEvent e)
    {
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

       /*System.out.println(mat1rows);
        System.out.println(mat1cols);
        System.out.println(mat2rows);
        System.out.println(mat2cols);*/

        if(mat1cols == mat2rows)
        {
            frame1 = new JFrame("Matrix 1");
            frame2 = new JFrame("Matrix 2");
            fields = new ArrayList<JTextField>();

            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridLayout(mat1rows,mat1cols));
            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(mat2rows,mat2cols));

            for(int i = 0; i < size1; i++)
            {
                fields.add(new JTextField());
                panel1.add(fields.get(i));
            }
            for(int i = 0 ; i < size2; i++)
            {
                fields.add(i + size1,new JTextField());
                panel2.add(fields.get(i+size1));
            }
            frame1.add(panel1, BorderLayout.CENTER);
            frame1.add(save1, BorderLayout.SOUTH);
            frame1.setSize(300,400);
            frame1.setVisible(true);
            frame2.add(panel2, BorderLayout.CENTER);
            frame2.add(save2, BorderLayout.SOUTH);
            frame2.setSize(300,400);
            frame2.setLocation(300, 0);
            frame2.setVisible(true);



        }
        else
        {
            System.out.println("Error: Mismatched matrix sizes.");
        }

        save1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i < size1; i++)
                {
                    String textFieldVal = fields.get(i).getText();
                    Scanner scanner = new Scanner(textFieldVal);
                    m1.add(scanner.nextInt());
                }
            }
        });

        save2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i < size2; i++)
                {
                    String textFieldVal = fields.get(i + size1).getText();
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
                   // System.out.println(x + "*" + y + "=" + (x*y));
                    d += x*y;

                }
                //System.out.println("d = " + d);
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
                //solution.add(new JLabel("" + m.get(i*mat2cols + j)));
                System.out.println(m.get(i*mat2cols + j));
                solution.add(tempPanel);
            }
        }
        solFrame.add(solution, BorderLayout.CENTER);
        solFrame.setSize(300,400);
        solFrame.setVisible(true);
    }

    public int getX()
    {
        return mat1rows;
    }

    public int getY()
    {
        return mat1cols;
    }


}
