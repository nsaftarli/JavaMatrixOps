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
        //System.out.println(sizes);
        Scanner scanner = new Scanner(sizes).useDelimiter(",");
        mat1rows = scanner.nextInt();
        mat1cols = scanner.nextInt();
        sizes = sizePane.showInputDialog("Enter dimensions of matrix 2, separated by comma");
        scanner = new Scanner(sizes).useDelimiter(",");
        mat2rows = scanner.nextInt();
        mat2cols = scanner.nextInt();

        size1 = mat1rows * mat1cols;
        size2 = mat2rows * mat2cols;

       //System.out.println(x1);
        //System.out.println(y1);
        //System.out.println(x2);

        if(mat1cols == mat2rows)
        {
            frame1 = new JFrame("Matrix 1");
            frame2 = new JFrame("Matrix 2");
            fields = new ArrayList<JTextField>(size1 + size2);

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
                /*for(int i = 0; i < size1; i++)
                {
                    System.out.println(m1.get(i));
                }*/
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
                /*for(int i = 0; i < size2; i++)
                {
                    System.out.println(m2.get(i));
                }*/
                //matMult();
                //getM1();
                //getM2();
                ArrayList<Integer> m3 = matMult();
                getM3(m3);
            }
        });






    }

    /*public void matMult()
    {
        int a,b,c,d;
        ArrayList<Integer> tempMatrix = new ArrayList<Integer>();

        for(int i = 0; i < x1; i++)
        {
            for(int j = 0; j < y1; j++)
            {
                System.out.print(m1.get(i + j));
            }

        }
    }*/

    public ArrayList<Integer> matMult()
    {
        ArrayList<Integer> m3 = new ArrayList<Integer>();

        for(int a = 0; a < mat1rows; a++)
        {
            for(int b = 0; b < mat2cols; b++)
            {
                int d = 0;
                for(int c = 0; c < mat2rows; c++)
                {
                    d = d + m1.get(a * mat1cols + c) * m2.get(c * mat2rows + b);
                    //System.out.println(d);
                   //m3.add(d);
                }
                //System.out.println(d);
                m3.add(d);


            }
        }
        return m3;

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
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat2cols; j++)
            {
                System.out.println(m.get(i*mat2cols + j));
            }
        }
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
