package SubmittedJunk;

import java.util.Scanner;

/**
 * A class that keeps time
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2
 *
 * @author Quintin Bello
 * @version March 2, 2022
 */

public class TimeKeeper
{

    private static String welcomePrompt = "Welcome to the SubmittedJunk.TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for SubmittedJunk.Lab ";
    private static String enterLabLocation = "Enter the location for SubmittedJunk.Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current SubmittedJunk.Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using SubmittedJunk.TimeKeeper!";

    private static Scanner fromKeyboard = new Scanner(System.in);
    private static TimeKeeper intWomDay = new TimeKeeper(fromKeyboard);


    public static void main(String[] args)
    {
        System.out.println(welcomePrompt);
        System.out.println(initializeMenu);

        fromKeyboard = new Scanner(System.in);
        int input = Integer.parseInt(fromKeyboard.nextLine());

        boolean isKeepingTime = true;

        while (isKeepingTime)
        {
            while (input != 1 && input != 2)
            {
                System.out.println(invalidInput);
                System.out.println(initializeMenu);
                input = Integer.parseInt(fromKeyboard.nextLine());
            }

            if (input == 1)
                intWomDay.init();

            isKeepingTime = false;
        }

        System.out.println(exitMessage);

    }

    public TimeKeeper(Scanner scanner)
    {
        try
        {
            fromKeyboard = scanner;
        } catch (AssertionError e)
        {
            e.printStackTrace();
        }
    }

    public LabManager init()
    {
        Lab[] labs = {new Lab(0, ""), new Lab(0, ""), new Lab(0, "")};

        for (int  i = 1; i <= 3; i++)
        {
            System.out.println(enterLabCapacity + i + ":");
            labs[i - 1].setCapacity(Integer.parseInt(fromKeyboard.nextLine()));
            System.out.println(enterLabLocation + i + ":");
            labs[i - 1].setLocation(fromKeyboard.nextLine());
        }

        System.out.println(ongoingMenu);
        return intWomDay.menu(Integer.parseInt(fromKeyboard.nextLine()), new LabManager(labs[0], labs[1], labs[2]));
    }

    public LabManager menu(int choice, LabManager manager)
    {
        boolean isKeepingTime = true;

        while (isKeepingTime)
        {
            switch (choice) {
                case 1:
                    System.out.println(manager.getLabOne().toString());
                    System.out.println(manager.getLabTwo().toString());
                    System.out.println(manager.getLabThree().toString());
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 2:
                    System.out.println(manager.listAvailableLabs());
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 3:
                    System.out.println(manager.listReservedLabs());
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 4:
                    manager = intWomDay.addRes(manager);
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 5:
                    manager = intWomDay.remRes(manager);
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 6:
                    manager = intWomDay.modRes(manager);
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 7:
                    intWomDay.calcStats(manager);
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
                case 8:
                    isKeepingTime = false;
                    break;
                default:
                    System.out.println(invalidInput);
                    System.out.println(ongoingMenu);
                    choice = Integer.parseInt(fromKeyboard.nextLine());
                    break;
            }
        }

        return manager;
    }

    private LabManager calcStats(LabManager manager)
    {
        System.out.println(statisticsMenu);
        int input = Integer.parseInt(fromKeyboard.nextLine());

        while (input != 4)
        {
            switch (input) {
                case 1:
                    System.out.println("Total Capacity: " + manager.calculateTotalCapacity());
                    break;
                case 2:
                    System.out.println("Total Utilization: " + manager.calculateTotalUtilization());
                    break;
                case 3:
                    System.out.println("Available seats: " + manager.calculateAvailableSeats());
                    break;
                default:
                    System.out.println(invalidInput);
            }

            System.out.println(statisticsMenu);
            input = Integer.parseInt(fromKeyboard.nextLine());
        }

        return manager;
    }

    private LabManager modRes(LabManager manager)
    {
        System.out.println(labLocationPrompt);
        String loc = fromKeyboard.nextLine();
        System.out.println(reservationTimePrompt);
        String tim = fromKeyboard.nextLine();
        System.out.println(reservationNameUpdate);
        String nam = fromKeyboard.nextLine();
        System.out.println(reservationEnrollmentUpdate);
        int rol = Integer.parseInt(fromKeyboard.nextLine());
        System.out.println(manager.modifyReservation(loc, tim, nam, rol));
        return manager;
    }

    private LabManager remRes(LabManager manager)
    {
        System.out.println(labLocationPrompt);
        String loc = fromKeyboard.nextLine();
        System.out.println(reservationTimePrompt);
        String tim = fromKeyboard.nextLine();
        System.out.println(manager.removeReservation(loc, tim));
        return manager;
    }

    private LabManager addRes(LabManager manager)
    {
        System.out.println(labLocationPrompt);
        String loc = fromKeyboard.nextLine();
        System.out.println(reservationTimePrompt);
        String tim = fromKeyboard.nextLine();
        System.out.println(reservationNamePrompt);
        String nam = fromKeyboard.nextLine();
        System.out.println(reservationEnrollmentPrompt);
        int rol = Integer.parseInt(fromKeyboard.nextLine());
        System.out.println(manager.addReservation(loc, tim, nam, rol));
        return manager;
    }

}