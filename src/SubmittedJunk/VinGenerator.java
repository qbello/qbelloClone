package SubmittedJunk;

import java.util.Scanner;

/**
 * Vin Generator
 *
 * A program that takes input about a car then returns a summary of it as well as produces a VIN
 *
 * <p>Purdue University -- CS18000 -- Spring 2022 -- Homework 03 -- Challenge</p>
 *
 * @author Quintin Bello, L18
 * @version January 26, 2022
 */

// The SubmittedJunk.VinGenerator Class
public class VinGenerator
{
    // Main Method
    public static void main(String[] args)
    {
        // Initial variables used throughout the program
        String vin = "";
        Scanner fb = new Scanner(System.in);

        // Getting input and saving it in variables to be used later
        System.out.println("Make: ");
        String make = fb.nextLine();

        System.out.println("Model: ");
        String model = fb.nextLine();

        System.out.println("Model Year: ");
        int modelYear = fb.nextInt();

        System.out.println("New SubmittedJunk.Car?: ");
        boolean isNewCar = fb.nextBoolean();

        System.out.println("Avg. Rating: ");
        double avgRating = fb.nextDouble();

        System.out.println("Price: ");
        int price = fb.nextInt();
        fb.nextLine();

        System.out.println("Dealership: ");
        String dealer = fb.nextLine();

        System.out.println("Phone Number: ");
        String phoneNum = fb.nextLine();

        System.out.println("Serial Number: ");
        String serialNum = fb.nextLine();

        // getting specific parts of variables to make next section cleaner
        int make1 = (int) make.toUpperCase().charAt(0);
        int makeLast = (int) make.toUpperCase().charAt(make.length() - 1);
        int model1 = (int) model.toUpperCase().charAt(0);
        int modelLast = (int) model.toUpperCase().charAt(model.length() - 1);
        int serial1 = Integer.parseInt("" + serialNum.charAt(0));
        int serial2 = Integer.parseInt("" + serialNum.charAt(1));

        // generating the vin (+32 is for lowercase)
        vin += ("" + modelYear).substring(0, 2); // #1
        vin += (char) (make1 + serial1); // #2
        vin += (char) (makeLast + serial1); // #3
        vin += (char) (make1 + 32 + serial2); // #4
        vin += (char) (makeLast + 32 + serial2); // #5
        vin += (char) (model1 + serial1); // #6
        vin += (char) (modelLast + serial1); // #7
        vin += (char) (model1 + 32 + serial2); // #8
        vin += (char) (modelLast + 32 + serial2); // #9
        vin += ("" + serialNum).substring(("" + serialNum).length() - 4); // #10

        // printing results in proper formatting
        System.out.println(modelYear + " " + make + " " + model);
        System.out.println("New SubmittedJunk.Car?: " + isNewCar);
        System.out.printf("Avg. Rating: %.1f%n\n", avgRating);
        System.out.println("Price: $" + price);
        System.out.println("Dealership: " + dealer);
        System.out.println("Phone Number: (" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-"
                + phoneNum.substring(6));
        System.out.println("Serial Number: " + serialNum);
        System.out.println("VIN: " + vin);

    }

}
