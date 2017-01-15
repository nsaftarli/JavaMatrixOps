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
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        adjHelper(tempList, 0);
    }

    public void adjHelper(ArrayList<Integer> list, int n)
    {
        int x;
        ArrayList<Integer> tempList;
        if(list.size() == mFrame.getNums().size())
        {
            return;
        }
        else if(list.size() == 4)
        {
            x = list.get(0) * list.get(3) - list.get(1) * list.get(2);
            adjFrame.addNums(x);
        }
        else
        {
            tempList = new ArrayList<Integer>();
            for(int i = 0; i < matcols; i++)
            {
                for(int j = 0; j < matrows; j++)
                {

                }
            }

        }


    }

}
