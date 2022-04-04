package SubmittedJunk;

import java.util.Scanner;

public class CarInfo
{
    public static void main(String[] args)
    {
        Scanner fromKeyboard = new Scanner(System.in);
        System.out.println("Enter car's make: ");
        String make = fromKeyboard.nextLine();
        System.out.println("Enter car's model: ");
        String model = fromKeyboard.nextLine();
        System.out.println("Enter car's highway and city MPG: ");
        int highwayMPG = fromKeyboard.nextInt();
        int cityMPG = fromKeyboard.nextInt();
        System.out.println("Enter car's ratings of performance and comfort: ");
        double perf = fromKeyboard.nextDouble();
        double comfort = fromKeyboard.nextDouble();

        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Highway MPG: " + highwayMPG);
        System.out.println("City MPG: " + cityMPG);
        System.out.printf("Performance Rating: %.1f\n", perf);
        System.out.printf("Comfort Rating: %.1f\n", comfort);
    }


}
