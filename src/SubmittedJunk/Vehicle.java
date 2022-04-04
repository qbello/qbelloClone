package SubmittedJunk;

public interface Vehicle
{
    public int getNumSpotsAvailable();
    public String getVehicleName();
    public boolean hasWheels();
    public boolean addPassenger();
    public boolean hasRudder();
    public double calculateTravelCost(int miles);
    public int getMaxPassengers();
    public String[] findSimilarVehicles(Vehicle[] vehicleList, int maximumDelta);

}
