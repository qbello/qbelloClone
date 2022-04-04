package SubmittedJunk;

import java.util.ArrayList;

/**
 * A Water SubmittedJunk.Park class
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

public class WaterPark implements Park
{
    private double admissionCost;
    private boolean indoor;
    private double land;
    private boolean lazyRiver;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    private boolean wavePool;

    public WaterPark(String name, double admissionCost, double land, ArrayList<Ride> rides, boolean indoor,
               boolean outdoor, boolean lazyRiver, boolean wavePool, boolean[] seasons)
    {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public boolean isLazyRiver()
    {
        return lazyRiver;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public boolean isWavePool() {
        return wavePool;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
    }

    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    @Override
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public double getLand() {
        return land;
    }

    @Override
    public void addRide(Ride ride) throws WrongRideException
    {
        if (ride.getClass().getName().compareTo("SubmittedJunk.Waterslide") != 0)
            throw new WrongRideException("A waterpark can only have waterslide rides!");

        rides.add(ride);
    }

    @Override
    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public boolean isOutdoor() {
        return outdoor;
    }

    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }

    @Override
    public boolean[] getSeasons() {
        return seasons;
    }

    @Override
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor)
            throws SpaceFullException
    {
        if (land + addedLand > maxLand)
            throw new SpaceFullException("There is no more land to use for this park!");

        land += addedLand;

        if (!outdoor && addedOutdoor)
            outdoor = true;

        if (!indoor && addedIndoor)
            indoor = true;

    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRiders,
                           double newSplashDepth)
    {
        int index = rides.indexOf(ride);
        rides.set(index, new Waterslide(newName, newColor, newMinHeight, newMaxRiders, newSplashDepth));
    }

    @Override
    public void close() {
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        lazyRiver = false;
        wavePool = false;
    }
}









