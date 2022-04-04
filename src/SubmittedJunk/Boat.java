package SubmittedJunk;

import java.util.ArrayList;

public class Boat implements Vehicle
{

    private final String vehicleName;
    private final int costPerMile;
    private int maximumSpots;
    private int seatsTaken;

    public Boat(String vehicleName, int maximumSpots, int costPerMile)
    {
        seatsTaken = 1;

        if (vehicleName == null)
            throw new NullPointerException();

        if (maximumSpots < 0)
            throw new IllegalArgumentException();

        this.vehicleName = vehicleName;
        this.costPerMile = costPerMile;
        this.maximumSpots = maximumSpots;
    }

    public int getNumSpotsAvailable()
    {
        return maximumSpots - seatsTaken;
    }

    public String getVehicleName()
    {
        return vehicleName;
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

    public boolean hasWheels()
    {
        return false;
    }

    public boolean hasRudder()
    {
        return true;
    }

    public double calculateTravelCost(int miles)
    {
        return (double) miles * (double) costPerMile * 1.8;
    }

    public int getMaxPassengers()
    {
        return maximumSpots;
    }

    public String[] findSimilarVehicles(Vehicle[] vehicleList, int maximumDelta)
    {
        ArrayList<String> matches = new ArrayList<>();

        for (Vehicle vehicle : vehicleList)
            if (vehicle instanceof Boat)
                if (Math.abs(((Boat) vehicle).maximumSpots - maximumSpots) <= maximumDelta)
                    matches.add(vehicle.getVehicleName());

        return matches.toArray(new String[matches.size()]);
    }
}
