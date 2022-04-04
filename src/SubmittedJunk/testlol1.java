package SubmittedJunk;

import SubmittedJunk.Boat;
import SubmittedJunk.Car;
import SubmittedJunk.Vehicle;

public class testlol1
{
    public static void main(String[] args)
    {
        Vehicle[] vehicles = {new Car("Lexus", 4, 1),
                new Boat("Boat1", 10, 4),
                new Car("Car1", 5, 2),
                new Boat("Boat2", 12, 5),
                new Car("Car2", 8, 3),
                new Boat("Boat3", 30, 12)};

        String[] simToCar = vehicles[0].findSimilarVehicles(vehicles, 3);

        for (String str : simToCar)
            System.out.println(str);

        System.out.println();

        String[] simToBoat = vehicles[1].findSimilarVehicles(vehicles, 5);

        for (String str : simToBoat)
            System.out.println(str);
    }
}
