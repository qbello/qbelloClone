package SubmittedJunk;

import java.util.Scanner;

/**
 * A Food Truck order program.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 04 -- Debugging
 *
 * @author Quintin Bello
 * @version February 2, 2022
 */

public class FoodTruck
{
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to place an order? (yes or no)");
        String orderStatus = scanner.nextLine();

        String category = "";
        String cookMethod = "";
        String dish = "";

        if (orderStatus.compareTo("no") == 0)
        {
            System.out.println("Okay, have a nice day!");
        }
        else if (orderStatus.compareTo("yes") == 0)
        {
            System.out.println("What would you like to order?");

            System.out.println("1. Lamb");
            System.out.println("2. Pork");
            System.out.println("3. Chicken");
            System.out.println("4. Vegetables");

            int selection = scanner.nextInt();

            switch (selection)
            {
                case 1:
                    category = "Lamb";
                    break;
                case 2:
                    category = "Pork";
                    break;
                case 3:
                    category = "Chicken";
                    break;
                case 4:
                    category = "Vegetables";
                    break;
                default:
                    System.out.println("Input Error! Valid menu options are from 1 - 4.");
                    System.out.println("We couldn't complete the order, sorry!");
            }

            if(selection > 0 && selection < 5)
            {
                System.out.println("How would you like it cooked?");
                System.out.println("1. Fried");
                System.out.println("2. Boiled");

                selection = scanner.nextInt();

                switch (selection)
                {
                    case 1:
                        cookMethod = "Fried";
                        break;
                    case 2:
                        cookMethod = "Boiled";
                        break;
                    default:
                        System.out.println("Input Error! Valid cooking options are 1 or 2.");
                        System.out.println("We couldn't complete the order, sorry!");
                }

                if (selection == 1 || selection == 2)
                {
                    dish = cookMethod + " " + category;
                    System.out.println("You have ordered " + dish + "!");
                }
            }
        }
        else
            System.out.println("Input Error! Valid options are yes or no.");

    }


}

