package SubmittedJunk;

import java.util.ArrayList;

public class Car implements Vehicle
{
    private final String vehicleName;
    private final int costPerMile;
    private int maximumSpots;
    private int seatsTaken;

    public Car(String vehicleName, int maximumSpots, int costPerMile)
    {
        if (vehicleName == null)
            throw new NullPointerException();

        if (maximumSpots < 0)
            throw new IllegalArgumentException();

        this.vehicleName = vehicleName;
        this.costPerMile = costPerMile;
        this.maximumSpots = maximumSpots;
        seatsTaken = 0;
    }

    public int getNumSpotsAvailable()
    {
        return maximumSpots - seatsTaken;
    }

    public String getVehicleName()
    {
        return vehicleName;
    }

    public boolean hasWheels()
    {
        return true;
    }

    public boolean addPassenger()
    {
        if (seatsTaken < maximumSpots)
        {
            seatsTaken++;
            return true;
        }

        return false;
    }

    public boolean hasRudder()
    {
        return false;
    }

    public double calculateTravelCost(int miles)
    {
        return (double) miles * (double) costPerMile;
    }

    public int getMaxPassengers()
    {
        return maximumSpots;
    }

    public String[] findSimilarVehicles(Vehicle[] vehicleList, int maximumDelta)
    {
        ArrayList<String> matches = new ArrayList<>();

        for (Vehicle vehicle : vehicleList)
            if (vehicle instanceof Car)
                if (Math.abs(((Car) vehicle).maximumSpots - maximumSpots) <= maximumDelta)
                    matches.add(vehicle.getVehicleName());

        return matches.toArray(new String[matches.size()]);
    }
}
