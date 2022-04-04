package SubmittedJunk;

import java.util.Arrays;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Quintin Bello
 * @version February 23, 2022
 */

public class DrawX
{

    private int size;

    public DrawX(int size)
    {
        this.size = size;
    }

    public static void main(String[] args)
    {
        DrawX sample = new DrawX(9);

        char[][] testArray = sample.generateArray();

        for (int i = 0; i < testArray.length; i++)
            System.out.println(Arrays.toString(testArray[i]));
    }

    public char[][] generateArray()
    {

        char[][] xArray = new char[size][size];

        // TODO

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == j || i + j == size - 1)
                    xArray[i][j] = '*';
                else
                    xArray[i][j] = ' ';
            }
        }

        return xArray;
    }
}