package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nariman on 2017-01-06.
 */
public class MatrixFrame extends JFrame
{
    ArrayList<JTextField> fields;
    ArrayList<Integer> nums = new ArrayList<Integer>();
    JPanel panel;
    int rows, cols, size;
    public MatrixFrame(int rows, int cols, String title)
    {
        this.rows = rows;
        this.cols = cols;
        size = rows * cols;
        fields = new ArrayList<JTextField>();
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        this.setTitle(title);
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                fields.add(new JTextField());
                panel.add(fields.get(i * cols + j));
            }
        }
        this.add(panel);
    }

    public void addNums(int x)
    {
        nums.add(x);
    }
    public ArrayList<Integer> getNums()
    {
        return nums;
    }
    public int getAt(int x)
    {
        return nums.get(x);
    }
    public int getRows()
    {
        return rows;
    }
    public int getCols()
    {
        return cols;
    }
    public int retSize()
    {
        return size;
    }


    public ArrayList<JTextField> getFields()
    {
        return fields;
    }





}
