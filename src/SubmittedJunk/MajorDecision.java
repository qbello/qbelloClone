package SubmittedJunk;

import java.util.Scanner;

/**
 * A major decision assistance program.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 04 -- Challenge
 *
 * @author Quintin Bello
 * @version February 7, 2022
 */

public class MajorDecision {
    public static final String WELCOME_MESSAGE = "Hi! SubmittedJunk.Welcome to the major decider. Answer \"Yes\" or \"No\" to " +
            "our questions.";
    public static final String ALREADY_KNOW = "Do you know which major you want?";
    public static final String MATH = "Do you like math?";
    public static final String PEOPLE = "Do you like talking to people?";
    public static final String TEACHING = "Do you like teaching?";
    public static final String SCIENCES = "Do you like the sciences?";
    public static final String MONEY = "Do you think of ways to make money?";
    public static final String LANGUAGES = "Do you like languages?";
    public static final String ENGLISH = "Do you like English?";
    public static final String COMPUTERS = "Do you like using computers?";
    public static final String BUILDING = "Do you like building things?";
    public static final String GOODBYE_MESSAGE = "Thank you. Goodbye.";

    // ------------------------- DO NOT MODIFY ABOVE -------------------------

    // IMPLEMENT YOUR SOLUTION HERE

    public static void main(String[] args)
    {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ALREADY_KNOW);

        Scanner fb = new Scanner(System.in);

        String in = fb.nextLine();

        if(in.compareTo("Yes") == 0)
        {
            System.out.println(GOODBYE_MESSAGE);
        }
        else
        {
            System.out.println(MATH);
            in = fb.nextLine();

            if(in.compareTo("Yes") == 0)
            {
                System.out.println(COMPUTERS);
                in = fb.nextLine();

                if(in.compareTo("Yes") == 0)
                    System.out.println("Computer Science");
                else
                {
                    System.out.println(BUILDING);
                    in = fb.nextLine();

                    if(in.compareTo("Yes") == 0)
                        System.out.println("Engineering");
                    else
                    {
                        System.out.println(SCIENCES);
                        in = fb.nextLine();

                        if(in.compareTo("Yes") == 0)
                            System.out.println("Natural Sciences");
                        else
                            System.out.println("Math");
                    }
                }
            }
            else
            {
                System.out.println(PEOPLE);
                in = fb.nextLine();

                if(in.compareTo("Yes") == 0)
                {
                    System.out.println(TEACHING);
                    in = fb.nextLine();

                    if(in.compareTo("Yes") == 0)
                        System.out.println("Education");
                    else
                    {
                        System.out.println(SCIENCES);
                        in = fb.nextLine();

                        if(in.compareTo("Yes") == 0)
                            System.out.println("Medicine");
                        else
                        {
                            System.out.println(MONEY);
                            in = fb.nextLine();

                            if(in.compareTo("Yes") == 0)
                                System.out.println("Business");
                            else
                                System.out.println("Psychology");
                        }
                    }
                }
                else
                {
                    System.out.println(LANGUAGES);
                    in = fb.nextLine();

                    if(in.compareTo("Yes") == 0)
                    {
                        System.out.println(ENGLISH);
                        in = fb.nextLine();

                        if(in.compareTo("Yes") == 0)
                            System.out.println("English");
                        else
                            System.out.println("Foreign Languages");
                    }
                    else
                        System.out.println("Art");
                }
            }
        }
    }

}
