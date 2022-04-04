package SubmittedJunk;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Shopkeeper
{

    public static void main(String[] args)
    {
        String receiptCode = "";
        Scanner fromKeyboard = new Scanner(System.in);

        // Get name and number of items
        System.out.println("What is the customer's name?");
        String customerName = fromKeyboard.nextLine();

        System.out.println("How many items did the customer purchase?");
        int itemsPurchased = fromKeyboard.nextInt();
        String[] items = new String[itemsPurchased];

        double total = 0;

        // Loop through for every item
        for (int i = 1; i <= itemsPurchased; i++)
        {
            // Do the correct suffix for numbers and get item names for item array
            if (i % 10 == 1 && i % 100 != 11)
                System.out.println("Enter the 1st item name.");
            else if (i % 10 == 2 && i % 100 != 12)
                System.out.println("Enter the 2nd item name.");
            else if (i % 10 == 3 && i % 100 != 13)
                System.out.println("Enter the 3rd item name.");
            else
                System.out.println("Enter the " + i + "th item name.");

            fromKeyboard.nextLine();
            items[i - 1] = fromKeyboard.nextLine();

            //Get the prices
            System.out.println("How much did this item cost?");
            total += fromKeyboard.nextDouble();
        }

        receiptCode += customerName.charAt(0);

        if(customerName.contains(" "))
            receiptCode += customerName.charAt(customerName.indexOf(" ") + 1);

        receiptCode += "" + itemsPurchased;

        for (int i = 0; i < items.length; i++)
        {
            receiptCode += items[i];

            if (i == items.length - 1)
                receiptCode += ":";
            else
                receiptCode += ",";
        }

        receiptCode += "" + total;
        System.out.println(receiptCode);
    }
}
