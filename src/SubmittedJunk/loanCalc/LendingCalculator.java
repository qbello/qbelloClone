package SubmittedJunk.loanCalc;

import java.util.Scanner;

/**
 * A program that calculates values based on hypothetical loans from input from the user
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 06 -- Challenge
 *
 * @author Quintin Bello
 * @version February 16, 2022
 */

public class LendingCalculator
{

    // Main method
    public static void main(String[] args)
    {
        // Scanner to be used throughout
        Scanner scanner = new Scanner(System.in);
        int in;

        System.out.println("SubmittedJunk.Welcome to the Lending Calculator!");

        // Initial Menu Stage
        do
        {
            System.out.println("Menu");
            System.out.println("0. Quit");
            System.out.println("1. Add a loan");
            in = scanner.nextInt();

            if (in != 1 && in != 0)
                System.out.println("Error! Invalid input.");
        } while (in != 1 && in != 0);

        // If user selects to add a loan ...
        if (in == 1)
        {
            System.out.println("Enter the duration: ");
            int dur = scanner.nextInt();
            System.out.println("Enter the rate: ");
            double rate = scanner.nextDouble();
            System.out.println("Enter the amount: ");
            double amt = scanner.nextDouble();

            Loan loan = new Loan(dur, rate, amt);
            System.out.println(loan);

            // Ongoing Menu Stage
            do
            {
                System.out.println("Menu\n" +
                        "0. Quit\n" +
                        "1. Modify Loan\n" +
                        "2. Calculate Total Cost");

                in = scanner.nextInt();

                if (in == 1)
                {
                    System.out.println("Enter the duration: ");
                    dur = scanner.nextInt();
                    System.out.println("Enter the rate: ");
                    rate = scanner.nextDouble();
                    System.out.println("Enter the amount: ");
                    amt = scanner.nextDouble();

                    loan = new Loan(dur, rate, amt);
                    System.out.println(loan);
                }
                else if (in == 2)
                {
                    System.out.println("Would you like to print the amortization schedule?\n" +
                            "1. Yes\n" +
                            "2. No");

                    in = scanner.nextInt();
                    System.out.println("Total cost: " + String.format("%.2f",
                            (double) Math.round(loan.calculateTotalCost(in == 1) * 100) / 100));
                }


            } while (in == 1 || in == 2);
        }


        System.out.println("Thank you!");
    }

}
