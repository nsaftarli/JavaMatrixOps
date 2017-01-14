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
    //integers to keep track of matrix dimensions
    int mat1rows, mat1cols, mat2rows, mat2cols, size1, size2;
    //OptionPane to take size input, button to take a sum once matrices have been entered
    JOptionPane sizePane;
    JButton sum;
    //Scanner to read text fields of matrices
    Scanner scanner;
    //Temporary string to keep track of matrix sizes until scanned
    String sizes;
    //The final matrix object that will hold data associated with given matrices
    MatrixFrame mFrame1, mFrame2;

    public void actionPerformed(ActionEvent e)
    {
        //gets sizes to be used as matrices
        getDimensions();

        //checks to see that dimensions are appropriate
        if(mat1rows == mat2rows && mat1cols == mat2cols)
        {
            //creates instance of the JButton, and creates instances of matrices
            sum = new JButton("Add");
            setMatrices();

            //ActionListener for the button.
            //When button is pressed:
            //1. Loops through ArrayList of JTextFields in each matrix.
            //2. Takes the integer entry in each JTextField, and adds it to the ArrayList of integers.
            //Could probably be done better somehow.
            sum.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    for(int i = 0; i < size1; i++)
                    {
                        String textFieldVal = mFrame1.getFields().get(i).getText();
                        scanner = new Scanner(textFieldVal);
                        mFrame1.addNums(scanner.nextInt());

                    }
                    for(int i = 0; i < size1; i++)
                    {
                        String textFieldVal = mFrame2.getFields().get(i).getText();
                        scanner = new Scanner(textFieldVal);
                        mFrame2.addNums(scanner.nextInt());
                    }
                    //Creates a third ArrayList of integers, which is the sum of the two matrices.
                    ArrayList<Integer> m3 = doSum();
                    //Shows the third matrix
                    getM3(m3);
                }

            });
        }
        else
        {
            System.out.println("Error: Mismatched matrix sizes.");
        }


    }

    //Prompts for user input of matrix size.
    // Stores sizes as rows and columns, and individual areas for ease of access
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

    //Creates instances of matrices, called only if two matrices have the right dimensions
    //Sets locations and visibility of matrices
    public void setMatrices()
    {
        mFrame1 = new MatrixFrame(mat1rows, mat1cols, "Matrix 1");
        mFrame2 = new MatrixFrame(mat2rows, mat2cols, "Matrix 2");
        mFrame1.setSize(200,300);
        mFrame2.setSize(200,300);
        mFrame1.setVisible(true);
        mFrame2.setVisible(true);
        mFrame2.setLocation(200,0);
        mFrame2.add(sum, BorderLayout.SOUTH);
    }

    //Does sum of two matrices
    public ArrayList<Integer> doSum()
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int a,b;
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat1cols; j++)
            {
                //Adds numbers at appropriate indices to the temporary ArrayList
                a = mFrame1.getNums().get(i * mat1cols + j);
                b = mFrame2.getNums().get(i * mat1cols + j);
                tempList.add(a + b);
            }
        }
        return tempList;

    }

    public void getM3(ArrayList<Integer> m)
    {
        JFrame solFrame = new JFrame("Solution");
        JPanel solution = new JPanel();
        JPanel tempPanel;
        solution.setLayout(new GridLayout(mat1rows,mat1cols));
        for(int i = 0; i < mat1rows; i++)
        {
            for(int j = 0; j < mat1cols; j++)
            {
                tempPanel = new JPanel();
                tempPanel.add(new JLabel("" + m.get(i*mat1cols + j)), BorderLayout.CENTER);
                solution.add(tempPanel);
            }
        }
        solFrame.add(solution, BorderLayout.CENTER);
        solFrame.setSize(300,400);
        solFrame.setVisible(true);
    }
}
