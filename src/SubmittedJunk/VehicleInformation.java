package SubmittedJunk;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleInformation
{
    public static void main(String[] args)
    {
        Scanner fromKeyboard = new Scanner(System.in);
        System.out.println("Enter the input file name:");
        String filename = fromKeyboard.nextLine();

        String[] vehicles = readFile(filename);

        if (vehicles == null)
            System.out.println("The file doesn't exist!");
        else
        {
            System.out.println("Enter the output file name:");
            String outputFilename = fromKeyboard.nextLine();
            System.out.println("Enter the type of vehicle to sort by:");
            String vehicleType = fromKeyboard.nextLine();
            writeFile(vehicles, vehicleType, outputFilename);

            if (!writeFile(vehicles, vehicleType, outputFilename))
                System.out.println("There was an error writing to the file.");
            else
                System.out.println("The file was written to!");
        }
    }

    public static String[] readFile(String filename)
    {
        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        String[] vehicle;
        BufferedReader fromFile = null;

        try
        {
            fromFile = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e)
        {
            return null;
        }

        try
        {
            while ((line = fromFile.readLine()) != null)
            {
                lines.add(line);
            }
        } catch (IOException e)
        {
            return null;
        }

        return lines.toArray(new String[lines.size()]);
    }

    public static boolean writeFile(String[] vehicles, String filter, String filename)
    {
        PrintWriter writer = null;

        try
        {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        for (String vehicle : vehicles)
            if (vehicle.split(",")[1].compareTo(filter) == 0)
                writer.println(vehicle);

        writer.close();
        return true;
    }
}
