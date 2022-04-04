package SubmittedJunk;

import java.util.Scanner;

public class Scan
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Performance and Comfort ratings separated by a comma:");
        String line = scanner.nextLine();
        int id = line.indexOf(",");
        String performace = line.substring(0, id);
        String comfort = line.substring(id + 1);

        System.out.println("Performance Rating: " + performace);
        System.out.println("Comfort Rating: " + comfort);

        float avg = (Float.parseFloat(performace) + Float.parseFloat(comfort)) / 2;
        System.out.printf("Avg. Rating: %.3f\n", avg);

    }
}
