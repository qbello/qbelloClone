package SubmittedJunk;

import java.util.Scanner;

public class ReverseString
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input;

        do
        {
            System.out.println("Enter a string:");
            input = scanner.nextLine();

            for (int i = input.length() - 1; i >= 0; i--)
            {
                System.out.print(input.charAt(i));
            }

            System.out.println("\nAgain?");
            input = scanner.nextLine();
        }
        while (input.compareTo("Y") == 0);

    }
}
