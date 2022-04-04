package SubmittedJunk;

import java.util.Scanner;

/**
 * A simple SubmittedJunk.SnowAccumulation class
 *
 * @author Quintin Bello
 * @version February 21, 2022
 */

public class SnowAccumulation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SubmittedJunk.Welcome!");
        System.out.println("Enter Resort One Name:");
        String resortOne = scanner.nextLine();
        System.out.println("Enter Resort Two Name:");
        String resortTwo = scanner.nextLine();
        System.out.println("Enter Snow Accumulations:");
        String accumulations = scanner.nextLine();
        System.out.println("Enter Report type:" +
                "\n1. Full" +
                "\n2. Summary");
        int reportType = scanner.nextInt();

        scanner.close();

        // The values of each of the accumulations are defined below,
        // you should use these double variables to make your calculations.
        // Each string has 7 paired values so the format of the string is resortOneDayOne
        // - resortTwoDayOne, resortOneDayTwo - resortTwoDayTwo, ...
        int currentStringIndex = 0;
        double resortOneDayOne = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDayOne = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDayTwo = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDayTwo = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDayThree = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDayThree = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDayFour = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDayFour = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDayFive = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDayFive = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDaySix = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDaySix = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf(",")));
        accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

        currentStringIndex = 0;
        double resortOneDaySeven = Double.parseDouble(accumulations.substring(currentStringIndex,
                accumulations.indexOf("-")));
        currentStringIndex += accumulations.indexOf("-") + 1;
        double resortTwoDaySeven = Double.parseDouble(accumulations.substring(currentStringIndex));

        // Do not modify above

        // ToDo: Implement your solution below.

        // Using arrays to save lines and initializing some counter variables
        double[] resort1 = {resortOneDayOne, resortOneDayTwo, resortOneDayThree, resortOneDayFour,
                            resortOneDayFive, resortOneDaySix, resortOneDaySeven};
        double[] resort2 = {resortTwoDayOne, resortTwoDayTwo, resortTwoDayThree, resortTwoDayFour,
                            resortTwoDayFive, resortTwoDaySix, resortTwoDaySeven};
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double totalAcc1 = 0;
        double totalAcc2 = 0;
        int resort1SnowierDays = 0;

        // Special Full report formatting
        if (reportType == 1)
            System.out.println(resortOne + " Full Report: ");

        for (int i = 0; i < 7; i++)
        {
            // print day of week plus formatted snowfall and add to total accumulation 1
            if (reportType == 1)
                System.out.printf(daysOfWeek[i] + ": %.2f\n", resort1[i]);

            totalAcc1 += resort1[i];

            // Keep track of who has more days with more accumulation
            if (resort1[i] > resort2[i])
                resort1SnowierDays++;
            else if (resort1[i] < resort2[i])
                resort1SnowierDays--;
        }

        // Second resort
        if (reportType == 1)
            System.out.println(resortTwo + " Full Report: ");

        for (int i = 0; i < 7; i++)
        {
            // same as above but for resort 2
            if (reportType == 1)
                System.out.printf(daysOfWeek[i] + ": %.2f\n", resort2[i]);

            totalAcc2 += resort2[i];
        }

        // Print the required print stuff
        System.out.printf("Total Accumulation: %.2f\n", totalAcc1 + totalAcc2);
        System.out.printf(resortOne + " Total Accumulation: %.2f\n", totalAcc1);
        System.out.printf(resortTwo + " Total Accumulation: %.2f\n", totalAcc2);
        System.out.printf(resortOne + " Average Accumulation: %.2f\n", totalAcc1 / 7.0);
        System.out.printf(resortTwo + " Average Accumulation: %.2f\n", totalAcc2 / 7.0);

        // Standard winner messages
        if (resort1SnowierDays > 0)
            System.out.println(resortOne + " had greater snowfall on more days than " + resortTwo + "!");
        if (resort1SnowierDays < 0)
            System.out.println(resortTwo + " had greater snowfall on more days than " + resortOne + "!");

        // Undisputed winner messages
        if (resort1SnowierDays == 7)
            System.out.println(resortOne + " is the undisputed winner!");
        if (resort1SnowierDays == -7)
            System.out.println(resortTwo + " is the undisputed winner!");
    }
}
