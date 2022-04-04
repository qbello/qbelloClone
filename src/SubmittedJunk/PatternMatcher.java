package SubmittedJunk;

import java.util.Scanner;

/**
 * A pattern guessing program with three levels
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 05 -- Challenge
 *
 * @author Quintin Bello
 * @version February 9, 2022
 */

public class PatternMatcher
{

    public static void main(String[] args)
    {

        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";

        Scanner fb = new Scanner(System.in);
        int level;
        int start;
        int int1;
        int int2;
        int int3;
        String playAgain;

        do
        {
            do
            {
                System.out.println(chooseLevel);
                level = fb.nextInt();
            }
            while (level != 1 && level != 2 && level != 3);

            System.out.println(startNumber);
            start = fb.nextInt();

            if (level == 1)
            {
                System.out.println(nextThree);
                System.out.print(start);

                for (int i = 1; i < 4; i++)
                    System.out.print(" " + (start + 3 * i));

                System.out.println();
                int1 = fb.nextInt();
                int2 = fb.nextInt();
                int3 = fb.nextInt();

                if (int1 == start + 3 * 4 && int2 == start + 3 * 5 && int3 == start + 3 * 6)
                    System.out.println(congratulations);
                else
                    System.out.println(sorry);
            }

            if (level == 2)
            {
                System.out.println(nextThree);
                System.out.print(start);

                for (int i = 1; i < 4; i++)
                    System.out.print(" " + (int) (start * Math.pow(7, i)));

                System.out.println();
                int1 = fb.nextInt();
                int2 = fb.nextInt();
                int3 = fb.nextInt();

                if (int1 == start * Math.pow(7, 4) && int2 == start * Math.pow(7, 5) && int3 == start * Math.pow(7, 6))
                    System.out.println(congratulations);
                else
                    System.out.println(sorry);
            }

            if (level == 3)
            {
                System.out.println(nextThree);
                System.out.print((int) (Math.pow(start + 0, 3) - 1));

                for (int i = 1; i < 4; i++)
                    System.out.print(" " + (int) (Math.pow(start + i, 3) - 1));

                System.out.println();
                int1 = fb.nextInt();
                int2 = fb.nextInt();
                int3 = fb.nextInt();

                if (int1 == Math.pow(start + 4, 3) - 1 && int2 == Math.pow(start + 5, 3) - 1
                        && int3 == Math.pow(start + 6, 3) - 1)
                    System.out.println(congratulations);
                else
                    System.out.println(sorry);
            }

            fb.nextLine();
            System.out.println(again);
            playAgain = fb.nextLine();
        }
        while (playAgain.compareTo("y") == 0);

        System.out.println(ending);
    }
}
