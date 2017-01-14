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
    public MatrixFrame(int rows, int cols, String title)
    {
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

    public ArrayList<JTextField> getFields()
    {
        return fields;
    }





}
