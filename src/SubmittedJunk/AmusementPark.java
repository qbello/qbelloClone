package SubmittedJunk;

import java.util.ArrayList;

/**
 * An Amusement SubmittedJunk.Park class
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

public class AmusementPark implements Park
{
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
                  boolean indoor, boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons)
    {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    public void addRide(Ride ride) throws WrongRideException
    {
        if (ride.getClass().getName().compareTo("SubmittedJunk.Rollercoaster") != 0)
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");

        rides.add(ride);
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight,
                           int newMaxRiders, boolean newSimulated)
    {
        int index = rides.indexOf(ride);
        rides.get(index).setName(newName);
        rides.get(index).setColor(newColor);
        rides.get(index).setMinHeight(newMinHeight);
        rides.get(index).setMaxRiders(newMaxRiders);
        ((Rollercoaster) rides.get(index)).setSimulated(newSimulated);
    }

    public boolean isArcade()
    {
        return arcade;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public boolean isBowling() {
        return bowling;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    @Override
    public void close()
    {
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        arcade = false;
        bowling = false;
    }

    @Override
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor)
            throws SpaceFullException
    {
        if (land + addedLand > maxLand)
            throw new SpaceFullException("There is no more land to use for this park!");

        land += addedLand;

        if (!indoor && addedIndoor)
            indoor = true;

        if (!outdoor && addedOutdoor)
            outdoor = true;
    }

    @Override
    public double getAdmissionCost() {
        return admissionCost;
    }

    @Override
    public double getLand() {
        return land;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public boolean[] getSeasons() {
        return seasons;
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
    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    @Override
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
}
