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
    MatrixFrame mFrame, adjFrame;
    JOptionPane sizePane;
    JButton adjButton;
    Scanner scanner;
    String sizes;
    //ArrayList<Integer> m1 = new ArrayList<Integer>();
    ArrayList<Integer> adjList = new ArrayList<Integer>();
    int matrows, matcols, x, y, msize;

    ArrayList<Integer> adjoint;


    public void actionPerformed(ActionEvent e)
    {
        getDimensions();
        if(matrows == matcols)
        {
            adjButton = new JButton("Adjoint");
            setMatrix();

            adjButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    for(int i = 0; i < msize; i++)
                    {
                        String textFieldVal = mFrame.getFields().get(i).getText();
                        scanner = new Scanner(textFieldVal);
                        //m1.add(scanner.nextInt());
                        mFrame.addNums(scanner.nextInt());

                    }
                    //ArrayList<Integer> adjoint = getAdj();
                    //adjFrame = getAdj();
                    getAdj();
                }
            });

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
        mFrame = new MatrixFrame(matrows, matcols, "Input");
        adjFrame = new MatrixFrame(matrows, matcols, "Adjoint");
        adjFrame.setVisible(false);
        mFrame.setSize(200,300);
        mFrame.setVisible(true);
        mFrame.add(adjButton, BorderLayout.SOUTH);
    }

    public void getAdj()
    {
        getCofactors();
    }

    public void getCofactors()
    {
        int index;
        for(int i = 0; i < matrows; i++)
        {
            for(int j = 0; j < matcols; j++)
            {
                index = mFrame.getNums().get(i * matcols + j);
                getSubmatrix(index, i, j);
            }
        }
        printAdj();
    }
    public void getSubmatrix(int index, int x, int y)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int n;
        for(int i = 0; i < matrows; i++)
        {
            for(int j = 0; j < matcols; j++)
            {
                n = mFrame.getNums().get(i * matcols + j);

                if(i != x && j != y)
                {
                    //System.out.println(n);
                    tempList.add(n);
                }


            }
        }
        if(tempList.size() == 4)
        {
            if((x + y) % 2 == 0)
            {
                adjList.add(tempList.get(0) * tempList.get(3) - tempList.get(1) * tempList.get(2));
            }
            else
            {
                adjList.add(-1 * (tempList.get(0) * tempList.get(3) - tempList.get(1) * tempList.get(2)));
            }
        }
        else
        {
            getSubmatrix(index, x ,y);
        }


    }
    public void printAdj()
    {
        for(int i = 0; i < adjList.size(); i++)
        {
            System.out.println(adjList.get(i));
        }
    }



}
